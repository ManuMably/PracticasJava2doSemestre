
package practicasjava;

import vacas.Establo;
import vacas.Vaca;
import java.util.Scanner;


public class PracticasJava {

    
    public static void main(String[] args) {
        
        
        Scanner leer = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menu del Establo:");
            System.out.println("1. Cargar establo desde archivo.");
            System.out.println("2. Guardar establo en archivo.");
            System.out.println("3. Insertar vaca al principio.");
            System.out.println("4. Mostrar vacas.");
            System.out.println("5. Ordenar por nombre.");
            System.out.println("6. Buscar por nombre ordenado.");
            System.out.println("7. Insertar vaca al final.");
            System.out.println("8. Ordenar por litros.");
            System.out.println("9. Buscar por litros ordenado.");
            System.out.println("10. Borrar la vaca menos lechera.");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: \n");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Establo.cargarEstablo();
                    System.out.println("Datos cargados desde el archivo plano, entrar a la opcion mostrar para ver los datos\n");
                    break;
                case 2:
                    Establo.guardarEstablo();
                    System.out.println("datos guardados en el archivo plano\n");
                    break;
                case 3:
                    
                    System.out.print("Ingrese el nombre de la vaca:\n ");
                    String nombre = leer.next();

                    System.out.print("Ingrese el tipo de la vaca (1 o 2): \n");
                    int tipo = leer.nextInt();

                    System.out.print("Ingrese la cantidad de litros de leche:\n");
                    float litros = leer.nextFloat();

                    Vaca nuevaVaca = new Vaca(nombre, tipo, litros);
                    Establo.insertarPpio(nuevaVaca);

                    System.out.println("Vaca insertada con éxito en el establo\n");
                        
                    break;
                case 4:
                    Establo.mostrar();
                    break;
                case 5:
                    Establo.ordenarPorNombre();
                    System.out.println("establo ordenado por nombre\n");
                    break;
                case 6:
                    System.out.print("Ingrese el nombre a buscar:\n ");
                    String nombreABuscar = leer.next();
                    Establo.buscarPorNombreOrdenado(nombreABuscar);
                    break;
                case 7:
                    System.out.print("Ingrese el nombre de la vaca: \n");
                        String nombre2 = leer.next();

                        System.out.print("Ingrese el tipo de la vaca (1 o 2):\n ");
                        int tipo2 = leer.nextInt();

                        System.out.print("Ingrese la cantidad de litros de leche:\n ");
                        float litros2 = leer.nextFloat();

                        Vaca nuevaVaca2 = new Vaca(nombre2, tipo2, litros2);
                        
                        Establo.insertarFinal(nuevaVaca2);

                        
                        System.out.println("vaca insertada con exito en el establo\n");
                    // Leer los datos de la vaca a insertar y luego llamar a establo.insertarFinal(vaca)
                    break;
                case 8:
                    Establo.ordenarPorLitros();
                    break;
                case 9:
                    System.out.print("Ingrese los litros a buscar: \n");
                    float litrosABuscar = leer.nextFloat();
                    int indice = Establo.busquedaBinaria(litrosABuscar);
                    if (indice != -1) {
                        System.out.println("Vaca encontrada en la posición: " + indice);
                    } else {
                        System.out.println("Vaca no encontrada.\n");
                    }
                    break;
                case 10:
                    Establo.borrarMenosLechera();
                    System.out.println(" borrada con exito\n");
                    break;
                case 0:
                    System.out.println("Saliendo del programa.\n");
                    break;
                default:
                    System.out.println("Opción no valida.\n");
                    break;
            }
        } while (opcion != 0);

        leer.close();
    }
        
        
    }
    

