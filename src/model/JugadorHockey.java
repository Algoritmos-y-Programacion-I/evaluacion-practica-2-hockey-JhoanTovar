package model;
import model.IDesplazarseEnPistaConPalo;
import model.IPasarDisco;

public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo, IPasarDisco {
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, Posicion posicion, int numero) {
        super(nombre, edad);
        this.posicion = posicion;
        this.numero = numero;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getNumero(){
        return this.numero;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }


    @Override
    public String desplazarseConPalo(){
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    @Override

    public String darPase(){
        return " le pasa el disco a ";
    }
}