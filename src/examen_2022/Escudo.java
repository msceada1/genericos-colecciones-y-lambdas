package examen_2022;

public class Escudo extends Cromo {

    private String nombreEquipo;
    private int yearOfFundation;
    private int numJugadores;

    public Escudo(String identificador, String nombreEquipo, int yearOfFundation, int numJugadores) throws MazoException {
        super(identificador, nombreEquipo);
        setNombreEquipo(nombreEquipo);
        setYearOfFundation(yearOfFundation);
        setNumJugadores(numJugadores);
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) throws MazoException {
        if (nombreEquipo == null || nombreEquipo.isBlank()) {
            throw new MazoException("El escudo debe tener un nombre de equipo");
        }
        this.nombreEquipo = nombreEquipo;
    }

    public int getYearOfFundation() {
        return yearOfFundation;
    }

    public void setYearOfFundation(int yearOfFundation) throws MazoException {
        if (yearOfFundation < 0) {
            throw new MazoException("El año debe ser positivo");
        }
        this.yearOfFundation = yearOfFundation;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) throws MazoException {
        if (numJugadores < 0) {
            throw new MazoException("El numero de jugadores debe ser positivo");
        }
        this.numJugadores = numJugadores;
    }
}
