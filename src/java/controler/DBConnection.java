/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Addfood;

public class DBConnection{
//        public static void main(String[] args) {
//        DBConnection dbConnection = new DBConnection();
//        Addfood food = dbConnection.getFood("French");
//        
//        if (food != null) {
//            System.out.println("Food found:");
//            System.out.println("Name: " + food.getFoodname());
//            System.out.println("Type: " + food.getType());
//            System.out.println("Crispness: " + food.getCrispness());
//            System.out.println("Hotlevel: " + food.getHotlevel());
//            System.out.println("Sauce: " + food.getSauce());
//            System.out.println("Price: " + food.getFoodPrice());
//        } else {
//            System.out.println("Food not found");
//        }
//    }


    public boolean insertNewFood(Addfood food) {
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DBfood",
                    "root", "882003");

            Statement statement = connection.createStatement();

            String query = "INSERT INTO food "
                    + "(name, type, crispness, hotlevel, sauce, price) "
                    + "VALUES('"
                    + food.getFoodname() + "','"
                    + food.getType() + "','"
                    + food.getCrispness() + "','"
                    + food.getHotlevel() + "','"
                    + food.getSauce() + "',"
                    + food.getFoodPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }

        return result;
    }

    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
    public Addfood getFood(String name) {
        Addfood food = new Addfood();
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DBfood",
                    "root", "882003");
            
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM food WHERE name='" + name + "'";
            System.out.println(">>>>>>>>>> query=" + query);

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                food.setFoodname(resultSet.getString("name").trim());
                food.setType(resultSet.getString("type").trim());
                food.setCrispness(resultSet.getString("crispness").trim());
                food.setHotlevel(resultSet.getString("hotlevel").trim());
                food.setSauce(resultSet.getString("sauce").trim());
                food.setFoodPrice(resultSet.getDouble("price"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
        }
        return food;
    }
}
