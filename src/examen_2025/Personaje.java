package examen_2025;

import java.util.LinkedList;
import java.util.List;

public class Personaje implements Comparable<Personaje> {

    private String nombre;
    private TRaza TRaza;
    private int vida;
    private int limiteVida;
    private int ki;
    private int limiteKi;
    private List<Ataque> ataques;

    public Personaje(String nombre, TRaza TRaza, int vida, int limiteVida, int ki, int limiteKi) {
        this.nombre = nombre;
        this.TRaza = TRaza;
        this.vida = vida;
        this.limiteVida = limiteVida;
        this.ki = ki;
        this.limiteKi = limiteKi;
        this.ataques = new LinkedList<>();
    }

    public int getLimiteVida() {
        return limiteVida;
    }

    public void setLimiteVida(int limiteVida) {
        this.limiteVida = limiteVida;
    }

    public int getLimiteKi() {
        return limiteKi;
    }

    public void setLimiteKi(int limiteKi) {
        this.limiteKi = limiteKi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public TRaza getRaza() {
        return TRaza;
    }

    public void setRaza(TRaza TRaza) {
        this.TRaza = TRaza;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Personaje personaje)) return false;

        return nombre.equals(personaje.nombre) && TRaza == personaje.TRaza;
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + TRaza.hashCode();
        return result;
    }


    @Override
    public int compareTo(Personaje o) {
        return this.getAtaques().size() - o.getAtaques().size();
    }

    public void addAtaque(Ataque ataque) {
        ataques.add(ataque);
    }
}
