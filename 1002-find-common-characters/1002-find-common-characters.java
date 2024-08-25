import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : words[0].toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Iterate for the rest words.
        for (int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (char ch : words[i].toCharArray()) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            
            HashMap<Character, Integer> newFrqMap = new HashMap<>();
            for (char ch2 : map.keySet()) {
                if (map2.containsKey(ch2)) {
                    newFrqMap.put(ch2, Math.min(map.get(ch2), map2.get(ch2)));
                }
            }

            map = newFrqMap;
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ele = entry.getKey();
            int cnt = entry.getValue();
            for (int i = 0; i < cnt; i++) {
                list.add(String.valueOf(ele));
            }
        }

        return list;
    }
}
