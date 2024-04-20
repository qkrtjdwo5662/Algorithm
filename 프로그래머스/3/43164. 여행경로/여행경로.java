import java.util.*;
class Solution {
    static String[][] tickets;
    static String[] answer;
    static boolean[] visited;
    static boolean flag;
    static ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        list = new ArrayList<>();
        
        dfs("ICN",0, "ICN");
        Collections.sort(list);
        
        answer = list.get(0).split(" ");
        
        return answer;
    }
    
    static void dfs(String now, int depth, String s){
        
        if(depth == tickets.length){
            list.add(s);
            return;
        }
        
        
        
        for(int i=0; i<tickets.length; i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(from.equals(now) && !visited[i]){
                visited[i] = true;
                dfs(to, depth + 1, s + " " + to);
                visited[i] = false;
            }
        }
        
    }
}