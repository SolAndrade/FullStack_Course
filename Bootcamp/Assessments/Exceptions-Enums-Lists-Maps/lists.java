public import java.util.*;

class Solution {
    public static List<String> wordTransformation(List<String> wordList, int n) {
        boolean removeFirst = true;
        for(int j=0; j<n; j++) {
            for (int i=0; i< wordList.size(); i++) {
                String word = wordList.get(i);
                if (removeFirst && word.length() > 1) {
                    String newWord = word.substring(1, word.length());
                    wordList.set(i, newWord);
                } else if (!removeFirst && word.length() > 1){
                    String newWord = word.substring(0, word.length()-1);
                    wordList.set(i, newWord);
                }
            }
            removeFirst = !removeFirst;
        }

        return wordList;
    }
} lists {
    
}
