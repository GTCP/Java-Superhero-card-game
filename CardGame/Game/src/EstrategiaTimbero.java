import java.util.ArrayList;
import java.util.Collections;
public class EstrategiaTimbero implements EstrategiaDeJuego {
	public Atributo definirEstrategia(Carta c) {
		ArrayList<String> nombresAtributos=new ArrayList<String>();	
		nombresAtributos=c.obtener_nombres_atributos();	
	    Collections.shuffle(nombresAtributos);   
	    return c.obtener_atributo_por_nombre(nombresAtributos.get(0));
	}
}