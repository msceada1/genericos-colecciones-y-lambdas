package examen_2024;

import java.util.HashSet;
import java.util.Set;

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

    public void eliminarProducto(Producto producto) {

    }
}
