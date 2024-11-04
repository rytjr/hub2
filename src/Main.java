import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int M, N, K;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            cnt = 0;

            for(int i=0;i<K;i++) { //배추 위치 넣어줌
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j]==1&&!visited[i][j]) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            result.append(cnt+"\n");
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >=0&&ny>=0&&nx<M&&ny<N&&!visited[nx][ny]&&map[nx][ny]==1) {
                dfs(nx,ny);
            }
        }
    }
}