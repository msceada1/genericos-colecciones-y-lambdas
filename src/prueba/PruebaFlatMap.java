package prueba;

import java.util.ArrayList;
import java.util.List;

public class PruebaFlatMap {
    List<Usuario> usuarios;

    public PruebaFlatMap() {
        this.usuarios = new ArrayList<>();
    }

    public void addUsuario(Usuario u) {
        this.usuarios.add(u);
    }

    public void imprimeTodosLosCromos() {
        usuarios.stream()
                .flatMap(u -> u.getCromos().stream())
                .filter(c -> c.getNombre().startsWith("A"))
                .forEach(System.out::println);
    }

    public void imprimeUsuariosCromosC() {
        usuarios.stream()
                /*.filter(u -> u.getCromos().stream()
                        .anyMatch(c -> c.getEtiquetas().stream()
                                .anyMatch(e -> e.startsWith("F"))))*/
                .filter(u -> u.getCromos().stream()
                        .flatMap(c -> c.getEtiquetas().stream())
                        .anyMatch(e -> e.startsWith("F")))

                .forEach(u -> System.out.println(u.getNombre()));
    }

    public static void main(String[] args) {
        PruebaFlatMap p = new PruebaFlatMap();
        Cromo c1 = new Cromo("Avatar");
        Cromo c2 = new Cromo("Basdfdas");
        Cromo c3 = new Cromo("Zadsfas");
        Cromo c4 = new Cromo("Ñadad");
        Cromo c5 = new Cromo("Wyllifó");
        Cromo c6 = new Cromo("Asdasd");
        Cromo c7 = new Cromo("Rasdfa");
        Cromo c8 = new Cromo("Viasdf");
        Cromo c9 = new Cromo("Casdfsd");
        Cromo c10 = new Cromo("DAdfadsfa");

        // Etiquetas para el Cromo 1
        c1.addEtiqueta("Coleccionable");
        c1.addEtiqueta("Raro");
        c1.addEtiqueta("Edición 2026");

        // Etiquetas para el Cromo 2
        c2.addEtiqueta("Coleccionable");
        c2.addEtiqueta("Común");
        c2.addEtiqueta("Edición 2026");

        // Etiquetas para el Cromo 3
        c3.addEtiqueta("Coleccionable");
        c3.addEtiqueta("Legendario");
        c3.addEtiqueta("Brillante");

        // Etiquetas para el Cromo 4
        c4.addEtiqueta("Coleccionable");
        c4.addEtiqueta("Raro");
        c4.addEtiqueta("Serie A");

        // Etiquetas para el Cromo 5
        c5.addEtiqueta("Coleccionable");
        c5.addEtiqueta("Común");
        c5.addEtiqueta("Serie A");

        // Etiquetas para el Cromo 6
        c6.addEtiqueta("Coleccionable");
        c6.addEtiqueta("Épico");
        c6.addEtiqueta("Serie B");

// Etiquetas para el Cromo 7
        c7.addEtiqueta("Coleccionable");
        c7.addEtiqueta("Raro");
        c7.addEtiqueta("Serie B");

// Etiquetas para el Cromo 8
        c8.addEtiqueta("Coleccionable");
        c8.addEtiqueta("Común");
        c8.addEtiqueta("Serie C");

// Etiquetas para el Cromo 9
        c9.addEtiqueta("Coleccionable");
        c9.addEtiqueta("Legendario");
        c9.addEtiqueta("Especial");

// Etiquetas para el Cromo 10
        c10.addEtiqueta("Coleccionable");
        c10.addEtiqueta("Épico");
        c10.addEtiqueta("Finalizado");

        Usuario u1 = new Usuario("Paco");
        Usuario u2 = new Usuario("Paqui");

        u1.addCromo(c1);
        u1.addCromo(c2);
        u1.addCromo(c3);
        u1.addCromo(c4);
        u1.addCromo(c5);

        u2.addCromo(c6);
        u2.addCromo(c7);
        u2.addCromo(c8);
        u2.addCromo(c9);
        u2.addCromo(c10);

        p.addUsuario(u1);
        p.addUsuario(u2);

        //p.imprimeTodosLosCromos();

        p.imprimeUsuariosCromosC();

    }

}
