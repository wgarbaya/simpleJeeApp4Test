/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.control.ChickenStore;
import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import fr.dilaw.simplejeeapp.business.chickens.entity.Farm;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

/**
 *
 * @author Walid
 */
public class ChickenServiceTest {
    
    ChickenService cut;

    @Before
    public void init(){
        this.cut = new ChickenService();
        this.cut.cs = Mockito.mock(ChickenStore.class);
        this.cut.fs = Mockito.mock(FarmService.class);
    }
    
    @Test
    public void save_without_farm(){
        Chicken c = new Chicken();
        c.setName("save_without_farm");
        c.setAge(0);
        cut.save(c);
    }
    
    @Test
    public void save_with_existing_farm(){
        Farm ret = new Farm();
        ret.setId(1);
        Mockito.when(this.cut.fs.getByName(ArgumentMatchers.anyString())).thenReturn(ret);
        Chicken c = new Chicken();
        c.setFarm(new Farm("TEST"));
        assertThat(cut._save(c).getFarm().getId(),Is.is(ret.getId()));
    }
    
    @Test
    public void save_with_not_existing_farm(){
        Mockito.when(this.cut.fs.getByName(ArgumentMatchers.anyString())).thenReturn(null);
        Chicken c = new Chicken();
        c.setFarm(new Farm("TEST"));
        assertNull(cut._save(c).getFarm());
    }    
    
    @Test
    public void getAllChickens(){
        
       List<Chicken> ls = new ArrayList<Chicken>();
       ls.add(new Chicken());
       ls.add(new Chicken());
       Mockito.when(this.cut.cs.all()).thenReturn(ls); 
       assertThat(this.cut.getAllChickens(), Is.is(ls));
    }
    
}
