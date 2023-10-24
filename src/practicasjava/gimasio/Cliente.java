
package practicasjava.gimasio;

import java.util.Date;


public class Cliente {
    private int idCliente;
    private int frecuenciaMes;
    private float peso;
    private float porcentajeMasaMuscular;
    private Date fechaVinculacion;
    private Date fechaActual;
    private String nombre;
    
    public Cliente(int idCliente, String nombre, float peso, float porcentajeMasaMuscular, int frecuenciaMes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.peso = peso;
        setPorcentajeMasaMuscular(porcentajeMasaMuscular);
        this.frecuenciaMes = frecuenciaMes;
        this.fechaVinculacion = new Date(); // Se inicializa con la fecha actual
        this.fechaActual = new Date(); // Se inicializa con la fecha actual
    }
    
    public String toString() {
    return "ID: " + idCliente +
           ", Nombre: " + nombre +
           ", Peso: " + peso +
           ", Masa Muscular: " + porcentajeMasaMuscular +
           ", Frecuencia Mensual: " + frecuenciaMes +
           ", Fecha Vinculación: " + fechaVinculacion;
}
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getFrecuenciaMes() {
        return frecuenciaMes;
    }

    public void setFrecuenciaMes(int frecuenciaMes) {
        this.frecuenciaMes = frecuenciaMes;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPorcentajeMasaMuscular() {
        return porcentajeMasaMuscular;
    }

    public void setPorcentajeMasaMuscular(float porcentajeMasaMuscular) {
        if (porcentajeMasaMuscular >= 0 && porcentajeMasaMuscular <= 100) {
            this.porcentajeMasaMuscular = porcentajeMasaMuscular;
        } else {
            throw new IllegalArgumentException("El porcentaje de masa muscular debe estar en el rango de 0 a 100.");
        }
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
