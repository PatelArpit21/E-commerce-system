package product;  
import DatabaseConnection.dbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import user.user1;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.naming.spi.DirStateFactory;
//UPDATE PRODUCT
public class product {
    private int id;
    private  String name;
    private  double price;
    int stock;
    
    static ArrayList<product> cart=new ArrayList<product>();
    static Scanner sc = new Scanner(System.in);
    public product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }
    
    public double getPrice() {
        return price;
    }

    public static void addProduct(product product) {
        try (Connection conn = dbc.getConnection()) {
            String sql = "INSERT INTO products (name, price, stock,cid) VALUES (?, ?, ?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.name);
            statement.setDouble(2, product.price);
            statement.setInt(3, product.stock);
            System.out.println("enter category id:-");
            statement.setInt(4, sc.nextInt());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static product getProduct(int productId) {
        try (Connection conn = dbc.getConnection()) {
            String sql = "SELECT * FROM products WHERE pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                product product = new product(
                        result.getString("name"),
                        result.getDouble("price"),
                        result.getInt("stock")
                );
                product.id = result.getInt("pid");
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet allproducts() throws Exception{
        Connection con=dbc.getConnection();
        String query="SELECT * FROM products";
        PreparedStatement pst=con.prepareStatement(query);
        ResultSet rs=pst.executeQuery();
        return rs;
    }

    public static void viewallProduct()throws Exception{
            product p;
            ResultSet result = allproducts();
            HashSet products=new HashSet();

        while(result.next()) {
            p = new product(result.getString("name"),(double)result.getInt("price"),result.getInt("stock"));
            p.id = result.getInt("pid");
                products.add(p);
        }
            //System.out.println(products);
       
            if (products.isEmpty()) {
                System.out.println("no  product");
            }else{
                for (Object elem : products) {
                System.out.println(elem);
            }
        }
    }

    public static void filter()throws Exception{
            product p;
            ResultSet result = allproducts();
             HashSet products=new HashSet();

            while(result.next()) {
                p = new product(result.getString("name"),(double)result.getInt("price"),result.getInt("stock"));
                p.id = result.getInt("cid");
                products.add(p);
            }
       
        System.out.println("1. by high price to low price");
        System.out.println("2. by low price to high price");
        ArrayList a = new ArrayList<>(products);
        
            int i =sc.nextInt();
            switch (i) {
                case 1:
                List<product> productList = new ArrayList<>(products);
                //System.out.println(productList);
                productList.sort(Comparator.comparingDouble(product::getPrice).reversed());
                if (productList.isEmpty()) {
                    System.out.println("no  product");

                }else{
                for (Object elem : productList) {
                    System.out.println(elem);
                }
            }
                break;
                case 2:
                List<product> productList1 = new ArrayList<>(products);
                productList1.sort(Comparator.comparingDouble(product::getPrice));
                if (productList1.isEmpty()) {
                    System.out.println("no  product");

                }else{
                for (Object elem : productList1) {
                    System.out.println(elem);
                }
            }
                    break;
                default:
                    break;
            } 
    }

    public static void update(int id)throws  SQLException{
        try (Connection conn = dbc.getConnection()) {
            String sql = "UPDATE products SET name = ?, price = ?, stock = ? WHERE pid =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println("enter price:-");
            statement.setInt(4, id);
            statement.setInt(3, sc.nextInt());
            System.out.println("enter stock :- ");
            statement.setInt(2, sc.nextInt());
            System.out.println("enter name :- ");
            statement.setString(1, sc.next());
            statement.executeUpdate();
        }
    }

    public static void delete(int id1) throws SQLException{
        Connection conn = dbc.getConnection();
            String sql = "DELETE FROM products WHERE pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,id1);
            statement.execute();
    }

    public static void addcart(int id){
       product p= getProduct(id);
       if(p.stock!=0){
            cart.add(p);
            System.out.println(p+"is added");
       }
       else{
        System.out.println("Product out of stock");
       }
    }

    public static void conorder()throws SQLException{
        try (Connection conn = dbc.getConnection()) {
            Iterator itr=cart.iterator();
          //  product p;
            
        }
    }

    public static void viewcart(){
        for (Object p : cart) {
            System.out.println(p);
        }
    }

@Override
    public String toString() {
        return "product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }
    public static void confirmorder(){
        
    }

    public static void download() throws Exception{
        File f=new File("Products.txt");
        f.createNewFile();
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        ResultSet rs=allproducts();
        bw.write("Product_ID\t\tName\t\tPrice\n");
        while(rs.next()){
            bw.write(rs.getString(1)+" \t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
            bw.newLine();
        }
        bw.close();
}

    public static HashSet filterdownload()throws Exception{
        product p;
        ResultSet result = allproducts();
         HashSet products=new HashSet();

        while(result.next()) {
            p = new product(result.getString("name"),(double)result.getInt("price"),result.getInt("stock"));
            p.id = result.getInt("cid");
            products.add(p);
        }
   
    System.out.println("1. by high price to low price");
    System.out.println("2. by low price to high price");
    ArrayList a = new ArrayList<>(products);
    
        int i =sc.nextInt();
        switch (i) {
            case 1:
            List<product> productList = new ArrayList<>(products);
            //System.out.println(productList);
            productList.sort(Comparator.comparingDouble(product::getPrice).reversed());
            if (productList.isEmpty()) {
                System.out.println("no  product");

            }else{
                File f=new File("D:/Products.txt");
                BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                ResultSet rs=allproducts();
                bw.write("Product_ID\t\tName\t\tPrice");
            for (Object elem : productList) {
                bw.write(rs.getString(1)+" \t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
                bw.newLine();
            }
        }
            break;
            case 2:
            List<product> productList1 = new ArrayList<>(products);
            productList1.sort(Comparator.comparingDouble(product::getPrice));
            if (productList1.isEmpty()) {
                System.out.println("no  product");

            }else{
                File f=new File("D:/Products.txt");
                BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                ResultSet rs=allproducts();
                bw.write("Product_ID\t\tName\t\tPrice");
            for (Object elem : productList1) {
                bw.write(rs.getString(1)+" \t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
                bw.newLine();            }
        }
                break;
            default:
                break;
        } 
        return products;
}

}