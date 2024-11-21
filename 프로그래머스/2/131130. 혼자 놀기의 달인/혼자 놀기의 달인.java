import java.util.*;

class Solution {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> list;
    static int[] cards;
    public int solution(int[] cards) {
        // 1 ~ 100 숫자 카드 존재
        // 2 이상 100 이하 자연수 정함 작거나 같은 숫자 준비
        
        // 1번 그룹
        // 임의의 상자 하나 선택 -> 선택한 상자 안의 숫자 -> 해당 상자 열기
        // 이미 열려있을때까지
        
        // 2번 그룹
        // 임의의 상자 하나 선택 -> 선택한 상자 안의 숫자 -> 해당 상자 열기
        // 이미 열려있을때까지
        
        // 1번 그룹 상자 수 * 2번 그룹 상자 수의 최대 값
        
        // backtracking
        int answer = 0;
        this.cards = cards;
        
        n = cards.length;
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for(int i=0; i<n; i++){
            dfs(cards[i], 0);
        }
        
        
        for(int i=0; i<list.size() - 1; i++){
            for(int j=i+1; j<list.size(); j++){
                answer = Math.max(answer, list.get(i) * list.get(j));
            }
        }
        
        return answer;
    }
    
    static void dfs(int now, int count){
        if(visited[now]){
            if(count > 0) list.add(count);
            return;  
        } 
        visited[now] = true;
        
        dfs(cards[now - 1], count + 1);
    }
}