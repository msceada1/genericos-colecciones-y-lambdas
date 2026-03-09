package examen_2022;

import java.util.Objects;

public abstract class Cromo implements Comparable<Cromo> {

    private String identificador;
    private String equipo;

    public Cromo(String identificador, String equipo) throws MazoException {
        setIdentificador(identificador);
        setEquipo(equipo);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) throws MazoException {
        if (identificador == null || identificador.isBlank()) {
            throw new MazoException("El cromo debe tener un identificador");
        }
        this.identificador = identificador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) throws MazoException {
        if (equipo == null || equipo.isBlank()) {
            throw new MazoException("El jugador debe tener equipo");
        }
        this.equipo = equipo;
    }

    @Override
    public int compareTo(Cromo o) {
        return this.getIdentificador().compareTo(o.getIdentificador());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cromo cromo)) return false;
        return Objects.equals(identificador, cromo.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }
}
