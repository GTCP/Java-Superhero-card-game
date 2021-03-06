public class Atributo{
	private String nombre;
	private double valor;
	public Atributo(String nombre, double valor) {
		this.nombre=nombre;
		this.valor = valor;
	}	
	public String get_nombre() {
		return nombre;
	}
	public double get_valor() {
		return this.valor;
	}
	public void set_valor(double valor) {
		this.valor = valor;
	}	
	public boolean equals(Object o) {
		try {
			Atributo atributo=(Atributo)o;
			return get_nombre().equals(atributo.get_nombre());
		} catch (Exception e){
			return false;
		}
	}	
	public String toString() {
		return ""+this.nombre +" "+ this.valor;
	}
}