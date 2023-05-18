//Vehicle Class
//CS 380
//Jesus Rodriguez
//Version 1.1
//Last edited 5/18/2023
public abstract class Vehicle{

   private String licensePlate;
   private String make;
   private int parkingSpot;
    /**
      *
      *  Constructs a new Vehicle object with the specified license plate
      *  @param licensePlate the license plate of the vehicle
      *  @param parkingSpot the parking spot of the vehicle
      */
   public Vehicle(String make, String licensePlate){
      this.make = make;
      this.licensePlate = licensePlate;
   
   }
   
   /**
    * getter for license 
    * @return make
    */

   public String getMake(){
      return make;
   }
   
   /**
    * setter for make 
    * @param make
    */

   public void setMake(String make){
      this.make = make;
   }
   
   /**
    * getter for license 
    * @return license plate
    */
   public String getLicensePlate(){
      return licensePlate;
   }
    /**
    * setter for license 
    * @param String license plate
    */

   public void setLicensePlate(String licensePlate){
      this.licensePlate = licensePlate;
   }
   
   /**
    * toString method to retrive values
    * @return string
    */
   public String toString(){
      return " Make of vehicle: " + this.make + " License Plate: " + this.licensePlate;
   }
     /**
    * abstract method for parked spot 
    * @param parking spot
    */

   public abstract int parkedSpot(int parkingSpot);
   

}
