package ug.estructura.practice;

import java.util.LinkedList;
import java.util.Queue;

class Caja {
    
    private int numero;
    private String estado;
    private final Queue<Relacion> clientesEnCola = new LinkedList<Relacion>();

    public Caja(int numero, String estado) {
        this.numero = numero;
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

    public Queue<Relacion> getClientesEnCola() {
        return clientesEnCola;
    }

    
    
    
    
    
    
    
}
