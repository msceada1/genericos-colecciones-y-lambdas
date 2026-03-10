package examen_2024;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Stream<Producto> productosUltimoAnio() {
        return productos.stream().filter(p -> p.getFechaIncorporacion().isAfter(LocalDate.now().minus(1, ChronoUnit.YEARS)));
    }

    public Stream<Producto> productosOrdenadoPorPrecio() {
        return productos.stream().sorted(Comparator.comparingDouble(Producto::getPrecio).reversed());
    }
}
