public abstract class Pocima {
	protected String nombre;
	public abstract double agregarPocima(Atributo atributo);
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		 this.nombre=nombre;
	}
}