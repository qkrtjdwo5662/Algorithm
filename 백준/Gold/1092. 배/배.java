import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        List<Integer> craneList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            craneList.add(num);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> boxList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            boxList.add(num);
        }

        Collections.sort(craneList, Collections.reverseOrder());
        Collections.sort(boxList, Collections.reverseOrder());

        int count = 0;
        int answer = 0;

        if(craneList.get(0) < boxList.get(0)){
            System.out.println(-1);
            return;
        }


        while(count < m){ //
            int craneIndex = 0;
            int boxIndex = 0;

            while(boxIndex < boxList.size()){
                if(craneIndex == craneList.size()) break;

                if(craneList.get(craneIndex) >= boxList.get(boxIndex)){
                    craneIndex++;
                    boxList.remove(boxIndex);
                    count++;
                }else{
                    boxIndex++;
                }
            }

            answer++;
        }

        System.out.println(answer);
    }

}
