import java.io.*;
import java.util.*;
public class Main {
	static int[] dice;
	static int[] dy = {1, 0, 0, -1};	//남,동,서,북 y값 변경
	static int[] dx = {0, 1, -1, 0};	//남,동,서,북 x값 변경
	static int row, col;	//첫 아랫면이 되는 row값과 col값
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	//입력값 처리하는 BufferedReader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        	//결과값 출력하는 BufferedWriter
		StringTokenizer st;
        	//1.
		for(int i=0;i<3;i++) {
			int[][] arr = new int[6][6];
			boolean[][] visited = new boolean[6][6];
			dice = new int[7];
			for(int j=0;j<6;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int s=0;s<6;s++) {
					arr[j][s] = Integer.parseInt(st.nextToken());
				}
			}
			startPoint(arr);	//2.
			cubeMake(arr, visited, row, col);	//3.
			if(cubeCheck())		//4.
				bw.write("yes\n");
			else
				bw.write("no\n");
		}
		bw.flush();		//결과 출력
		bw.close();
		br.close();
	}
    	//종이를 접는 함수
	static void cubeMake(int[][] arr, boolean[][] visited, int row, int col) {
		int[] temp = new int[7];
		dice[1] = 1;		//아랫면 확인
		visited[row][col] = true;	//방문 확인
		for(int i=0;i<4;i++) {
			int tempRow = row + dy[i];
			int tempCol = col + dx[i];
			if(tempRow>=0 && tempCol>=0 && tempRow<6 && tempCol<6 && !visited[tempRow][tempCol]) {
				if(arr[tempRow][tempCol]==1) {
					cubeChange(i, temp);	//정육면체 회전
					cubeMake(arr, visited,tempRow,tempCol);	//종이 접기
					cubeReverse(i, temp);	//정육면체 되돌리기
				}
			}
		}

	}
    	//정육면체 회전 되돌아오기 함수
	static void cubeReverse(int direction, int[] temp) {
		cubeChange(3-direction, temp);
	}
    	//정육면체 회전 함수
	static void cubeChange(int direction, int[] temp) {
		if(direction == 0)		//남쪽
			down(temp);
		else if(direction == 1)	//동쪽
			right(temp);
		else if(direction == 2)	//서쪽
			left(temp);
		else		//북쪽
			up(temp);
		
		tempToDice(temp);	
	}
    	//정육면체 회전된 값 적용 함수
	static void tempToDice(int[] temp) {
		for(int i=1;i<7;i++) 
			dice[i] = temp[i];
	}
    	//종이의 첫 지점을 아랫면으로 설정하는 함수
	static void startPoint(int[][] arr) {
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(arr[i][j] == 1) {
					row = i;
					col = j;
					return;
				}
			}
		}
	}
    	//정육면체가 되었는지 확인하는 함수
	static boolean cubeCheck() {
		for(int i=1;i<7;i++) {
			if(dice[i]==0)
				return false;
		}
		return true;
	}
    	//주사위가 아랫면 기준 남쪽방향으로 굴러갈 때 정육면체 변화
	static void down(int[] temp) {
		temp[4] = dice[1];
		temp[1] = dice[2];
		temp[2] = dice[3];
		temp[3] = dice[4];
		temp[5] = dice[5];
		temp[6] = dice[6];
	}
    	//주사위가 아랫면 기준 동쪽방향으로 굴러갈 때 정육면체 변화
	static void right(int[] temp) {
		temp[5] = dice[1];
		temp[2] = dice[2];
		temp[6] = dice[3];
		temp[4] = dice[4];
		temp[3] = dice[5];
		temp[1] = dice[6];
	}
    	//주사위가 아랫면 기준 서쪽방향으로 굴러갈 때 정육면체 변화
	static void left(int[] temp) {
		temp[6] = dice[1];
		temp[2] = dice[2];
		temp[5] = dice[3];
		temp[4] = dice[4];
		temp[1] = dice[5];
		temp[3] = dice[6];
	}
    	//주사위가 아랫면 기준 북쪽방향으로 굴러갈 때 정육면체 변화
	static void up(int[] temp) {
		temp[2] = dice[1];
		temp[3] = dice[2];
		temp[4] = dice[3];
		temp[1] = dice[4];
		temp[5] = dice[5];
		temp[6] = dice[6];
	}
}