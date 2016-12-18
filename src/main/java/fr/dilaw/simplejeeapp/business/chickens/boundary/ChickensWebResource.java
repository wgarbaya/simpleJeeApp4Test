/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dilaw.simplejeeapp.business.chickens.boundary;

import fr.dilaw.simplejeeapp.business.chickens.entity.Chicken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Garbaya
 */
@WebServlet(urlPatterns = "/web/Chickens", loadOnStartup = 1)
//@ApplicationPath("web/Chickens")
public class ChickensWebResource extends HttpServlet {

    @Inject
    ChickenService cs;
    public static final String VIEW = "/WEB-INF/newjsp.jsp";
    private static final String CHICKENTAB = "Chicken_Tab";
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                Map<String, String[]> parameterMap = request.getParameterMap();
   
        if(parameterMap.get("operation").length > 0 && parameterMap.get("operation")[0].equals("save")){
            int age = Integer.valueOf(parameterMap.get("age")[0]);
            String name = parameterMap.get("name")[0];
            cs.save(new Chicken(name, age));
            
        }  
//        doGet(request, response); //TO DO: transform to ajax
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String[]> parameterMap = request.getParameterMap();

     
            List<Map<String,String>> cl = new ArrayList<>();
            List<Chicken> lc  = cs.getAllChickens() ;
            for ( Chicken c : lc){
                Map<String,String> tmp = new HashMap<>();
                tmp.put("name", c.getName());
                tmp.put("age", String.valueOf((c.getAge())));
                cl.add(tmp);
            request.setAttribute(CHICKENTAB, cl);

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VIEW);
        requestDispatcher.include(request, response);
        

    }
}
