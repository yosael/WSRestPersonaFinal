/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.yosael.model.Persona;
import dao.PersonaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author edwingutierrez
 */

@Stateless
public class PersonaService {
    
    @EJB
    PersonaDAO personaDAO;

    public void agregar(Persona t) throws Exception {
        try {
            personaDAO.agregar(t);
        }
        catch (Exception e) {	
            e.printStackTrace();
        }
    }

    
    public void modificar(Persona t) throws Exception {
        try {
            personaDAO.modificar(t);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    
    public void eliminar(Persona t) throws Exception {
            personaDAO.eliminar(t);
    }

    
    public Persona buscarPorId(int id) throws Exception {
        
        Persona persona = null;
        try {
            System.out.println("Entro a persona service impl, buscar por id");
            persona = personaDAO.buscarPorId(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }

    
    public List<Persona> buscarTodos() throws Exception {
        
        List<Persona> personas = new ArrayList<Persona>();
        System.out.println("Entro a buscar todos personaService");
        try {
             personas = personaDAO.buscarTodos();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return personas;
    }
	
}
