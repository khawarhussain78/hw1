package com.java;
import java.sql.*;
public class Main
{
    public static void main(String[] args) {

        connection_main con = new connection_main();
        con.connect();
        insert_Record in = new insert_Record();
        in.insert();
        delete del = new delete();
        del.delete();
        manyToManyRelations m = new manyToManyRelations();
        m.select_query();
    }
}

class connection_main
{
    void connect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/contest","root","");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
class insert_Record
{
    void insert()
    {
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?)";
try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn= DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/contest","root","");
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, "3");
    statement.setString(2, "bill.gates@microsoft.com");
    statement.setString(3, "Bill Gates");
    statement.setString(4, "billgates123");

    int rowsInserted = statement.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("A new user was inserted successfully!");
    }
}catch(Exception e)
{
    e.printStackTrace();
}

    }
}

class update_Record
{
    void update()
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/contest","root","");
        String sql = "UPDATE user SET email=?, username=?, password=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, "3");
            statement.setString(3, "bill.gates@microsoft.com");
            statement.setString(2, "William Henry Bill Gates");
            statement.setString(4, "bill123");

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class delete
{
    void delete()
    {

        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/contest","root","");

        String sql = "DELETE FROM user WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);


            statement.setString(1, "3");

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class manyToManyRelations
{
    void select_query()
    {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/khawar_db","root","123456");
        String sql = "SELECT user.id, user.email, user.username, role.id AS role_id, role.name AS role_name FROM user JOIN user_roles on (user.id=user_roles.user_id) JOIN role on (role.id=user_roles.role_id)";

        Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                String id = result.getString(1);
                String email = result.getString("email");
                String pass = result.getString("username");
                String roleId = result.getString("role_id");
                String rollname = result.getString("role_name");


                //System.out.println(id, email, pass, roleId, rollname);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

