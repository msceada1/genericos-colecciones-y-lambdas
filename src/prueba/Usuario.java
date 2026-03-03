package prueba;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Cromo> cromos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        cromos = new LinkedList<>();
    }

    public List<Cromo> getCromos() {
        return cromos;
    }

    public void addCromo(Cromo c){
        this.cromos.add(c);
    }

    public String getNombre() {
        return nombre;
    }
}
