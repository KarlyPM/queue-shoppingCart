package ug.estructura.practice;

public class Carrito {
    
    private int numero;
    private String estado;

    public Carrito(int id, String estado) {
        this.numero = id;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Carrito{" + "numero=" + numero + ", estado=" + estado + '}';
    }
    
    
    
}
