package org.example;
import org.example.logica.Empleados;
import org.example.persistencia.PersistenciaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables de los empleados
        String nombre;
        String apellido;
        double salario;
        String cargo;
        String fechaDeInicio;

        //Creamos la clase scanner
        Scanner scanner = new Scanner(System.in);

        //Llamamos a la controladora de persistencia
        PersistenciaController controladora = new PersistenciaController();

        System.out.println("***BIENVENIDO AL SISTEMA DE GESTIÓN DE EMPLEADOS***");

        //Creamos un menu con opciones para que el usuario elija que quiere hacer:
        while(true){
                System.out.println("Selecciona una opcion: ");
                System.out.println("Pulse 1 para agregar un nuevo empleado");
                System.out.println("Pulse 2 para ver la lista de empleados");
                System.out.println("Pulse 3 para modificar un empleado");
                System.out.println("Pulse 4 para eliminar un empleado");
                System.out.println("Pulse 5 para buscar los empleados por cargo");
                System.out.println("Pulse 6 para terminar");

                //Pedimos al usuario que elija una de las opciones
                System.out.println("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                //Creamos un switch para los diferentes casos.
                switch (opcion) {
                    case 1:
                        //Creamos la variable nuevo empleado
                        Empleados nuevoEmpleado = new Empleados();
                        //Solicitamos el ingreso de datos de el empleado.
                        System.out.println("Ingrese al nuevo empleado ");
                        //Nombre
                        System.out.println("Ingrese el nombre:");
                        scanner.nextLine();
                        nombre = scanner.nextLine();
                        nuevoEmpleado.setNombre(nombre);
                        //Apellido
                        System.out.println("Ingrese el apellido: ");
                        apellido = scanner.nextLine();
                        nuevoEmpleado.setApellido(apellido);
                        //Cargo
                        System.out.println("Ingrese el cargo: ");
                        cargo = scanner.nextLine();
                        nuevoEmpleado.setCargo(cargo);
                        //Salario
                        //Agregamos try catch para dar una excepcion si el usuario ingresa un valor no numerico.
                        try {
                            System.out.println("Ingrese el salario:");
                            salario = scanner.nextDouble();
                            nuevoEmpleado.setSalario(salario);
                        } catch (Exception e) {
                            System.out.println("Error: Ingrese un salario válido.");
                            System.out.println("Volviendo al menú.....");
                            scanner.next(); //Limpiamos el bufer del scanner
                            continue; //Volvemos al menu de inicio
                        }
                        //Fecha de inicio
                        //Creamos objeto con el patron deseado y declaramos variable para objeto Date.
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaDeInicioDate;
                            try {
                                System.out.println("Ingrese la fecha de inicio en formato yyyy-MM-dd:");
                                fechaDeInicio = scanner.next();
                                //Validamos el formato de la fecha antes de convertirla.
                                dateFormat.setLenient(false);
                                dateFormat.parse(fechaDeInicio);
                                fechaDeInicioDate = dateFormat.parse(fechaDeInicio);
                            } catch (ParseException e) {
                                System.out.println("Error: Formato de fecha incorrecto. Formato yyyy-MM-dd.");
                                System.out.println("Volviendo al menú.....");
                                continue;//Volvemos al menu sin procesar la entrada incorrecta.
                            }
                        nuevoEmpleado.setFechaDeInicio(dateFormat.format(fechaDeInicioDate));

                        //Agregamos al nuevo empleado en la base de datos
                        controladora.crearEmpleado(nuevoEmpleado);

                        System.out.println("Empleado agregado correctamente");
                        break;

                    case 2:
                        //Listar empleados
                        //Creamos la lista de los empleados y los mostramos en una tabla
                        List<Empleados> listEmpleados = controladora.listarEmpleados();
                        System.out.println("| ID | Nombre | Apellido | Cargo | Salario | Fecha de inicio |");
                        for (Empleados empleados : listEmpleados) {
                            System.out.printf("| %d | %s | %s | %s | %.2f | %s |%n", empleados.getId(), empleados.getNombre(), empleados.getApellido(), empleados.getCargo(), empleados.getSalario(), empleados.getFechaDeInicio());
                        }
                        break;

                    case 3:
                        //Modificar un empleado
                        //Creamos otra lista para que el usuario elija que empleado quiere modificar.
                        System.out.println("Lista de empleados:");
                        List<Empleados> listEmpleadosModificar = controladora.listarEmpleados();
                        System.out.println("| ID | Nombre | Apellido | Cargo | Salario | Fecha de inicio |");
                        for (Empleados empleados : listEmpleadosModificar) {
                            System.out.printf("| %d | %s | %s | %s | %.2f | %s |%n", empleados.getId(), empleados.getNombre(), empleados.getApellido(), empleados.getCargo(), empleados.getSalario(), empleados.getFechaDeInicio());
                        }
                        //Pedimos el ingreso del ID
                        System.out.println("Ingrese el ID del empleado que desea modificar:");
                        Long idEmpleadoModificar = scanner.nextLong();

                        Empleados empleadoModificar = controladora.buscarEmpleadoPorId(idEmpleadoModificar);

                        //Creamos un if para controlar que el ID sea correcto y un switch para que el usuario elija el campo a modificar.
                        if (empleadoModificar != null) {
                            System.out.println("Seleccione el dato a modificar:");
                            System.out.println("Pulse 1 para cambiar el Nombre");
                            System.out.println("Pulse 2 para cambiar el Apellido");
                            System.out.println("Pulse 3 para cambiar el Cargo");
                            System.out.println("Pulse 4 para cambiar el Salario");
                            System.out.println("Pulse 5 para cambiar la Fecha de inicio");
                            System.out.println(("Pulse 6 para si no quiere realizar cambios"));
                            int seleccionar = scanner.nextInt();

                            switch (seleccionar) {
                                case 1:
                                    System.out.println("Ingrese el nuevo Nombre:");
                                    scanner.nextLine();
                                    String nuevoNombre = scanner.nextLine();
                                    empleadoModificar.setNombre(nuevoNombre);
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nuevo Apellido:");
                                    scanner.nextLine();
                                    String nuevoApellido = scanner.nextLine();
                                    empleadoModificar.setApellido(nuevoApellido);
                                    break;
                                case 3:
                                    System.out.println("Ingrese el nuevo Cargo:");
                                    scanner.nextLine();
                                    String nuevoCargo = scanner.nextLine();
                                    empleadoModificar.setCargo(nuevoCargo);
                                    break;
                                case 4:
                                    try{
                                    System.out.println("Ingrese el nuevo Salario:");
                                    double nuevoSalario = scanner.nextDouble();
                                    empleadoModificar.setSalario(nuevoSalario);
                                    } catch (Exception e) {
                                        System.out.println("Error: Ingrese un salario válido.");
                                        System.out.println("Volviendo al menú.....");
                                        scanner.next(); //Limpiamos el bufer del scanner
                                        continue; //Volvemos al menu de inicio
                                    }
                                    break;
                                case 5:
                                    System.out.println("Ingrese la nueva Fecha de inicio:");
                                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                                    scanner.nextLine();
                                    String nuevaFechaDeInicio = scanner.nextLine();
                                    try {
                                        //Validacion del formato de la fecha
                                        dateFormat1.setLenient(false);
                                        dateFormat1.parse(nuevaFechaDeInicio);
                                        empleadoModificar.setFechaDeInicio(nuevaFechaDeInicio);
                                    } catch (ParseException e) {
                                        System.out.println("Error: Formato de fecha incorrecto. Formato: yyyy-MM-dd");
                                        System.out.println("Volviendo al menú.......");
                                        continue;
                                    }
                                    empleadoModificar.setFechaDeInicio(nuevaFechaDeInicio);
                                    break;

                                default:
                                    System.out.println("Vuelta al menú......");
                                    break;
                            }
                            //Persistimos al empleado modificado
                            controladora.editarEmpleado(empleadoModificar);
                            System.out.println("Empleado actualizado correctamente.");
                        } else {
                            System.out.println("No existe ningún empleado con ese ID.");
                        }
                        break;
                    case 4:
                        //Eliminar un empleado
                        //Mostramos la lista de nuevo para que vean al empleado que desean eliminar.
                        System.out.println("Lista de empleados:");
                        List<Empleados> listEmpleadosEliminar = controladora.listarEmpleados();
                        for (Empleados empleados : listEmpleadosEliminar) {
                            System.out.println(empleados.toString());
                        }
                        //Pedimos el ID del empleado que se quiere eliminar
                        System.out.println("Ingrese el ID del empleado que desea eliminar:");
                        Long idEmpleadoEliminar = scanner.nextLong();
                        Empleados empleadoEliminar = controladora.buscarEmpleadoPorId(idEmpleadoEliminar);

                        if (empleadoEliminar != null) {
                            controladora.eliminarEmpleado(idEmpleadoEliminar);
                            System.out.println("Empleado eliminado correctamente");
                        } else {
                            System.out.println("No existe ningún empleado con ese ID");
                        }
                        break;
                    case 5:
                        //Buscar empleados por cargo
                        //Pedimos al usuario el cargo que desea seleccionar
                        System.out.println("Ingrese el cargo a buscar:");
                        String buscarCargo = scanner.next().toLowerCase();
                        List<Empleados> empleadosPorCargo = controladora.buscarEmpleadosPorCargo(buscarCargo);

                        if (!empleadosPorCargo.isEmpty()) {
                            System.out.println("Empleados con el cargo " + buscarCargo + ": ");
                            for (Empleados empleado : empleadosPorCargo) {
                                System.out.println(empleado.toString());
                            }
                        } else {
                            System.out.println("No se encontraron empleados con el cargo " + buscarCargo);
                        }
                        break;
                    case 6:
                        // Terminar el programa
                        System.out.println("***¡HASTA PRONTO!***");
                        System.out.println("La aplicación se ha cerrado correctamente.");
                        System.exit(0);
                        break;
                }
            }
        }

    }


