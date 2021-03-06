public class PocimaCocktail extends Pocima  {
	private Pocima pocima1;
	private Pocima pocima2;
	public PocimaCocktail(Pocima pocima1,Pocima pocima2,String nombre) {//43% mas
		this.pocima1=pocima1;
		this.pocima2=pocima2;
		this.nombre = nombre;
	}	
	@Override
	public double agregarPocima(Atributo atributo) {
		Atributo copiaAtributo = new Atributo(atributo.get_nombre(), atributo.get_valor());
		copiaAtributo.set_valor(pocima1.agregarPocima(copiaAtributo));	
		return pocima2.agregarPocima(copiaAtributo);
	}	
}