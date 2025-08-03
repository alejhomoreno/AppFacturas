package org.amoreno.appfacturas;

import org.amoreno.appfacturas.domain.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Alejandro");

        Scanner teclado = new Scanner(System.in);
        System.out.println("Inrese una desipcion de la factura: ");
        String desc = teclado.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();
        for (int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto nº " + producto.getCodigo() + ": ");
            nombre = teclado.nextLine();
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio: ");
            precio = teclado.nextFloat();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = teclado.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println();
            teclado.nextLine();

        }
        System.out.println(factura.generarDetalle());
    }
}
