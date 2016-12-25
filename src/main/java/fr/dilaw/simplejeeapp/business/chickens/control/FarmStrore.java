/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.control;

import fr.dilaw.simplejeeapp.business.chickens.entity.Farm;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Walid
 */
public class FarmStrore {
    @PersistenceContext
    EntityManager em;
    
    public void save(Farm fr){
        em.persist(fr);
    }

    public Farm getByName(String name) {
        return (Farm) em.createNamedQuery("getById").setParameter("name", name).getSingleResult();
    }

   
}
