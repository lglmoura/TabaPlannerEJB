package br.iff.pooa20132.tabaplanner.persistence.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20132.tabaplanner.persistence.entity.Iteracao;
import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;


@Stateless
@LocalBean
public class IteracaoPersistence extends AbstractPersistence implements IteracaoPersistenceRemote{

	public Iteracao inserir(String uid, String nome, Integer duracao,Projeto projeto) {

		Iteracao iteracao = new Iteracao();
		iteracao.setUid(uid);
		iteracao.setNome(nome);
		iteracao.setDuracao(duracao);
		iteracao.setProjeto(projeto);
		super.insert(iteracao);
		return iteracao;

	}
	
	public Iteracao update(String uid, String nome, Integer duracao,Projeto projeto) {

		Iteracao iteracao = super.find(Iteracao.class,uid);
		
		iteracao.setUid(uid);
		iteracao.setNome(nome);
		iteracao.setDuracao(duracao);
		iteracao.setProjeto(projeto);
		super.update(iteracao);
		return iteracao;

	}
	
	public Iteracao find(String uid) {

		return super.find(Iteracao.class, uid);
	}

	public void delete(String uid) {
		super.delete(Iteracao.class, uid);
	}

	@XmlElement(name = "iteracaos")
	public List<Iteracao> findAll() {
		return super.findAll(Iteracao.class);

	}

}
