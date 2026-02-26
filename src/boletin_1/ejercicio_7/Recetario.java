package boletin_1.ejercicio_7;

import java.util.*;

public class Recetario {

    private Map<String, Receta> recetas;


    public void addReceta(Receta nuevaReceta) throws RecetaException {
        if (!recetas.containsKey(nuevaReceta.getNombreReceta())) {
            recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
            return;
        }
        throw new RecetaException("ERROR: La receta ya esxiste");
    }

    public String mostrarRecetasOrdenadasAlfabeticamente() throws RecetaException {
        if (recetas.isEmpty()) {
            throw new RecetaException("Error: El recetario está vacio");
        }

        List<String> listaOrdenada = new ArrayList<>(recetas.keySet());
        listaOrdenada.sort(null);
        return listaOrdenada.toString();
    }

    public StringBuilder mostrarRecetasPorIngredientes(String ingrediente) throws RecetaException {
        StringBuilder sb = new StringBuilder();

        for (Receta r : recetas.values()) {
            if(r.necesitaIngrediente(ingrediente)) {
                sb.append(r.getNombreReceta());
            }
        }

        if (sb.length() == 0) {
            throw new RecetaException("Error: no esxiste recetas con el ingrediente introducido");
        }

        return sb;
    }

    public Map<String, Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(Map<String, Receta> recetas) {
        this.recetas = recetas;
    }
}
