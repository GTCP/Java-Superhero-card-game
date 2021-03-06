import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
public class VisorMazo {
	public static  Mazo cargarMazo(String jsonFile) {
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        Mazo mazoMaestro = new Mazo(); // MAZO ORIGINAL DEL JUEGO 
        try {
            is = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(is);
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");  
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
            	ArrayList<Atributo> atributosCarta = new ArrayList<Atributo>();
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                String atributosStr = "";
                int atributoValor = 0;
                for (String nombreAtributo:atributos.keySet()) {
                    atributosStr = atributosStr + nombreAtributo + ": " +
                            atributos.getInt(nombreAtributo) + "; ";
                	atributoValor = atributos.getInt(nombreAtributo);
                	Atributo atributo = new Atributo(nombreAtributo, atributoValor);
                	atributosCarta.add(atributo);
                }
                Carta c = new Carta(nombreCarta, atributosCarta);
                mazoMaestro.agregar_carta(c);    
            }    
            reader.close();                  
            return mazoMaestro;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return mazoMaestro;
        }
    }
}