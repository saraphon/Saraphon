<%-- 
    Document   : addNewFoodSuccess
    Created on : Aug 25, 2024, 1:14:29 PM
    Author     : LENOVO
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Addfood" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Add Fried chicken Success</h1>
        <%
            Addfood newFood = (Addfood) session.getAttribute("newFood");
        %>
        Namefood: <%= newFood.getFoodname() %><br/>
        Type: <%= newFood.getType() %><br/>
        Crispness: <%= newFood.getCrispness() %><br/>
        Spicy: <%= newFood.getHotlevel() %><br/>
        Sauce: <%= newFood.getSauce() %><br/>
        Price: <%= newFood.getFoodPrice() %><br/>
        <a href="ShowUpdatedFood.jsp">Edit Fried chickens</a>
    </body>
</html>
