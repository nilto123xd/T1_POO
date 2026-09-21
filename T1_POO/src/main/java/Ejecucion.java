
public class Ejecucion {

    public static void main(String[] args) {
         
        try {
            Cliente cliente = new Cliente("C001", "Ana Pérez", "ana.perez@universidad.edu");
            cliente.agregarPedido(new Pedido("P001", "Café americano", 2.50, 2));
            cliente.agregarPedido(new Pedido("P002", "Sándwich", 5.00, 1));
            cliente.cambiarEstadoPedido("P001", "Atendido");
            System.out.println(cliente.mostrarDatos());
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
   }      
}
