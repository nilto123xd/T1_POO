public class Pedido {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private String estado;

    public Pedido(String codigo, String descripcion, double precioUnitario, int cantidad) {
        this(codigo, descripcion, precioUnitario, cantidad, "Pendiente");
    }

    public Pedido(String codigo, String descripcion, double precioUnitario, int cantidad, String estado) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        setEstado(estado);
    }

    private String validarTexto(String valor, String mensaje) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = validarTexto(codigo, "El código del pedido no puede estar vacío");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = validarTexto(descripcion, "La descripción no puede estar vacía");
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario <= 0 || Double.isNaN(precioUnitario) || Double.isInfinite(precioUnitario)) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor que cero");
        }
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        estado = validarTexto(estado, "El estado no puede estar vacío");
        if (!estado.equalsIgnoreCase("Pendiente")
                && !estado.equalsIgnoreCase("Atendido")
                && !estado.equalsIgnoreCase("Cancelado")) {
            throw new IllegalArgumentException("El estado debe ser Pendiente, Atendido o Cancelado");
        }
        this.estado = estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();
    }

    public double calcularImporte() {
        return precioUnitario * cantidad;
    }
}