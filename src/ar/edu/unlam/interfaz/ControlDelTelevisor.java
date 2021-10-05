package ar.edu.unlam.interfaz;

import ar.edu.unlam.dominio.Televisor;

public class ControlDelTelevisor {

	public static void main(String[] args) {

		Televisor producto1 = new Televisor();
		System.out.println(producto1 + "\n");

		producto1.encenderOApagar();
		System.out.println("El televisor esta: " + producto1.isEncendido());
		producto1.seleccionarEntrada('1');
		producto1.subirCanal();
		System.out.println("Numero de canal: " + producto1.getCanalActual());
		producto1.subirCanal();
		System.out.println("Numero de canal: " + producto1.getCanalActual());

		producto1.subirCanal();
		System.out.println("Numero de canal: " + producto1.getCanalActual());

		producto1.bajarCanal();
		System.out.println("Numero de canal: " + producto1.getCanalActual());
		producto1.cambiarDeCanal(100);
		System.out.println("Numero de canal: " + producto1.getCanalActual());
		producto1.volverAlCanalAnterior();
		System.out.println("Se volvio al numero de canal: " + producto1.getCanalActual());

		producto1.cambiarDeCanal(2, 4);
		System.out.println("Numero de canal: " + producto1.getCanalActual());

		producto1.subirVolumen();
		producto1.subirVolumen();
		producto1.subirVolumen();
		System.out.println("Numero de volunen: " + producto1.getVolumenActual());
		producto1.bajarVolumen();
		System.out.println("Numero de volunen: " + producto1.getVolumenActual());
		producto1.silenciar();
		System.out.println("Numero de volunen (silenciar): " + producto1.getVolumenActual());

		System.out.println("\n" + producto1);

		producto1.encenderOApagar();

		System.out.println("\n" + producto1);

		producto1.encenderOApagar();

		producto1.seleccionarEntrada('A');

		System.out.println("\n" + producto1);

	}

}
