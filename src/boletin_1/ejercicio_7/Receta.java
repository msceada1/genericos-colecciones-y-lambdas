package boletin_1.ejercicio_7;

import boletin_1.ejercicio_6.Caja;

import java.util.*;
import java.util.stream.Stream;

public class Receta {

    private String nombreReceta;
    private int tiempo;
    private Set<Ingrediente> ingredientes;
    private List<String> pasos;

    public Receta(String nombreReceta, int tiempo) {
        this.nombreReceta = nombreReceta.toLowerCase();
        this.tiempo = tiempo;
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    /**
     * Comprueba si la receta requiere un ingrediente especifico buscando por su nombre
     *
     * @param nombreIngrediente El nombre del ingrediente que se desea verificar
     * @return {@code true} si el ingrediente esta en la receta,
     * {@code false} en caso contrario.
     */
    public boolean necesitaIngrediente(String nombreIngrediente) {
        return ingredientes.stream().anyMatch(i -> i.getNombreIngrediente().equalsIgnoreCase(nombreIngrediente));
    }

    /**
     * Añade un ingrediente a la lista siempre y cuando este no esté.
     * Si el ingrediente que se desea añadir ya estaba, se suma a cantidad la nueva
     *
     * @param ingredienteNuevo El ingrediente que se desea añadir
     */
    public void addIngrediente1(Ingrediente ingredienteNuevo) {
        if (!ingredientes.add(ingredienteNuevo)) {
            for (Ingrediente n : ingredientes) {
                if (n.getNombreIngrediente().equalsIgnoreCase(ingredienteNuevo.getNombreIngrediente())) {
                    n.setCantidad(n.getCantidad() + ingredienteNuevo.getCantidad());
                    break;
                }
            }
        }
    }

/*
    public void addIngrediente2(Ingrediente newIngrediente) {
        if (!ingredientes.add(newIngrediente)) {
            ingredientes.stream().filter(i -> i.getNombreIngrediente().equalsIgnoreCase(newIngrediente.getNombreIngrediente())).
                    findFirst().ifPresent(i -> i.setCantidad(i.getCantidad() + newIngrediente.getCantidad()));
        }
    }

 */

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        if (!ingredientes.remove(ingredienteABorrar)) {
            throw new RecetaException("Error: el ingrediente no se encuentra en la receta");
        }
        pasos.removeIf(p -> p.toLowerCase().contains(ingredienteABorrar.getNombreIngrediente().toLowerCase()));
    }

    public void addPasoDetrasDeOtro(String pasoNuevo, String pasoExistente) throws RecetaException {
        boolean encontrado = false;

        for (String n : pasos) {
            if (n.equalsIgnoreCase(pasoExistente)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            pasos.addLast(pasoNuevo);
        } else {
            throw new RecetaException("El paso no ha sido encontrado");
        }
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Receta receta)) return false;
        return tiempo == receta.tiempo && Objects.equals(nombreReceta, receta.nombreReceta) && Objects.equals(ingredientes, receta.ingredientes) && Objects.equals(pasos, receta.pasos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreReceta, tiempo, ingredientes, pasos);
    }

    @Override
    public String toString() {
        return "Receta{" +
                "nombreReceta='" + nombreReceta + '\'' +
                ", tiempo=" + tiempo +
                ", ingredientes=" + ingredientes +
                ", pasos=" + pasos +
                '}';
    }
}
