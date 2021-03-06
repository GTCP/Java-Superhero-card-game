public class Jugador {
	private Mazo mazo;
	private String nombre;
	private EstrategiaDeJuego estrategia;
		public Jugador(String nombre, EstrategiaDeJuego estrategia) {
		this.nombre=nombre;
		this.estrategia=estrategia;
		this.mazo=new Mazo();
	}	
	public Atributo get_estrategia(Carta c) {
		return this.estrategia.definirEstrategia(c); 
	}	
	public void set_estrategia(EstrategiaDeJuego estrategia) {
		this.estrategia = estrategia;
	}
	public String getNombre() {
		return this.nombre;
	}	
	public int getCantidadCartas() {
		return this.mazo.getCantidadCartas();
	}	
	public Carta getCarta() {
		return this.mazo.getCarta();
	}	
	public void agregar_carta(Carta c) {
		this.mazo.agregar_carta(c);
	}	
	public void eliminar_carta() {
		this.mazo.eliminarCarta();
	}		
	public void ganar_ronda(Carta c1,Carta c2){
		this.mazo.mandar_carta_final_lista();
		this.mazo.agregar_carta(c2);
	}
	public void empatar_ronda(Carta c1) {
		this.mazo.mandar_carta_final_lista();
	}	
}