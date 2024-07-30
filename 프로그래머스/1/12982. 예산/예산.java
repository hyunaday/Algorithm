import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
		//✅ d를 정렬한다.
        Arrays.sort(d);
        int result = 0;
        
        //✅ 예산이 적은 부서부터 전체 예산이 소진될 때까지 지급한다.
        for (int price : d) {
            budget -= price;
            if (budget < 0) break;
            result++;
        }
        
        //✅ 예산을 지급한 부서의 개수를 반환한다.
        return result;
    }
}

        // 최솟값 구하기: 작은 수들로 고르기
        // 전체 예산-최솟값들로 구성된 금액들(그래야 최대한 많은 지원을 할 수 있음)
        // 신청한 모든 금액 지원
        
        // d는 부서별로 신청한 금액이 들어있는 배열
        // 1<=d.length<=100,000
        // 1<=length<=100