public class Main {
    public static String rps(String p1, String p2) {
      if(p1 == p2) return "Draw!";
      String rock = "rock";
      String paper = "paper";
      String scissors = "scissors";

      boolean rs = p1 == rock && p2 == scissors;
      boolean pr = p1 == paper && p2 == rock;
      boolean tp = p1 == scissors && p2 == paper;

      if (rs || pr || tp) return "Player 1 won!";
      else return "Player 2 won!";

    }
}
