
package bancoMariem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainBanco {
    private static Sucursal sucursal = new Sucursal();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú del Banco");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton agregarCuentaButton = new JButton("Agregar Cuenta");
        agregarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                if (nombreCliente != null && !nombreCliente.isEmpty()) {
                    Cuenta nuevaCuenta = new Cuenta(nombreCliente);
                    sucursal.agregarCuenta(nuevaCuenta);
                    JOptionPane.showMessageDialog(frame, "Cuenta agregada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre de cliente no válido.");
                }
            }
        });

        JButton buscarCuentaButton = new JButton("Buscar Cuenta por ID");
        buscarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClienteStr = JOptionPane.showInputDialog("Ingrese el ID del cliente:");
                if (idClienteStr != null && !idClienteStr.isEmpty()) {
                    int idCliente = Integer.parseInt(idClienteStr);
                    Cuenta cuenta = sucursal.buscarCuentaPorId(idCliente);
                    if (cuenta != null) {
                        mostrarCuentaEnVentana(cuenta.toString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cuenta no encontrada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "ID de cliente no válido.");
                }
            }
        });

        JButton mostrarCuentasButton = new JButton("Mostrar Todas las Cuentas");
        mostrarCuentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCuentasEnVentana(sucursal.getCuentas());
            }
        });

        JButton borrarCuentaButton = new JButton("Borrar Cuenta por ID");
        borrarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idClienteStr = JOptionPane.showInputDialog("Ingrese el ID del cliente a borrar:");
                if (idClienteStr != null && !idClienteStr.isEmpty()) {
                    int idCliente = Integer.parseInt(idClienteStr);
                    if (sucursal.borrarCuentaPorId(idCliente)) {
                        JOptionPane.showMessageDialog(frame, "Cuenta borrada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cuenta no encontrada o no se pudo borrar.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "ID de cliente no válido.");
                }
            }
        });

        panel.add(agregarCuentaButton);
        panel.add(buscarCuentaButton);
        panel.add(mostrarCuentasButton);
        panel.add(borrarCuentaButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void mostrarCuentasEnVentana(Cuenta[] cuentas) {
        JFrame ventanaCuentas = new JFrame("Cuentas de la Sucursal");
        ventanaCuentas.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Cuenta cuenta : cuentas) {
            if (cuenta != null) {
                textArea.append(cuenta.toString() + "\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        ventanaCuentas.add(scrollPane);
        ventanaCuentas.setVisible(true);
    }

    private static void mostrarCuentaEnVentana(String infoCuenta) {
        JFrame ventanaCuenta = new JFrame("Información de la Cuenta");
        ventanaCuenta.setSize(300, 200);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append(infoCuenta);

        JScrollPane scrollPane = new JScrollPane(textArea);
        ventanaCuenta.add(scrollPane);
        ventanaCuenta.setVisible(true);
    }
}
