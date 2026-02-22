package boletin_1.ejercicio_5;

import java.util.*;

public class Diccionario {

    private Map<String, List<String>> definiciones;

    public Diccionario() {
        this.definiciones = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Diccionario that)) return false;
        return Objects.equals(definiciones, that.definiciones);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(definiciones);
    }

    /**
     * Metodo encargado de añadir una palabra al diccionario
     *
     * @param palabra     la palabra a añadir
     * @param significado el significado de la palabra
     */
    public void addPalabra(String palabra, String significado) {
        if (definiciones.containsKey(palabra)) { //comprueba si la palabra ya estaba y solo añade el significado
            definiciones.get(palabra).add(significado);
        } else {
            List<String> nuevaLista = new ArrayList<>();
            nuevaLista.add(significado); //añade el significado a la lista
            definiciones.put(palabra, nuevaLista);
        }
    }

    /**
     * Metodo que devuelve las definiciones de una palabra
     *
     * @param palabra la palabra a buscar
     * @return las definiciones de la palabra buscada
     * @throws DiccionarioException si la palabra no se encuentra en el diccionario
     */
    public List<String> buscarPalabra(String palabra) throws DiccionarioException {
        if (!definiciones.containsKey(palabra)) {
            throw new DiccionarioException("La palabra no se ha encontrado en el diccionario");
        }
        return definiciones.get(palabra);
    }

    public void borrarPalabra(String palabraABorrar) throws DiccionarioException {
        if (!definiciones.containsKey(palabraABorrar)) {
            throw new DiccionarioException("La palabra no se ha encontrado en el diccionario");
        }
        definiciones.remove(palabraABorrar);
    }

    public List<String> listadoPalabras(String comienzoPalabra) {
        List<String> listadoPalabras = new ArrayList<>();
        for (String palabra : definiciones.keySet()) {
            if (palabra.toLowerCase().startsWith(comienzoPalabra)) {
                listadoPalabras.add(palabra);
            }
        }
        return listadoPalabras;
    }
}
