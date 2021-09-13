package com.projeto.model.model;

import java.util.Date;
import java.util.Objects;

public class Trabalho {
	
	private Integer id;
	private Integer idServico;
	private Integer idFuncionario;
	private Date 	dataHoraServico;
	
	public Trabalho() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Date getDataHoraServico() {
		return dataHoraServico;
	}

	public void setDataHoraServico(Date dataHoraServico) {
		this.dataHoraServico = dataHoraServico;
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
		Trabalho other = (Trabalho) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Trabalho [id=" + id + ", idServico=" + idServico + ", idFuncionario=" + idFuncionario
				+ ", dataHoraServico=" + dataHoraServico + "]";
	}
	
	
}
