
package vacas;

import vacas.Vaca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Establo {
    
    private static final int taMax = 100;
    private static Vaca[] arregloVacas = new Vaca[taMax];
    private static int n = 0;
    
    
    public static void cargarEstablo() {
    String archivoEstablo = "C:\\Users\\ROGER\\Documents\\NetBeansProjects\\PracticasJava\\PracticasJava2doSemestre\\src\\practicasjava\\ArchivosPlanos\\Vacas.txt";

    try (BufferedReader lector = new BufferedReader(new FileReader(archivoEstablo))) {
        String linea;
        while ((linea = lector.readLine()) != null) {
            // Dividir la línea en partes usando el separador ";".
            String[] partes = linea.split(";");
            
            if (partes.length == 4) { // Asumiendo que hay 4 partes en cada línea
                String nombre = partes[0];
                int tipo = Integer.parseInt(partes[1]);
                float litros = Float.parseFloat(partes[2]);
                float precio = Float.parseFloat(partes[3]);
                
                // Crear un objeto Vaca y agregarlo a tu arreglo o colección de vacas.
                Vaca vaca = new Vaca(nombre, tipo, litros, precio);
                insertarPpio(vaca);
                
            }
        }

        System.out.println("Establo cargado desde el archivo.");
    } catch (IOException e) {
        System.err.println("Error al cargar el establo desde el archivo: " + e.getMessage());
    }
}






    
    public static void guardarEstablo() {
            String archivoEstablo = "C:\\Users\\ROGER\\Documents\\NetBeansProjects\\PracticasJava\\PracticasJava2doSemestre\\src\\practicasjava\\ArchivosPlanos\\Vacas.txt";

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoEstablo))) {
                for (int i = 0; i < n; i++) {
                    Vaca vaca = arregloVacas[i];
                    String linea = vaca.getNombre() + ";"+vaca.getTipo()+";"+vaca.getLitros()+";"+vaca.getPrecio()+";";

                    escritor.write(linea);
                    escritor.newLine();
                }

                System.out.println("Establo actual guardado en el archivo.");
            } catch (IOException e) {
                System.err.println("Error al guardar establo registrados en el archivo: " + e.getMessage());
            }
        }
    
        public static void insertarPpio(Vaca va) {
        if (n == taMax) {
            System.out.println("No se pueden insertar más vacas, el arreglo está lleno.");
        } else {
            // Mueve todos los elementos hacia la derecha para hacer espacio para el nuevo elemento.
            for (int i = n; i > 0; i--) {
                arregloVacas[i] = arregloVacas[i - 1];
            }

            // Inserta el nuevo elemento en la posición 0.
            arregloVacas[0] = va;
            n++; // Incrementa el contador de elementos válidos.
            System.out.println("Vaca insertada.");
        }
    }
        public static String mostrar(){
            int i;
            String s = "";
                for (i = 0; i < n; i++) {
                    s += arregloVacas[i].toString();
                }
                return s;
            }
        
        //metodo baraja
        public static void ordenarPorNombre() {
            int i, j;
            String clave;
            Vaca auxVac = new Vaca();

            for (i = 1; i < n; i++) {
                clave = arregloVacas[i].getNombre();
                auxVac = arregloVacas[i];
                j = i - 1;

                while (j >= 0 && arregloVacas[j].getNombre().compareTo(clave) > 0) {
                    arregloVacas[j + 1] = arregloVacas[j];
                    j--;
                }

                arregloVacas[j + 1] = auxVac;
            }
        }
        public static int busquedaBinaria(float vaLitros) {   
    int inicio = 0;
    int fin = n - 1;

    while (inicio <= fin) {
        
        int posm = (fin + inicio) / 2;
        float litrosActual = arregloVacas[posm].getLitros();

        if (litrosActual == vaLitros) {
            return posm + 1;
        } else if (litrosActual > vaLitros) {
            inicio = posm + 1;
        } else {
            fin = posm - 1;
        }
    }

    return -1; // Elemento no encontrado
}
        
        //busqueda binaria 
        public static String buscarPorNombreOrdenado(String nom) {
            int inicio = 0;
            int fin = n - 1;

            while (inicio <= fin) {
                int medio = (inicio + fin) / 2;
                int comparacion = arregloVacas[medio].getNombre().compareTo(nom);

                if (comparacion == 0) {
                    String respuesta = "La vaca: " + nom + " se encuentra en la posición: " + (medio +1);
                    return respuesta; // Se encontró la vaca, podemos salir del método.
                } else if (comparacion < 0) {
                    inicio = medio + 1; // La vaca podría estar en la mitad derecha.
                } else {
                    fin = medio - 1; // La vaca podría estar en la mitad izquierda.
                }
            }

            return "No se encontró la vaca.";
        }
        
        public static void insertarFinal(Vaca va) {
                // Comprueba si hay espacio suficiente en el arreglo
                if (n < taMax) {
                    arregloVacas[n] = va; // Inserta la nueva vaca en la posición n
                    n = n + 1; // Incrementa el contador de elementos válidos
                    System.out.println("Vaca insertada al final.");
                } else {
                    System.out.println("No se pueden insertar más vacas, el arreglo está lleno.");
                }
            }


public static void ordenarPorLitros() {
            boolean cambiado = true;

            while (cambiado) {
                cambiado = false; // Inicialmente, no se han realizado cambios en esta pasada

                for (int i = 1; i < n; i++) {
                    if (arregloVacas[i - 1].getLitros() < arregloVacas[i].getLitros()) {
                        // Intercambiar elementos si están en el orden incorrecto (de mayor a menor)
                        Vaca temporal = arregloVacas[i - 1];
                        arregloVacas[i - 1] = arregloVacas[i];
                        arregloVacas[i] = temporal;
                        cambiado = true; // Marcar que se ha realizado un cambio en esta pasada
                    }
                }
                //n--; // Reducir n después de cada pasada
            }
        }



public static void borrarMenosLechera() {
    if (n == 0) {
        System.out.println("El arreglo está vacío");
        return;
    }

    Vaca menor = arregloVacas[0];
    int indiceMenor = 0;

    // Encuentra la vaca menos lechera y su índice
    for (int i = 1; i < n; i++) {
        if (arregloVacas[i].getLitros() < menor.getLitros()) {
            menor = arregloVacas[i];
            indiceMenor = i;
        }
    }

    System.out.println("La vaca con menos litros fue " + menor.getNombre());

    // Mover las vacas restantes hacia la izquierda para llenar el espacio vacío
    for (int i = indiceMenor; i < n - 1; i++) {
        arregloVacas[i] = arregloVacas[i + 1];
    }

    // Reducir n para reflejar que se ha eliminado una vaca
    n--;
}

}
