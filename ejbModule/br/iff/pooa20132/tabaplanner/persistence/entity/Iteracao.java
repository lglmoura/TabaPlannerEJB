package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the iteracao database table.
 * 
 */
@Entity
@NamedQuery(name="Iteracao.findAll", query="SELECT i FROM Iteracao i")
public class Iteracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer duracao;

	private String nome;

	//bi-directional many-to-one association to Estoria
	@OneToMany(mappedBy="iteracao")
	private List<Estoria> estorias;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="uidprojeto")
	private Projeto projeto;

	public Iteracao() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getDuracao() {
		return this.duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estoria> getEstorias() {
		return this.estorias;
	}

	public void setEstorias(List<Estoria> estorias) {
		this.estorias = estorias;
	}

	public Estoria addEstoria(Estoria estoria) {
		getEstorias().add(estoria);
		estoria.setIteracao(this);

		return estoria;
	}

	public Estoria removeEstoria(Estoria estoria) {
		getEstorias().remove(estoria);
		estoria.setIteracao(null);

		return estoria;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}