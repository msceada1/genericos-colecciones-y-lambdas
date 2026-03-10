package examen_2022;

import java.util.*;
import java.util.stream.Stream;

public class Mazo {
    public static final int INCREMENTO = 1;
    public static final int DECREMENTO = 1;

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

    /**
     * Añade un cromo a la colecion
     * Si el cromo ya existe, incrementa su valor en 1, mientras que si no existe lo aniade por primera vez
     * y su valor por defecto se pone a 1 gracias a la funcion -merge- de la clase -Map-
     *
     * @param cromoAAniadir el cromo que se desea aniadir a la coleccion
     */
    public void addCromo(Cromo cromoAAniadir) {
        cromos.merge(cromoAAniadir, INCREMENTO, Integer::sum);
    }

    /**
     * Intercambia cromos eliminado el perteneciente de la coleccion y aniadiendo el recibido a esta
     *
     * @param cromoDado     el cromo que se da
     * @param cromoRecibido el cromo que se recibe
     * @throws MazoException si el cromo que se da no esta en el mazo
     */
    public void intercambiarCromo(Cromo cromoDado, Cromo cromoRecibido) throws MazoException {
        cromos.merge(cromoRecibido, INCREMENTO, Integer::sum);

        if (!cromos.containsKey(cromoDado)) {
            throw new MazoException("no puedes dar un cromo que no tienes");
        } else {
            cromos.replace(cromoDado, cromos.get(cromoDado), cromos.get(cromoDado) - DECREMENTO);
        }

        if (cromos.get(cromoDado) == 0) {
            cromos.remove(cromoDado);
        }
    }

    /**
     * Devuelve un mazo mezclado entre el que se posee y el que se recibe.
     * Si hay claves duplicadas, deja la clave(para que no haya claves duplicadas)
     * pero suma sus valores (veces que se repite)
     *
     * @param mazoAMezclar el mazo que se mezcla
     * @return un mazo con la mezcla de los mezclados
     */
    public Map<Cromo, Integer> mezclarMazo(Mazo mazoAMezclar) throws MazoException {
        if (mazoAMezclar.getCromos().isEmpty() && this.cromos.isEmpty()) {
            throw new MazoException("No puedo mezclar mazos vacios");
        }
        Map<Cromo, Integer> mazoMezclado = new HashMap<>(this.cromos);

        mazoAMezclar.getCromos().forEach((cromo, cantidad) -> mazoMezclado.merge(cromo, cantidad, Integer::sum));

        return mazoMezclado;
    }

    /**
     * Devuelve los cromos diferentes que tiene el conjunto
     *
     * @return los diferentes cromos que hay
     */
    public long conteoCromos() {
        return cromos.values().stream().distinct().count();
    }

    /**
     * Devuelve los cromos que tienen un equipo especifico0
     *
     * @param equipo el equipo del cromo
     * @return un stream filtrando una lista por el nombre del equipo deseado
     */
    public Stream<Cromo> devolverCromoPorEquipo(String equipo) {
        List<Cromo> cromosPorEquipo = new ArrayList<>(cromos.keySet());

        return cromosPorEquipo.stream().filter(c -> c.getEquipo().equalsIgnoreCase(equipo));
    }

    /**
     * Calcula la media de altura de los jugadores por equipo
     *
     * @param equipo el equipo al que se le desea hacer la media
     * @return la media de los jugadores del equipo deseado
     */
    public double calcularAlturaMediaPorEquipo(String equipo) {
        List<Cromo> clavesCromo = new ArrayList<>(cromos.keySet());
        int contador = 0;
        double sumaAlturas = 0;

        for (Cromo c : clavesCromo) {
            if (c instanceof Jugador j && j.getEquipo().equalsIgnoreCase(equipo)) {
                sumaAlturas += j.getAltura();
                contador++;
            }
        }

        return sumaAlturas / contador;
    }

    public List<Cromo> listaDeCromos() {
        return new ArrayList<>(cromos.keySet());
    }

    public List<Cromo> ordenacionEscudosPrimeros() {
        List<Cromo> orden = new ArrayList<>(cromos.keySet());

        for (Cromo c : orden) {
            if (c instanceof Escudo) {
                orden.add(c);
            }
        }

        for (Cromo c : orden) {
            if (c instanceof Jugador) {
                orden.add(c);
            }
        }

        return orden;
    }

    public List<Cromo> ordenacionEscudoPrimerosPorNombre() {
        List<Cromo> orden = new ArrayList<>(cromos.keySet());

        for (Cromo c : orden) {
            if (c instanceof Escudo) {
                orden.add(c);
                orden.sort(Comparator.comparing(Cromo::getEquipo));
            }
        }

        List<Cromo> orden2 = new ArrayList<>(cromos.keySet());

        for (Cromo c : orden) {
            if (c instanceof Jugador) {
                orden2.add(c);
                orden2.sort(Comparator.comparing(Cromo::getEquipo));
            }
        }

        orden.addAll(orden2);
        return orden2;
    }
}
