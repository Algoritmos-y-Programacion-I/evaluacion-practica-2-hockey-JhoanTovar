package model;
import model.JugadorHockey;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];


    public Equipo(String nombreequipo){
        this.nombreEquipo = nombreequipo;

    }

    public void agregarJugador(JugadorHockey jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = jugador;
                break;
            }
        }
    }
    public String getTeamName(){
        return this.nombreEquipo;
    }

    public JugadorHockey crearjugador(String nombre, int edad, Posicion posicion, int numero){
        JugadorHockey jugador = new JugadorHockey(nombre, edad, posicion, numero);
        return jugador;
    }

    

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}