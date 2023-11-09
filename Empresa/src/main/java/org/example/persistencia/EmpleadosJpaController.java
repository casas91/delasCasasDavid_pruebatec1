package org.example.persistencia;
import org.example.logica.Empleados;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmpleadosJpaController {
    private EntityManagerFactory emf = null;

    //Constructor

    public EmpleadosJpaController() {
        //Obtener la unidad de persistencia creada
        this.emf = Persistence.createEntityManagerFactory("empresaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear metodos para interactuar con la BD

    public void create(Empleados empleados) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(empleados);
        em.getTransaction().commit();
    }

    public void destroy(Long id) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        Empleados empleados = em.find(Empleados.class, id);
        em.remove(empleados);
        em.getTransaction().commit();

    }

    public void edit(Empleados empleados) {
        EntityManager em = null;
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(empleados);
        em.getTransaction().commit();
    }

    public List<Empleados> findEmpleadosEntities() {
        EntityManager em = null;
        em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Empleados.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    //Creamos un metodo para encontrar los empleados por ID.

    public Empleados findEmpleados(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public List<Empleados> findEmpleadosPorCargo(String cargo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Empleados> query = em.createQuery(
                    "SELECT e FROM Empleados e WHERE e.cargo = :cargo", Empleados.class);
            query.setParameter("cargo", cargo.toLowerCase());
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}

