package examen_2024;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {

    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) throws TiendaException {
        setNombre(nombre);
        this.productos = new HashSet<>();
    }

    public Set<Producto> getProductos() {
        return productos;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Categoria categoria)) return false;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
}
