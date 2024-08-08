class Solution {
    // prices를 int 배열로 받는 매개변수 만들기
    public int[] solution(int[] prices) {
        // answer는 int 배열로 받는다.
        // answer 생성자 객체 만들
        int[] answer = new int[prices.length];
        
        // for문을 활용해 0부터 주식가격의 길이만큼 증가하며 돌린다.
        for(int i = 0; i<prices.length; i++) {
            // int j는 i에서 1을 더한 값이며, 동일하게 주식가격의 길이만큼 증가하면 돌린다.
            for(int j = i+1; j<prices.length; j++) {
                // answer를 증가하는 배열로 값을 받는다.
                answer[i]++;
                // if문을 통해 i 배열의 주식가격이 j 배열의 주식가격보다 큰 경우 break하여 루프문을 빠져나온다.
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        // 결과값 answer를 생성자에 return 해준다.
        return answer;
    }
}