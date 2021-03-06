package br.iff.pooa20132.tabaplanner.persistence.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20132.tabaplanner.persistence.controller.IteracaoPersistenceRemote;
import br.iff.pooa20132.tabaplanner.persistence.controller.ProjetoPersistenceRemote;
import br.iff.pooa20132.tabaplanner.persistence.entity.Iteracao;
import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;

public class IteracaoTest {
	private ProjetoPersistenceRemote pproj;
	private IteracaoPersistenceRemote piteracao;

	@Before
	public void setUp() throws Exception {
		
		Context context = null;
		pproj = null;
		try {

			context = JNDILookupClass.getInitialContext();

			pproj = (ProjetoPersistenceRemote) context
					.lookup("ejb:TabaPlannerEAR/TabaPlannerEJB/ProjetoPersistence!br.iff.pooa20132.tabaplanner.persistence.controller.ProjetoPersistenceRemote");
			
			piteracao = (IteracaoPersistenceRemote) context
					.lookup("ejb:TabaPlannerEAR/TabaPlannerEJB/IteracaoPersistence!br.iff.pooa20132.tabaplanner.persistence.controller.IteracaoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testinserir() {
		String uid = UUID.randomUUID().toString();
		Projeto prop = pproj.inserir(uid, new Date(), new Date(), "Descricao",
				"Nome");
		Iteracao iter = piteracao.inserir(uid, "nome",10, prop);
		assertEquals(iter.getUid(), uid);
		piteracao.delete(uid);
		pproj.delete(uid);
	}


}
