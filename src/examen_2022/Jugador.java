package examen_2022;

public class Jugador extends Cromo{

    private String nombreJugador;
    private String equipo;
    private int altura;

    public Jugador(String identificador, String nombreJugador, String equipo, int altura) throws MazoException {
        super(identificador);
        this.nombreJugador = nombreJugador;
        this.equipo = equipo;
        this.altura = altura;
    }
}
