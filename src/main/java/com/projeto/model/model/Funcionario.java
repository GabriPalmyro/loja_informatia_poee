package com.projeto.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_FUNCIONARIO")
public class Funcionario {
	
	private Integer id;
	private String 	cpf;
	private String 	nome;
	private double 	salario;
	private String 	cep;
	private String 	bairro;
	private String 	cidade;
	private String 	rua;
	private String 	telefone;
	
	public Funcionario() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FUNCIONARIO_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="FUNCIONARIO_CPF", length = 20, nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name="FUNCIONARIO_NOME", length = 80, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="FUNCIONARIO_SALARIO", length = 20, nullable = false)
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Column(name="FUNCIONARIO_CEP", length = 12, nullable = false)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name="FUNCIONARIO_BAIRRO", length = 30, nullable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name="FUNCIONARIO_CIDADE", length = 40, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="FUNCIONARIO_RUA", length = 30, nullable = false)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@Column(name="FUNCIONARIO_TELEFONE", length = 14, nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", salario=" + salario + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", rua=" + rua + ", telefone=" + telefone + "]";
	}
	
	
}
