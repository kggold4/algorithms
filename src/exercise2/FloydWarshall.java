package exercise2;

public class FloydWarshall {

    /**
     * Problem 1: Floyd-Warshall algorithm
     * Build transitive closure of a graph
     * @param T - the boolean matrix
     */
    public static void floyd_warshall(boolean[][] T) {
        int size = T.length;
        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    T[i][j] = (T[i][k] && T[k][j]) || T[i][k];
                }
            }
        }
    }

    /**
     * Problem 2: Constructing a path by Floyd-Warshall algorithm
     * @param T   - the boolean matrix
     * @return S  - the path matrix
     */
    public static String[][] buildPathMatrix(boolean[][] T) {
        int size = T.length;

        // path matrix
        String[][] S = new String[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(T[i][j]) S[i][j] = " " + i + "->" + j + " ";
                else S[i][j] = "";
            }
        }

        // path matrix building
        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(!T[i][j] && (T[i][k] && T[k][j])) {
                        S[i][j] = S[i][k] + S[k][j];
                    }
                    T[i][j] = T[i][j] || (T[i][k] && T[k][j]);
                }
            }
        }
        return S;
    }

    /**
     * Problem 3:
     * @param T
     * @param S
     */
    public static void floyd_warshall(boolean[][] T, String[][] S) {
        int size = T.length;
        for(int k = 0; k < size; k++) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(!T[i][j] && (T[i][k] && T[k][j]))
                        S[i][j] = S[i][k] + "->" + S[k][j];
                    T[i][j] = (T[i][k] && T[k][j]) || T[i][j];
                }
            }
        }
    }

    private static void fixPath(String[][] path, int n) {
        int size = path.length;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                path[i][j] += "->(" + _01_Bottles_Problem.getI(j, n) + "," + _01_Bottles_Problem.getJ(j, n) + ")";
            }
        }
    }

    /**
     * is connected function of boolean matrix
     * complexity: O(n^2)
     * @param mat
     * @return
     */
    public static boolean isConnected(boolean mat[][]) {
        boolean ans = true;
        for(int i = 0; ans && i < mat.length; i++) {
            for(int j = 0; ans && j < mat.length; j++) {
                if(!mat[i][j]) ans = false;
            }
        }
        return ans;
    }

    /**
     * is connected function of boolean matrix
     * complexity: O(n)
     * @param mat
     * @return
     */
    public static boolean isConnectedOn(boolean mat[][]) {
        boolean ans = true;
        for(int i = 0; ans && i < mat.length; i++) {
            if(mat[i][0]) ans = false;
        }
        return false;
    }



}
