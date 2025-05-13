package mascotas;
import java.time.LocalDate;
import java.util.List;
class Fechas {
    public static void calcularPromedioIngreso(List<Animal> animals, int mesBuscado, int anoBuscado) {
        int animalesEnMes = 0;
        int diasMes = 30;
        for (Animal animal : animals) {
            LocalDate fecha = animal.getFechaEntrada();
            if (fecha.getMonthValue() == mesBuscado && fecha.getYear() == anoBuscado) {
                animalesEnMes++;
            }
        }
        double porcentaje = (animalesEnMes / (double) diasMes) * 100;
        System.out.println("Animales registrados en " + mesBuscado + "/" + anoBuscado + ": " + animalesEnMes);
        System.out.println("Porcentaje de ingresos en el mes: " + porcentaje + "%");
    }
}