package com.agencia.model;

public class Destino {
	
private int idDestino;
	
	private String localDestino;
	
	private String horarioDestino;

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}

	public String getHorarioDestino() {
		return horarioDestino;
	}

	public void setHorarioDestino(String horarioDestino) {
		this.horarioDestino = horarioDestino;
	}

	public Destino(int idDestino, String localDestino, String horarioDestino) {
		super();
		this.idDestino = idDestino;
		this.localDestino = localDestino;
		this.horarioDestino = horarioDestino;
	}

	public Destino() {
		// TODO Auto-generated constructor stub
	}
	

}
