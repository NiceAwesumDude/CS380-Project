//ParkingSpot class
//CS 380
//Liam Barr
//version 1.0
//Last edit 5/8/2023

public class ParkingSpot {
   
   //fields
   
   //does not need setter because it should be permanent
   //nor a getter because it can be derived in Lot class
   private int ID;
   
   //These do not have a setter, but should have a getter
   private int timePaid;
   private int timeLeft;
   private String vehicle;
   
   //has both setter and getter
   private boolean occupied;
   
   
   //methods
   
   
   /**
   * Creates a new ParkingSpot
   * @param id The ID of the spot
   * @param time the time alloted to the vehicle
   * @param vehicle The licsence plate number of the vehicle
   */
   ParkingSpot (int id, int time, String vehicle) {
      this.ID = id;
      timePaid = time;
      timeLeft = time;
      this.vehicle = vehicle;
      if (vehicle.equals("")) {
         occupied = false;
      }
      else {
         occupied = true;
      }
   }
   
   /**
   * Creates a new ParkingSpot
   * @param id The ID of the spot
   */
   ParkingSpot (int id) {
      this(id, 0, "");
   }
   
   /**
   * Adds time to the vehicle
   * @param time The amount to add
   */
   public void addTime(int time) {
      timePaid += time;
      timeLeft += time;
   }
   
   /**
   * Simulates the passage of time by lowering the ramaining time
   * @param time The time to take away
   */
   public void passTime (int time) {
      timeLeft -= time;
      if (timeLeft < 0) {
         timeLeft = 0;
      }
   }
   
   /**
   * Basic toString method
   * @return The string
   */
   public String toString() {
      return "ID: "+this.ID+" Licencse Plate: "+vehicle+" Time Paid: "+timePaid+" Time Left: "+timeLeft;
   }
   
   /**
   * Setter for occupied
   * @param o Whether it is occupied or not
   */
   public void setOccupancy (boolean o) {
      occupied = o;
   }
   
   /**
   * Getter for occupied
   * @return Is it occupied?
   */
   public boolean getOccupancy() {
      return occupied;
   }
   
   /**
   * Returns the amount of time paid for
   * @return The time paid for
   */
   public int getTimePaid() {
      return timePaid;
   }
   
   /**
   * Returns the amount of time left
   * @return The amount of time left
   */
   public int getTimeLeft() {
      return timeLeft;
   }
   
   /**
   * Returns the vehicle
   * @return The vehicle
   */
   public String getVehicle() {
      return vehicle;
   }
}