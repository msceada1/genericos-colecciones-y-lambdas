package examen_2022;

import java.util.HashMap;
import java.util.Map;

public class Mazo {

    private Map<Cromo, Integer> cromos;

    public Mazo() {
        this.cromos = new HashMap<>();
    }

    public Map<Cromo, Integer> getCromos() {
        return cromos;
    }

    public void setCromos(Map<Cromo, Integer> cromos) {
        this.cromos = cromos;
    }

    public void addCromo(Cromo c) {

    }
}
