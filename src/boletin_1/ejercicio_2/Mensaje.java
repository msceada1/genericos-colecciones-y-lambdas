package boletin_1.ejercicio_2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mensaje implements Comparable<Mensaje> {

    private Persona remitente;
    private Mensaje mensaje;
    private LocalDateTime fechaYHora;

    public Persona getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }


    @Override
    public int compareTo(Mensaje o) {
        return this.remitente.getNombre().compareTo(o.getRemitente().getNombre());
    }
}
