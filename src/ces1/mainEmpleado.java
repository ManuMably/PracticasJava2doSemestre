
package ces1;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class mainEmpleado {
    public static void main(String[] args) {
        
        int maxEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número máximo de empleados:"));
        Empleado[] empleados = new Empleado[maxEmpleados];
        int cantidadEmpleados = 0;

        while (true) {
            String menu = "Menú Principal\n"
                    + "1. Mostrar empleado con menor salario\n"
                    + "2. Calcular suma de salarios\n"
                    + "3. Ordenar empleados por cédula\n"
                    + "4. Buscar empleado por cédula\n"
                    + "5. Modificar dirección de un empleado\n"
                    + "6. Mostrar información de todos los empleados\n"
                    + "7. Ingresar un nuevo empleado\n"
                    + "8. Salir";
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    if (cantidadEmpleados == 0) {
                        JOptionPane.showMessageDialog(null, "No hay empleados en la lista.");
                    } else {
                        Empleado empleadoMenorSalario = encontrarEmpleadoMenorSalario(empleados, cantidadEmpleados);
                        JOptionPane.showMessageDialog(null, "Empleado con menor salario:\n" +
                                "Cédula: " + empleadoMenorSalario.getCedula() +
                                "\nNombre: " + empleadoMenorSalario.getNombre());
                    }
                    break;
                case 2:
                    float sumaSalarios = calcularSumaSalarios(empleados, cantidadEmpleados);
                    JOptionPane.showMessageDialog(null, "Suma de todos los salarios: " + sumaSalarios);
                    break;
                case 3:
                    if (cantidadEmpleados > 0) {
                        ordenarEmpleadosPorCedula(empleados, cantidadEmpleados);
                        mostrarEmpleados(empleados, cantidadEmpleados);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay empleados para ordenar.");
                    }
                    break;
                case 4:
                    int cedulaBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula a buscar:"));
                    Empleado empleadoEncontrado = buscarEmpleadoPorCedula(empleados, cantidadEmpleados, cedulaBusqueda);
                    if (empleadoEncontrado != null) {
                        mostrarEmpleado(empleadoEncontrado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                    break;
                case 5:
                    int cedulaModificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del empleado a modificar:"));
                    Empleado empleadoAModificar = buscarEmpleadoPorCedula(empleados, cantidadEmpleados, cedulaModificacion);
                    if (empleadoAModificar != null) {
                        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:");
                        empleadoAModificar.setDireccion(nuevaDireccion);
                        JOptionPane.showMessageDialog(null, "Dirección modificada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                    break;
                case 6:
                    mostrarEmpleados(empleados, cantidadEmpleados);
                    break;
                case 7:
                    if (cantidadEmpleados < maxEmpleados) {
                        int nuevaCedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del nuevo empleado:"));
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo empleado:");
                        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la dirección del nuevo empleado:");
                        float nuevoSalario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario del nuevo empleado:"));
                        Empleado nuevoEmpleado = new Empleado(nuevaCedula, nuevoNombre, nuevaDireccion, nuevoSalario);
                        empleados[cantidadEmpleados] = nuevoEmpleado;
                        cantidadEmpleados++;
                        JOptionPane.showMessageDialog(null, "Empleado ingresado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista de empleados está llena. No se pueden agregar más empleados.");
                    }
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static Empleado encontrarEmpleadoMenorSalario(Empleado[] empleados, int cantidadEmpleados) {
        Empleado menorSalario = empleados[0];
        for (int i = 1; i < cantidadEmpleados; i++) {
            if (empleados[i].getSalario() < menorSalario.getSalario()) {
                menorSalario = empleados[i];
            }
        }
        return menorSalario;
    }

    public static float calcularSumaSalarios(Empleado[] empleados, int cantidadEmpleados) {
        float suma = 0;
        for (int i = 0; i < cantidadEmpleados; i++) {
            suma += empleados[i].getSalario();
        }
        return suma;
    }

    public static void ordenarEmpleadosByCedula(Empleado[] empleados, int cantidadEmpleados) {
        Arrays.sort(empleados, 0, cantidadEmpleados, Comparator.comparing(Empleado::getCedula));
    }

    public static Empleado buscarEmpleadoPorCedula(Empleado[] empleados, int cantidadEmpleados, int cedula) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (empleados[i].getCedula() == cedula) {
                return empleados[i];
            }
        }
        return null;
    }

    public static void mostrarEmpleados(Empleado[] empleados, int cantidadEmpleados) {
        StringBuilder empleadoInfo = new StringBuilder("Lista de empleados:\n");
        for (int i = 0; i < cantidadEmpleados; i++) {
            empleadoInfo.append("Cédula: ").append(empleados[i].getCedula())
                    .append("\nNombre: ").append(empleados[i].getNombre())
                    .append("\nDirección: ").append(empleados[i].getDireccion())
                    .append("\nSalario: ").append(empleados[i].getSalario())
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, empleadoInfo.toString());
    }

    public static void mostrarEmpleado(Empleado empleado) {
        StringBuilder empleadoInfo = new StringBuilder("Información del empleado:\n");
        empleadoInfo.append("Cédula: ").append(empleado.getCedula())
                .append("\nNombre: ").append(empleado.getNombre())
                .append("\nDirección: ").append(empleado.getDireccion())
                .append("\nSalario: ").append(empleado.getSalario());
        JOptionPane.showMessageDialog(null, empleadoInfo.toString());
    }

    public static void ordenarEmpleadosPorCedula(Empleado[] empleados, int cantidadEmpleados) {
        Arrays.sort(empleados, 0, cantidadEmpleados, Comparator.comparing(Empleado::getCedula));
    }
        
        
    
}
