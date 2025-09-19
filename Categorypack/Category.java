package Categorypack;
import java.util.Scanner;
//DONE
public class Category {
    private String type;
    Scanner sc=new Scanner(System.in);

    Category(){
        System.out.print("Enter the category of product : ");
        type=sc.nextLine();
    }

    public void changecategory(){
        System.out.print("Enter the new category of product : ");
        type=sc.nextLine();
    }


}
