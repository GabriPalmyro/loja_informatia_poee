package com.projeto.model.model;

import java.util.Objects;

public class Servico {
	
	private Integer id;
	private Integer idComputador;
	private double 	precoServico;
	private String 	tipo;
	private String 	descricao;
	
	public Servico() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdComputador() {
		return idComputador;
	}

	public void setIdComputador(Integer idComputador) {
		this.idComputador = idComputador;
	}

	public double getPrecoServico() {
		return precoServico;
	}

	public void setPrecoServico(double precoServico) {
		this.precoServico = precoServico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", idComputador=" + idComputador + ", precoServico=" + precoServico + ", tipo="
				+ tipo + ", descricao=" + descricao + "]";
	}

	
	
}
