import java.util.Optional;

// Esta clase representa una orden de pizza que puede o no incluir número de contacto.
// Cambié el nombre de 'Pedido' a 'OrdenPizza' por claridad y para diferenciarlo del reto original.
public class OrdenPizza {
    private String cliente;
    private String tipoEntrega;  // Puede ser "domicilio" o "local"
    private String telefono;     // Puede ser null

    public OrdenPizza(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    // Método que devuelve un Optional con el número de contacto si existe
    // Renombrado de 'getTelefono()' a 'obtenerContacto()' como parte del reto
    public Optional<String> obtenerContacto() {
        return Optional.ofNullable(telefono);
    }
}
