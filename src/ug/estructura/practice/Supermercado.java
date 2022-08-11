package ug.estructura.practice;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Supermercado {
    
    static ArrayList<Relacion> usuariosComprando = new ArrayList<>();

    static Queue<Cliente> clientes = new LinkedList<>();
    static Stack<Carrito> carritos = new Stack<>();
    static Caja[] cajas;
    static int[] numeroClientesAtendidos;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=7) {
                System.out.println("\nMENU PRINCIPAL");
    		System.out.println("******************");
    		System.out.println("1. CARGAR CLIENTES");
    		System.out.println("2. CARGAR CARRITOS Y CAJAS");
    		System.out.println("3. COLOCAR CLIENTES EN COLA DE CARRITOS");
    		System.out.println("4. COLOCAR CLIENTES EN CAJA PARA PAGAR");
    		System.out.println("5. SACAR CLIENTE DE CAJA");
                System.out.println("6. TOTAL DE CLIENTES ATENDIDOS");
    		System.out.println("7. SALIR");
    		System.out.print("INGRESE UNA OPCION: ");
                opcion= sc.nextInt();
                
                if(opcion == 1){
    		    cargarClientes(clientes);
    		}
                else if (opcion==2){
    		    cargarCarritosYCajas(carritos);
    		}
                else if (opcion==3){
    		    if (clientes.isEmpty() || carritos.isEmpty()) {
                        System.out.println("No se han cargado los datos");

                    } else {
                        clienteEnColaCarrito();
                    }
    		}
                else if (opcion==4){
    		    if (usuariosComprando.isEmpty()) {
                        System.out.println("No hay clientes comprando");
                    } else {
                        clienteEnCaja();
                    }
    		}
                else if (opcion==5){
    		    if (cajas == null) {
                        System.out.println("No se han cargado las cajas");
                    } else {
                        sacarClientes();
                    }
    		}
                else if (opcion==6){
                    if (cajas == null) {
                        System.out.println("No se han cargado las cajas");
                    } else {
                        totalClientes();
                    }
                    break;                    
                }
        }
    }

    
    public static void sacarClientes(){
        for (int i = 0; i < cajas.length; i++) {
            while (!cajas[i].getClientesEnCola().isEmpty()) {
                Relacion relacion = cajas[i].getClientesEnCola().poll();

                relacion.getCarrito().setEstado("Desocupado");
                carritos.push(relacion.getCarrito());
                relacion.getCliente().setEstado("Antendido");
                
                numeroClientesAtendidos[i]++;
                System.out.println("Cliente: "+ relacion.getCliente().getNombre() + " / "+ relacion.getCliente().getEstado()+ " / Se ha retirado");
            }

                cajas[i].setEstado("Libre");
                
        }
    }
    
    
    public static void clienteEnColaCarrito(){
        int nClientes = clientes.size();
        for (int i = 0; i < nClientes; i++) {
            //Se empareja un carrito con un cliente
            Carrito carrito = carritos.pop();
            Cliente cliente = clientes.poll();
            usuariosComprando.add(new Relacion(cliente,carrito));
            carrito.setEstado("Ocupado");
            System.out.println("Cliente: "+  cliente.getNombre()+ " - Cedula: "+cliente.getCedula() + " - Nº de carrito: " + carrito.getNumero());
        }    
    }
    
    
    
    public static void clienteEnCaja(){
        System.out.println("TOTAL DE CLIENTES EN CAJA: " + usuariosComprando.size());
        while (!usuariosComprando.isEmpty()) {
            Relacion relacion = usuariosComprando.remove(0);
            //Colocar el cliente emparejado con su carrito en la caja con menos clientes
            Caja cajaConMenosClientes = null;
            for (int i = 0; i < cajas.length; i++) {
                if (cajaConMenosClientes == null || cajas[i].getClientesEnCola().size() < cajaConMenosClientes.getClientesEnCola().size()) {
                    cajaConMenosClientes = cajas[i];
                }
            }
            cajaConMenosClientes.getClientesEnCola().add(relacion);
            cajaConMenosClientes.setEstado("Ocupada");
            System.out.println("Identificadion de Cliente: "+ relacion.getCliente().getCedula() + " /Nº de caja: " + cajaConMenosClientes.getNumero());
        }  

    }
    
    public static void totalClientes(){
        for (int i = 0; i < cajas.length; i++) {
            System.out.print("CAJA ");
            System.out.println(cajas[i].getNumero());
            System.out.println(numeroClientesAtendidos[i] + " clientes atentidos");
        }
    }
    
    public static void cargarCarritosYCajas(Stack<Carrito> carritos) {
        if (carritos.isEmpty()) {
            for (int i = 1; i <= 25; i++) {
                carritos.push(new Carrito(i, "Desocupado"));
            }
            System.out.println("\nSE CARGARON " + carritos.size() + " CARRITOS...");

            cajas = new Caja[3];
            numeroClientesAtendidos = new int[3];
            for (int i = 1; i <= 3; i++) {
                //L: Libre
                cajas[i - 1] = new Caja(i, "Libre");
                numeroClientesAtendidos[i - 1] = 0;
            }
            System.out.println("SE CARGARON " + cajas.length + " CAJAS...");
        }
    }
    
    public static void cargarClientes(Queue<Cliente> clientes) {
        if (clientes.isEmpty()) {
            clientes.addAll(Arrays.asList(
                    new Cliente("0932054601", "Maria", "No antendido"),
                    new Cliente("0932054602", "Pedro", "No antendido"),
                    new Cliente("0932054603", "Luis", "No antendido"),
                    new Cliente("0932054604", "Arturo", "No antendido"),
                    new Cliente("0932054605", "Armando", "No antendido"),
                    new Cliente("0932054606", "Manuel", "No antendido"),
                    new Cliente("0932054607", "Jose", "No antendido"),
                    new Cliente("0932054608", "Miguel", "No antendido"),
                    new Cliente("0932054609", "Erick", "No antendido"),
                    new Cliente("0932054610", "Bruno","No antendido"),
                    new Cliente("0932054611", "Benjamin", "No antendido"),
                    new Cliente("0932054612", "Rebeca", "No antendido"),
                    new Cliente("0932054613", "Laura", "No antendido"),
                    new Cliente("0932054614", "Ezequiel", "No antendido"),
                    new Cliente("0932054615", "Andres", "No antendido"),
                    new Cliente("0932054616", "Raul", "No antendido"),
                    new Cliente("0932054617", "Karen", "No antendido"),
                    new Cliente("0932054618", "Andrea", "No antendido"),
                    new Cliente("0932054619", "Kennya","No antendido"),
                    new Cliente("0932054620", "Rosaura", "No antendido")
            ));
            
            System.out.println("\nSE HAN CARGADO LOS CLIENTES...");
        }
    }

}
