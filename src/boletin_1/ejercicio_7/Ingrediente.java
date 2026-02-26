package boletin_1.ejercicio_7;

import java.util.Objects;

public class Ingrediente {

    private String nombreIngrediente;
    private double cantidad;

    public Ingrediente(String nombreIngrediente, double cantidad) {
        this.nombreIngrediente = nombreIngrediente.toLowerCase();
        this.cantidad = cantidad;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ingrediente that)) return false;
        return Objects.equals(nombreIngrediente, that.nombreIngrediente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreIngrediente);
    }
}
