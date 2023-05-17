import java.sql.*;


public class Test {
   public static void main(String[] args) {
      /*String url = "jdbc:mysql://localhost:3306/parkinglot";
		String userName = "root";
		String password = "@1Lumlum";
      
      Connection con;
      */
      
      ParkingLot p = new ParkingLot();
      p.addVehicle(0,10,"DF");
      p.addVehicle(1,20,"CV");
      p.addVehicle(2,30,"ER");
      System.out.println(p.toString());
      
      p.passTime(15);
      p.addTime(1,3);
      System.out.println("\n"+p.toString());
      
      p.save();
   }
}