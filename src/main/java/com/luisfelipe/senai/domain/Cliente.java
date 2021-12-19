package com.luisfelipe.senai.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity 
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nome;
	private String cpfOuCnpj;
	private Integer tipo;

	@Column(unique = true)
	private String email;

	@ElementCollection 
	@CollectionTable(name = "TELEFONE") 
	private Set<String> telefones = new HashSet<>();

public Cliente() {
}

public Cliente(Integer idCliente, String nome, String cpfOuCnpj, String email, 
		TipoCliente tipo) {
	super();
	this.idCliente = idCliente;
	this.nome = nome;
	this.cpfOuCnpj = cpfOuCnpj;
	this.email = email;
	this.tipo = tipo.getCod();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
	Cliente other = (Cliente) obj;
	if (idCliente == null) {
		if (other.idCliente != null)
			return false;
	} else if (!idCliente.equals(other.idCliente))
		return false;
	return true;
}
public TipoCliente getTipo() {
	return TipoCliente.toEnum(tipo);
}

public void setTipo(TipoCliente tipo) {
	this.tipo = tipo.getCod();
}
}
