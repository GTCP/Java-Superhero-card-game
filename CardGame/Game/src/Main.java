public class Main {
    public static void main(String[] args) {
        Pocima p1=new PocimaPorcentaje(20, "Fortalecedora");
        Pocima p2=new PocimaPorcentaje(55, "Fortalecedora Plus");
        Pocima p3=new PocimaPorcentaje(-25, "Kriptonita");
        Pocima p4=new PocimaPorcentaje(-55, "Reductor de Plomo");
        Pocima p5=new PocimaNumeroEspecifico(4, "Quiero Vale Cuatro");
        Pocima p6=new PocimaNumeroEspecifico(23, "Numero Magico");
        Pocima p7=new PocimaSelectiva(35, "Selectiva Fuerza", "fuerza");
        Pocima p8=new PocimaSelectiva(43, "Selectiva Peso", "peso");
        Pocima p9=new PocimaCocktail(p1,p2,"Cocktail");
        Pocima p10=new PocimaPorcentaje(40, "Fortalecedora");
        Pocima p11=new PocimaPorcentaje(70, "Fortalecedora Plus");
          
        EstrategiaAmbicioso ambicioso = new EstrategiaAmbicioso();
        EstrategiaTimbero timbero = new EstrategiaTimbero();
        
        //----------------------------------------------------------------
        //PRIMER MAZO//
        EstrategiaObstinado Obstinado = new EstrategiaObstinado("velocidad");

        Jugador jugador1 = new Jugador("Guille", timbero);
        Jugador jugador2 = new Jugador("Ligge", timbero);
        
        String mazoPath = "./superheroes.json";
        Mazo mazoMaestro = VisorMazo.cargarMazo(mazoPath);       
        Juego juego = new Juego(jugador1, jugador2, mazoMaestro, 10); 
        
        juego.agregar_pocima(p1);
        juego.agregar_pocima(p2);
        juego.agregar_pocima(p3);
        juego.agregar_pocima(p4);
        juego.agregar_pocima(p5);
        juego.agregar_pocima(p6);
        juego.agregar_pocima(p7);
        juego.agregar_pocima(p8);
        juego.agregar_pocima(p9);  
        juego.agregar_pocima(p10);
        juego.agregar_pocima(p11);
       	juego.jugar();
       	
        juego.obtener_jugador1().set_estrategia(ambicioso);
        juego.obtener_jugador2().set_estrategia(Obstinado);
        //----------------------------------------------------------------
        //SEGUNDO MAZO//  
        Jugador jugador3 = new Jugador("Marta", timbero);
        Jugador jugador4 = new Jugador("Raul", timbero);

        Pocima p19=new PocimaSelectiva(35, "Selectiva HP", "HP");
        Pocima p20=new PocimaSelectiva(43, "Selectiva RPM", "RPM");
        
        String segundoMazoPath = "./autos.json";
        Mazo segundoMazoMaestro = VisorMazo.cargarMazo(segundoMazoPath);       
        Juego juego2 = new Juego(jugador3,jugador4, segundoMazoMaestro, 10); 
        juego2.agregar_pocima(p1);
        juego2.agregar_pocima(p2);
        juego2.agregar_pocima(p3);
        juego2.agregar_pocima(p4);
        juego2.agregar_pocima(p5);
        juego2.agregar_pocima(p6);
        juego2.agregar_pocima(p7);
        juego2.agregar_pocima(p8);
        juego2.agregar_pocima(p9); 
        juego2.agregar_pocima(p19);
        juego2.agregar_pocima(p20);
  
       	juego2.jugar();
       	
        EstrategiaObstinado Obstinado2 = new EstrategiaObstinado("HP");
        juego2.obtener_jugador1().set_estrategia(Obstinado2);
        juego2.obtener_jugador2().set_estrategia(ambicioso);  	
    }
}