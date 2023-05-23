import java.sql.*;


public class Test {
   public static void main(String[] args) {

      
      ParkingLot p = new ParkingLot();
      /*
      p.addVehicle(0,10,"DF");
      p.addVehicle(1,20,"CV");
      p.addVehicle(2,30,"ER");
      System.out.println(p.toString());
      
      p.passTime(15);
      p.addTime(1,3);
      System.out.println("\n"+p.toString());
      
      p.save();
      */
      
      p.load();
      System.out.println(p.toString());
      System.out.println("\n"+p.getEmpty());
      System.out.println("\n"+p.getFull());
      
   }
}