/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.control;

import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Garbaya
 */
public class ChickenStore {
    @PersistenceContext
    EntityManager em;
    
    public void save(Chicken ck){
        em.merge(ck);
    }
    public List<Chicken> all(){
        return this.em.createNamedQuery("all", Chicken.class).getResultList();
    }
}
