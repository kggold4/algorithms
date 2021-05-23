//package algorithms_2.practice_graph_boolean_matrix;
//
//import java.util.Arrays;
//
//public class GraphBooleanMatrix implements boolean_graph_matrix {
//
//    private boolean[][] mat;
//    private int size;
//
//    /**
//     * constructor
//     * @param n
//     */
//    GraphBooleanMatrix(int n) {
//        this.size = n;
//        this.mat = new boolean[this.size][this.size];
//    }
//
//    /**
//     * copy constructor
//     * @param oldMatrix
//     */
//    GraphBooleanMatrix(boolean[][] oldMatrix) {
//        this.size = oldMatrix.length;
//        this.mat = new boolean[this.size][this.size];
//        for(int i = 0; i < this.size; i++) {
//            for(int j = 0; j < this.size; j++) {
//                this.mat[i][j] = oldMatrix[i][j];
//            }
//        }
//    }
//
//    public boolean[][] copy() { return new boolean[0][0]; }
//    public void connect(int i, int j) {}
//    public void disconnect(int i, int j) {}
//    public boolean isConnected(int i, int j) { return false; }
//    public void floyd_warshall() {}
//    public String[][] path_matrix() { return new String[0][0]; }
//    public int size() { return 0; }
//    public void clear() {}
//
//    /**
//     * making the main diagonal be false value
//     */
//    private void diagonal_default() {
//        for(int i = 0; i < this.size; i++) this.mat[i][i] = false;
//    }
//
//    /**
//     * to string method
//     * @return
//     */
//    @Override
//    public String toString() { return toString(this.mat); }
//
//    /**
//     * static function to get the print string of a given matrix
//     * @param mat
//     * @return
//     */
//    public static String toString(boolean[][] mat) {
//        String ans = "\t";
//        for(int i = 0; i < mat.length; i++) ans += i + "  ";
//        ans += "\n";
//        for(int i = 0; i < mat.length; i++) {
//            ans += + i + "  [";
//            for(int j = 0; j < mat[0].length; j++) {
//                if(mat[i][j]) ans += "T";
//                else ans += "F";
//                if(j != mat[0].length - 1) ans += ", ";
//            }
//            ans += "]\n";
//        }
//        return ans;
//    }
//
//    /**
//     * static function to get the print string of a given matrix
//     * @param mat
//     * @return
//     */
//    public static String toString(String[][] mat) {
//        String ans = "";
//        for(int i = 0; i < mat.length; i++) {
//            ans += Arrays.toString(mat[i]) + "\n";
//        }
//        return ans;
//    }
//}
