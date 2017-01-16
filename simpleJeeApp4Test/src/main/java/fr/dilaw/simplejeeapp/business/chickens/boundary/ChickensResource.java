/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import fr.dilaw.simplejeeapp.business.chickens.entity.Farm;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Garbaya
 */
@Path("chickens")
public class ChickensResource {
    
    @Inject
    ChickenService cs;
    
    @GET
    @Path("list")
    @Produces("application/json")
    public List<Chicken> chickens(){ 
        return cs.getAllChickens();
    }
    
    @POST
    @Path("add")
    @Consumes("application/json")
    public void save(JsonObject jchicken){
        Chicken c = new Chicken(jchicken.getString("name"),jchicken.getInt("age"));
        Optional<String> oSFarmName = Optional.ofNullable(jchicken.getString("farmName", null));
        if (oSFarmName.isPresent()){
        c.setFarm(new Farm(oSFarmName.get()));
        }
        cs.save(c);
    }
}
