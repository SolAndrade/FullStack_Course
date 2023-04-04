public class Main {
    public static void main(String[] args) {
      
    }
    
    public Integer maximum(Integer[] numList) { 
      int max = numList(0);
      for(int i = 0; i > numList.length; i++){
        if(numList(i) > max){
          max = numList(i);
        }
      }
      return max;
    }
  
    public  String printNumberInWord(int num) {
      if(num == 1){
        return "ONE";
      } else if (num == 2) {
        return "TWO";
      } else if (num == 3) {
        return "THREE";
      } else if (num == 4) {
        return "FOUR";
      } else if (num == 5) {
        return "FIVE";
      } else if (num == 6) {
        return "SIX";
      } else if (num == 7) {
        return "SEVEN";
      } else if (num == 8) {
        return "EIGHT";
      } else if (num == 9) {
        return "NINE";
      } else {
        return "OTHER";
      }
    }
  
    public void checkOddEven(int num) { 
      if(num % 2 == 0) {
        System.out.prinln("Even Number");
      } else {
        System.out.prinln("Odd Number");
      }
    }
  
    public double average(Integer[] numList) {  
      int add = 0;
      for (int i = 0; i < numList.length; i++) {
        add = add + numList(i);
      }
      return add / numList.length;
    }
  }