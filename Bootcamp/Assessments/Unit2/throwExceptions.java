public class Main{
  public static int positiveMultiplier(int input){
    if(input < 0){
      throw new IllegalArgumentException("input number must be positive");
    } 
    
    return input * input;
  } 
    
}