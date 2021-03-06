import java.util.ArrayList;
public class Carta {
	private String nombre;
	private ArrayList <Atributo> atributos;
	private Pocima pocima;
	public Carta(String nombre, ArrayList<Atributo> atributos) {
		this.nombre = nombre;
		this.atributos = atributos;
		this.pocima = null;
	}
	public Pocima getPocima() {
		return this.pocima;
	}
	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}
	public String obtener_nombre() {
		return this.nombre;
	}
	public double obtener_valor_atributo_por_nombre(String nombreAtributo) {
		Atributo atributo = null;
		int valor = 0; 
		for (int i = 0; i < atributos.size(); i++) {
			atributo = atributos.get(i);
			if (atributo.get_nombre().equals(nombreAtributo)) {
				if(pocima == null) {
					return atributo.get_valor();
				}
				else {	
					return pocima.agregarPocima(atributo);
				}
			}
		}
		return valor;
	}
	public ArrayList<String> obtener_nombres_atributos() {
        ArrayList<String> aux= new ArrayList<String>();
        for (Atributo atributo : atributos) {
            aux.add(atributo.get_nombre());
        }
        return aux;
    }
	public Atributo obtener_atributo_por_nombre(String atributo){
        for (Atributo a : atributos) {
            if(a.get_nombre().equals(atributo)){
                return a;
            }
        }
        return null;
    }
	public boolean equals(Object o) {
		try {
	        Carta auxiliar = (Carta) o;
	        if (this.obtener_nombres_atributos().size() == (auxiliar.obtener_nombres_atributos().size())) {
	            for (int i = 0; i < this.obtener_nombres_atributos().size(); i++) {
	                if (!this.atributos.get(i).equals(auxiliar.atributos.get(i))) {
	                    return false;
	                }
	            }
	            return true;
	        }
	        return false;
	    } catch (Exception exp) {
	        return false;
	    }
	}
	public boolean verificar(Carta c) { 
		if(this.atributos.size()==c.atributos.size()) {
			for(int i=0;i<atributos.size();i++){
				if (!this.atributos.get(i).equals(c.atributos.get(i))) {
					return false;	
				}
			}
			return true;
			}	
		return false;	
	}
	public String toString(String atributo) {
        String concatenacion = this.obtener_atributo_por_nombre(atributo).toString();
        if(this.pocima!=null){
        	concatenacion+= ",se aplic? P?cima "+ this.getPocima().getNombre()+" su valor resultante es: "+ this.obtener_valor_atributo_por_nombre(atributo);           
        }
        return concatenacion;
   }
}