package examen_2022;

public abstract class Cromo {

    private String identificador;

    public Cromo(String identificador) throws MazoException {
        setIdentificador(identificador);
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
}
