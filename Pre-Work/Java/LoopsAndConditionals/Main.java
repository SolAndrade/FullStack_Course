class Main {
  public static void main(String[] args){
    int[] nbrListInt = {3, 5, 7, 9};
    double[] nbrListDouble = {3.1, 5.2, 7.3, 9.4, 5.3};
    String[] strList = {"Hola", "esto", "es", "una", "prueba"};
    boolean[] boolList = {true, false, true};
    
    for (int i = 0; i < nbrListInt.length; i++) {
      System.out.println(nbrListInt[i]);
    }
    for (int i = 0; i < nbrListDouble.length; i++) {
      System.out.println(nbrListDouble[i]);
    }
    for (int i = 0; i < strList.length; i++) {
      System.out.println(strList[i]);
    }
    for (int i = 0; i < boolList.length; i++) {
      System.out.println(boolList[i]);
    }
  }
}