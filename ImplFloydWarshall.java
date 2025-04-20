public class ImplFloydWarshall {
        private static final int N = 4;
        private static final int Infinity = 9999;

        public static void printShortestPaths(int[][] distances) {
            System.out.println("The following table shows the shortest distances between every pair of vertices:");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distances[i][j] == Integer.MAX_VALUE) {
                        System.out.print("∞\t");
                    } else {
                        System.out.print(distances[i][j] + "\t");
                    }
                }
                System.out.println();
            }
        }

        //Floyd-Warshall algorithm
        public static void floydWarshall(int[][] graph) {
            int[][] distances = new int[N][N];

            // Initialize distances matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && graph[i][j] == Integer.MAX_VALUE) {
                        // If there is no direct edge, set distance to infinity
                        distances[i][j] = Integer.MAX_VALUE;
                    } else {
                        distances[i][j] = graph[i][j];
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        distances[i][j] = Math.min(distances[i][j],
                                distances[i][k] + distances[k][j]);
                    }
                }
            }
            // Print the shortest paths matrix
            printShortestPaths(distances);
        }

        public static void main(String[] args) {
            int[][] graph = { {0, 3, Infinity, 7},
                    {8, 0, 2, Infinity},
                    {5, Infinity, 0, 1},
                    {2, Infinity, Infinity, 0} };

            floydWarshall(graph);
        }
    }

