package examen_2024;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Tienda {

    private Set<Categoria> categorias;

    public Tienda() {
        this.categorias = new HashSet<>();
    }

    public void addCategoria(Categoria categoria) throws TiendaException {
        if (!categorias.add(categoria)) {
            throw new TiendaException("No puedes añadir una categoria que ya existe");
        }
    }

    public void addProducto(Producto producto, Set<Categoria> categoriasRecibidas) throws TiendaException {
        if (!categorias.containsAll(categoriasRecibidas)) {
            throw new TiendaException("Error: Una categoría no fue encontrada");
        }
        this.categorias.stream().filter(categoriasRecibidas::contains).forEach(c -> c.addProducto(producto));
    }

    public Stream<Categoria> categoriasConProductosSinStock() {
        return categorias.stream().filter(c -> c.getProductos().stream().anyMatch(p -> !p.isStock()));
    }

    public Stream<Categoria> categoriasALasQuePerteneceUnProducto(Producto producto) {
        return categorias.stream().filter(c -> c.getProductos().contains(producto));
    }

    public Stream<Producto> productosPorPrecio() {
        return categorias.stream().flatMap(c -> c.getProductos().stream()).distinct().
                sorted(Comparator.comparingDouble(Producto::getPrecio).reversed());
    }

    public void eliminarProducto(Producto producto) {
        categorias.forEach(c -> c.eliminarProducto(producto));
    }

    public Stream<Producto> productosUltimoAnio() {
        return categorias.stream().flatMap(c -> c.getProductos().stream()).filter
                (p -> p.getFechaIncorporacion().isAfter(LocalDate.now().minusYears(1)));
    }
}
