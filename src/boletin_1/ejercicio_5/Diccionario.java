package boletin_1.ejercicio_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Diccionario {

    private Map<String, String> miDiccionario;

    public Map<String, String> getMiDiccionario() {
        return miDiccionario;
    }

    public void addPalabra(String palabra, String significado) {
        miDiccionario.put(palabra, significado);
    }


    //public void buscarPalabra(String palabra) {}

    public void setMiDiccionario(Map<String, String> miDiccionario) {
        this.miDiccionario = miDiccionario;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Diccionario that)) return false;

        return miDiccionario.equals(that.miDiccionario);
    }

    @Override
    public int hashCode() {
        return miDiccionario.hashCode();
    }
}
