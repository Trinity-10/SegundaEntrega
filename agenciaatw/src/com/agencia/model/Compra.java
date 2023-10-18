package com.agencia.model;

public class Compra {
	
	private int idCompra;
	
	private double valorCompra;
	
	private String descricaoCompra;
	
	private Destino destino; 
	
	
	private Cliente cliente;
	
	

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getDescricaoCompra() {
		return descricaoCompra;
	}

	public void setDescricaoCompra(String descricaoCompra) {
		this.descricaoCompra = descricaoCompra;
	}

	public Compra(int idCompra, double valorCompra, String descricaoCompra) {
		super();
		this.idCompra = idCompra;
		this.valorCompra = valorCompra;
		this.descricaoCompra = descricaoCompra;
		
	}

	public Compra(Destino destino, Cliente cliente) {
		super();
		this.destino = destino;
		this.cliente = cliente;
	}

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public void setCliente(int nextInt) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
