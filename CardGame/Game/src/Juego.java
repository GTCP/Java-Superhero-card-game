import java.util.ArrayList;
public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int maximoRondas;
	private ArrayList<Pocima> pocimas;
	public Juego(Jugador jugador1, Jugador jugador2, Mazo mazo, int maximoRondas) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
		this.maximoRondas = maximoRondas;
		this.pocimas = new ArrayList<Pocima>();
	}	
	public void jugar() {
		Jugador jugadorMano=jugador1;
		Jugador jugadorSinMano=jugador2;
		int rondasJugadas=1;		
		repartir_cartas();
		System.out.println("");	System.out.println("--------------------------------Arranca el juego--------------------------------");System.out.println("");
		while(!verificarPartida(rondasJugadas)) {
			System.out.println("");
			System.out.println("--------------- Ronda "+rondasJugadas+ " ---------------");
			Atributo atributoEstrategia = jugadorMano.get_estrategia(jugadorMano.getCarta());				
			double valorAtriPocimadoJugMano = jugadorMano.getCarta().obtener_valor_atributo_por_nombre(atributoEstrategia.get_nombre());
			double valorAtriPocimadoJugSinMano = jugadorSinMano.getCarta().obtener_valor_atributo_por_nombre(atributoEstrategia.get_nombre());
			System.out.println("El jugador "+jugadorMano.getNombre()+" selecciona competir por el atributo "+atributoEstrategia.get_nombre()+"\n"+"La carta del jugador "+jugadorMano.getNombre()+" es "+jugadorMano.getCarta().obtener_nombre()+" con "+jugadorMano.getCarta().toString(atributoEstrategia.get_nombre()));
		        System.out.println("La carta del jugador "+jugadorSinMano.getNombre()+" es "+jugadorSinMano.getCarta().obtener_nombre()+" con "+jugadorSinMano.getCarta().toString(atributoEstrategia.get_nombre()));
				if (valorAtriPocimadoJugMano > valorAtriPocimadoJugSinMano) {	
					jugadorMano.ganar_ronda(jugadorMano.getCarta(),jugadorSinMano.getCarta());
					jugadorSinMano.eliminar_carta();		
					System.out.println("Gana la ronda "+jugadorMano.getNombre()+"("+jugadorMano.getNombre()+" queda con "+jugadorMano.getCantidadCartas()+
							" cartas y "+jugadorSinMano.getNombre()+" posee ahora "+jugadorSinMano.getCantidadCartas()+")");
				} else if (valorAtriPocimadoJugMano < valorAtriPocimadoJugSinMano) {
					jugadorSinMano.ganar_ronda(jugadorSinMano.getCarta(),jugadorMano.getCarta());
					jugadorMano.eliminar_carta();
					System.out.println("Gana la ronda "+jugadorSinMano.getNombre()+"("+jugadorSinMano.getNombre()+" queda con "+jugadorSinMano.getCantidadCartas()+
							" cartas y "+jugadorMano.getNombre()+" posee ahora "+jugadorMano.getCantidadCartas()+")");
					Jugador aux=jugadorMano;
					jugadorMano=jugadorSinMano;
					jugadorSinMano=aux;
				} else {
					System.out.println("Hubo Empate!");
					jugadorMano.empatar_ronda(jugadorMano.getCarta());
					jugadorSinMano.empatar_ronda(jugadorSinMano.getCarta());
				}	
			rondasJugadas++;
		}
	}
	public Jugador obtener_jugador1() {
		return this.jugador1;
	}
	public Jugador obtener_jugador2() {
		return this.jugador2;
	}
	private void repartir_cartas() {
		repartir_pocimas();
		for (int i = 0; i < this.mazo.getCantidadCartas(); i++) {
			jugador1.agregar_carta(this.mazo.getCarta());
			this.mazo.eliminarCarta();
			if(i < this.mazo.getCantidadCartas()) {
				jugador2.agregar_carta(this.mazo.getCarta());
				this.mazo.eliminarCarta();
			}
		}
	}
	public void agregar_pocima(Pocima pocima) {
		this.pocimas.add(pocima);
	}
	private void repartir_pocimas() {
		Pocima pocima;
		for (int i = 0; i < pocimas.size(); i++) {
			pocima = pocimas.get(i);
			mazo.getCartaElegida(i).setPocima(pocima);
		}
	}
	private boolean verificarPartida(int rondasJugadas) {
		if(rondasJugadas > maximoRondas) {
			ganador_juego();
			return true;
		} else if((jugador1.getCantidadCartas()==0)||(jugador2.getCantidadCartas()==0)) {
			ganador_juego();
			return true;
		} else if (rondasJugadas < maximoRondas){
			return false;
		}
		return false;
	}
	private void ganador_juego() {
		if(jugador1.getCantidadCartas() > jugador2.getCantidadCartas()) {
			System.out.println("--------------- Ganador  ---------------");
			System.out.println("Gan? el juego: "+jugador1.getNombre());		
		}
		else if (jugador1.getCantidadCartas() < jugador2.getCantidadCartas()) {
			System.out.println("--------------- Ganador  ---------------");
			System.out.println("Gan? el juego: "+jugador2.getNombre());		
		} else {
			System.out.println("--------------- Empate  ---------------");
			System.out.println("Hubo Empate!");		
		}
		System.out.println("");System.out.println("");
		System.out.println("--------------------------------Termino el juego--------------------------------");
		System.out.println("");System.out.println("");
	}	
}