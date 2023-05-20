//CS 380
//Liam Barr
//5/19/23
//car class
public class Car extends Vehicle{
   
   /*
   * Constructor for car
   */
   Car(String make, String plateNum){
      this.make = make;
      this.licensePlate = plateNum;
   }
   
   /*
   * I'm not sure what this method is for, but since it extends vehicle it is required to get this to work
   * @param Some integer
   */
   public int parkedSpot(int i){
      return i;
   }
}