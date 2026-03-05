package examen_2022;

public class Jugador extends Cromo {

    private String nombreJugador;
    private String equipo;
    private int altura;

    public Jugador(String identificador, String nombreJugador, String equipo, int altura) throws MazoException {
        super(identificador);
        setNombreJugador(nombreJugador);
        setEquipo(equipo);
        setAltura(altura);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) throws MazoException {
        if (nombreJugador == null || nombreJugador.isBlank()) {
            throw new MazoException("El jugador debe tener nombre");
        }
        this.nombreJugador = nombreJugador;
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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) throws MazoException {
        if (altura <= 0) {
            throw new MazoException("La altura debe ser mayor que cero");
        }
        this.altura = altura;
    }
}
