package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alocacao database table.
 * 
 */
@Entity
@NamedQuery(name="Alocacao.findAll", query="SELECT a FROM Alocacao a")
public class Alocacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date dataentrada;

	@Temporal(TemporalType.DATE)
	private Date datasaida;

	//bi-directional many-to-one association to Desenvolvedor
	@ManyToOne
	@JoinColumn(name="uiddesenvolvedor")
	private Desenvolvedor desenvolvedor;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="uidprojeto")
	private Projeto projeto;

	//bi-directional many-to-one association to Tarefa
	@OneToMany(mappedBy="alocacao")
	private List<Tarefa> tarefas;

	public Alocacao() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDataentrada() {
		return this.dataentrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.dataentrada = dataentrada;
	}

	public Date getDatasaida() {
		return this.datasaida;
	}

	public void setDatasaida(Date datasaida) {
		this.datasaida = datasaida;
	}

	public Desenvolvedor getDesenvolvedor() {
		return this.desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa addTarefa(Tarefa tarefa) {
		getTarefas().add(tarefa);
		tarefa.setAlocacao(this);

		return tarefa;
	}

	public Tarefa removeTarefa(Tarefa tarefa) {
		getTarefas().remove(tarefa);
		tarefa.setAlocacao(null);

		return tarefa;
	}

}