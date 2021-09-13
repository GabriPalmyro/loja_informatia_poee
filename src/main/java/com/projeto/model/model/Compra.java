package com.projeto.model.model;

import java.util.Date;
import java.util.Objects;

public class Compra {

	private Integer id;
	private Integer idFuncionario;
	private Date 	dataCompra;
	private double 	valorCompra;
	
	public Compra() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
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
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", idFuncionario=" + idFuncionario + ", dataCompra=" + dataCompra + ", valorCompra="
				+ valorCompra + "]";
	}
	
	
}
