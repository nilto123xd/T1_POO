# Evaluación T1 POO

Proyecto sencillo para registrar clientes y sus pedidos usando Java y `ArrayList<Pedido>`.

## Clases

- `Pedido`: contiene los datos del pedido y calcula su importe.
- `Cliente`: contiene los datos del cliente, administra sus pedidos y tiene el método `main`.

## Ejecutar

Desde la carpeta `T1_POO`:

```text
mvn compile exec:java
```

El programa crea un cliente, agrega dos pedidos, cambia el estado de uno y muestra el total.