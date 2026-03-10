package examen_2024;

import java.util.HashSet;
import java.util.Set;

public class Categoria {

    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) throws TiendaException {
        setNombre(nombre);
        this.productos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws TiendaException {
        if (nombre == null || nombre.isBlank()) {
            throw new TiendaException("La categoría debe tener nombre");
        }
        this.nombre = nombre;
    }

    /**
     * Inserta un producto siempre que no esté
     *
     * @param producto el producto a aniadir
     * @throws TiendaException si el producto a aniadir ya existe
     */
    public void addProducto(Producto producto) throws TiendaException {
        if (!this.productos.add(producto)) {
            throw new TiendaException("No se puede añadir un producto que ya existe");
        }
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
    }
}
