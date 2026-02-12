package boletin_1.ejercicio_1;

import java.util.HashSet;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {

        Alumno a = new Alumno("Manuel", "42546728X");
        Alumno b = new Alumno("Manolo", "53443753A");
        Alumno c = new Alumno("Paco", "427534928D");
        Alumno d = new Alumno("Daniel", "9459343B");
        Alumno e = new Alumno("Pablo", "583135466S");
        Alumno f = new Alumno("Enzo", "85454657J");
        Alumno g = new Alumno("Manuel", "42546728X");

        Set<Alumno> equipo1 = new HashSet<>(Set.of(a, b, c, d));
        Set<Alumno> equipo2 = new HashSet<>(Set.of(e, f, g));

        Equipo equipoLocal = new Equipo("Dream Team", equipo1);
        Equipo equipoVisitante = new Equipo("Los galácticos", equipo2);

        System.out.println("Datos equipo local:");
        System.out.println(equipoLocal);
        System.out.println("Datos equipo visitante");
        System.out.println(equipoVisitante);

        System.out.println("Borrando alumno paco de Dream Team");
        try {
            equipoLocal.deleteAlumno(c);
        } catch (EquipoException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(equipoLocal);

        System.out.println("Fusion de equipos:");

        System.out.println(equipoLocal.unirEquipos(equipoVisitante));

        System.out.println("Interseccion de equipos:");

        System.out.println(equipoLocal.interseccionDeEquipo(equipoVisitante));

        System.out.println("Añadiendo alumno a Los Galacticos");

        Alumno alumno = new Alumno("Zidane", "2364553G");

        try {
            equipoLocal.addAlumno(alumno);
        } catch (EquipoException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(equipoVisitante);
    }
}
