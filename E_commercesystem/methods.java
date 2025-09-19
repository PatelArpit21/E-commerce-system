package E_commercesystem;
import  java.sql.*;
import java.util.Scanner;
import product.*;
public class methods {
    static Scanner sc=new Scanner(System.in);
   static  Connection con;
    static PreparedStatement pst;

    public methods() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
    }
        
    public static void owner() throws Exception{
        int choice=0;
        boolean b=true;
        do {
                
            System.out.println("Enter 1 to add a new product");
            System.out.println("Enter 2 to update a product");
            System.out.println("Enter 3 to delete product");
            System.out.println("Enter 4 to get list of all products");
            System.out.println("Enter 5 to download product list");
            System.out.println("Enter 6 to get list of product using some filter");
            System.out.println("Enter 7 to exit");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                System.out.println("enter product name:- ");
                String name=sc.next();
                System.out.println("enter product price:- ");
                int price=sc.nextInt();
                System.out.println("enter product quantity:- ");
                int quantity=sc.nextInt();

              product.addProduct(new product(name,price,quantity));
              break;
              case 2:
              System.out.println("enter product id:- ");
              int id=sc.nextInt();
              product.update(id);   
              break;
              case 3:
              System.out.println("enter product id:- ");
              int id1=sc.nextInt();
              product.delete(id1);
              break;
              case 4:
              product.viewallProduct();
              break;
              case 5:
                product.download();
              break;
              case 6:
              product.filter();
              break;
              case 7:
              b=false;
              break;
              default:
              break;
            }
        } while (b);
    }
 


    public static void usermethods() throws Exception{
            System.out.println();/*
            view products d
            view products by filter d 
            view past ordered items 
            view cart d
            confirm order d
        */
        int choice=0;
        boolean b=true;
        do {
            System.out.println("Enter 1 to view all products");
            System.out.println("Enter 2 to view products by filter");
            System.out.println("Enter 3 to view past ordered items");
            System.out.println("Enter 4 to add product to cart");
            System.out.println("Enter 5 to view cart");
            System.out.println("Enter 6 to confirm order");
            System.out.println("Enter 7 to exit");
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                product.viewallProduct();
                break;
                case 2:
                product.filter();
                break;
                case 3:
               // product.viewpastorder();
                break;
                case 4:
                System.out.println("enter product id:- ");
                product.addcart(sc.nextInt());
                break;
                case 5:
                product.viewcart();
                break;
                case 6:
                product.confirmorder();
                break;
                case 7:
                b=false;
                break;
                default:
                break;
    }
    }while(b);
}
}
