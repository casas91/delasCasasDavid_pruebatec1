package org.example.persistencia;

import org.example.logica.Empleados;

import java.util.List;

public class PersistenciaController {
    EmpleadosJpaController empleadosJpa = new EmpleadosJpaController();

    //Metodos para operaciones CRUD

    public void crearEmpleado(Empleados empleados) {
        empleadosJpa.create(empleados);
    }

    public void eliminarEmpleado(Long id) {
        empleadosJpa.destroy(id);
    }

    public void editarEmpleado(Empleados empleados) {
        empleadosJpa.edit(empleados);
    }

    public List<Empleados> listarEmpleados() {
        return empleadosJpa.findEmpleadosEntities();
    }

    //Creamos metodos para encontrar los empleados por ID y por cargo

    public Empleados buscarEmpleadoPorId(Long id) {
        return empleadosJpa.findEmpleados(id);
    }


    public List<Empleados> buscarEmpleadosPorCargo(String cargoBuscar) {
        return empleadosJpa.findEmpleadosPorCargo(cargoBuscar);
    }
}
