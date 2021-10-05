package ar.edu.unlam.dominio;

public class Televisor {

	// atributos
	private static long numeroDeSerie = 0;
	private int canalActual;
	private int volumenActual;
	private String encendidoOApagado;
	private boolean botonPower;
	private boolean auxiliarParaSilenciar;
	private int guardarVolumen;
	private int canalAnterior;

	// constantes
	private char ENTRADA_TELEVISOR_DE_AIRE = 'A';
	private char ENTRADA_TELEVISOR_POR_CABLE = 'C';
	private char ENTRADA_HDMI1 = '1';
	private char ENTRADA_HDMI2 = '2';
	private char ENTRADA_USB = 'U';
	private char botonInput = 'X';
	private int VOLUMEN_MAXIMO = 100;
	private int VOLUMEN_MINIMO = 0;
	private int CANAL_MAXIMO = 999;
	private int CANAL_MINIMO = 1;

	// constructor
	public Televisor() {
		this.canalActual = 0;
		this.volumenActual = 0;
		this.encendidoOApagado = "apagado";
		this.botonPower = false;
		this.auxiliarParaSilenciar = false;
		this.canalAnterior = 0;
		this.guardarVolumen = 0;
		numeroDeSerie++;
	}

	// metodos
	public void encenderOApagar() {
		botonPower = !botonPower;
		if (botonPower == true) {
			encendidoOApagado = "encendido";
		} else {
			encendidoOApagado = "apagado";
		}
	}

	public String toString() {
		return "Televisor (" + numeroDeSerie + "): " + encendidoOApagado + "\nEntrada: " + botonInput + "\nCanal: "
				+ canalActual + "   Volumen: " + volumenActual;
	}

	public void seleccionarEntrada(char entradaDeseada) {
		if (botonPower == true) {
			switch (entradaDeseada) {
			case 'A':
				if (botonInput != 'A') {
					canalActual = 0;
				}
				botonInput = ENTRADA_TELEVISOR_DE_AIRE;
				break;
			case 'C':
				if (botonInput != 'B') {
					canalActual = 0;
				}
				botonInput = ENTRADA_TELEVISOR_POR_CABLE;
				break;
			case '1':
				if (botonInput != '1') {
					canalActual = 0;
				}
				botonInput = ENTRADA_HDMI1;
				break;
			case '2':
				if (botonInput != '2') {
					canalActual = 0;
				}
				botonInput = ENTRADA_HDMI2;
				break;
			case 'U':
				if (botonInput != 'U') {
					canalActual = 0;
				}
				botonInput = ENTRADA_USB;
				break;
			default:
				botonInput = 'X';
				break;
			}
		}
	}

	public void subirVolumen() {
		if (botonPower == true) {
			volumenActual++;
			if (volumenActual >= VOLUMEN_MAXIMO) {
				volumenActual = VOLUMEN_MAXIMO;
			}
			if (auxiliarParaSilenciar == true) {
				volumenActual = ++guardarVolumen;
				auxiliarParaSilenciar = false;
			}
		}
	}

	public void bajarVolumen() {
		if (botonPower == true) {
			volumenActual--;
			if (volumenActual <= VOLUMEN_MINIMO) {
				volumenActual = VOLUMEN_MINIMO;
			}
			if (auxiliarParaSilenciar == true) {
				volumenActual = --guardarVolumen;
				auxiliarParaSilenciar = false;
			}
		}
	}

	public boolean televisorEncendidoYEntradaSeleccionada() {
		return (botonPower == true && botonInput != 'X');
	}

	public boolean verificarNumeroDeCanal(int canal) {
		return (canal != 0 && canal <= CANAL_MAXIMO && canal >= CANAL_MINIMO);
	}

	public void subirCanal() {
		if (televisorEncendidoYEntradaSeleccionada()) {
			canalAnterior = canalActual++;
			if (canalActual > CANAL_MAXIMO) {
				canalActual = CANAL_MINIMO;
			}
		}
	}

	public void bajarCanal() {
		if (televisorEncendidoYEntradaSeleccionada()) {
			canalAnterior = canalActual--;
			if (canalActual < CANAL_MINIMO) {
				canalActual = CANAL_MAXIMO;
			}
		}
	}

	public void cambiarDeCanal(int canalDeseado) {
		int canal = 0;
		if (televisorEncendidoYEntradaSeleccionada()) {
			canal = canalDeseado;
			if (verificarNumeroDeCanal(canal)) {
				canalAnterior = canalActual;
				canalActual = canal;
			}
		}
	}

	public void cambiarDeCanal(int primerDigito, int segundoDigito) {
		int canal = 0;
		if (televisorEncendidoYEntradaSeleccionada()) {
			canal = ((primerDigito * 10) + (segundoDigito));
			if (verificarNumeroDeCanal(canal)) {
				canalAnterior = canalActual;
				canalActual = canal;
			}
		}
	}

	public void cambiarDeCanal(int primerDigito, int segundoDigito, int tercerDigito) {
		int canal = 0;
		if (televisorEncendidoYEntradaSeleccionada()) {
			canal = ((primerDigito * 100) + (segundoDigito * 10) + (tercerDigito));
			if (verificarNumeroDeCanal(canal)) {
				canalAnterior = canalActual;
				canalActual = canal;
			}
		}
	}

	public void cambiarDeCanal(int primerDigito, int segundoDigito, int tercerDigito, int cuartoDigito) {
		int canal = 0;
		if (televisorEncendidoYEntradaSeleccionada()) {
			canal = ((primerDigito * 1000) + (segundoDigito * 100) + (tercerDigito * 10) + (cuartoDigito));
			if (verificarNumeroDeCanal(canal)) {
				canalAnterior = canalActual;
				canalActual = canal;
			}
		}
	}

	public void volverAlCanalAnterior() {
		canalActual = canalAnterior;
	}

	public void silenciar() {
		guardarVolumen = volumenActual;
		volumenActual = 0;
		auxiliarParaSilenciar = true;
	}

	/*
	 * public char getEntradaUsb() { return 'a'; }
	 */

	// get
	public long getnumeroDeSerie() {
		return numeroDeSerie;
	}

	public String isEncendido() {
		return encendidoOApagado;
	}

	public int getVolumenActual() {
		return volumenActual;
	}

	public int getCanalActual() {
		return canalActual;
	}

	public char getEntradaActual() {
		return botonInput;
	}

}
