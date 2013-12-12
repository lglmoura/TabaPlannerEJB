package br.iff.pooa20132.tabaplanner.persistence.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20132.tabaplanner.persistence.controller.ProjetoPersistenceRemote;
import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;

public class ProjetoTest {

	private ProjetoPersistenceRemote pproj;
	
	@Before
	public void setUp() throws Exception {
		
		Context context = null;
		pproj = null;
		try {

			context = JNDILookupClass.getInitialContext();

			pproj = (ProjetoPersistenceRemote) context
					.lookup("ejb:TabaPlannerEAR/TabaPlannerEJB/ProjetoPersistence!br.iff.pooa20132.tabaplanner.persistence.controller.ProjetoPersistenceRemote");

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
		Projeto prop = pproj.inserir(uid, new Date(), new Date(),
				"Descricao", "Nome");
		assertEquals(prop.getUid(), uid);
		pproj.delete(uid);
	}

}
