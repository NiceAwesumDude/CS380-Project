//CS380
//ParkingLot class, to function as in in-between of the GUI and the spot class
//Liam Barr, Jacob Thornton
//version 1.3
//last edit on 6/2/2023

import java.sql.*;

public class ParkingLot {
   
   //fields
   private ParkingSpot[] lot;
   private Connection con;
   
   //methods
   
   /**
   * Creates an empty ParkingLot class
   * Meant for initializing the program
   */
   ParkingLot() {
      lot = new ParkingSpot[30];
      for (int i = 0; i<lot.length; i++) {
         lot[i] = new ParkingSpot(i);
      }
      connect();
   }
   
   /**
   * Getter for an individual spot
   * @param The ID of the desired spot
   * @return A parking spot
   */
   public ParkingSpot getSpot(int id) {
      return lot[id];
   }
   
   /**
   * Patrols the lot, removing any vehicle that has stayed longer than its alloted time
   */
   public void patrol() {
      for (int i =0; i<lot.length; i++) {
         if (lot[i].getTimeLeft() == 0) {
            lot[i] = new ParkingSpot(i);
         }
      }
   }
   
   /**
   * Passes the time, subtracting minuites from all spots.
   * This includes those that are unoccupied
   * @param time The amount of time to pass
   */
   public void passTime(int t) {
      for (int i = 0; i<lot.length; i++) {
         lot[i].passTime(t);
      }
   }
   
   /**
   * Vacates a spot
   * @param id The spot to vacate
   * @return Boolean for operation completion
   */
   public boolean vacate(int id) {
	   if (lot[id].getOccupancy()) {
		   lot[id] = new ParkingSpot(id);
		   return true;
	   }
       return false;
   }
   
   /**
   * Adds a vehicle to the lot.
   * Does not do it if the spot is occupied
   * @param id The spot to park in
   * @param t The time paid for
   * @param v The vehicle, currently a plate num
   * @return Boolean for operation completion
   */
   public boolean addVehicle(int id, int t, String v) {
      if (lot[id].getOccupancy()) {
         System.out.println("Spot is already occupied");
         return false;
      }
      lot[id] = new ParkingSpot(id, t, v);
      return true;
   }
   
   /**
   * Adds time to a particular spot
   * @param id The ID of the spot
   * @param t The amount of time to add
   * @return Boolean for operation completion
   */
   public boolean addTime (int id, int t) {
	   if (lot[id].getOccupancy()) {
		   lot[id].addTime(t);
	       return true;
	   }
	   return false;
   }
   
   /**
   * toString method
   * @return The lot's string
   */
   public String toString() {
      String s = "Spot, License, Time Bought, Time Left";
      for (int i = 0; i <lot.length; i++) {
         s = s + "\n" + lot[i].toString();
      }
      return s;
   }
   
   /**
   * Returns a list of empty spots
   * @return A list of empty spots
   */
   public String getEmpty() {
      String s = "Spot ID";
      for (int i = 0; i < lot.length; i++) {
         if (lot[i].getOccupancy() == false) {
            s = s + "\n" + i;
         }
      }
      return s;
   }
   
   /**
   * Returns a list of occupied spots
   * @return A list of occupied spots
   */
   public String getFull() {
      String s = "Spot ID, License, Time Left";
      for (int i = 0; i < lot.length; i++) {
         if (lot[i].getOccupancy()) {
            s = s + "\n" + lot[i].toString();
         }
      }
      return s;
   }
   /**
   * initialises the connection
   */
   private void connect(){
		String url = "jdbc:mysql://localhost:3306";
		String userName = "root";
		String pass = "@1Lumlum";
		
		try {
			con = DriverManager.getConnection(url, userName, pass);
			System.out.println("connected");
		}
		catch (Exception e) {
			System.out.println("exception " + e.getMessage()); 
		}
	}
   
   /**
   * Resets the database and stores info in it
   */
   public void save(){
      //dropping the old database
      String init = "DROP DATABASE IF EXISTS parkinglot; ";
      try{
         Statement s = con.createStatement();
         s.execute(init);
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
      //create the new one
      init = "CREATE DATABASE parkinglot;";
      try{
         Statement s = con.createStatement();
         s.execute(init);
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
      //use the db
      init = "USE parkinglot;";
      try{
         Statement s = con.createStatement();
         s.execute(init);
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
      //make table
      init = "CREATE TABLE lot ( "+
            "id         INT         NOT NULL, "+
            "occupied   BIT   NOT NULL, "+
            "lplatenum  VARCHAR(7), "+
            "timepaid   INT, "+
            "timeleft   INT, "+
            "CONSTRAINT lotPK "+
            "PRIMARY KEY (id) "+
            ");";
      try{
         Statement s = con.createStatement();
         s.execute(init);
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
      //add the info
      init = "INSERT INTO lot(id, occupied, lplatenum, timepaid, timeleft) values(?,?,?,?,?)";
      for (int i = 0; i < lot.length; i++){
         try{
            PreparedStatement ps = con.prepareStatement(init);
            ps.setInt(1, i);
            ps.setBoolean(2, lot[i].getOccupancy());
            ps.setString(3, lot[i].getPlateNum());
            ps.setInt(4, lot[i].getTimePaid());
            ps.setInt(5, lot[i].getTimeLeft());
            ps.execute();
         }
         catch(Exception e){
            System.out.println(e);
            System.exit(0);
         }
      }
   }
   
   /**
   * Loads the data into the database
   */
   public void load(){
      String q = "USE parkinglot;";
      try{
         Statement s = con.createStatement();
         s.execute(q);
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
      
      q = "SELECT * FROM lot";
      int i = 0;
      
      try {
         Statement s = con.createStatement();
         ResultSet r = s.executeQuery(q);
         while (r.next()){
            lot[i] = new ParkingSpot(r.getInt("id"), r.getInt("timepaid"),
                  r.getInt("timeleft"), r.getString("lplatenum"));
            
            i++;
         }
      }
      catch(Exception e){
         System.out.println(e);
         System.exit(0);
      }
   }
}