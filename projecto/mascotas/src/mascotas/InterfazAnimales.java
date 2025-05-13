package mascotas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazAnimales extends JFrame {
    private JTextField txtCodigo, txtNombre, txtEdad, txtEspecie, txtSexo, txtCaracteristica, txtEstadoSalud, txtDia, txtMes, txtAno;
    private JTable table;
    private DefaultTableModel tableModel;
    private RegistroAnimales registro;

    public InterfazAnimales() {
        registro = new RegistroAnimales();
        setTitle("Gestión de Animales");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntrada = new JPanel(new GridLayout(11, 2, 5, 5));
        panelEntrada.setBorder(new TitledBorder("Datos del Animal"));

        panelEntrada.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelEntrada.add(txtCodigo);

        panelEntrada.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelEntrada.add(txtNombre);

        panelEntrada.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelEntrada.add(txtEdad);

        panelEntrada.add(new JLabel("Especie:"));
        txtEspecie = new JTextField();
        panelEntrada.add(txtEspecie);

        panelEntrada.add(new JLabel("Sexo:"));
        txtSexo = new JTextField();
        panelEntrada.add(txtSexo);

        panelEntrada.add(new JLabel("Características:"));
        txtCaracteristica = new JTextField();
        panelEntrada.add(txtCaracteristica);

        panelEntrada.add(new JLabel("Estado de Salud:"));
        txtEstadoSalud = new JTextField();
        panelEntrada.add(txtEstadoSalud);

        panelEntrada.add(new JLabel("Fecha de Ingreso (Día, Mes, Año):"));
        txtDia = new JTextField();
        txtMes = new JTextField();
        txtAno = new JTextField();
        JPanel panelFecha = new JPanel(new GridLayout(1, 3, 5, 5));
        panelFecha.add(txtDia);
        panelFecha.add(txtMes);
        panelFecha.add(txtAno);
        panelEntrada.add(panelFecha);

        JButton btnAgregar = new JButton("Agregar Animal");
        btnAgregar.setBackground(new Color(100, 200, 100));
        panelEntrada.add(btnAgregar);

        String[] columnNames = {"Código", "Nombre", "Edad", "Especie", "Sexo", "Características", "Estado Salud", "Fecha Ingreso"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new TitledBorder("Lista de Animales"));

        JPanel panelBuscarEliminar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBuscarEliminar.setBorder(new TitledBorder("Buscar / Eliminar"));
        panelBuscarEliminar.add(new JLabel("Código:"));
        JTextField txtBuscarEliminar = new JTextField(10);
        panelBuscarEliminar.add(txtBuscarEliminar);
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        btnBuscar.setBackground(new Color(100, 150, 255));
        btnEliminar.setBackground(new Color(255, 100, 100));
        panelBuscarEliminar.add(btnBuscar);
        panelBuscarEliminar.add(btnEliminar);

        
        
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBuscarEliminar, BorderLayout.SOUTH);

        registro.cargarATabla(tableModel); 

        btnAgregar.addActionListener(this::agregarAnimal);
        btnBuscar.addActionListener(e -> buscarAnimal(txtBuscarEliminar.getText()));
        btnEliminar.addActionListener(e -> eliminarAnimal(txtBuscarEliminar.getText()));
    }

    private void agregarAnimal(ActionEvent e) {
        registro.agregarAnimal(
                txtCodigo.getText(),
                txtNombre.getText(),
                txtEdad.getText(),
                txtEspecie.getText(),
                txtSexo.getText(),
                txtCaracteristica.getText(),
                txtEstadoSalud.getText(),
                Integer.parseInt(txtDia.getText()),
                Integer.parseInt(txtMes.getText()),
                Integer.parseInt(txtAno.getText()),
                tableModel
        );
        txtCodigo.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtEspecie.setText("");
        txtSexo.setText("");
        txtCaracteristica.setText("");
        txtEstadoSalud.setText("");
        txtDia.setText("");
        txtMes.setText("");
        txtAno.setText("");
    }

    private void buscarAnimal(String codigo) {
        Animal a = registro.buscarAnimal(codigo);
        if (a != null) {
            JOptionPane.showMessageDialog(this, "Animal encontrado:\n" +
                    "Nombre: " + a.getNombre() + "\nEdad: " + a.getEdad() + "\nEspecie: " + a.getEspecie());
        } else {
            JOptionPane.showMessageDialog(this, "Animal no encontrado.");
        }
    }

    private void eliminarAnimal(String codigo) {
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa un código para eliminar.");
            return;
        }
        boolean eliminado = registro.eliminarAnimal(codigo, tableModel);
        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Animal eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un animal con ese código.");
        }
    }
}
