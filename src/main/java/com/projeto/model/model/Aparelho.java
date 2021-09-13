package com.projeto.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_APARELHO")
public class Aparelho {

	private Integer id;
	private Integer idCliente;
	private String 	numeroSerie;
	private String 	nome;
	private String 	marca;
	
	public Aparelho() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="APARELHO_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="APARELHO_IDCLIENTE", length = 20, nullable = false)
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@Column(name="APARELHO_NUMSERIE", length = 30, nullable = false)
	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	@Column(name="APARELHO_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="APARELHO_MARCA", length = 50, nullable = false)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aparelho [id=" + id + ", idCliente=" + idCliente + ", numeroSerie=" + numeroSerie + ", nome=" + nome
				+ ", marca=" + marca + "]";
	}
}
