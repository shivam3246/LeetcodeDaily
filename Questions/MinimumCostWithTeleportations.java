package Questions;

//https://leetcode.com/problems/minimum-cost-path-with-teleportations/description/
import java.util.*;

public class MinimumCostWithTeleportations {

    static class State {
        int r, c, t;
        long cost;

        State(int r, int c, int t, long cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public static long minCost(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        long INF = (long) 1e18;

        // dist[r][c][t] = minimum cost to reach (r,c) using t teleports
        long[][][] dist = new long[n][m][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dist[i][j], INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.cost > dist[cur.r][cur.c][cur.t]) continue;

            // Destination reached
            if (cur.r == n - 1 && cur.c == m - 1) {
                return cur.cost;
            }

            // Move Down
            if (cur.r + 1 < n) {
                long nextCost = cur.cost + grid[cur.r + 1][cur.c];
                if (nextCost < dist[cur.r + 1][cur.c][cur.t]) {
                    dist[cur.r + 1][cur.c][cur.t] = nextCost;
                    pq.offer(new State(cur.r + 1, cur.c, cur.t, nextCost));
                }
            }

            // Move Right
            if (cur.c + 1 < m) {
                long nextCost = cur.cost + grid[cur.r][cur.c + 1];
                if (nextCost < dist[cur.r][cur.c + 1][cur.t]) {
                    dist[cur.r][cur.c + 1][cur.t] = nextCost;
                    pq.offer(new State(cur.r, cur.c + 1, cur.t, nextCost));
                }
            }

            // Teleport
            if (cur.t < k) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] <= grid[cur.r][cur.c]) {
                            if (cur.cost < dist[i][j][cur.t + 1]) {
                                dist[i][j][cur.t + 1] = cur.cost;
                                pq.offer(new State(i, j, cur.t + 1, cur.cost));
                            }
                        }
                    }
                }
            }
        }

        return -1; // unreachable
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 3},
                {2, 5, 4},
                {4, 3, 5}
        };
        int k = 2;
        System.out.println(minCost(grid, k)); // Expected output: 6
    }
}
