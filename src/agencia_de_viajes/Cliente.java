package agencia_de_viajes;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

    private static int contador = 1;
    private String nombre;
    private int id;
    Set<Ruta> rutas;

    public Cliente(String nombre) throws AgenciaException {
        setNombre(nombre);
        contador++;
        this.id = contador;
        this.rutas = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws AgenciaException {
        if (nombre == null || nombre.isBlank()) {
            throw new AgenciaException("error: El nombre está vacío");
        }
        this.nombre = nombre;
    }

    public void addRuta(Ruta rutaNueva) throws AgenciaException {
        if (!rutas.add(rutaNueva)) {
            throw new AgenciaException("Error: No se puede añadir una ruta existente");
        }
    }

    public void borrarRuta(Ruta rutaABorrar) throws AgenciaException {
        if (!rutas.remove(rutaABorrar)) {
            throw new AgenciaException("error: No puedes borrar una ruta que no tienes");
        }
    }
}
