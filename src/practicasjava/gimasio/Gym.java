
package practicasjava.gimasio;
import java.util.Arrays;

public class Gym {
    private static Cliente[] clientesRegistrados = new Cliente[100];
    private static int clientesActuales = 0;
    
    public static Cliente[] getClientesRegistrados() {
        return clientesRegistrados;
    }

    public static void setClientesRegistrados(Cliente[] clientesRegistrados) {
        Gym.clientesRegistrados = clientesRegistrados;
    }

    public static int getClientesActuales() {
        return clientesActuales;
    }

    public static void ordenarPorPeso() {
        Arrays.sort(clientesRegistrados, 0, clientesActuales, (cliente1, cliente2) -> Float.compare(cliente1.getPeso(), cliente2.getPeso()));
    }

    public static void ordenarPorMasaMuscular() {
        Arrays.sort(clientesRegistrados, 0, clientesActuales, (cliente1, cliente2) -> Float.compare(cliente1.getPorcentajeMasaMuscular(), cliente2.getPorcentajeMasaMuscular()));
    }

    public static void ordenarPorFrecuenciaMes() {
        Arrays.sort(clientesRegistrados, 0, clientesActuales, (cliente1, cliente2) -> Integer.compare(cliente1.getFrecuenciaMes(), cliente2.getFrecuenciaMes()));
    }

    public static void mostrarInformacionClientes() {
        for (int i = 0; i < clientesActuales; i++) {
            System.out.println(clientesRegistrados[i]);
        }
    }

    public static void insertarCliente(Cliente cliente) {
        if (clientesActuales < clientesRegistrados.length) {
            clientesRegistrados[clientesActuales] = cliente;
            clientesActuales++;
        } else {
            System.out.println("No se pueden agregar más clientes. La capacidad máxima se ha alcanzado.");
        }
    }

    public static void borrarClientePorId(int idCliente) {
        for (int i = 0; i < clientesActuales; i++) {
            if (clientesRegistrados[i].getIdCliente() == idCliente) {
                // Mover los clientes restantes un lugar hacia arriba para llenar el espacio eliminado
                for (int j = i; j < clientesActuales - 1; j++) {
                    clientesRegistrados[j] = clientesRegistrados[j + 1];
                }
                clientesActuales--;
                break;
            }
        }
    }
    
}
