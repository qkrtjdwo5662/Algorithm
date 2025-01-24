class Solution {
    static int osm;
    static int oss;
    static int oem;
    static int oes;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] posSplit = pos.split(":");
        
        int nm = Integer.parseInt(posSplit[0]); // 현재 분
        int ns = Integer.parseInt(posSplit[1]); // 현재 초
        
        String[] videoLenSplit = video_len.split(":");
        
        int em = Integer.parseInt(videoLenSplit[0]); // 끝 분
        int es = Integer.parseInt(videoLenSplit[1]); // 끝 초 
        
        String[] opStartSplit = op_start.split(":");
        String[] opEndSplit = op_end.split(":");
        
        osm = Integer.parseInt(opStartSplit[0]);
        oss = Integer.parseInt(opStartSplit[1]);
        
        oem = Integer.parseInt(opEndSplit[0]);
        oes = Integer.parseInt(opEndSplit[1]);
        
        // video_len : 영상 길이 // 마지막 위치
        // pos : 이전 위치 
        // op_start, op_end : 오프닝 위치
        
        if(check(nm, ns)){
            nm = oem;
            ns = oes;
        }
        
        
        for(int i=0; i<commands.length; i++){
            String command = commands[i];
            
            if(command.equals("prev")){
                ns -= 10;
            }else if(command.equals("next")){
                ns += 10;
            }
            
            if(ns < 0){
                nm -= 1;
                ns += 60;
                
                if(nm < 0){ // 음수로 향하면 처음 시간
                    nm = 0;
                    ns = 0;
                }
            }else if(ns >= 60){
                nm += 1;
                ns -= 60;
                
                if(nm > em){ // 끝 시간 보다 넘치면 
                    ns = es;
                    nm = em;
                }
            }
            
            if(nm == em && ns > es){ // 분이 같은데 초가 넘쳤으면
                ns = es;
            }
            
            // 오프닝 위치 인지
            if(check(nm, ns)){
                nm = oem;
                ns = oes;
            }
        
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(nm == 0) sb.append("00");
        else if(nm < 10) sb.append("0").append(nm);
        else sb.append(nm);
        
        sb.append(":");
        
        if(ns == 0) sb.append("00");
        else if(ns < 10) sb.append("0").append(ns);
        else sb.append(ns);
        
        return sb.toString();
    }
    
    static boolean check(int nm, int ns){
        if(osm < nm && nm < oem) return true;
        
        else if(osm == nm && oem == nm && oss <= ns && ns <= oes) return true;
        
        else if(osm == nm && nm < oem && oss <= ns) return true;
        else if(osm < nm && nm == oem && ns <= oes) return true;
        
        
        return false;
    }
}