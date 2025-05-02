package mascotas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoAnimales {
    private static final String NOMBRE_ARCHIVO = "animales.dat";

    public static void guardarDatos(List<Animal> animales) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(animales);
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Animal> cargarDatos() {
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            return (List<Animal>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}