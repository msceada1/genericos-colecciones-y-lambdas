package examen_2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Equipo {

    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws LigaException {
        if (nombre == null || nombre.isBlank()) {
            throw new LigaException("El equipo debe tener nombre");
        }
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;

        return nombre.equals(equipo.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
