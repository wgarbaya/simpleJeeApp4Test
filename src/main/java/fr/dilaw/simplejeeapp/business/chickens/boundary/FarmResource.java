/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.entity.Farm;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Walid
 */
@Startup
@Singleton
public class FarmResource {
    
    @Inject
    FarmService fs;

    public FarmResource() {
    }


    public FarmService getFs() {
        return fs;
    }

    public void setFs(FarmService fs) {
        this.fs = fs; 
    }
   
   @PostConstruct
    void atStartup(){
        fs.create(new Farm("Cereix")); 
    }
}
