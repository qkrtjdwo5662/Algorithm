class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        // 0번째는 1로 고정
        // n-1번째 수에서 1은 110111 0은 00000으로 치환
        // l과 r구간에서 1의 개수는 몇개인지
        
        // n이 주어졌을때 칸토어 비트열에서
        // l과 r에 해당하는게 어디 부분인지를 구해야함
        
        for(long i = l; i <= r; i++){
            if (isOne(n, i)) { // 1이면 카운트
                answer++;
                // System.out.println(i);
            }
        }
        
        return answer;
    }
    

    static boolean isOne(int n, long index) {
        if (n == 1 && index != 3) return true; // n=1일 때는 항상 1
        
        long length = (long) Math.pow(5, n - 1); // 현재 단계의 블록 크기
        long section = (index - 1) / length; // 현재 인덱스가 속한 5개 구역 중 어느 위치인지 판별
        
        if (section == 2) return false; // 중앙 00000 구역이면 0
        
        // 재귀적으로 더 작은 단계로 내려가서 확인
        return isOne(n - 1, (index - 1) % length + 1);
    }
}