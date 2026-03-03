package empresa_paqueteria;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ruta {

    private String nombre;
    private Deque<Paquete> paquetes;

    public Ruta(String nombre) {
        this.nombre = nombre;
        this.paquetes = new ArrayDeque<>();
    }
}
