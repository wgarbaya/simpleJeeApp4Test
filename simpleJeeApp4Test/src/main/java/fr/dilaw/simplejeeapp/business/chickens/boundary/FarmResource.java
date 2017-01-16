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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Walid
 */
@Startup
@Singleton
@Path("Farm")
public class FarmResource {
    
    @Inject
    FarmService fs;

    public FarmResource() {
    }
    
    @POST
    @Path("add")
    @Consumes("application/json")
    public void addFarm(Farm nwFarm){
        fs.create(nwFarm); 
    }
    
    

  /** @PostConstruct
    void atStartup(){
    **/
}
