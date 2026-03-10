package examen_2024;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {

    private String marca;
    private String modelo;
    private double precio;
    private String descripcion;
    private LocalDate fechaIncorporacion;
    private boolean stock;

    public Producto(String marca, String modelo, double precio, String descripcion, boolean stock) throws TiendaException {
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setDescripcion(descripcion);
        setFechaIncorporacion(fechaIncorporacion);
        setStock(stock);
    }

    public void setMarca(String marca) throws TiendaException {
        if (marca == null || marca.isBlank()) {
            throw new TiendaException("El producto debe tener marca");
        }
        this.marca = marca;
    }

    public void setModelo(String modelo) throws TiendaException {
        if (modelo == null || modelo.isBlank()) {
            throw new TiendaException("El producto debe tener modelo");
        }
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) throws TiendaException {
        if (descripcion == null || descripcion.isBlank()) {
            throw new TiendaException("El producto debe tener descripcion");
        }
        this.descripcion = descripcion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) throws TiendaException {
        if (fechaIncorporacion == null) {
            throw new TiendaException("El producto debe tener fcha de incorporacion");
        }
        this.fechaIncorporacion = LocalDate.now();
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public boolean isStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(marca, producto.marca) && Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIncorporacion=" + fechaIncorporacion +
                ", stock=" + stock +
                '}';
    }
}
