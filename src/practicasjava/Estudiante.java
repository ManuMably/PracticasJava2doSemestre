
package practicasjava;

import javax.swing.JOptionPane;

public class Estudiante {
    private String id;
    private String nombre;
    private float notas[];
    private int n; // numero de notas
    
    // constructor
    public Estudiante(String id, String nombre, int n){
    this.id = id;
    this.nombre = nombre;
    this.n = n;
    notas = new float[n];
    this.ingresarNotas();
    }
    
    public String getId(){ return id;}
    public String getNombre(){return nombre;}
    
    // metodo para ingresar 
    public void ingresarNotas(){
        for (int i = 0; i < n; i++) {
            notas[i] = Float.parseFloat(JOptionPane.showInputDialog("ingrese la nota"));
        }
    }
    
    // metodo para mostrar solo las notas
    public String mostrarNotas(){
        String salida = "";
        for (int k = 0; k < n; k++) {
            salida += notas[k] + " ";
            
        }
        return salida;
    }
    
    // metodo para mostrar todos los datos (pendiente)
    public String mostrar(){
        String salida = "";
        salida += id + " " + nombre +" "+ mostrarNotas();
        return salida;
    }
    
    // metodo para calcular la nota promedio
    public float calcularPromedio(){
        float suma = 0, prom;
        for (int j = 0; j < n; j++) {
            suma += notas[j];
        }
        prom = suma/n;
        return prom;
    }
    
}
