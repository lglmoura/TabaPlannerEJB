package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the desenvolvedor database table.
 * 
 */
@Entity
@NamedQuery(name="Desenvolvedor.findAll", query="SELECT d FROM Desenvolvedor d")
public class Desenvolvedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String email;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Alocacao
	@OneToMany(mappedBy="desenvolvedor")
	private List<Alocacao> alocacaos;

	public Desenvolvedor() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Alocacao> getAlocacaos() {
		return this.alocacaos;
	}

	public void setAlocacaos(List<Alocacao> alocacaos) {
		this.alocacaos = alocacaos;
	}

	public Alocacao addAlocacao(Alocacao alocacao) {
		getAlocacaos().add(alocacao);
		alocacao.setDesenvolvedor(this);

		return alocacao;
	}

	public Alocacao removeAlocacao(Alocacao alocacao) {
		getAlocacaos().remove(alocacao);
		alocacao.setDesenvolvedor(null);

		return alocacao;
	}

}