package com.projeto.model.model;

import java.util.Objects;

public class CompraProduto {

	private Integer id;
	private Integer idCompra;
	private Integer idProduto;
	private Integer quantidade;
	
	public CompraProduto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		CompraProduto other = (CompraProduto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CompraProduto [id=" + id + ", idCompra=" + idCompra + ", idProduto=" + idProduto + ", quantidade="
				+ quantidade + "]";
	}
	
}
