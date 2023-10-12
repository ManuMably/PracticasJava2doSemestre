
package practicasjava;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main2 {
    
    public static void main(String[] args) {
        
Scanner leer = new Scanner(System.in);

        int opcion, ne;
        Estudiante VecEstudiante[];
        do {
            ne = Integer.parseInt(JOptionPane.showInputDialog("Cuantos estudiantes son:"));
            VecEstudiante = new Estudiante[ne];
            String menu ="-----------Menu------------\n"
                    + "1. Mostrar datos.\n"
                    + "2. Mostrar promedio.\n"
                    + "3. Mostrar el estudiante con mayor promedio.\n"
                    + "4. mostrar ordenado por nombre.\n"
                    + "5. mostrar ordenado por identificacion.\n"
                    + "6. Permitir modificar nombre.\n"
                    + "7. Permitir modificar las notas.\n"
                    + "0. Salir\n"
                    + "Seleccione una opcion: \n";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            

            switch (opcion) {
                case 1:
                    mostrarDatos(VecEstudiante);
                    break;
                case 2:
                    mostrarNotaPromedio(VecEstudiante);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Saliendo del programa.\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida.\n");
                    break;
            }
        } while (opcion != 0);

        leer.close();     
        
        // Metodo para ingresar los datos
        
        
        
        
        
        
    }
public static void ingresarDatos(Estudiante vecEstudiante[]){
        int p,ne;
        String id, nombre;
            for (p = 0; p < vecEstudiante.length; p++) {
                id = JOptionPane.showInputDialog("Ingrese la identificacion");
                nombre = JOptionPane.showInputDialog("Ingrese el nombre");
                ne = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de notas"));
                vecEstudiante[p] = new Estudiante(id, nombre, ne);
                
            }
        }
// metodo para mostrar los datos ingresados
public static void mostrarDatos(Estudiante vecEstudiante[]){
    String salida = "";
    for (int i = 0; i < 10; i++) {
        salida+=vecEstudiante[i].mostrar()+"\n";
    }
    JOptionPane.showMessageDialog(null, "id Nombre Notas\n"+ salida);
}

// metodo para mostrar id, nombre y nota promedio
public static void mostrarNotaPromedio(Estudiante vec[]){
    String salida = "";
    for (int i = 0; i < 10; i++) {
        salida += vec[i].getId()+" "+vec[i].getNombre()+" "+vec[i].calcularPromedio()+"\n";
    }
    JOptionPane.showMessageDialog(null,"id Nombre promedio\n"+salida);
}

public static void ordenarPorNombre(Estudiante vecEstudiante[]){
int K,j;
Estudiante auxiliar;
    for (K = 0; K  < vecEstudiante.length -1 ; K++) {
        for (j = K + 1; j  < vecEstudiante.length; j ++) {
            if (vecEstudiante[K].getNombre().compareToIgnoreCase(vecEstudiante[j].getNombre())> 0) {
                auxiliar = vecEstudiante[K];
                vecEstudiante[K] = vecEstudiante[j];
                vecEstudiante[j]= auxiliar;
                
            }
            
        }
        
    }
}


}
    
    

