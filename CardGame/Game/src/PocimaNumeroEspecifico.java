public class PocimaNumeroEspecifico extends Pocima {
	private double valor;
	public PocimaNumeroEspecifico(double valor, String nombre) {
		this.valor = valor;
		this.nombre = nombre;
	}	
	@Override
	public double agregarPocima(Atributo atributo) {
		return valor;	
	}
}