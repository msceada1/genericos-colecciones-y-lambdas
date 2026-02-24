package boletin_1.ejercicio_6;

public class Cliente {

    private static int numeroCliente;

    public Cliente() {
        this.numeroCliente++;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;

        return numeroCliente == cliente.numeroCliente;
    }

    @Override
    public int hashCode() {
        return numeroCliente;
    }
}
