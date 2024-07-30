import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int solution(String s) {
        int answer = 0;
        // 문자열을 리스트에 저장
        List<Character> sList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            sList.add(c);
        }

        int l = s.length();
        for (int i = 0; i < l; i++) {
            // 현재 리스트가 유효한 괄호 문자열인 경우 정답을 증가시킴
            if (isValid(sList)) {
                answer += 1;
            }
            // 문자열을 한 칸 회전시킴
            sList.add(0, sList.get(sList.size() - 1));
            sList.remove(sList.size() - 1);
        }
        return answer;
    }

    // 주어진 리스트가 유효한 괄호 문자열인지 확인하는 메서드
    private boolean isValid(List<Character> sList) {
        Deque<Character> stack = new ArrayDeque<>(); // 스택을 이용하여 괄호 매칭 확인
        HashMap<Character, Character> map = new HashMap<>(); // 매칭 정보를 담은 해시맵
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : sList) {
            if (map.containsKey(c)) { // 여는 괄호일 경우 스택에 push
                stack.push(c);
            } else { // 닫는 괄호일 경우
                if (stack.isEmpty()) { // 스택이 비어있으면 불일치
                    return false;
                }
                if (map.get(stack.peek()) != c) { // 스택의 맨 위 괄호와 일치하지 않으면 불일치
                    return false;
                }
                stack.pop(); // 일치하면 스택에서 pop
            }
        }
        return stack.isEmpty(); // 스택이 비어있으면 모든 괄호가 정상적으로 매칭됨
    }

}
