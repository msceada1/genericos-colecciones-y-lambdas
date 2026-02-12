package boletin_1.ejercicio_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {

    private String nombreEquipo;
    private Set<Alumno> alumnos;

    public Equipo(String nombreEquipo, Set alumnos) {
        this.nombreEquipo = nombreEquipo;
        this.alumnos = new HashSet<>();
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;

    }


    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;

        return nombreEquipo.equals(equipo.nombreEquipo) && alumnos.equals(equipo.alumnos);
    }

    @Override
    public int hashCode() {
        int result = nombreEquipo.hashCode();
        result = 31 * result + alumnos.hashCode();
        return result;
    }

    public void addAlumno(Alumno alumnoAInsertar) throws EquipoException {
        if (!alumnos.add(alumnoAInsertar)) {
            throw new EquipoException("No se puedo añadir al alumno");
        }
    }

    public void deleteAlumno(Alumno alumnoABorrar) throws EquipoException {
        if (!alumnos.remove(alumnoABorrar)) {
            throw new EquipoException("El alumno no pertence al equipo");
        }
    }

    public Alumno buscarAlumno(Alumno alumno) {
        if (!alumnos.contains(alumno)) {
            return alumno;
        }

        return null;
    }

    public List<Alumno> devolverListaDeAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public Equipo unirEquipos(Equipo equipo) {
        Set<Alumno> unionDeEquipos = new HashSet<>();
        unionDeEquipos.addAll(this.alumnos);
        unionDeEquipos.addAll(equipo.alumnos);

        return new Equipo("Equipo fusion", unionDeEquipos);

    }

    public Equipo interseccionDeEquipo(Equipo equipo) {
        Set<Alumno> interseccionDeEquipo = new HashSet<>(this.alumnos);
        interseccionDeEquipo.retainAll(equipo.alumnos);

        return new Equipo("Equioi intersectado", interseccionDeEquipo);
    }
}
