package algorithms_2.algo_2_exercise2;

import java.util.Arrays;

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
     * @param T  - the boolean matrix
     * @return S - the path matrix
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
     * Problem 3: Constructing a path by Floyd-Warshall algorithm
     * @param T - the boolean matrix
     * @param S - the path matrix
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

//    private static void fixPath(String[][] path, int n) {
//        int size = path.length;
//        for(int i = 0; i < size; i++) {
//            for(int j = 0; j < size; j++) {
//                path[i][j] += "->(" + _01_Bottles_Problem.getI(j, n) + "," + _01_Bottles_Problem.getJ(j, n) + ")";
//            }
//        }
//    }

    /**
     * Problem 4: is connected function of boolean matrix
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
     * Problem 4: is connected function of boolean matrix
     * complexity: O(n)
     * @param mat
     * @return
     */
    public static boolean isConnectedOn(boolean mat[][]) {
        boolean ans = true;
        for(int i = 0; ans && i < mat.length; i++) {
            if(mat[i][0]) ans = false;
        }
        return ans;
    }

    /**
     * Problem 5: Number connected component
     * Complexity: O(n^2)
     * @param mat
     * @return T
     */
    public static int[][] connectComponentsOfGraphBoolN2(boolean[][] mat) {
        int size = mat.length;
        int[][]T = new int[size][size];
        int numComps = 1, count = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(mat[i][j] && T[i][j] == 0){
                    T[i][j] = T[j][i] = numComps;
                }
            }
            if(count > 0) numComps++;
            count = 0;
        }
        return T;
    }

    /**
     * Problem : Number connected component + List connected component
     * in undirected graph (square symmetric matrix)
     * @param mat
     */
    public static void connectComponentsOfGraphBoolean(boolean[][] mat) {
        int size = mat.length;
        int connectComp[] = new int[size];
        int numComponents = 0;

        for(int i = 0; i < mat.length; i++) {
            if(connectComp[i] == 0){
                numComponents++;
                connectComp[i] = numComponents;
            }
            for(int j = i + 1; j < mat.length; j++) {
                // vertex j is not defined yet - the path exists
                if(connectComp[j] == 0 && mat[i][j]) {
                    connectComp[j] = numComponents;
                }
            }
        }
        //list of connected component
        String vs[] = new String[numComponents];
        for(int i = 0; i < numComponents; i++)
            vs[i] = new String();
        for(int i = 0; i < size; i++){
            int index = connectComp[i] - 1;
            vs[index] = vs[index] + i + ",";
        }
        System.out.println(Arrays.toString(connectComp));
        System.out.println("number of components = " + numComponents);
        for (int i = 0; i < numComponents; i++)
            System.out.println("component number " + i + ", vertices: [" + vs[i].substring(0, vs[i].length()-1) + "]");
    }

    /************************************************************************/
    public static boolean[][] initB1(){
        boolean [][] mat = {{true,true,true,false},
                            {true,true,false,true},
                            {true,false,true,true},
                            {false,true,true,true}};

        return mat;
    }

    public static boolean[][] initB2(){
        boolean [][] mat = {{true,false,false,false},
                            {false,true,true,true},
                            {false,true,true,true},
                            {false,true,true,true}};
        return mat;
    }
    public static boolean[][] initB3(){
        boolean [][] mat = {{true,true,false,false},
                            {true,true,false,false},
                            {false,false,true,true},
                            {false,false,true,true}};
        return mat;
    }
    public static boolean[][] initB4(){
        boolean [][] mat = {{true,true,false},
                            {true,true,true},
                            {false,true,true}};
        return mat;
    }
    public static boolean[][] initB5(){
        boolean [][] mat = {{true,true,false,false},
                            {true,true,true,false},
                            {false,true,true,true},
                            {false,false,true,true}};
        return mat;
    }
    public static boolean[][] initB6(){
        boolean [][] mat = {{true,true,false,false,true},
                            {true,true,true,false,false},
                            {false,true,true,true,false},
                            {false,false,true,true,true},
                            {true,false,false,true,true}};
        return mat;
    }
    //        V4
    //        /\
    //       /  \
    //      /____\
    //     V0     V5
    //    V6------V3
    //      |     |
    //	    |_____|
    //     V1     V2
    //
    public static boolean[][] Init01() {
        boolean[][] mat= {{false,false,false,false,true,true,false},
                          {false,false,true,false,false,false,true},
                          {false,true,false,true,false,false,false},
                          {false,false,true,false,false,false,true},
                          {true,false,false,false,false,true,false},
                          {true,false,false,false,true,false,false},
                          {false,true,false,true,false,false,false}};
        return mat;
    }
    public static boolean[][] initBool(){
        boolean [][] mat = {{false,true,false,false,true},
                            {true,false,true,false,false},
                            {false,true,false,true,false},
                            {false,false,true,false,true},
                            {true,false,false,true,false}};
        return mat;
    }

    /**********************************************************/
    public static void printBooleanMatrix(boolean[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void printPath(String[][] pathMat, boolean[][] mat){
        System.out.println();
        for(int i = 0; i < pathMat.length; i++){
            for(int j = 0; j<pathMat[0].length; j++){
                if(!mat[i][j]) System.out.printf("%28s","*, ");
                else System.out.printf("%28s",pathMat[i][j]+"; ");
            }
            System.out.println();
        }
    }
    public static void checkFWBooleanMatrix(){
        System.out.println("\ninitBool ");
        boolean[][]mat = initBool();
        floyd_warshall(mat);
        printBooleanMatrix(mat);
        String [][] path = buildPathMatrix(initBool());
        printPath(path,mat);
        System.out.println("Is the graph connected?  " + isConnected(mat));
    }
    public static void checkComps(){
        boolean[][]mat = initBool();
        connectComponentsOfGraphBoolean(mat);
    }
    public static void main(String[] args) {
        checkFWBooleanMatrix();
        checkComps();
    }
}
