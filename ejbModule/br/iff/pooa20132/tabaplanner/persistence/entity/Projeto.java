package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity
@NamedQuery(name="Projeto.findAll", query="SELECT p FROM Projeto p")
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date datafim;

	@Temporal(TemporalType.DATE)
	private Date datainicio;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Alocacao
	@OneToMany(mappedBy="projeto")
	private List<Alocacao> alocacaos;

	//bi-directional many-to-one association to Iteracao
	@OneToMany(mappedBy="projeto")
	private List<Iteracao> iteracaos;

	public Projeto() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDatafim() {
		return this.datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Alocacao> getAlocacaos() {
		return this.alocacaos;
	}

	public void setAlocacaos(List<Alocacao> alocacaos) {
		this.alocacaos = alocacaos;
	}

	public Alocacao addAlocacao(Alocacao alocacao) {
		getAlocacaos().add(alocacao);
		alocacao.setProjeto(this);

		return alocacao;
	}

	public Alocacao removeAlocacao(Alocacao alocacao) {
		getAlocacaos().remove(alocacao);
		alocacao.setProjeto(null);

		return alocacao;
	}

	public List<Iteracao> getIteracaos() {
		return this.iteracaos;
	}

	public void setIteracaos(List<Iteracao> iteracaos) {
		this.iteracaos = iteracaos;
	}

	public Iteracao addIteracao(Iteracao iteracao) {
		getIteracaos().add(iteracao);
		iteracao.setProjeto(this);

		return iteracao;
	}

	public Iteracao removeIteracao(Iteracao iteracao) {
		getIteracaos().remove(iteracao);
		iteracao.setProjeto(null);

		return iteracao;
	}

}