public import java.util.HashMap;
import java.util.Map;

class Solution {
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap();
        for (String s:strings) {
          // plan for stored boolean:
          //   false = seen it once
          //   true = seen it twice or more
          if (!map.containsKey(s)) {
            map.put(s, false);
          }
          else if (map.get(s) == false) {  // works without this test
            map.put(s, true);
          }
        }
        return map;
    }
} maps {
    
}
