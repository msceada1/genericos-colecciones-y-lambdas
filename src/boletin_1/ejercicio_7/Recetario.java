package boletin_1.ejercicio_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Recetario {

    private Map<Receta, Ingrediente> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();
    }

    public Map<Receta, Ingrediente> getRecetas() {
        return recetas;
    }

    public void setRecetas(Map<Receta, Ingrediente> recetas) {
        this.recetas = recetas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Recetario recetario)) return false;
        return Objects.equals(recetas, recetario.recetas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(recetas);
    }
}
