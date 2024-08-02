import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : numbers) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int key : map.keySet()) {
                temp.put(key+num, map.get(key) + temp.getOrDefault(key+num, 0));
                temp.put(key-num, map.get(key) + temp.getOrDefault(key-num, 0));
            }
            map = temp;
        }
        return map.getOrDefault(target, 0);
    }
}
