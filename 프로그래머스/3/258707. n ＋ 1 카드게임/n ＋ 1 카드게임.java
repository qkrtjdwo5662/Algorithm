import java.util.*;

class Solution {
    static int coin;
    static int[] cards;
    static int index; // 시작 인덱스
    static int n; // 카드 전체 크기
    static Set<Integer> myCards = new HashSet<>(); // 내가 보유한 카드
    static Set<Integer> addCards = new HashSet<>();

    public int solution(int coin, int[] cards) {
        int answer = 0;
        // 새로운 카드를 추가할때, 코인을 사용해야하는가?
        // 최대한 사용하지 않게
        this.coin = coin;
        this.cards = cards;
        n = cards.length;
        
        // 종료조건
        // 1. 카드 뭉치에 남은카드가 없다면 종료.
        // 2. 낼 카드가 없다면 종료 .
        
        // 내가 보유한 카드에서 낼 수 있는가?
        // 코인이 있는가?
            // 있다면 카드를 추가했을때 낼 수 있는가?
        init();
        index = n/3;
        int target = n + 1;
        
        while(coin >= 0){
            // 내가 보유한 카드에서 낼 수 있는가?
            answer ++; // 다음턴은 와서 끝남
            // System.out.println(myCards + " " + coin + " " + answer);
            // System.out.println(addCards);
            if(index >= n) break;
            addCards.add(cards[index]);
            addCards.add(cards[index + 1]);
            index += 2;
            
            boolean flag = false;
            
            
            for(int key: myCards){
                if(myCards.contains(target - key)){
                    myCards.remove(target - key);
                    myCards.remove(key);
                    flag = true;
                    break;
                }
                
            }
            if(flag){
                
                continue;
            }
            
            // 한장 추가 해야 낼 수 있는가?
            if(coin >= 1){
                
                
                for(int key: myCards){
                    if(addCards.contains(target - key)){
                        addCards.remove(target - key);
                        myCards.remove(key);
                        coin -= 1;
                        flag = true;
                        break;
                    }
                }
            }
            
            if(flag){
                // System.out.println(2);
                continue;
            }
            
            // 추가한 것끼리 낼 수 있는가?
            if(coin >= 2){
                for(int key: addCards){
                    if(addCards.contains(target - key)){
                        addCards.remove(target - key);
                        addCards.remove(key);
                        coin -= 2;
                        flag = true;
                        break;
                    }
                }
            }
            // System.out.println(addCards);
            if(!flag) break;
            
            
            System.out.println(3);
        }
        
        return answer;
    }
    
    static void init(){
        
        for(int i=0; i<n/3; i++){
            myCards.add(cards[i]);
        }
        
        
    }
}