package examen_2023;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        Jugador j1 = null;
        try {
            j1 = new Jugador("Bermudiño", Demarcacion.DELANTERO, LocalDate.of(1985, 8, 24), "Brasil");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j2 = null;
        try {
            j2 = new Jugador("Santana", Demarcacion.PORTERO, LocalDate.of(1970, 6, 22), "España");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j3 = null;
        try {
            j3 = new Jugador("García", Demarcacion.DEFENSA, LocalDate.of(1990, 3, 10), "Argentina");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j4 = null;
        try {
            j4 = new Jugador("Lopez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1988, 11, 15), "Colombia");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j5 = null;
        try {
            j5 = new Jugador("Perez", Demarcacion.DEFENSA, LocalDate.of(1992, 2, 8), "México");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j6 = null;
        try {
            j6 = new Jugador("González", Demarcacion.DELANTERO, LocalDate.of(1995, 9, 1), "Perú");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j7 = null;
        try {
            j7 = new Jugador("Hernández", Demarcacion.CENTROCAMPISTA, LocalDate.of(1987, 7, 14), "Chile");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j8 = null;
        try {
            j8 = new Jugador("Martínez", Demarcacion.PORTERO, LocalDate.of(1983, 4, 28), "Uruguay");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j9 = null;
        try {
            j9 = new Jugador("Castro", Demarcacion.DEFENSA, LocalDate.of(1994, 12, 20), "Venezuela");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j10 = null;
        try {
            j10 = new Jugador("Ramírez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1993, 5, 12), "Ecuador");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j11 = null;
        try {
            j11 = new Jugador("Flores", Demarcacion.DELANTERO, LocalDate.of(1989, 10, 6), "Bolivia");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j12 = null;
        try {
            j12 = new Jugador("Ruiz", Demarcacion.PORTERO, LocalDate.of(1981, 1, 18), "Paraguay");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j1bis = null;
        try {
            j1bis = new Jugador("Bermudiño", Demarcacion.CENTROCAMPISTA, LocalDate.of(1985, 8, 24), "Brasil");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j2bis = null;
        try {
            j2bis = new Jugador("Santana", Demarcacion.DEFENSA, LocalDate.of(1970, 6, 22), "España");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j3bis = null;
        try {
            j3bis = new Jugador("García", Demarcacion.PORTERO, LocalDate.of(1990, 3, 10), "Argentina");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j4bis = null;
        try {
            j4bis = new Jugador("Lopez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1988, 11, 15), "Colombia");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }
        Jugador j5bis = null;
        try {
            j5bis = new Jugador("Perez", Demarcacion.DEFENSA, LocalDate.of(1992, 2, 8), "México");
        } catch (LigaException e) {
            System.out.println(e.getMessage());
        }

        Equipo e1 = new Equipo("Real Betis Balompié");
        Equipo e2 = new Equipo("La Redondela Football Club");
        Equipo e3 = new Equipo("Isla United");
        Equipo e4 = new Equipo("Vacío de Munich");

        e1.addJugador(j1);
        e1.addJugador(j2);
        e1.addJugador(j3);
        e1.addJugador(j4);
        e1.addJugador(j5bis);

        System.out.println(e1);

        e2.addJugador(j3);
        e2.addJugador(j6);
        e2.addJugador(j7);
        e2.addJugador(j8);
        e2.addJugador(j9);

        System.out.println(e2);

        e3.addJugador(j4);
        e3.addJugador(j5);
        e3.addJugador(j10);
        e3.addJugador(j11);
        e3.addJugador(j12);

        System.out.println(e3);

        //Las siguientes líneas no deberían añadir al jugador
        e1.addJugador(j1bis);
        e2.addJugador(j3);
        e2.addJugador(j3bis);
        e3.addJugador(j4bis);

        System.out.println(e1);

        Equipo e5 = new Equipo("Borrame FC");
        e5.addJugador(j1bis);
        e5.addJugador(j2bis);
        e5.addJugador(j3bis);
        e5.addJugador(j4bis);
        e5.addJugador(j5bis);


        Liga laLiga = new Liga("LaLiga Miravent");

        //Consulta que debe fallar, pues no hay equipos en la liga
        try {
            System.out.printf("Media de edad de la liga: %.2f\n", laLiga.mediaEdad());
        } catch (LigaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("##########");

        try {
            laLiga.addEquipo(e1);
            laLiga.addEquipo(e2);
            laLiga.addEquipo(e3);
            laLiga.addEquipo(e5);

            //Esta línea no puede funcionar
            laLiga.addEquipo(e4);
        }
        catch (LigaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("##########");
        //Visualicemos la liga hasta ahora
        System.out.println(laLiga);
        System.out.println("##############");

        // Esto debe fallar
        Equipo e6 = new Equipo("FC Sin liga");
        try {
            e6.addJugador(j1);
            laLiga.eliminaEquipo(e6);
        }
        catch (LigaException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("##########");
        //Esto debe eliminar el equipo
        try {
            laLiga.eliminaEquipo(e5);
        }
        catch (LigaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(laLiga);
        System.out.println("############");
        System.out.println("Visualicemos ahora los jugadores en común de los equipos 1 y 3");

        try {
            for (Jugador j: laLiga.jugadoresEnComun(e1, e3)) {
                System.out.println(j);
            }
        } catch (LigaException e) {
            System.err.println(e.getMessage());
        }

        //Unión de los equipos 6 y 2
        System.out.println("############");
        System.out.println("Visualicemos ahora la unión de los equipos 6 y 2");

        try {
            laLiga.addEquipo(e6);
            laLiga.unirEquipos(e6, e2);
        } catch (LigaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(e6);

        System.out.println();
        System.out.println("############");
        //Mostramos los jugadores ordenados por edad
        System.out.println("Jugadores ordenados por edad");
        laLiga.jugadoresOrdenadosEdad().forEach(System.out::println);

        System.out.println();
        System.out.println("############");
        //Mostramos los jugadores ordenados por edad
        System.out.println("Jugadores ordenados por nombre");
        laLiga.jugadoresOrdenadosNombre().forEach(System.out::println);

        System.out.println();
        System.out.println("############");
        try {
            System.out.printf("Media de edad de la liga: %.2f\n", laLiga.mediaEdad());
        } catch (LigaException e) {
            System.err.println(e.getMessage());
        }

    }

}

