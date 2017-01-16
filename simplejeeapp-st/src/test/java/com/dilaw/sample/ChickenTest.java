/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dilaw.sample;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Walid
 */
public class ChickenTest {

    private Client client;
    private WebTarget target;
    

    @Before
    public void initClient(){
       this.client= ClientBuilder.newClient();
       this.target = client.target("http://localhost:8080/SimpleJEEApp/web/Chickens");
       
    }
    @Test
    public void testHtml(){
        Response response = target.request().get();
        assertThat(response.getStatus(),is(200) );
    }


}
