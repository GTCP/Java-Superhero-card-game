import java.util.ArrayList;
public class Mazo {
	private ArrayList <Carta> cartas;
	public Mazo() {
		cartas = new ArrayList<Carta>();
	}
	public void agregar_carta(Carta c) {
		if(this.cartas.size()>0){	
			if(this.cartas.get(0).verificar(c)) {
				this.cartas.add(c);
			}
		}
		else {
			cartas.add(c);
		}
	}
	public int getCantidadCartas() {
		int contador=0;
		for(int i=0;i<cartas.size();i++) {
			contador++;
		}
		return contador;
	}
	public Carta getCarta() {
		return cartas.get(0);
	}	
	public Carta getCartaElegida(int i) {
		return cartas.get(i);
	}
	public void eliminarCarta() {
		cartas.remove(0);
	}
	public void mandar_carta_final_lista() {
		Carta contenedor= this.getCarta();
		cartas.remove(0);
		cartas.add(contenedor);
	}
}