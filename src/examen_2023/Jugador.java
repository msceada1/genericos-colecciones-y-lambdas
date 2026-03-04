package examen_2023;

import java.time.LocalDate;

public class Jugador implements Comparable<Jugador>{

    private String nombre;
    private LocalDate fechaNacimiento;
    private Demarcacion demarcacion;
    private String paisDeNacimiento;

    public Jugador(String nombre, LocalDate fechaNacimiento, Demarcacion demarcacion, String paisDeNacimiento) throws LigaException {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setDemarcacion(demarcacion);
        setPaisDeNacimiento(paisDeNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws LigaException {
        if (nombre == null || nombre.isBlank()) {
            throw new LigaException("El jugador debe tener nombre");
        }
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) throws LigaException {
        if (fechaNacimiento == null) {
            throw new LigaException("El jugador debe tener fecha de nacimiento");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public Demarcacion getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(Demarcacion demarcacion) throws LigaException {
        if (demarcacion == null) {
            throw new LigaException("El jugador debe tener demarcacion");
        }
        this.demarcacion = demarcacion;
    }

    public String getPaisDeNacimiento() {
        return paisDeNacimiento;
    }

    public void setPaisDeNacimiento(String paisDeNacimiento) throws LigaException {
        if (paisDeNacimiento == null || paisDeNacimiento.isBlank()) {
            throw new LigaException("El jugador debe tener pais de nacimiento");
        }
        this.paisDeNacimiento = paisDeNacimiento;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", demarcacion=" + demarcacion +
                ", paisDeNacimiento='" + paisDeNacimiento + '\'' +
                '}';
    }

    @Override
    public int compareTo(Jugador o) {
        return this.fechaNacimiento.compareTo(o.fechaNacimiento);
    }
}
