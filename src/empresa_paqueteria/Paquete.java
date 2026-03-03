package empresa_paqueteria;

public class Paquete {

    private static int contador = 1;
    private int numeroDeSeguimiento;
    private String remitente;
    private String destinatario;
    private int prioridad;

    public Paquete(String remitente, String destinatario, int prioridad) {
        contador++;
        this.numeroDeSeguimiento = contador;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.prioridad = prioridad;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Paquete.contador = contador;
    }

    public int getNumeroDeSeguimiento() {
        return numeroDeSeguimiento;
    }

    public void setNumeroDeSeguimiento(int numeroDeSeguimiento) {
        this.numeroDeSeguimiento = numeroDeSeguimiento;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
