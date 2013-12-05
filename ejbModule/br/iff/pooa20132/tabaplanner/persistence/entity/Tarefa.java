package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarefa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarefa.findAll", query="SELECT t FROM Tarefa t")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Alocacao
	@ManyToOne
	@JoinColumn(name="uidalocacao")
	private Alocacao alocacao;

	//bi-directional many-to-one association to Estoria
	@ManyToOne
	@JoinColumn(name="uidestoria")
	private Estoria estoria;

	public Tarefa() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public Alocacao getAlocacao() {
		return this.alocacao;
	}

	public void setAlocacao(Alocacao alocacao) {
		this.alocacao = alocacao;
	}

	public Estoria getEstoria() {
		return this.estoria;
	}

	public void setEstoria(Estoria estoria) {
		this.estoria = estoria;
	}

}