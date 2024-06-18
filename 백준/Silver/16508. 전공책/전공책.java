import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Book{
        int price;
        String title;

        public Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }

    static int[] count;
    static int[] selectedCount;
    static Book[] books;
    static int n;
    static final int MAX = 1_000_000;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String target = st.nextToken();
        count = new int[26];
        selectedCount = new int[26];

        for (int i = 0; i < target.length(); i++) {
            count[target.charAt(i) - 'A'] ++;
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        books = new Book[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();

            books[i] = new Book(price, title);
        }
        answer = MAX;
        backtrack(0, 0);
        if(answer == MAX){
            sb.append(-1).append("\n");
            System.out.println(sb);
        }else{
            sb.append(answer).append("\n");
            System.out.println(sb);
        }
    }

    static void backtrack(int depth, int sum){
        if(depth == n){
            if(check()) {
                answer = Math.min(answer, sum);
            }

            return;
        }

        Book book = books[depth];
        int price = book.price;
        String title = book.title;

        for (int i = 0; i < title.length(); i++) {
            selectedCount[title.charAt(i) - 'A'] ++;
        }
        backtrack(depth + 1, sum + price);
        for (int i = 0; i < title.length(); i++) {
            selectedCount[title.charAt(i) - 'A'] --;
        }
        backtrack(depth + 1, sum);
    }

    static boolean check(){
        for (int i = 0; i < 26; i++) {
            if(count[i] > selectedCount[i]) return false;
        }

        return true;
    }
}