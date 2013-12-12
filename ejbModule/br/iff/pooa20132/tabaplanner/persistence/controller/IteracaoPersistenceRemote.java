package br.iff.pooa20132.tabaplanner.persistence.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20132.tabaplanner.persistence.entity.Iteracao;
import br.iff.pooa20132.tabaplanner.persistence.entity.Projeto;

@Remote
public interface IteracaoPersistenceRemote {

	public Iteracao inserir(String uid, String nome, Integer duracao,
			Projeto projeto);

	public Iteracao update(String uid, String nome, Integer duracao,
			Projeto projeto);

	public Iteracao find(String uid);

	public void delete(String uid);

	@XmlElement(name = "iteracaos")
	public List<Iteracao> findAll();

}
