import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, WEelcome, JDBC...............");

        System.out.println("Please enter the task.....");
        System.out.println("1 :- Insert into database ");
        System.out.println("2 :- Update into database ");
        System.out.println("3 :- Delete into database ");
        System.out.println("4 :- Fetch into database ");
        Scanner sc =new Scanner(System.in);
        int input=sc.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","Nikhilg");
        
        if (input==1) {
            System.out.println("Insert...... ");
            System.out.println("Enter the Tools name:--");
            String name=sc.next();
            System.out.println("Enter the Status name:--");
            String status=sc.next();
            System.out.println("Enter the Channel name:--");
            String channel=sc.next();

            PreparedStatement ps=con.prepareStatement("Insert into jdbc_table values('"+name+"','"+status+"','"+channel+"')");
            int i=ps.executeUpdate();
            if (i>0) {
                System.out.println("Values Inserted, please check database");
                
            }else{
                System.out.println("Error...........");
            }

        }
        if (input==2) {
               System.out.println("Update...... ");
            System.out.println("what you want to update.............. ");
            System.out.println("1.Tools");
            System.out.println("2.Status");
            System.out.println("3.Channel");
            int number =sc.nextInt();
                if (number==1) {
                    System.out.println("Set tool:--");
                    String Tools=sc.next();
                    System.out.println("where name:--");
                    String Tools1=sc.next();
                    PreparedStatement ps = con.prepareStatement("UPDATE jdbc_table SET Tools = ? WHERE Tools = ?");
                    ps.setString(1, Tools);
                    ps.setString(2, Tools1);

                    int i=ps.executeUpdate();
                    if (i>0) {
                    System.out.println("Values Update, please check database");
                    
                    }else{
                    System.out.println("Error...........");
                    }

                }
                if (number==2) {
                    System.out.println("Set Status:--");
                    String Tools=sc.next();
                    System.out.println("where Tools:--");
                    String Tools1=sc.next();
                    PreparedStatement ps = con.prepareStatement("UPDATE jdbc_table SET status = ? WHERE Tools = ?");
                    ps.setString(1, Tools);
                    ps.setString(2, Tools1);

                    int i=ps.executeUpdate();
                    if (i>0) {
                    System.out.println("Values Update, please check database");
                    
                    }else{
                    System.out.println("Error...........");
                    }

                }
                if (number==3) {
                    System.out.println("Set Channel--");
                    String To=sc.next();
                    System.out.println("where Tools:--");
                    String Tools1=sc.next();
                    PreparedStatement ps = con.prepareStatement("UPDATE jdbc_table SET Chennal  = ? WHERE Tools = ?");
                    ps.setString(1, To);
                    ps.setString(2, Tools1);
                    int i=ps.executeUpdate();
                    if (i>0) {
                    System.out.println("Values Update, please check database");
                    }else{
                    System.out.println("Error...........");
                    }

                }
        }
        if (input==3) {
                    System.out.println("Delete...........");
                    System.out.println("what row you want to delete");
                    System.out.println("Enter tool name");
                    String To=sc.next();
                    PreparedStatement ps = con.prepareStatement("delete from jdbc_table where Tools =?");
                    ps.setString(1, To);
                    int i=ps.executeUpdate();
                    if (i>0) {
                    System.out.println("Row delete, please check database");
                    }else{
                    System.out.println("Error...........");
                    }
        }
        if (input==4) {
            System.out.println("Fetch the Database");
            PreparedStatement ps=con.prepareStatement("select * from jdbc_table");
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                String n1=rs.getString("Tools");
                System.out.println("Tools :" +n1);
                String n2=rs.getString("Status");
                System.out.println("status :" +n2);
                String n3=rs.getString("Tools");
                System.out.println("Channel:" +n3);
            }
            con.close();
        }

    }

}
