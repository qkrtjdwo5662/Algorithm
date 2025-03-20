import java.util.*;

class Solution {
    static int n;
    static int[] parent;
    static HashMap<String, Integer> map;
    static int m;
    
    static class Info{
        int from;
        int cost;
        boolean isEnd;
        
        public Info(int from, int cost, boolean isEnd){
            this.from = from;
            this.cost = cost;
            this.isEnd = isEnd;
        }
    }
    
    static List<Info>[] list;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        n = enroll.length;
        parent = new int[n + 1]; // 전체 부모까지 포함 시킴
        map = new HashMap<>(); // 각 사원의 인덱스를 추출하기 위한 Map
        list = new List[n + 1];
        
        for(int i=0; i<= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            String name = enroll[i];
            map.put(name, i + 1);
        }
        // System.out.println(map); 
        
        for(int i=0; i<n; i++){
            String parentName = referral[i];
            
            if(parentName.equals("-")){
                parent[i + 1] = 0;
                continue;
            }
            
            int index = map.get(parentName);
            
            parent[i + 1] = index;
        }
        // System.out.println(Arrays.toString(parent));
        
        m = seller.length;
        
        int[] answer = new int[n];
        for(int i=0; i<m; i++){
            String sellerName = seller[i];
            int count = amount[i];
            int total = 100 * count;
                
            // 재귀를 통해서 부모를 타고 타고 들어갈 것인가
            // 재귀 태우면 10_000
            // seller전체 길이 100_000 -> 시간초과 발생
            
            // 일단 부모한테만 계산때려서 넘기고 나중에 한번에 처리 하는 방식으로
            int index = map.get(sellerName);
            
            if(total / 10 > 0){
                
                int parentIndex = parent[index];
                int remain = total - (total / 10);
            
                
                list[parentIndex].add(new Info(index, total/10, false));
                list[index].add(new Info(index, remain, true));
                
            }else{
                list[index].add(new Info(index, total, true));
            }
            
            
        }
        
        // System.out.println(Arrays.toString(answer));
        // seller와 amount를 순회하며 이익의 10%를 부모에게 전달하는 과정까지만 했음
        // 그럼 이제 추천을 받은 사람으로 부터 온 금액을 나머지 부모에게 어떻게 전달해줄 것인가
        // 해당 금액을 누군한테 얼마를 전달 받았고, 정산이 끝났는가?에 대한 여부를 같이 저장해준다.
        
        for(int i=n; i >= 0; i--){
            List<Info> now = list[i];
            
            for(int j=0; j<now.size(); j++){
                Info info = now.get(j);
                
                // 정산 끝났는지 여부
                if(!info.isEnd){
                    // 정산이 끝나지 않았다면 부모의 리스트 갱신해줘야한다.
                    dfs(i, j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            int total = 0;
            List<Info> now = list[i + 1];
            for(int j=0; j<now.size(); j++){
                total += now.get(j).cost;
            } 
            
            answer[i] = total;
        }
        
        return answer;
    }
    
    static void dfs(int num, int listIndex){
        int parentIndex = parent[num];
        if(parentIndex == num) return;
        
        Info info = list[num].get(listIndex);
    
        if(info.cost / 10 > 0){
            int remain = info.cost - info.cost / 10;
            list[parentIndex].add(new Info(num, info.cost/10, false));
            info.cost = remain;
            info.isEnd = true;
            dfs(parentIndex, list[parentIndex].size() - 1);
        }
        
        info.isEnd = true;
        
    }
}