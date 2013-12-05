package br.iff.pooa20132.tabaplanner.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estoria database table.
 * 
 */
@Entity
@NamedQuery(name="Estoria.findAll", query="SELECT e FROM Estoria e")
public class Estoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	//bi-directional many-to-one association to Iteracao
	@ManyToOne
	@JoinColumn(name="uiditeracao")
	private Iteracao iteracao;

	//bi-directional many-to-one association to Tarefa
	@OneToMany(mappedBy="estoria")
	private List<Tarefa> tarefas;

	public Estoria() {
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

	public Iteracao getIteracao() {
		return this.iteracao;
	}

	public void setIteracao(Iteracao iteracao) {
		this.iteracao = iteracao;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Tarefa addTarefa(Tarefa tarefa) {
		getTarefas().add(tarefa);
		tarefa.setEstoria(this);

		return tarefa;
	}

	public Tarefa removeTarefa(Tarefa tarefa) {
		getTarefas().remove(tarefa);
		tarefa.setEstoria(null);

		return tarefa;
	}

}