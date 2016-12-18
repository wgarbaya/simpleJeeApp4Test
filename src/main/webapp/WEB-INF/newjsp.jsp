<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : newjsp
    Created on : 4 févr. 2015, 20:54:52
    Author     : Garbaya
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page Title</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form id="form1" class="form" method="post" action="#" onsubmit="fct();return false">
            <p class="name">
                <label for="name">Name</label>
                <input type="text" name="name" id="name" placeholder="John Doe" />
            </p>

            <p class="age">
                <label for="age">age</label>
                <select name="age">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </p>
            <p class="submit">
                <input type="submit" value="Send" />
            </p>

        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            
           
            <tbody>
                <c:forEach  items="${Chicken_Tab}" var="chicken">
                <tr>
                    <td>${chicken['name']}</td>
                    <td>${chicken['age']}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
    <script>




        function getXhr()
        {
            if (window.XMLHttpRequest)          
            {
                xhr = new XMLHttpRequest();
            }
            else if (window.ActiveXObject)   
            {
                try
                {
                    xhr = new ActiveXObject("Msxml2.XMLHTTP");  
                }
                catch (e)
                {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            else  
            {
                alert("Votre navigateur ne supporte pas les objets XMLHttpRequest !");
                xhr = false;
            }

            return xhr;
  
        }
 
 
        function actionForm(url, param)
        {
            var xhr = getXhr (); 
            xhr.open('POST', url, false);  
            xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
            if (param)
            {
                xhr.send(param);
            }
            if (xhr.responseText)
            {
                return eval('(' +  xhr.responseText + ')'); 
              
            }
            else
            {    alert("OK - data has been added");
                location.reload();
                return;
            }
        } 
        

        function fct(){


        var inputs= document.getElementById('form1').getElementsByTagName('select');
        param = '&name='+document.getElementById('name').value+'&age='+inputs[0].options[inputs[0].selectedIndex].text+ '&operation=save';
        url="Chickens";
        actionForm(url,param);
        return false;
        }
    </script>        
</html>
