/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.control.FarmStrore;
import fr.dilaw.simplejeeapp.business.chickens.entity.Farm;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Walid
 */
@Stateless
public class FarmService {
    
    @Inject 
    FarmStrore fs;
   
    public void save(Farm fr){
         fs.save(fr);
    }

    public Farm getByName(String name) {
        return fs.getByName(name);
    }

    public void  create(Farm farm) {
        fs.save(farm);
    }
}
