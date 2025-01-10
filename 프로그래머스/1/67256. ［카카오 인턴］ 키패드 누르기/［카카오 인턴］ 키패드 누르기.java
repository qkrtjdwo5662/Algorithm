class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 왼 *
        // 오 #
        
        // 1 4 7 -> 왼
        // 3 6 9 -> 오
        
        // 2 5 8 0 누를때 최근 상태에서 가장 가까운 엄지 손가락 
        // 거리 같으면 hand에 따라 누르기
        int tempL = 10;
        int tempR = 12;
        // 1 2 3
        // 4 5 6
        // 7 8 9
        
        // 4에서 3까지의 거리
        // 도착지를 3이하의 수가 될 수 있도록 나머지 연산 처리하고 count에 담음 0
        // 출발지를 3이하의 수가 될 수 있도록 나머지 연산 처리하고 count에 담음 1
        // 둘의 차 2 + count = 3
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            if(num == 0) num = 11;
            
            
            if(num == 1 || num == 4 || num == 7){
                // 무조건 왼쪽
                sb.append('L');
                tempL = num;
            }else if(num == 3 || num == 6 || num == 9){
                // 무조건 오른쪽
                sb.append('R');
                tempR = num;
            }else{
                int leftDist = cal(tempL, num);
                int rightDist = cal(tempR, num);
                
                // System.out.println(tempL + " " + tempR + " " + num);
                // System.out.println(leftDist + " " + rightDist);
                if(leftDist < rightDist){
                    sb.append('L');
                    tempL = num;
                }else if(leftDist > rightDist){
                    sb.append('R');
                    tempR = num;
                }else{
                    if(hand.equals("right")){
                        sb.append('R');
                        tempR = num;
                    }else {
                        sb.append('L');
                        tempL = num;
                    }
                }
            }
            
           
        }
        return sb.toString();
    }
    
    static int cal(int start, int end){
        int count = 0;
        
        int moveStart = 0;
        int moveEnd = 0;
        while(start > 3){
            start -= 3;
            moveStart ++;
        }
        
        while(end > 3){
            end -= 3;
            moveEnd ++;
        }
        
        return Math.abs(end - start) + Math.abs(moveStart - moveEnd);
    }
}