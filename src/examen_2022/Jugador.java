package examen_2022;

public class Jugador extends Cromo {

    private String nombreJugador;
    private double altura;

    public Jugador(String identificador, String nombreJugador, String equipo, double altura) throws MazoException {
        super(identificador, equipo);
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) throws MazoException {
        if (altura <= 0) {
            throw new MazoException("La altura debe ser mayor que cero");
        }
        this.altura = altura;
    }
}
