import E_commercesystem.methods;
import java.util.Scanner;
import user.user1;
public class Main{
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice=0;
        while(choice!=3){
            System.out.println("Enter 1 for new user registration");
            System.out.println("Enter 2 to login for exsisting user");
            System.out.println("Enter 3 to exit");
            choice=sc.nextInt();
            switch(choice){
                case 1 :{
                    System.out.print("Enter username : ");
                    String uname=sc.next();
                    System.out.print("Enter password : ");
                    String password=sc.next();
                    System.out.print("Enter email : ");
                    String email=sc.next();
                    user1.addUser(new user1(uname,password,email));
                    //break;
                }
                case 2 :{
                    String uname,password;
                    boolean b=true;
                    do {
                        System.out.print("Enter username : ");
                        uname=sc.next();
                        System.out.print("Enter password : ");
                        password=sc.next();
                        b=user1.checkUser(uname,password);
                        System.out.println(b);
                        if(b==false){
                            String olduname=uname;
                        }else{
                            break;
                        }
                    } while (b);

                    if (b) {
                        if(user1.checkOwner(uname)){
                            methods.owner();
                        }
                        else{
                            methods.usermethods();
                        }
                    }
                    break;
                }
                    
                case 3 :{
                    System.out.println("Thankyou for visiting our site");
                    break;
                }

                default :{
                    System.out.println("Please enter a valid choice");
                    break;
                }
            }
        }
        
    }
}
