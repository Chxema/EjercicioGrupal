package com.itt.arte;
import java.util.Scanner;
public class Principal {
       private static Scanner lector;
       private static Scanner rc;
       private static Obra obra = new Obra("La cena de los idiotas", "Comedia", 95);
       private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);
       public static void main(String[] args) {
       lector = new Scanner(System.in);
       rc = new Scanner(System.in);
       char opc;
       do {
          opc = mostrarMenu();
          switch (opc) {
          case '1':System.out.println(teatro.verProgramacion());break;
          case '2':System.out.println(teatro.verLocalidades());break;
          case '3':System.out.println(teatro.verLocalidadesOcupadas());break;
          case '4':System.out.println(teatro.venderLocalidades(filaDat(),ButacaDat(),datosEspecta()));break;
          case '5':System.out.println(teatro.cancelarLocalidad(filaDat(),ButacaDat()));break;
          case '6':System.out.println(teatro.consultarLocalidad(filaDat(),ButacaDat()));break;
          case '7':System.out.println("Recaudación: "+teatro.calcularRecaudación());break;
          case '8':
          default:
          }
       } while (opc!='8');
       lector.close();
       rc.close();
}

       public static char mostrarMenu() {
	       String opcion;
	       System.out.println ("TEATRO LA BOMBILLA DE DON BLAS");
	       System.out.println ("------------------------------");
	       System.out.println ("1. Ver la programación actual");
	       System.out.println ("2. Mostrar todas las localidades");
	       System.out.println ("3. Mostrar localidades ocupadas");
	       System.out.println ("4. Vender localidad");
	       System.out.println ("5. Cancelar localidad");
	       System.out.println ("6. Consultar localidad");
	       System.out.println ("7. Calcular recaudación");
	       System.out.println ("8. Terminar programa");
	       System.out.println ("------------------------------");
	       System.out.println ("¿Qué opción deseas?");
	       opcion = lector.nextLine();
	       return opcion.charAt(0); // Devuelvo el primer caracter tecleado.
       }   
       // Pedimos Fila del patico de butacas
       private static int filaDat() {
    	   int fila=0;
    	   do {
    		   System.out.println("Indique la fila que desea de [0] - [4]: ");
    		   fila=rc.nextInt();
    		  }while(fila<=-1 || fila>=5);
    	   return fila; //La matriz comienza por 0 y pedimos valores 1 o 5.
    	}
       
    // Pedimos Butaca del patico de butacas
       private static int ButacaDat() {
    	   int butaca=0;
    	   do {
    		   System.out.println("Indique la butaca que desea de [0] o [9]: ");
    		   butaca=rc.nextInt();
    		  }while(butaca<=-1 || butaca>=10);
    	   return butaca;
    	}
    // Introducimos Espectador & Instanciamos
       public static Espectador datosEspecta() {
    	    rc = new Scanner(System.in);
   			System.out.println("Introduce nombre: ");
   			String cadena1 = rc.nextLine();
   			System.out.println("Introduce teléfono: ");
   			String cadena2 = rc.nextLine();
   			System.out.println("Introduzca Edad: ");
   			int nedad = rc.nextInt();
   			Espectador e = new Espectador(cadena1,cadena2,nedad);
   		return e;
   	}
}
