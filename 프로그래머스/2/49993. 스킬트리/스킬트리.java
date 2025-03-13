import java.util.*;

class Solution {
    static boolean[] used;
    static char[] parent;
    static Set<Character> skillSet;
    public int solution(String skill, String[] skill_trees) {
        
        parent = new char['Z' - 'A' + 1];
        
        for(int i=0; i<'Z' - 'A' + 1; i++){
            parent[i] = (char)('A' + i);
        }
        
        
        skillSet = new HashSet<>();
        skillSet.add(skill.charAt(0));
        for(int i=1; i<skill.length(); i++){
            char c = skill.charAt(i);
            skillSet.add(c);
            
            parent[c - 'A'] = skill.charAt(i - 1);
        }
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            String s = skill_trees[i];
            
            if(check(s)) answer++;
        }
        
        
        
        return answer;
    }
    
    static boolean check(String s){
        used = new boolean['Z' - 'A' + 1];
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(skillSet.contains(c)){ // 선행 작업 필수
                char p = parent[c - 'A'];
                
                if(p != c && !used[p - 'A']) return false;
            }
            
            used[c - 'A'] = true;
        }
        
        return true;
    }
}