package boletin_1.ejercicio_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Almacen {

    static final int MAX_CAJAS = 20;

    private List<Caja> cajas;

    public Almacen() {
        this.cajas = new ArrayList<>(MAX_CAJAS);
    }

    public void asignarCajaACliente(Cliente c) throws CajaException {
        Stream<Caja> cajaAAsignar = cajas.stream();

        cajaAAsignar.filter(Caja::isAbierta).min(null).orElseThrow(CajaException::new);
    }

    public List<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(List<Caja> cajas) {
        this.cajas = cajas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Almacen almacen)) return false;
        return Objects.equals(cajas, almacen.cajas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cajas);
    }
}
