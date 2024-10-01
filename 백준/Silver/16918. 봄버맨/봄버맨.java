import java.util.*;
 
public class Main {
	
	public static int R, C, N;
	public static char[][] map;
	public static int time=0;
	public static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	R = sc.nextInt();
    	C = sc.nextInt();
    	N = sc.nextInt();
    	map = new char[R][C];
    	
    	//초기값 입력받음.
    	for(int i=0;i<R;i++) {
    		String str = sc.next();
    		for(int j=0;j<C;j++) {
    			map[i][j] = str.charAt(j);
    		}
    	}
    	
    	//0초 : 봄버맨 초기값.
    	//1초 : 1초동안 아무것도 안하므로 time = 2초부터 시작해야한다.
    	
    	//2초 : 폭탄설치되어있지 않은칸에 작업시작.
    	
    	//2초부터 N초까지 작업이 시작된다.
    	for(int time=2; time<=N;time++) {
    		
    		//시간이 짝수라면. 폭탄을 터뜨려야한다.
    		if( time % 2 == 0) {
    			for(int i=0;i<R;i++) {
    				for(int j=0;j<C;j++) {
    					if(map[i][j] == 'O') {
    						q.offer(new Node(i, j));
    					}
    				}
    			}
    			
    			//1초후의 값이 저장됨.
    			for(int i=0;i<R;i++) {
    				for(int j=0;j<C;j++) {
    					map[i][j] = 'O';
    				}
    			}
    			
    		}
    		
    		//시간이 홀수라면. 폭탄이 설치되어있지않은 모든 칸에 폭탄을 설치합니다.
    		if( time%2 == 1) { 			
    			BFS();
    		}
    	}
    	
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
    	
    }
    public static void BFS() {
    	int[] dx = {-1,1,0,0};
    	int[] dy = {0,0,-1,1};
    	while(!q.isEmpty()) {
    		Node temp = q.poll();
    		int x = temp.r;
    		int y = temp.c;
    		map[x][y] = '.';
    		
    		for(int dir=0;dir<4;dir++) {
    			int nx = x + dx[dir];
    			int ny = y + dy[dir];
    			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
    			
    			map[nx][ny] = '.';
    		}
    	}
    }
    
}
 
class Node{
	int r;
	int c;
	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}