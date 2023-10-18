package com.agencia.model;

public class Cliente {

	private	int idCliente;

	private String nomeCliente;

	private String cpfCliente;

	private String enderecoCliente;

	private String telefoneCliente;

	private String emailCliente;

	
	
	
	
	public Cliente(int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente,
			String emailCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
		this.emailCliente = emailCliente;
	}

	
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}




	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}




	public void updateCliente(Cliente atualizado) {
		// TODO Auto-generated method stub
		
	}

	
}
