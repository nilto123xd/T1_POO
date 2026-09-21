import java.util.ArrayList;

public class Cliente {
    private String codigo;
    private String nombreCompleto;
    private String correoElectronico;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String codigo, String nombreCompleto, String correoElectronico) {
        setCodigo(codigo);
        setNombreCompleto(nombreCompleto);
        setCorreoElectronico(correoElectronico);
    }

    private String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    private String validarCorreo(String correo) {
        String valor = validarTexto(correo, "El correo electrónico no puede estar vacío");
        if (!valor.contains("@") || !valor.contains(".")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        return valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = validarTexto(codigo, "El código del cliente no puede estar vacío");
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = validarTexto(nombreCompleto, "El nombre no puede estar vacío");
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = validarCorreo(correoElectronico);
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        if (buscarPedido(pedido.getCodigo()) != null) {
            throw new IllegalArgumentException("El código del pedido ya existe dentro del cliente");
        }
        pedidos.add(pedido);
    }

    public Pedido buscarPedido(String codigoPedido) {
        if (codigoPedido == null) {
            return null;
        }
        int indice = 0;
        while (indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            if (pedido.getCodigo().equals(codigoPedido.trim())) {
                return pedido;
            }
            indice++;
        }
        return null;
    }

    public void cambiarEstadoPedido(String codigoPedido, String nuevoEstado) {
        Pedido pedido = buscarPedido(codigoPedido);
        if (pedido == null) {
            throw new IllegalArgumentException("No existe un pedido con ese código");
        }
        pedido.setEstado(nuevoEstado);
    }

    public double calcularTotal() {
        double total = 0;
        int indice = 0;
        while (indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            total += pedido.calcularImporte();
            indice++;
        }
        return total;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public String mostrarDatos() {
        String datos = "Código: " + codigo + "\n";
        datos += "Nombre: " + nombreCompleto + "\n";
        datos += "Correo: " + correoElectronico + "\n";
        datos += "Pedidos:\n";
        int indice = 0;
        while (indice < pedidos.size()) {
            Pedido pedido = pedidos.get(indice);
            datos += "  Código: " + pedido.getCodigo();
            datos += ", Descripción: " + pedido.getDescripcion();
            datos += ", Precio: " + pedido.getPrecioUnitario();
            datos += ", Cantidad: " + pedido.getCantidad();
            datos += ", Estado: " + pedido.getEstado();
            datos += ", Importe: " + pedido.calcularImporte() + "\n";
            indice++;
        }
        datos += "Total: " + calcularTotal();
        return datos;
    }

}
