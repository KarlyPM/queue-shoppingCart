package ug.estructura.practice;

public class Cliente {
    private String cedula;
    private String nombre;
    private String estado;
    

    public Cliente(String cedula, String nombre, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
