package br.com.cotiinformatica.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idTarefa;

	@Column(length = 150, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataFim;

	@Column(length = 500, nullable = false)
	private String descricao;

	@ManyToOne // muitas tarefas para 1 usuario
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;

	public Tarefa() {
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer idTarefa, String nome, Date dataInicio, Date dataFim, String descricao, Usuario usuario) {
		super();
		this.idTarefa = idTarefa;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.usuario = usuario;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", nome=" + nome + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", descricao=" + descricao + ", usuario=" + usuario + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Tarefa) {
			Tarefa tarefa = (Tarefa) obj;
			return this.idTarefa.equals(tarefa.getIdTarefa());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return this.idTarefa.hashCode();
	}
}
