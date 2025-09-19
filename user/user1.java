package user;
import DatabaseConnection.dbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class user1{


    private static int id;
    private String username;
    private String password;
    private String email;

    public user1(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static int getId() {
        return id;
    }

    public static void addUser(user1 user) {
        try (Connection conn = dbc.getConnection()) {
            String sql = "INSERT INTO user (uname, password, email) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.username);
            statement.setString(2, user.password);
            statement.setString(3, user.email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static user1 getUser(String username) {
        try (Connection conn = dbc.getConnection()) {
            String sql = "SELECT * FROM users WHERE uname = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user1 user = new user1(
                        result.getString("uname"),
                        result.getString("password"),
                        result.getString("email")
                );
                user.id = result.getInt("id");
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean  checkUser(String username,String password) {
        try (Connection conn = dbc.getConnection()) {
            String sql = "SELECT * FROM user WHERE uname = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
           // if(result!=null){
                if(result.next()){
                    if(!result.getString("password").equals(password)){
                        System.out.println("Please enter valid password");
                    }else{
                        return true;
                    }
                }
           // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User does not exsists");
        return false;
    }

    public static boolean  checkOwner(String username) {
        String u_name="owner";
       if(username.equals(u_name)){
        return true;
       }
       return false;
    }
}