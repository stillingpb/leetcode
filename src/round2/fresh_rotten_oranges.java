package round2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a matrix of dimensions m*n where each cell in the matrix can
 * have values 0,1 or 2 which has the following meaning :
 * 0:empty cell
 * 1:cells have fresh oranges
 * 2:cells have rotten oranges
 * So we have to determine what is the minimum time required so that all the oranges
 * will be rotten.A rotten orange at index [i,j] can rot other fresh orange at
 * indexes [i+1,j] ,[i,j+1] ,[i-1,j] ,[i,j-1]. If it is impossible to rot every
 * orange then simply return -1.
 */
public class fresh_rotten_oranges {
    int solve(int[][] m) {
        int rawLen = m.length;
        int colLen = m[0].length;
        int FLAG = -1, time = 0;
        Queue<Integer> rottenRawPos = new LinkedList<>();
        Queue<Integer> rottenColPos = new LinkedList<>();
        int freshOrangeCount = 0;
        for (int i = 0; i < rawLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (m[i][j] == 1) {
                    freshOrangeCount++;
                } else if (m[i][j] == 2) {
                    rottenRawPos.offer(i);
                    rottenColPos.offer(j);
                }
            }
        }
        rottenRawPos.offer(FLAG);
        rottenColPos.offer(FLAG);
        while (freshOrangeCount > 0 && !rottenColPos.isEmpty()) {
            int rawPos = rottenColPos.poll();
            int colPos = rottenColPos.poll();
            if (rawPos == -1) {
                time++;
                rottenRawPos.offer(FLAG);
                rottenColPos.offer(FLAG);
            } else {
                if (rawPos - 1 >= 0 && m[rawPos - 1][colPos] == 1) {
                    freshOrangeCount--;
                    rottenOrange(m, rawPos - 1, colPos, rottenRawPos, rottenColPos);
                }
                if (rawPos + 1 < rawLen && m[rawPos + 1][colPos] == 1) {
                    freshOrangeCount--;
                    rottenOrange(m, rawPos + 1, colPos, rottenRawPos, rottenColPos);
                }
                if (colPos - 1 >= 0 && m[rawPos][colPos - 1] == 1) {
                    freshOrangeCount--;
                    rottenOrange(m, rawPos, colPos - 1, rottenRawPos, rottenColPos);
                }
                if (colPos + 1 < colLen && m[rawPos][colPos + 1] == 1) {
                    freshOrangeCount--;
                    rottenOrange(m, rawPos, colPos + 1, rottenRawPos, rottenColPos);
                }
            }
        }
        if (freshOrangeCount == 0) {
            return time;
        } else {
            return -1;
        }
    }

    private void rottenOrange(int[][] m, int rawPos, int colPos,
                              Queue<Integer> rottenRawPos, Queue<Integer> rottenColPos) {
        m[rawPos][colPos] = 2;
        rottenRawPos.offer(rawPos);
        rottenColPos.offer(colPos);
    }
}
