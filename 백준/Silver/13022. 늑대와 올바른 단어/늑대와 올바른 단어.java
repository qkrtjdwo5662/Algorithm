import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int wCount = 0;
        int oCount = 0;
        int lCount = 0;
        int fCount = 0;

        char temp = 'w';

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'w'){
                if(temp == 'f' && (wCount == oCount && oCount == lCount && lCount == fCount)){
                    wCount ++;
                }else if(temp == 'w'){
                    wCount ++;
                }else {
                    System.out.println(0);
                    return;
                }
            }else if(s.charAt(i) == 'o'){
                if(temp == 'w' && (wCount > oCount)){
                    oCount ++;
                }else if(temp == 'o'){
                    oCount ++;
                }else {
                    System.out.println(0);
                    return;
                }

            }else if(s.charAt(i) == 'l'){
                if(temp == 'o' && (oCount > lCount)){
                    lCount ++;
                }else if(temp == 'l'){
                    lCount ++;
                }else {
                    System.out.println(0);
                    return;
                }

            }else if(s.charAt(i) == 'f'){
                if(temp == 'l' && (lCount > fCount)){
                    fCount ++;
                }else if(temp == 'f'){
                    fCount ++;
                }else {
                    System.out.println(0);
                    return;
                }

            }
            temp = s.charAt(i);
        }

        if(wCount == oCount && oCount == lCount && lCount == fCount){
            System.out.println(1);
        }else System.out.println(0);


    }
}