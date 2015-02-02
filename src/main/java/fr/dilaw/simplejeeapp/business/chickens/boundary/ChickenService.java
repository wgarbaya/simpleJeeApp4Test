/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.control.ChickenStore;
import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Garbaya
 */
@Stateless
public class ChickenService {
    @Inject
    ChickenStore cs;
    public List<Chicken> getAllChickens(){
        return this.cs.all();
    }
    public void save(Chicken chicken){
        this.cs.save(chicken);
    }
}
