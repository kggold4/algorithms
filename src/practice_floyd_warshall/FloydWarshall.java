package practice_floyd_warshall;

public class FloydWarshall {

    static int infinity = Integer.MAX_VALUE;

    // mat.length == math[0].length

    public static void floyd_warshall(boolean[][] mat) {

        // o(n^3)
        for(int k = 0; k < mat.length; k++) {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat.length; j++) {
                    mat[i][j] = mat[i][j] || (mat[i][k] && mat[k][j]);
                }
            }
        }
    }

    public static void floyd_warshall(int[][] mat) {

        // O(n^3)
        for(int k = 0; k < mat.length; k++) {
            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat.length; j++) {
                    if(mat[i][k] != infinity && mat[k][j] != infinity) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }
    }

}
