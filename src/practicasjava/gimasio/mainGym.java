
package practicasjava.gimasio;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;


public class mainGym {
    
     public static void main(String[] args) {
        JFrame frame = new JFrame("administrador del gimnasio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JMenuBar menuBar = new JMenuBar();

        JMenu clienteMenu = new JMenu("Cliente");
        JMenuItem ingresarClienteItem = new JMenuItem("Ingresar Cliente");
        JMenuItem mostrarClientesItem = new JMenuItem("Mostrar Clientes");
        JMenuItem ordenarPorMasaMuscularItem = new JMenuItem("Ordenar por Masa Muscular");
        JMenuItem ordenarPorFrecuenciaItem = new JMenuItem("Ordenar por Frecuencia");
        JMenuItem borrarClienteItem = new JMenuItem("Borrar Cliente");
        JMenuItem ordenarPorPesoItem = new JMenuItem("Ordenar por Peso");

        clienteMenu.add(ingresarClienteItem);
        clienteMenu.add(mostrarClientesItem);
        clienteMenu.add(ordenarPorMasaMuscularItem);
        clienteMenu.add(ordenarPorFrecuenciaItem);
        clienteMenu.add(borrarClienteItem);
        clienteMenu.add(ordenarPorPesoItem);

        Gym gym = new Gym();

        ingresarClienteItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Ventana de diálogo para ingresar un nuevo cliente
        JFrame dialogFrame = new JFrame("Ingresar Cliente");
        dialogFrame.setSize(400, 200);

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel(new GridLayout(6, 2));
        
        JLabel idLabel = new JLabel("ID Cliente:");
        JTextField idField = new JTextField();
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();
        JLabel pesoLabel = new JLabel("Peso (kg):");
        JTextField pesoField = new JTextField();
        JLabel masaMuscularLabel = new JLabel("Masa Muscular (%):");
        JTextField masaMuscularField = new JTextField();
        JLabel frecuenciaLabel = new JLabel("Frecuencia Mensual:");
        JTextField frecuenciaField = new JTextField();

        JButton addButton = new JButton("Agregar Cliente");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(pesoLabel);
        panel.add(pesoField);
        panel.add(masaMuscularLabel);
        panel.add(masaMuscularField);
        panel.add(frecuenciaLabel);
        panel.add(frecuenciaField);
        panel.add(new JLabel());
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                float peso = Float.parseFloat(pesoField.getText());
                float masaMuscular = Float.parseFloat(masaMuscularField.getText());
                int frecuencia = Integer.parseInt(frecuenciaField.getText());

                Cliente cliente = new Cliente(id, nombre, peso, masaMuscular, frecuencia);
                gym.insertarCliente(cliente);

                JOptionPane.showMessageDialog(dialogFrame, "Cliente agregado con éxito.");

                dialogFrame.dispose();
            }
        });

        // Agregar el panel al JFrame
        dialogFrame.add(panel);
        dialogFrame.setVisible(true);
    }
    });

        mostrarClientesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ventana de diálogo para mostrar todos los clientes
                JFrame dialogFrame = new JFrame("Clientes Registrados");
                dialogFrame.setSize(400, 400);
                JTextArea textArea = new JTextArea();

                for (int i = 0; i < gym.getClientesActuales(); i++) {
                    textArea.append(gym.getClientesRegistrados()[i].toString() + "\n");
                }

                JScrollPane scrollPane = new JScrollPane(textArea);
                dialogFrame.add(scrollPane);
                dialogFrame.setVisible(true);
            }
        });

        ordenarPorMasaMuscularItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gym.ordenarPorMasaMuscular();
                mostrarClientesOrdenados(gym, "Clientes Ordenados por Masa Muscular");
            }
        });

        ordenarPorFrecuenciaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gym.ordenarPorFrecuenciaMes();
                mostrarClientesOrdenados(gym, "Clientes Ordenados por Frecuencia");
            }
        });

        borrarClienteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Ingrese el ID del cliente a borrar:");
                try {
                    int idCliente = Integer.parseInt(id);
                    gym.borrarClientePorId(idCliente);
                    JOptionPane.showMessageDialog(frame, "Cliente con ID " + idCliente + " ha sido eliminado.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID de cliente no válido.");
                }
            }
        });

        ordenarPorPesoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gym.ordenarPorPeso();
                mostrarClientesOrdenados(gym, "Clientes Ordenados por Peso");
            }
        });

        menuBar.add(clienteMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    private static void mostrarClientesOrdenados(Gym gym, String titulo) {
        JFrame dialogFrame = new JFrame(titulo);
        dialogFrame.setSize(400, 400);
        JTextArea textArea = new JTextArea();

        for (int i = 0; i < gym.getClientesActuales(); i++) {
            textArea.append(gym.getClientesRegistrados()[i].toString() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        dialogFrame.add(scrollPane);
        dialogFrame.setVisible(true);
    }
    
}
