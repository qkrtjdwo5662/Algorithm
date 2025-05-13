import java.util.*;

class Solution {
    static int n;
    static int m;
    static int answer;
    static int[] weak;
    static int[] dist;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> weakList;
    public int solution(int n, int[] weak, int[] dist) {
        answer = dist.length + 1;
        
        this.n = n;
        this.m = weak.length;
        this.weak = weak;
        this.dist = dist;
        
        arr = new int[dist.length];
        visited = new boolean[dist.length];
        
        Arrays.sort(dist);
        weakList = new ArrayList<>();
        
        for(int i=0; i<weak.length; i++){
            weakList.add(weak[i]);
            weakList.add(weak[i] + n);
        }
        Collections.sort(weakList);
        
        backtrack(0);
        
        if(answer == dist.length + 1) return -1;
        return answer;
    }
    static void check(){
        for(int i=0; i<m; i++){
            
            int count = 0; // 사용친구 수 
            int index = 0; // 취약점 몇개 수정?
            
            int s = weakList.get(i); // 시작점이라고 박고
            int max = s;
            for(int j=0; j<arr.length; j++){
                count ++;
                
                int num = arr[j]; // 친구놈 불러
                
                max += dist[num]; // 여기까지 올 수 있음?
                
                while(index < m && weakList.get(i + index) <= max){
                    index ++;
                }
                
                if(index == m) break;
                
                max = weakList.get(i + index);
                // 다음 지점 갱신
            }
            if (index >= m) answer = Math.min(answer, count);
        }
        
    }
    
    static void backtrack(int depth){
        if(depth == dist.length){
            // 사람 뽑아
            check();
            return;
        }
        
        for(int i=0; i<dist.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}