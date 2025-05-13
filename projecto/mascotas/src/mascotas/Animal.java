package mascotas;
import java.io.Serializable;
import java.time.LocalDate;
public class Animal implements Serializable {
    private String codigo;
    private String nombre;
    private String edad;
    private String especie;
    private String sexo;
    private String caracteristica;
    private String estadoSalud;
    private LocalDate fechaEntrada;
    public Animal(String codigo, String nombre, String edad, String especie, String sexo, String caracteristica, String estadoSalud, LocalDate fechaEntrada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.sexo = sexo;
        this.caracteristica = caracteristica;
        this.estadoSalud = estadoSalud;
        this.fechaEntrada = fechaEntrada;
    }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getEspecie() { return especie; }
    public String getSexo() { return sexo; }
    public String getCaracteristica() { return caracteristica; }
    public String getEstadoSalud() { return estadoSalud; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
}