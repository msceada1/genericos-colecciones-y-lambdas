package agencia_de_viajes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Agencia {

    private Set<Cliente> clientes;

    public Agencia() {
        this.clientes = new HashSet<>();
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void listadoDeClientesPorParada(String nombreParada) {
        clientes.stream().filter(c -> c.getRutas().stream().flatMap(r -> r.getParadas().stream())
                .anyMatch(s -> s.equalsIgnoreCase(nombreParada))).sorted(Cliente::compareTo).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "clientes=" + clientes +
                '}';
    }
}
