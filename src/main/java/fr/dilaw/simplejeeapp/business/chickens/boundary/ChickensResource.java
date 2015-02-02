/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import java.util.List;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Garbaya
 */
@Path("chickens")
public class ChickensResource {
    
    @Inject
    ChickenService cs;
    
    @GET
    public List<Chicken> chickens(){
        return cs.getAllChickens();
    }
    @POST
    public void save(JsonObject jchicken){
        System.out.println(jchicken.toString());
        String name = jchicken.getString("name");
        int age = jchicken.getInt("age");
        cs.save(new Chicken(name,age));
    }
}
