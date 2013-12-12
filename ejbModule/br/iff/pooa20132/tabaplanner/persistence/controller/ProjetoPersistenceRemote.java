package br.iff.pooa20132.tabaplanner.persistence.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;

@Remote
public interface ProjetoPersistenceRemote {

	public Projeto inserir(String uid, Date datainicio, Date datafim,
			String descricao, String nome);

	public Projeto update(String uid, Date datainicio, Date datafim,
			String descricao, String nome);

	public Projeto find(String uid);

	public void delete(String uid);

	@XmlElement(name = "projetos")
	public List<Projeto> findAll();

}
