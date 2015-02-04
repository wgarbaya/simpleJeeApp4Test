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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form class="form" method="POST">
            <p class="name">
                <label for="name">Name</label>
                <input type="text" name="name" id="name" placeholder="John Doe" />
            </p>

            <p class="age">
                <label for="name">age</label>
                <select name="age">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </p>
            <p class="submit">
                <input type="submit" value="Send" />
            </p>
            <input type="hidden" name="operation" value="save">

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
</html>
