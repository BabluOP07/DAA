public class _01KnapsackDP {
    public static int knapsackDP(int[] w, int[] v, int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w[i - 1] > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return m[n][W];
    }

    public static void main(String[] args) {
        int w[] = {3, 4, 4, 7};
        int v[] = {2, 4, 2, 8};
        int W = 10;
        int n = w.length;
        System.out.println("Max Profit: " + knapsackDP(w, v, n, W));
    }

}
