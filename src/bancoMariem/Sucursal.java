
package bancoMariem;

public class Sucursal {
    private static Cuenta[] cuentas = new Cuenta[100]; // Se asume una capacidad máxima de 100 cuentas
    private static int numCuentas = 0;

    public Sucursal() {
    }
    
    
    // Método para agregar una cuenta
    public static void agregarCuenta(Cuenta cuenta) {
        if (numCuentas < cuentas.length) {
            cuentas[numCuentas] = cuenta;
            numCuentas++;
        } else {
            System.out.println("No se pueden agregar más cuentas, la capacidad está llena.");
        }
    }
    
    
    public static int getNumCuentas() {
        return numCuentas;
    }
    
    // Getter para obtener la lista de cuentas
    public static Cuenta[] getCuentas() {
        return cuentas;
    }
    
    // Método para borrar una cuenta por ID del cliente
    public static boolean borrarCuentaPorId(int idCliente) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getIdCliente() == idCliente) {
                for (int j = i; j < numCuentas - 1; j++) {
                    cuentas[j] = cuentas[j + 1];
                }
                cuentas[numCuentas - 1] = null;
                numCuentas--;
                return true; // La cuenta se borró con éxito
            }
        }
        return false; // No se encontró la cuenta
    }

    // Método para mostrar todas las cuentas
    public static void mostrarCuentas() {
        System.out.println("Lista de cuentas en la sucursal:");
        for (int i = 0; i < numCuentas; i++) {
            cuentas[i].mostrarDatosCuenta();
        }
    }

    // Método para eliminar cuentas con saldo cero
    public static void eliminarCuentasConSaldoCero() {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getSaldo() == 0) {
                borrarCuentaPorId(cuentas[i].getIdCliente());
                i--; // Ajustar el índice después de eliminar una cuenta
                System.out.println("Cuenta con saldo cero eliminada.");
            }
        }
    }
    
    // Método para buscar una cuenta por ID del cliente
    public static Cuenta buscarCuentaPorId(int idCliente) {
        for (int i = 0; i < numCuentas; i++) {
            if (cuentas[i].getIdCliente() == idCliente) {
                return cuentas[i];
            }
        }
        return null; // No se encontró la cuenta
    }
    
}
