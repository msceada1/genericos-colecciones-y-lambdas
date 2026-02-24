package boletin_1.ejercicio_6;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

    static final int MAX_CAJAS = 20;

    private List<Caja> cajas;

    public Almacen() {
        this.cajas = new ArrayList<>(MAX_CAJAS);
    }
}
