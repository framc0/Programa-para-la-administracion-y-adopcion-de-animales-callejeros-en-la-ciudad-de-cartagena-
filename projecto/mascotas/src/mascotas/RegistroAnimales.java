package mascotas;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;
public class RegistroAnimales {
    private List<Animal> animales;
    public RegistroAnimales() {
        animales = ArchivoAnimales.cargarDatos();
    }
    public void agregarAnimal(String codigo, String nombre, String edad, String especie, String sexo, String caracteristica, String estadoSalud, int dia, int mes, int ano, DefaultTableModel model) {
        Animal animal = new Animal(codigo, nombre, edad, especie, sexo, caracteristica, estadoSalud, LocalDate.of(ano, mes, dia));
        animales.add(animal);
        model.addRow(new Object[]{
                codigo, nombre, edad, especie, sexo, caracteristica, estadoSalud, animal.getFechaEntrada().toString()
        });
        ArchivoAnimales.guardarDatos(animales);
    }
    public Animal buscarAnimal(String codigo) {
        for (Animal a : animales) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }
    public boolean eliminarAnimal(String codigo, DefaultTableModel model) {
        for (int i = 0; i < animales.size(); i++) {
            if (animales.get(i).getCodigo().equals(codigo)) {
                animales.remove(i);
                for (int j = 0; j < model.getRowCount(); j++) {
                    if (model.getValueAt(j, 0).equals(codigo)) {
                        model.removeRow(j);
                        break;
                    }
                }
                ArchivoAnimales.guardarDatos(animales);
                return true;
            }
        }
        return false;
    }
    public void cargarATabla(DefaultTableModel model) {
        for (Animal a : animales) {
            model.addRow(new Object[]{
                    a.getCodigo(), a.getNombre(), a.getEdad(), a.getEspecie(),
                    a.getSexo(), a.getCaracteristica(), a.getEstadoSalud(), a.getFechaEntrada().toString()
            });
        }
    }
}