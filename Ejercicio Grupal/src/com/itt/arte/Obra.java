package com.itt.arte;

public class Obra {
	private String titulo;
	private String genero;
	private int minutosDuracion;
	
	public Obra(String titulo, String genero, int minutosDuracion) {
		this.titulo = titulo;
		this.genero = genero;
		this.minutosDuracion = minutosDuracion;
	}
	@Override 
	public String toString() {
		return "Hoy representamos: "+titulo+" genero: "+genero+
			   " Duraci�n: "+minutosDuracion+"\n";
	}
	
	//Getters & Setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getMinutosDuracion() {
		return minutosDuracion;
	}
	public void setMinutosDuracion(int minutosDuracion) {
		this.minutosDuracion = minutosDuracion;
	}

}
