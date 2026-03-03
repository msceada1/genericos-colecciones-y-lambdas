package prueba;

import java.util.HashSet;
import java.util.Set;

public class Cromo {
    private String nombre;
    private Set<String> etiquetas;

    public Cromo(String nombre) {
        this.nombre = nombre;
        this.etiquetas = new HashSet<>();
    }

    public void addEtiqueta(String et) {
        this.etiquetas.add(et);
    }

    public String getNombre() {
        return nombre;
    }

    public Set<String> getEtiquetas() {
        return etiquetas;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
