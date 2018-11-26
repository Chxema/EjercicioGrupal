package com.itt.arte;

public class Espectador {
	private String nombre;
	private String tlf;
	private int edad;
	
	public Espectador(String nombre, String tlf,int edad) {
		this.nombre= nombre;
		this.tlf = tlf;
		this.edad = edad;
	}
	
	public String rangoEdad() {
		if (this.edad>=0 && this.edad<=12) {
			return "Infantil";
		}else if (this.edad>=13 && this.edad<=17) {
			return "Menor";
		}else if (this.edad>=18 && this.edad<=64) {
			return "Mayor";
		}else if (this.edad>=65) {
			return "Jubilado";
		}
		return "Edad Incorrecta, debe corregir la edad";
	}
	
	// Sobrescribimos toString 
	@Override
	public String toString() {
		return nombre.concat(" ");
				
	}
	//Getters & Setters
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
