//Vehicle Class
//CS 380
//Jesus Rodriguez
//Version 1.0
//Last edited 5/12/2023 1:52AM
public abstract class Vehicle{

   private String licensePlate;
   private String make;
   private String model;
   private String color;
   private int parkingSpot;
    /**
      *
      *  Constructs a new Vehicle object with the specified license plate, make, model, color, and parking spot.
      *  @param licensePlate the license plate of the vehicle
      *  @param make the make of the vehicle
      *  @param model the model of the vehicle
      *  @param color the color of the vehicle
      *  @param parkingSpot the parking spot of the vehicle
      */
   public Vehicle(String licensePlate, String make, String Model, String Color, int parkingSpot){
      this.licensePlate = licensePlate;
      this.make = make;
      this.model = model;
      this.color = color;
      this.parkingSpot = parkingSpot;
   
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
    * getter for car make 
    * @return make 
    */

   public String getMake(){
      return make;
   }
    /**
    * setter for make 
    * @param make
    */

   public void setmake(String make){
      this.make = make;
   }
    /**
    * getter for model 
    * @return model 
    */

   public String getModel(){
      return model;
   }
    /**
    * setter for model
    * @param model
    */

   public void setModel(String model){
      this.model = model;
   }
    /**
    * getter for color 
    * @return color
    */

   public String getColor(){
      return color;
   }
    /**
    * setter for color 
    * @param color
    */

   public void setColor(String color){
      this.color = color;
   }
   /**
    * toString method to retrive values
    * @return string
    */
   public String toString(){
      return "license plate: " + this.licensePlate +  "make: " + this.make + "model: " + this.model + "color: " + this.color;
   }
     /**
    * abstract method for parked spot 
    * @param parking spot
    */

   public abstract int parkedSpot(int parkingSpot);
   

}