import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String bomb = br.readLine();

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));

            boolean check = true;
            String ss = "";
            if(list.size() >= bomb.length()){
                for (int j = 0; j < bomb.length(); j++) {
                    if(list.get(list.size() - bomb.length() + j) != bomb.charAt(j)) {
                        check = false;
                        break;
                    }
                }

                if(check){
                    for (int j = 0; j < bomb.length(); j++) {
                    list.remove(list.size() -1);
                    }
                }
            }
        }

        if(list.size() == 0){
            System.out.println("FRULA");
        }else{
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
        }

        System.out.println(sb);
    }
}