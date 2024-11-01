package model;

import java.util.Random;
import model.Posicion;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;
    private JugadorHockey[] ganadores;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(4);
        int equipo2;
        do {
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: Equipo " + equipo1 + " vs Equipo " + equipo2;
        fixture += "\n";

        do {
            equipo1 = random.nextInt(4);
            equipo2 = random.nextInt(4);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: Equipo " + equipo1 + " vs Equipo " + equipo2;
        return fixture;
    }

    public void agregarEquipo(Equipo equipo){
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] == null) {
                equipos[i] = equipo;
                break;
            }
        }
        
    }

    public Equipo crearEquipo(String nombreEquipo) {
        Equipo equipo = new Equipo(nombreEquipo);
        return equipo;
    }

    public void añadiryCrearJugadorEnUnEquipo(Equipo equipo, String nombre, int edad, Posicion posicion, int numero) {
        equipo.agregarJugador(equipo.crearjugador(nombre, edad, posicion, numero));
    }

    public void precargar(){
        agregarEquipo(crearEquipo("Jaguares de hielo"));
        agregarEquipo(crearEquipo("Corazon de ella"));

        Equipo jaguares = buscarEquipo("Jaguares de hielo");

        añadiryCrearJugadorEnUnEquipo(jaguares, "Andres", 32, Posicion.PORTERO , 1);

        añadiryCrearJugadorEnUnEquipo(jaguares, "Felipe", 20, Posicion.DEFENSA , 2);      
        añadiryCrearJugadorEnUnEquipo(jaguares, "Camilo", 25, Posicion.DEFENSA , 3);

        añadiryCrearJugadorEnUnEquipo(jaguares, "Juan", 25, Posicion.ALA , 4);      
        añadiryCrearJugadorEnUnEquipo(jaguares, "Pablo", 22, Posicion.ALA , 5);

        añadiryCrearJugadorEnUnEquipo(jaguares, "David", 22, Posicion.CENTRO , 6);
        
        Equipo corazon = buscarEquipo("Corazon de ella");

        añadiryCrearJugadorEnUnEquipo(corazon, "Ingnacio", 22, Posicion.PORTERO , 1);

        añadiryCrearJugadorEnUnEquipo(corazon, "Asta", 19, Posicion.DEFENSA , 2);      
        añadiryCrearJugadorEnUnEquipo(corazon, "Naruto", 21, Posicion.DEFENSA , 3);

        añadiryCrearJugadorEnUnEquipo(corazon, "Felipe", 32, Posicion.ALA , 4);      
        añadiryCrearJugadorEnUnEquipo(corazon, "Martin", 24, Posicion.ALA , 5);

        añadiryCrearJugadorEnUnEquipo(corazon, "Setvan", 21, Posicion.CENTRO , 6);

        arbitros[0] = new ArbitroPrincipal("Andres", 23);
        arbitros[1] = new ArbitroPrincipal("Juan", 32);

        arbitros[2] = new JuezDeLinea("Juan", 21);
        arbitros[3] = new JuezDeLinea("Pablo", 19);

        


    }

    public Equipo buscarEquipo(String nombreposible) {
        Equipo equipoRetorno = null;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null && equipos[i].getTeamName().equalsIgnoreCase(nombreposible)) {
                equipoRetorno = equipos[i];
            }
        }
        return equipoRetorno;
    }

   
    public String mostrarJugada(){
        String mensaje = "";

        ganadores = equipos[0].getJugadores();

        
        mensaje += "Jugador " + ganadores[0].getNumero() + " empieza la jugada pasandole el disco al jugador " + ganadores[1].getNumero()  + "\n";

        for(int i = 0; i > 4; i++){
                mensaje += "Jugador " + ganadores[i +1].getNumero() + ganadores[i].darPase() + "Jugador " +ganadores[i+2].getNumero();

        }

        return mensaje;
    }


}