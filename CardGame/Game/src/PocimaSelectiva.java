public class PocimaSelectiva extends Pocima {
	private double valor;
	private String atributo;
	public PocimaSelectiva(double valor, String nombre, String atributo) {
		this.valor = valor;
		this.nombre = nombre;
		this.atributo = atributo;
	}
	@Override
	public double agregarPocima(Atributo atributo) {
		double valorActual = atributo.get_valor();
		double nuevoValor =  valorActual;
		if (this.atributo.equals(atributo.get_nombre())) {
			nuevoValor = valorActual + ((valor * valorActual)/100);
			return nuevoValor;
		} 
		return nuevoValor;
	}
}