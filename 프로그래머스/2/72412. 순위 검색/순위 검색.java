import java.util.*;

class Solution{
    static Map<String, Integer> initMap; // 모든 데이터 매핑
    static Map<Integer, List<Integer>> infoMap; // 해당 조합에 대한 점수

    // 쿼리 최대 10만번
    // 모든 조합 32가지
    
    public int[] solution(String[] info, String[] query) {
        init();
        initInfoData(info);
        
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            String s = query[i];
            
            String[] splitS = s.split(" ");
            
            String lan = splitS[0];
            String group = splitS[2];
            String career = splitS[4];
            String food = splitS[6];
            String score = splitS[7];
            
            int lanNum = initMap.get(lan);
            int groupNum = initMap.get(group);
            int careerNum = initMap.get(career);
            int foodNum = initMap.get(food);
            int scoreNum = Integer.parseInt(score);
            
            int num = lanNum | groupNum | careerNum | foodNum;
            int count = 0;
            
            for(int key: infoMap.keySet()){ // 조합의 개수로는 4X2X2X2 = 32
                // 기존키와 or 연산해서 기존키 나오면
                if((key|num) == key){
                    
                    List<Integer> list = infoMap.get(key);
                    
                    int left = 0;
                    int right = list.size() - 1;
                    
                    int index = -1;
                    
                    while(left <= right){
                        int mid = (left + right)/2;
                        
                        if(scoreNum <= list.get(mid)){
                            index = mid;
                            right = mid - 1;
                        }else left = mid + 1;
                    }
                    

                    if(index == -1) continue;
                    
                    count += list.size() - index;
                } 
    
            }
            
            
            answer[i] = count;
            
        }
        
        
        return answer;
    }
    
    static void init(){
        initMap = new HashMap<>();
        
        initMap.put("-", 0);
        
        initMap.put("cpp", 1);
        initMap.put("java", 2);
        initMap.put("python", 4);
        
        initMap.put("backend", 8);
        initMap.put("frontend", 16);
        
        initMap.put("junior", 32);
        initMap.put("senior", 64);
        
        initMap.put("chicken", 128);
        initMap.put("pizza", 256);
    }
    
    static void initInfoData(String[] info){
        infoMap = new HashMap<>();
        for(int i=0; i<info.length; i++){
            
            String s = info[i];
            
            String[] splitS = s.split(" ");
            String lan = splitS[0];
            String group = splitS[1];
            String career = splitS[2];
            String food = splitS[3];
            String score = splitS[4];
            
            int num = 0;
            int lanNum = initMap.get(lan);
            int groupNum = initMap.get(group);
            int careerNum = initMap.get(career);
            int foodNum = initMap.get(food);
            int scoreNum = Integer.parseInt(score);
            num = lanNum | groupNum | careerNum | foodNum;
            
            if(!infoMap.containsKey(num)){ // 조합 처음 나옴
                List<Integer> list = new ArrayList<>();
                infoMap.put(num, list);
                list.add(scoreNum);
                
            }else{
                List<Integer> list = infoMap.get(num);
                list.add(scoreNum);
            }
        }
        
        for(int key: infoMap.keySet()){
            List<Integer> list = infoMap.get(key);
            Collections.sort(list);
        }
    }
    
}