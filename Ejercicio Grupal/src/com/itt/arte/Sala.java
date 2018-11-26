package com.itt.arte;

public interface Sala {
	String verProgramacion();
	String verLocalidades();
	String verLocalidadesOcupadas();
	String venderLocalidades(int fila, int butaca, Espectador e);
	String cancelarLocalidad(int file, int butaca);
	String consultarLocalidad(int fila, int butaca);
	double calcularRecaudación();
}
