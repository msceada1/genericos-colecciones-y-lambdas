package examen_2025;

import java.util.PrimitiveIterator;

public class Ataque {

    private static final int MIN_PERFECCION_ATAQUE = 1;
    private static final int MAX_PERFECCION_ATAQUE = 3;
    private static final int MIN_DANIO = 0;
    private static final int MIN_KI = 0;

    private String nombre;
    private int ki;
    private int perfeccionAtaque;
    private int danioAtaque;

    public Ataque(String nombre, int ki, int perfeccionAtaque, int danioAtaque) throws DBException {
        this.nombre = nombre;
        setKi(ki);
        setPerfeccionAtaque(perfeccionAtaque);
        setDanioAtaque(danioAtaque);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) throws DBException {
        if (ki <= MIN_KI) {
            throw new DBException("el ki debe ser mayor que cero");
        }
        this.ki = ki;
    }

    public int getPerfeccionAtaque() {
        return perfeccionAtaque;
    }

    public void setPerfeccionAtaque(int perfeccionAtaque) throws DBException {
        if (perfeccionAtaque < MIN_PERFECCION_ATAQUE || perfeccionAtaque > MAX_PERFECCION_ATAQUE) {
            throw new DBException("la perfeccion de ataque debe estar entre uno y 3");
        }
        this.perfeccionAtaque = perfeccionAtaque;
    }

    public int getDanioAtaque() {
        return danioAtaque;
    }

    public void setDanioAtaque(int danioAtaque) throws DBException {
        if (danioAtaque <= MIN_DANIO) {
            throw new DBException("el ataque debe ser mayor que cero");
        }
        this.danioAtaque = danioAtaque;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Ataque ataque)) return false;

        return perfeccionAtaque == ataque.perfeccionAtaque && danioAtaque == ataque.danioAtaque && nombre.equals(ataque.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + perfeccionAtaque;
        result = 31 * result + danioAtaque;
        return result;
    }
}
