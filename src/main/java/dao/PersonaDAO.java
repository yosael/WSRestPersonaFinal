/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.yosael.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwingutierrez
 */

@Stateless
public class PersonaDAO implements Serializable {
    
    @PersistenceContext(unitName = "WSRestPersona_1PU")
    private EntityManager em;

	
    public void agregar(Persona t) throws Exception {
            em.persist(t);
    }

	
    public void modificar(Persona t) throws Exception {
            em.merge(t);

    }

    
    public void eliminar(Persona t) throws Exception {
            em.remove(t);

    }

    
    public Persona buscarPorId(int id) throws Exception {
            System.out.println("Entro a persona DAO impl, buscar por id");
            return em.find(Persona.class, id);
    }

    
    
    public List<Persona> buscarTodos() throws Exception {
            Query query = em.createQuery("SELECT p FROM Persona p");
            return query.getResultList();
    }
    
}
