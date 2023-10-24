/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ces1;

/**
 *
 * @author ROGER
 */
public class Empleado {
    // atributos
    private int cedula;
    private String nombre;
    private String direccion;
    private float salario;
    
    // constructor

    public Empleado() {
    }

    public Empleado(int cedula, String nombre, String direccion, float salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
    }
    
    // getters y setters

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    
    
}
