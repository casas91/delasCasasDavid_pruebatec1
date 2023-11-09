package org.example.persistencia;

import org.example.logica.Empleados;

import java.util.Scanner;

public class MenuController extends Empleados{

    public void agregarEmpleado(){
        ////Creamos la variable nuevo empleado
        Empleados nuevoEmpleado = new Empleados();
        //Solicitamos el ingreso de datos de el empleado.
        System.out.println("Ingrese al nuevo empleado ");

        System.out.println("Ingrese el nombre:");
        Scanner scanner = null;
        scanner.nextLine();
        nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido: ");
        apellido = scanner.nextLine();
        System.out.println("Ingrese el cargo: ");
        cargo = scanner.nextLine();
        System.out.println("Ingrese el salario: ");
        salario = scanner.nextDouble();
        System.out.println("Ingrese la fecha de inicio en formato yyyy-MM-dd");
        scanner.nextLine();
        fechaDeInicio = scanner.nextLine();

        //Crear empleado con la informacion ingresada
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setApellido(apellido);
        nuevoEmpleado.setCargo(cargo);
        nuevoEmpleado.setSalario(salario);
        nuevoEmpleado.setFechaDeInicio(fechaDeInicio);
    }
}
