/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoMariem;

import java.util.Date;

public class Cuenta {
    
    private static int ultimoId = 0;
    
    private int tipo;
    private Date fechaCreacion;
    private float saldo;
    private int idCliente;
    private String nombreCliente;

    // Constructor
    public Cuenta(String nombreCliente) {
        this.idCliente = ++ultimoId;
        this.nombreCliente = nombreCliente;
        this.saldo = 50000.0f;
        this.fechaCreacion = new Date();
    }

    // Getters y setters
    public int getTipo() {
        return tipo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public String toString() {
        return "ID del Cliente: " + idCliente + "\n" +
               "Nombre del Cliente: " + nombreCliente + "\n" +
               "Saldo: " + saldo + "\n" +
               "Fecha de Creación: " + fechaCreacion;
    }

    // Método para mostrar los datos de la cuenta
    public void mostrarDatosCuenta() {
        System.out.println("Tipo de cuenta: " + tipo);
        System.out.println("Fecha de creación: " + fechaCreacion);
        System.out.println("Saldo actual: " + saldo);
        System.out.println("ID del cliente: " + idCliente);
        System.out.println("Nombre del cliente: " + nombreCliente);
    }

    // Método para consignar saldo
    public void consignarSaldo(float monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se ha consignado $" + monto + " en la cuenta.");
        } else {
            System.out.println("El monto a consignar debe ser mayor que 0.");
        }
    }

    // Método para retirar saldo
    public void retirarSaldo(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Se ha retirado $" + monto + " de la cuenta.");
        } else {
            System.out.println("Monto no válido o insuficiente saldo para retirar.");
        }
    }
}
