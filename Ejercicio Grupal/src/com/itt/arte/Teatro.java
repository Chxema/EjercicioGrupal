package com.itt.arte;

import java.util.Scanner;

public class Teatro extends Local implements Sala {
	private Obra obra;
	private Espectador[][] localidades;
	private double precio;
	
	//Constructor Teatro
	public Teatro(String domicilio, int metros, int accesos,Obra obra, double precio ) {
		super(domicilio,metros,accesos);
		this.obra = obra;
		this.precio = precio;
		this.localidades = new Espectador[5][10];
	}
	
	//Ver Programación
	@Override
	public String verProgramacion() {
		return obra.toString()+"En "+getDomicilio()+" local de: "+getMetros()+
     		   " con: "+getAccesos()+" accesos"+"\n"+"Precio: "+precio+" €"+"\n";	
	}
	
	//Mostrar todas las localidades
	@Override
	public String verLocalidades() {
		String cadena="";
		for (int i=0;i<localidades.length;i++) {
			for (int x=0;x<localidades[i].length;x++) {
				if (localidades[i][x]== null) {
				    cadena=cadena+i+"."+x+" "+"Libre ";
				}else {
					cadena=cadena+i+"."+x+" "+"Ocupada ";
				}
			}
			cadena=cadena+"\n";
		}
		return cadena;
	}
	
	//Ver localidades ocupada
	@Override
	public String verLocalidadesOcupadas() {
		String ocup="";
		for (int i=0;i<localidades.length;i++) {
			for (int x=0;x<localidades[i].length;x++) {
				if (localidades[i][x]!= null) {
				    ocup += "Reserva: "+Integer.toString(i)+"."+Integer.toString(x)+" Nombre: "+localidades[i][x].getNombre()+
				    	   " Teléfono: "+localidades[i][x].getTlf()+" Tipo: "+localidades[i][x].rangoEdad()+
				    	   "\n";
				}
		   }
		}	
	    return ocup;
	}
	
	//Vender Localidad
	@Override
	public String venderLocalidades(int fila, int butaca, Espectador e) {
		if (localidades[fila][butaca]==null) {
			localidades[fila][butaca] = e;
			return "Se ha vendido la localidad "+fila+"."+butaca+" a "+e.getNombre()+" por "+
					Double.toString(calculoPrecio(e));
		}else {
			return "La Localidad ya está ocupada por "+localidades[fila][butaca].getNombre()+
					" Teléfono: "+localidades[fila][butaca].getTlf()+" debe seleccionar otra";
		}
	}
	
	public double calculoPrecio(Espectador e) {
		double importe = this.precio;
		if (e.rangoEdad().equals("Infantil")) {
			importe -= ((this.precio*50)/100);
		}else if (e.rangoEdad().equals("Menor")) {
			importe -= ((this.precio*20)/100);
		}else if (e.rangoEdad().equals("Jubilado")) {
			importe -= ((this.precio*66)/100);
	    }
		return importe;
	}
	
	@Override
	public String cancelarLocalidad(int fila, int butaca) {
		if (localidades[fila][butaca]==null) {
			return "Esta localidad está libre no precisa ser cancelada";
		}else {
			String cadena = "La localidad a nombre de: "+localidades[fila][butaca]+" "+
							" se ha cancelado";
			localidades[fila][butaca] = null;
			return cadena;
		}
	}
	
	@Override
	public String consultarLocalidad(int fila, int butaca) {
		if (localidades[fila][butaca]==null) {
			return "Esta localidad está libre, no podemos suministrar datos";
		}else {
			return "La localidad pertenece a: "+localidades[fila][butaca].getNombre()+
							" Teléfono: "+localidades[fila][butaca].getTlf()+" Tipo: "+
							localidades[fila][butaca].rangoEdad()+" Precio: "+
							calculoPrecio(localidades[fila][butaca]);
							
		}
	}
		
	@Override
	public double calcularRecaudación() {
		double suma=0;
		for (int i=0;i<localidades.length;i++) {
			for (int x=0;x<localidades[i].length;x++) {
				if (localidades[i][x]!= null) {
				    suma += calculoPrecio(localidades[i][x]);
				}
		   }
		}	
	return suma;
	}
	
	//Getters & Setters
	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Espectador[][] getLocalidades() {
		return localidades;
	}

	public void setLocalidades(Espectador[][] localidades) {
		this.localidades = localidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
