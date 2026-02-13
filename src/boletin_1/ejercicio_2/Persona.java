package boletin_1.ejercicio_2;

import java.util.LinkedList;
import java.util.List;

public abstract class Persona {

    private static final int EDAD_MINIMA = 12;

    // Atributos
    private String dni;
    private String nombre;
    private int edad;
    private List<Mensaje> mensajes;

    // Constructor
    public Persona(String dni, String nombre, int edad) throws IESException {
        this.dni = dni;
        this.nombre = nombre;
        mensajes = new LinkedList<Mensaje>();
        setEdad(edad);
    }

    // Métodos get y set
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    private void setEdad(int edad) throws IESException {
        if (edad < EDAD_MINIMA)
            throw new IESException("La edad minima es de" + EDAD_MINIMA);
        this.edad = edad;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    public abstract void enviarCorreo(Mensaje mensaje, Persona personaDestinatario) throws IESException;

    /**
     * Si no tiene ningún mensaje salta la excepción
     *
     * @return
     * @throws IESException
     */

    public StringBuilder mostrarMensajes() throws IESException {
        if (mensajes.isEmpty()) {
            throw new IESException("Error: El buzón está vacío");
        }

        int contador = 0;

        StringBuilder sb = new StringBuilder();

        for (Mensaje mensaje : mensajes) {
            sb.append("Mensaje ").append(++contador).append(": ").append(" de: ").append(mensaje.getRemitente()).append("texto :").append(mensaje.getMensaje())
                    .append("Fecha y hora : ").append(mensaje.getFechaYHora());
        }

        return sb;
    }

    public StringBuilder mostrarMensajeOrdenadoAlfabeticamente() throws IESException {
        mensajes.sort(null);
        return mostrarMensajes();
    }

    /**
     * @param numeroMensaje De 1 en adelante
     * @throws IESException
     */
    public void borrarMensaje(int numeroMensaje) throws IESException {

    }

    public void addMensajeABuzon(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public String mostrarMensajesOrdenados() throws IESException {
        return null;
    }


    public String buscarMensajesConTexto(String texto) throws IESException {
        return null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMensajes(LinkedList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
