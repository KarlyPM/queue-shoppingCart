
package ug.estructura.practice;


public class Relacion {
    
    //Cliente emparejado con un carrito al momento de hacer las compras
    private Cliente cliente;
    private Carrito carrito;

    public Relacion(Cliente cliente, Carrito carrito) {
        this.cliente = cliente;
        this.carrito = carrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return "Relacion{" + "cliente=" + cliente + ", carrito=" + carrito + '}';
    }
    
    
    
}
