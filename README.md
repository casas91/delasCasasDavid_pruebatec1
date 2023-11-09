Se trata de una aplicación conectada a una base de datos, que permite al usuario gestionar los empleados a través de los siguientes métodos:
Agregar empleados.
Listar a los empleados.
Modificar a los empleados.
Eliminar a los empleados.
Buscar a los empleados por su cargo.

Al ejecutar la aplicación, esta le dara un numero de opciones a realizar, en la que el usuario elegirá la que mas le convenga en ese momento.

***BIENVENIDO AL SISTEMA DE GESTIÓN DE EMPLEADOS***
Selecciona una opcion: 
Pulse 1 para agregar un nuevo empleado
Pulse 2 para ver la lista de empleados
Pulse 3 para modificar un empleado
Pulse 4 para eliminar un empleado
Pulse 5 para buscar los empleados por cargo
Pulse 6 para terminar
Seleccione una opción: 

Al elegir la opción 1 el usuario ingresara campo a campo los diferentes datos (Nombre, Apellidos, Salario, Cargo y Fecha de Inicio). Si los datos introducidos como el salario o la fecha de inicio no tienen la sintaxis correcta se lanzará una excepcion y se le mostrará un mensaje de lo que debe introducir y le llevará de nuevo a la pantalla principal.

Ingrese al nuevo empleado 
Ingrese el nombre:
Pedro
Ingrese el apellido: 
Martinez
Ingrese el cargo: 
Programador
Ingrese el salario:
25p00
Error: Ingrese un salario válido.
Volviendo al menú.....

Al elegir la opcion 2 se le mostrará la lista de los empleados que han sido introducidos anteriormente a la base de datos.

Seleccione una opción: 
2
| ID | Nombre | Apellido | Cargo | Salario | Fecha de inicio |
| 2 | Marta | Cerezo | Profesora | 45000,00 | 2021-09-15 |
| 3 | Julio | Ramirez | Carpintero | 4500,00 | 2002-06-26 |
| 4 | Pedro | Martinez | Programador | 25000,00 | 2016-12-15 |

Al elegir la opción 3 se le pide ingresar el ID del empleado que quiere modificar y se le muestra la lista para que confirme que el empleado a modificar es el correcto.
Si se ingresa un ID inexistente la aplicación lo detectará y lanzara un mensaje diciendo que el ID no existe y le llevará a la pantalla principal.
Al ingresar un ID correcto se le preguntará por el dato que desea modificar(Nombre, Apellidos, Salario, Cargo y Fecha de Inicio), que se seleccionará presionando la tecla correspondiente.

Selecciona una opcion: 
Pulse 1 para agregar un nuevo empleado
Pulse 2 para ver la lista de empleados
Pulse 3 para modificar un empleado
Pulse 4 para eliminar un empleado
Pulse 5 para buscar los empleados por cargo
Pulse 6 para terminar
Seleccione una opción:

Al elegir la opción 4, al igual que en la opción 3, se le muestra la lista de los empleados para que ingrese el ID del empleado que desea eliminar. Si ingresase un ID inexistente el programa lo detectará y lanzará el mensaje de ID inexistente, llevandole a la pantalla principal de nuevo.

Al elegir la opción 5, se le pide el ingreso de el cargo que quiere buscar, si no existe en la base de datos, se mostrará un mensaje diciendo que el cargo buscado no existe, en cambio, si existe, se le mostrará una lista con los empleados con ese cargo. No importa si el cargo se escribe en mayusculas o minusculas, será reconocido por la aplicación siempre que se encuentre dentro de los cargos en la base de datos.  

Seleccione una opción: 
5
Ingrese el cargo a buscar:
Programador
Empleados con el cargo programador: 
| ID | Nombre | Apellido | Cargo | Salario | Fecha de inicio |
| 4 | Pedro | Martinez | Programador | 25000,00 | 2016-12-15 |

Por último, la elección de la opción 6 llevará al cierre de la aplicación.

Seleccione una opción: 
6
***¡HASTA PRONTO!***
La aplicación se ha cerrado correctamente.

Process finished with exit code 0

CONSIDERACIONES 

La aplicación podría haber sido más extensa proponiendo otros métodos y funcionalidades como buscar personas por rango de salario, nombre, apellidos u ordenarlos campos por orden alfabético entre otras.
Una interfaz gráfica de usuario facilitaría el uso de la aplicación.










