package org.example.logica;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Empleados {

    //Declaramos las variables y pedimos que el ID se genere automaticamente.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    protected String nombre;
    protected String apellido;
    protected String cargo;
    protected Double salario;
    protected String fechaDeInicio;

    //Generamos los constructores


    public Empleados(Long id, String nombre, String apellido, String cargo, Double salario, String fechaDeInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaDeInicio = fechaDeInicio;
    }

    public Empleados() {
    }

    //Generamos los getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(String fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    //Generamos un toString


    @Override
    public String toString() {
        return "Empleados{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", fechaDeInicio='" + fechaDeInicio + '\'' +
                '}';
    }

    }



