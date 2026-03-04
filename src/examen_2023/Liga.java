package examen_2023;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Liga {

    private String nombre;
    private List<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.equipos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws LigaException {
        if (nombre == null || nombre.isBlank()) {
            throw new LigaException("La liga debe tener un nombre");
        }
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", equipos=" + equipos +
                '}';
    }

    public void addEquipo(Equipo equipoAInsertar) throws LigaException {
        if (equipoAInsertar.getJugadores().isEmpty()) {
            throw new LigaException("No puedes añadir un equipo sin jugadores");
        }

        for (Equipo e : equipos) {
            if (e != null && e.getNombre().equalsIgnoreCase(equipoAInsertar.getNombre())) {
                throw new LigaException("El equipo que deseas insertar ya existe");
            }
        }

        equipos.add(equipoAInsertar);
    }

    public void eliminaEquipo(Equipo equipoAEliminar) throws LigaException {
        if (!equipos.remove(equipoAEliminar)) {
            throw new LigaException("No se puede eliminar un equipo que no existe");
        }
    }

    public Equipo unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            Equipo equipoFusion = new Equipo("Equipo fusion");
            equipoFusion.setJugadores(e1.getJugadores());
            equipoFusion.getJugadores().addAll(e2.getJugadores());
            return equipoFusion;
        }
        throw new LigaException("Error: Uno de los equipos no ha sido encontrado");
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1)) {
            throw new LigaException("El equipo " + e1.getNombre() + " no se ha encontrado");
        }

        if (!equipos.contains(e2)) {
            throw new LigaException("El equipo " + e2.getNombre() + " no se ha encontrado");
        }

        List<Jugador> jugadoresEnComun = new ArrayList<>(e1.getJugadores());

        jugadoresEnComun.retainAll(e2.getJugadores());

        return jugadoresEnComun;
    }

    public Set<Jugador> todosLosJugadores() {
        Set<Jugador> todos = new HashSet<>();
        for (Equipo e : equipos) {
            todos.addAll(e.getJugadores());
        }
        return todos;
    }

    public List<Jugador> jugadoresOrdenadosEdad() {
        return todosLosJugadores().stream().sorted().toList();
    }

    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream().sorted(Comparator.comparing(Jugador::getNombre)).toList();
    }

    public double mediaEdad() throws LigaException {
        if (equipos.isEmpty()) {
            throw new LigaException("No hay equipos en la liga");
        }
        return todosLosJugadores().stream().mapToInt(j -> Period.between(j.getFechaNacimiento(), LocalDate.now()).getYears())
                .average().orElse(0.0);
    }

}
