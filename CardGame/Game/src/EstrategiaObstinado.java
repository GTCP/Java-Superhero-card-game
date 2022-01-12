public class EstrategiaObstinado implements EstrategiaDeJuego {
	private String nombreAtributo;
	public EstrategiaObstinado(String atributo) {
		this.nombreAtributo = atributo;
	}
	public Atributo  definirEstrategia(Carta c) {
		return c.obtener_atributo_por_nombre(nombreAtributo);
	}
}