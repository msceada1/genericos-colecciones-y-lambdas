package agencia_de_viajes;

import utils.MiEntradaSalida;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgenciaApp {

    public static void main(String[] args) {
        // 1 y 2: Rutas idénticas
        Ruta ruta1 = new Ruta("Expreso Norte", "Monterrey");
        Ruta ruta2 = new Ruta("Expreso Norte", "Monterrey");

        // 3, 4 y 5: Rutas con el mismo destino final ("Valencia")
        Ruta ruta3 = new Ruta("Costa Azul", "Valencia");
        Ruta ruta4 = new Ruta("Interior Directo", "Valencia");
        Ruta ruta5 = new Ruta("Regional Sur", "Valencia");

        // 6 a 10: Rutas con destinos variados
        Ruta ruta6 = new Ruta("Transoceanica", "Lisboa");
        Ruta ruta7 = new Ruta("Ruta del Sol", "Malaga");
        Ruta ruta8 = new Ruta("Enlace Capital", "Madrid");
        Ruta ruta9 = new Ruta("Circuito Andino", "Santiago");
        Ruta ruta10 = new Ruta("Via Pradera", "Buenos Aires");

        List<Ruta> misRutas = new ArrayList<>(List.of(ruta1, ruta2, ruta3, ruta4, ruta5, ruta6, ruta7, ruta8, ruta9, ruta10));

        try {
            //clientes
            Cliente c1 = new Cliente("Antonio");
            Cliente c2 = new Cliente("Pepe");
            Cliente c3 = new Cliente("Sergio");
            Set<Cliente> clientes = new HashSet<>(Set.of(c1, c2, c3));

            Agencia agencia = new Agencia();
            agencia.setClientes(clientes);

            funcionarApp(agencia, misRutas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN DE RUTAS ---");
        System.out.println("1. Añadir ruta a cliente (Evitar duplicados)");
        System.out.println("2. Eliminar ruta de cliente");
        System.out.println("3. Añadir parada a una ruta");
        System.out.println("4. Eliminar parada de una ruta");
        System.out.println("5. Mostrar rutas de un cliente (Paradas ordenadas)");
        System.out.println("6. Clientes con una parada específica (Ordenados)");
        System.out.println("7. Todas las paradas únicas de un cliente (Ordenadas)");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void funcionarApp(Agencia agencia, List<Ruta> rutas) throws AgenciaException {
        boolean enFuncionamiento = true;

        while (enFuncionamiento) {
            menu();
            int opcion = MiEntradaSalida.leerEnteroEnRango("¿Que deseas hacer?", 1, 8);

            try {
                switch (opcion) {
                    case 1 -> addRutaAUnCliente(agencia, rutas);
                    case 2 -> borrarRutaDeUnCliente(agencia);
                    case 3 -> addParadaAUnaRuta(rutas);
                    case 4 -> borrarParadaDeUnaRuta(rutas);
                    case 5 -> mostrarRutasClienteOrdenadas(agencia);
                    case 6 -> mostrarClientesPorParadaEnRuta(agencia, rutas);
                    case 7 -> mostrarParadas(agencia);
                    case 8 -> enFuncionamiento = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Gracias por usar mi App");
    }

    private static void addRutaAUnCliente(Agencia agencia, List<Ruta> rutas) throws AgenciaException {
        agencia.getClientes().forEach(System.out::println);
        String nombreCliente = MiEntradaSalida.leerCadena("Selecciona el cliente al que deseas añadir una ruta");

        Cliente clienteEncontrado = agencia.getClientes().stream().filter(c -> c != null && c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst().orElseThrow(() -> new AgenciaException("El cliente seleccionado no se encuentra en la lista de clientes"));

        rutas.forEach(System.out::println);
        String nombreRuta = MiEntradaSalida.leerCadena("Indica el nombre de la ruta que deseas añadir");

        Ruta rutaEncontrada = rutas.stream().filter(r -> r != null && r.getNombre().equalsIgnoreCase(nombreRuta))
                .findFirst().orElseThrow(() -> new AgenciaException("La ruta seleccionada no se encuentraen la lista de rutas"));

        System.out.println("Añadiendo la ruta " + rutaEncontrada.getNombre() + " al cliente " + clienteEncontrado.getNombre() + " ...");
        clienteEncontrado.addRuta(rutaEncontrada);
        System.out.println("¡Ruta añadida con éxito!");
    }

    private static void borrarRutaDeUnCliente(Agencia agencia) throws AgenciaException {
        agencia.getClientes().forEach(System.out::println);
        String nombreCliente = MiEntradaSalida.leerCadena("Selecciona el cliente al que deseas borrar una ruta");

        Cliente clienteEncontrado = agencia.getClientes().stream().filter(c -> c != null && c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst().orElseThrow(() -> new AgenciaException("El cliente seleccionado no se encuentra en la lista de clientes"));

        clienteEncontrado.getRutas().forEach(System.out::println);
        String nombreRuta = MiEntradaSalida.leerCadena("Que ruta deseas borrar del cliente " + clienteEncontrado.getNombre() + "?");

        Ruta rutaEncontrada = clienteEncontrado.getRutas().stream().filter(r -> r != null && r.getNombre()
                .equalsIgnoreCase(nombreRuta)).findFirst().orElseThrow(() -> new AgenciaException("La ruta " + nombreRuta
                + " no se encuentra en las rutas del cliente"));

        System.out.println("Borrando ruta del cliente " + clienteEncontrado.getNombre() + " ...");
        clienteEncontrado.borrarRuta(rutaEncontrada);
        System.out.println("Ruta borrada con éxito");
    }

    private static void addParadaAUnaRuta(List<Ruta> rutas) throws AgenciaException {
        rutas.forEach(System.out::println);
        String nombreRuta = MiEntradaSalida.leerCadena("Selecciona la ruta a la que quieres añadir la parada nueva");

        Ruta rutaEncontrada = rutas.stream().filter(r -> r != null && r.getNombre().equalsIgnoreCase(nombreRuta))
                .findFirst().orElseThrow(() -> new AgenciaException("La ruta seleccionada no se encuentra en la lista de rutas"));

        String nombreParada = MiEntradaSalida.leerCadena("Indica el nombre de la parada que deseas añadir a la ruta " + rutaEncontrada.getNombre());
        System.out.println("Añadiendo parada a la ruta " + rutaEncontrada.getNombre());
        rutaEncontrada.addParada(nombreParada);
        System.out.println("Parada añadida con exito!");
    }

    private static void borrarParadaDeUnaRuta(List<Ruta> rutas) throws AgenciaException {
        rutas.forEach(System.out::println);
        String nombreRuta = MiEntradaSalida.leerCadena("Selecciona la ruta a la que quieres borrar la parada");

        Ruta rutaEncontrada = rutas.stream().filter(r -> r != null && r.getNombre().equalsIgnoreCase(nombreRuta))
                .findFirst().orElseThrow(() -> new AgenciaException("La ruta seleccionada no se encuentra en la lista de rutas"));

        rutaEncontrada.getParadas().forEach(System.out::println);
        String nombreParada = MiEntradaSalida.leerCadena("Indica el nombre de la parada que deseas borrar a la ruta " + rutaEncontrada.getNombre());
        System.out.println("Borrando parada a la ruta " + rutaEncontrada.getNombre());
        rutaEncontrada.borrarParada(nombreParada);
        System.out.println("Parada borrada con exito!");
    }

    private static void mostrarRutasClienteOrdenadas(Agencia agencia) throws AgenciaException {
        agencia.getClientes().forEach(System.out::println);
        String nombreCliente = MiEntradaSalida.leerCadena("Selecciona un cliente");

        Cliente clienteEncontrado = agencia.getClientes().stream().filter(c -> c != null && c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst().orElseThrow(() -> new AgenciaException("El cliente seleccionado no se encuentra en la lista de clientes"));

        System.out.println("Rutas del cliente " + clienteEncontrado.getNombre() + " :");
        clienteEncontrado.mostrarRutas();
    }

    private static void mostrarClientesPorParadaEnRuta(Agencia agencia, List<Ruta> rutas) {
        String nombreParada = MiEntradaSalida.leerCadena("Indica el nombre de la parada");

        System.out.println("Buscando...");
        agencia.listadoDeClientesPorParada(nombreParada);
    }

    private static void mostrarParadas(Agencia agencia) throws AgenciaException {
        String nombreCliente = MiEntradaSalida.leerCadena("Selecciona un cliente");
        agencia.getClientes().forEach(System.out::println);

        Cliente clienteEncontrado = agencia.getClientes().stream().filter(c -> c != null && c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst().orElseThrow(() -> new AgenciaException("El cliente seleccionado no se encuentra en la lista de clientes"));

        clienteEncontrado.mostrarRutasYParadas();
    }
}
