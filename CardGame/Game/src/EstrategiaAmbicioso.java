import java.util.ArrayList;
public class EstrategiaAmbicioso implements EstrategiaDeJuego{
	public Atributo definirEstrategia(Carta c) {
		Atributo atributoMayor= new Atributo ("",0);
        ArrayList<String> nombresAtributos= new ArrayList<String>();
        nombresAtributos=c.obtener_nombres_atributos();
        for (String atributo : nombresAtributos) {
        	Atributo auxiliar=c.obtener_atributo_por_nombre(atributo);
            if(auxiliar.get_valor()>atributoMayor.get_valor()){
            	atributoMayor=auxiliar;
            }
        }
        return atributoMayor;
	}
}