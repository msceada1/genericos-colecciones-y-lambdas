package agencia_de_viajes;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cliente implements Comparable<Cliente> {

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

    /**
     * Añade una ruta al conjunto de rutas
     *
     * @param rutaNueva la ruta que se desea añadir
     * @throws AgenciaException si la ruta ya está en el Set
     */
    public void addRuta(Ruta rutaNueva) throws AgenciaException {
        if (!rutas.add(rutaNueva)) {
            throw new AgenciaException("Error: No se puede añadir una ruta existente");
        }
    }

    /**
     * Borra una ruta del conjunto de rutas
     *
     * @param rutaABorrar la ruta que se desea borrar
     * @throws AgenciaException si la ruta no está en el Set
     */
    public void borrarRuta(Ruta rutaABorrar) throws AgenciaException {
        if (!rutas.remove(rutaABorrar)) {
            throw new AgenciaException("error: No puedes borrar una ruta que no tienes");
        }
    }

    public void mostrarRutas() {
        rutas.stream().map(r -> r.getNombre() + " - " + r.getDestinoFinal() + " - " + r.getParadas().stream().
                sorted().collect(Collectors.joining(", "))).forEach(System.out::println);
    }

    public void mostrarRutasYParadas() {
        rutas.stream().flatMap(r -> r.getParadas().stream()).sorted().forEach(System.out::println);
    }

    public Set<Ruta> getRutas() {
        return rutas;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", rutas=" + rutas +
                '}';
    }
}
