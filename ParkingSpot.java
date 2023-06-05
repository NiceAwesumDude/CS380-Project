//ParkingSpot class
//CS 380
//Liam Barr, Jesus Rodriguez, Jacob Thornton
//version 1.6
//Last edit 6/5/2023

public class ParkingSpot {
 
 //fields
 
 //does not need setter because it should be permanent
 //nor a getter because it can be derived in Lot class
 private int ID;
 
 //These do not have a setter, but should have a getter
 private int timePaid;
 private int timeLeft;
 private Vehicle vehicle;
 private boolean occupied;
 //when occupied is false, that means the spot is empty
 
 
 //methods
 
 /**
 * @param id The ID of the spot
 * @param tp The time paid for
 * @param tl The time remaining
 * @param licensePlate The liscence plate number of the vehicle
 */
 ParkingSpot(int id, int tp, int tl, String licensePlate){
    this.ID = id;
    timePaid = tp;
    timeLeft = tl;
    if (licensePlate.isEmpty() || licensePlate.equals("Empty")){
       occupied = false;
    }
    else {
       occupied = true;
    }
    this.vehicle = new Car("", licensePlate);
 }
 
 
 /**
 * Creates a new ParkingSpot
 * Kept for compatibility purposes
 * @param id The ID of the spot
 * @param time the time alloted to the vehicle
 * @param licensePlate The licsence plate number of the vehicle
 */
 ParkingSpot (int id, int time, String licensePlate) {
    this(id, time, time, licensePlate);
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
 * Basic toString method that also uses the vehicle class toString method to get license plate info
 * @return The string
 */
public String toString() {
    if (vehicle == null) {
       return "No Vehicle";
    } else {
       //This is how to interpret the results: ID, platenum, timeLeft
       return this.ID + ", " + this.getPlateNum() + ", " + timeLeft;
    }
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
 public Vehicle getVehicle() {
    return vehicle;
 }
 
 /**
 * Returns the license plate number
 * @return The license plate number
 */
 public String getPlateNum(){
    if(vehicle != null){
       return vehicle.getLicensePlate();
    }else{
       return "Null";
    }
 }
}