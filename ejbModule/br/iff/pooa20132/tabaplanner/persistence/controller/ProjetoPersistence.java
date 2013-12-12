package br.iff.pooa20132.tabaplanner.persistence.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;


@Stateless
@LocalBean
public class ProjetoPersistence extends AbstractPersistence implements ProjetoPersistenceRemote{

	public Projeto inserir(String uid, Date datainicio, Date datafim,
			String descricao, String nome) {

		Projeto projeto = new Projeto();
		projeto.setDatafim(datafim);
		projeto.setDatainicio(datainicio);
		projeto.setUid(uid);
		projeto.setNome(nome);
		projeto.setDescricao(descricao);
		super.insert(projeto);
		return projeto;

	}
	
	public Projeto update(String uid, Date datainicio, Date datafim,
			String descricao, String nome) {

		Projeto projeto = super.find(Projeto.class,uid);
		
		projeto.setDatafim(datafim);
		projeto.setDatainicio(datainicio);
		projeto.setUid(uid);
		projeto.setNome(nome);
		projeto.setDescricao(descricao);
		super.update(projeto);
		return projeto;

	}
	
	public Projeto find(String uid) {

		return super.find(Projeto.class, uid);
	}

	public void delete(String uid) {
		super.delete(Projeto.class, uid);
	}

	@XmlElement(name = "projetos")
	public List<Projeto> findAll() {
		return super.findAll(Projeto.class);

	}

}
