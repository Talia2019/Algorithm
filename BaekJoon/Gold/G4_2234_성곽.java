package CJY.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2234 {
    static int n, m, roomSize, roomNum, breakWall;
    static boolean[][] visitedOrigin;
    static boolean[][][] visitedBreak;
    static int[][] map, roomMap;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static HashMap<Integer, Set<Integer>> roomSet;
    static List<Integer> roomSizes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        roomMap = new int[m][n];
        visitedOrigin = new boolean[m][n];
        visitedBreak = new boolean[m][n][2];
        roomSizes = new LinkedList<>();
        roomSet = new HashMap<>();
        roomNum = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedOrigin[i][j]) {
                    roomSize = Math.max(roomSize, bfs(i, j));
                    roomNum++;
                }
//                if (!visitedBreak[i][j][0])
//                    breakWall = Math.max(breakWall, bfsBreakWall(i, j));
            }
        }
        roomNum--;
        for (int i = 1; i <= roomNum; i++) {
            for (int r : roomSet.get(i)) {
                breakWall = Math.max(breakWall, roomSizes.get(i - 1) + roomSizes.get(r - 1));
            }
        }

        System.out.println(roomNum);
        System.out.println(roomSize);
        System.out.println(breakWall);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new int[]{x, y});
        roomMap[x][y] = roomNum;
        visitedOrigin[x][y] = true;
        int room = 0;

        while (queue.size() > 0) {
            int[] cur = queue.poll();
            room++;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;

                if (roomMap[nx][ny] != 0 && roomMap[nx][ny] != roomNum)
                    set.add(roomMap[nx][ny]);

                if ((map[cur[0]][cur[1]] & 1 << i) == 0 && !visitedOrigin[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    roomMap[nx][ny] = roomNum;
                    visitedOrigin[nx][ny] = true;
                }
            }
        }
        roomSet.put(roomNum, set);
        roomSizes.add(room);
        return room;
    }

//    public static int bfsBreakWall(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x, y, 0, 1});
//        visitedBreak[x][y][0] = true;
//        int room = 0;
//
//        System.out.println("시작: " + x + " " + y);
//        while (queue.size() > 0) {
//            int[] cur = queue.poll();
//            room++;
//            System.out.println(cur[0] + ", " + cur[1] + ": " + room);
//            for (int i = 0; i < 4; i++) {
//                int nx = cur[0] + dir[i][0];
//                int ny = cur[1] + dir[i][1];
//                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
//                    continue;
////                System.out.println(nx + " " + ny + " " + cur[2] + " : " + cur[3]);
//                if ((map[cur[0]][cur[1]] & 1 << i) == 0) { //벽이아님
//                    if (!visitedBreak[nx][ny][cur[2]]) {
//                        queue.add(new int[]{nx, ny, cur[2], cur[3] + 1});
//                        visitedBreak[nx][ny][cur[2]] = true;
//                    }
//                } else if ((map[cur[0]][cur[1]] & 1 << i) != 0) { //벽임
//                    if (cur[2] == 0 && !visitedBreak[nx][ny][1]) {
//                        queue.add(new int[]{nx, ny, 1, cur[3] + 1});
//                        visitedBreak[nx][ny][1] = true;
//                    }
//                }
//            }
//        }
//
//        return room;
//    }
}
