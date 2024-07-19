class Solution {
    int[] numbers; // 사용할 수 있는 숫자가 담긴 배열 선언
    int target;
    static int answer;
    
    
    void dfs(int idx, int sum){
        // idx = dfs call에서 연산할 숫자가 위치한 인덱스
        // sum = 누적합
 
        
        // 1. 탈출 조건
        if (idx == numbers.length){
            if(sum==target) answer++;
            return;
        }
        
        // 2. 수행동작
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]);
        
    }
    
    public int solution(int[] numbers, int target) { 
        answer = 0;
        this.numbers = numbers; // 멤버변수 Numbers에 전달 받은 numbers 담음
        this.target = target; // 멤버 변수 target에 전달 받은 target 담음
 
        dfs(0,0);
        
        return answer;
    }
}
