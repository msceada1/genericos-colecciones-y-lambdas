package agencia_de_viajes;

import java.util.HashSet;
import java.util.Set;

public class Ruta {

    private String nombre;
    private String destinoFinal;
    Set<String> paradas;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        this.paradas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws AgenciaException {
        if (nombre == null || nombre.isBlank()) {
            throw new AgenciaException("Error: La ruta debe tener un nombre");
        }
        this.nombre = nombre;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) throws AgenciaException {
        if (destinoFinal == null || destinoFinal.isBlank()) {
            throw new AgenciaException("Error: El destino final debe tener un nombre");
        }
        this.destinoFinal = destinoFinal;
    }

    /**
     * Añade una parada al conjunto de paradas
     *
     * @param paradaNueva la parada que se desea añadir
     * @throws AgenciaException si la parada ya está en el Set
     */
    public void addParada(String paradaNueva) throws AgenciaException {
        if (!paradas.add(paradaNueva)) {
            throw new AgenciaException("Error: No puedes añadir una parada que ya existe en la ruta");
        }
    }

    /**
     * Borra una parada del conjunto de paradas
     *
     * @param paradaABorrar la parada que se desea borrar
     * @throws AgenciaException si la parada no esta en el Set
     */
    public void borrarParada(String paradaABorrar) throws AgenciaException {
        if (!paradas.remove(paradaABorrar)) {
            throw new AgenciaException("Error: No puedes borrar una parada que no existe en la ruta");
        }
    }
}
