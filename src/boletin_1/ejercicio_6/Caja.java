package boletin_1.ejercicio_6;

import java.util.ArrayDeque;
import java.util.Queue;

public class Caja {

    private int numCaja;
    private boolean abierta;
    private Queue<Cliente> clientes;

    public Caja(int numero, boolean abierta) {
        this.numCaja = numero;
        this.abierta = abierta;
        this.clientes = new ArrayDeque<>();
    }

    public int getNumCaja() {
        return numCaja;
    }

    public void setNumCaja(int numCaja) {
        this.numCaja = numCaja;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    /**
     * Metodo que se encarga de abrir la caja del Almacen
     * @param numCaja
     * @throws CajaException
     */
    public void abrirCaja(int numCaja) throws CajaException {
        if (abierta) {
            throw new CajaException("ERROR: La caja numero " + numCaja + " ya estaba abierta");
        }
        setAbierta(true);
    }

    public void cerrarCaja(int numCaja) throws CajaException {
        if (!abierta) {
            throw new CajaException("ERROR: La caja " + numCaja + " ya esta cerrada");
        }
        if (!clientes.isEmpty()) {
            throw new CajaException("Error: La caja " + numCaja + " no se puede cerrar porque aún hay clientes");
        }
        setAbierta(false);
    }



    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Caja caja)) return false;

        return numCaja == caja.numCaja && abierta == caja.abierta;
    }

    @Override
    public int hashCode() {
        int result = numCaja;
        result = 31 * result + Boolean.hashCode(abierta);
        return result;
    }
}
