package maraton1;

import java.util.Arrays;

// LCS = Longest Common Subsequence
public class LCS {

    /**
     * complexity: O(n*m), n = s1.length, m = s2.length
     *
     * dynamic function:
     * f(i,j) = LCS(s1, s2).length when s1 is limited to index i
     *                              and s2 is limited to index j
     * 0 <= i <= n, 0 <= j <= m
     *
     * recursive definition of the dynamic function
     * f(0,j) = f(i,0) = 0
     * f(i,j) = 1 + f(i-1, j-1) if s1[i] == s2[j]
     * f(i,j) = 1 + f(i-1, j-1) if s1[i] == s2[j]
     * f(i,j) = MAX(f(i, j-1), f(i-1, j)) if s1[i] != s2[j]
     *
     * @param s1
     * @param s2
     * @return LCS size between s1 and s2
     */
    public static int dynamicLCS_size(String s1, String s2) {

        // s1 and s2 lengths
        int n = s1.length(), m = s2.length();

        // build the matrix
        int[][] f = new int[n+1][m+1];

        // left column and top row are zeros
        for(int i = 0; i < n+1; i++) f[i][0] = 0;
        for(int j = 0; j < m+1; j++) f[0][j] = 0;

        // build the rest of the matrix
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) f[i][j] = 1 + f[i-1][j-1];
                else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
            }
        }

        // size of the LCS
        return f[n][m];
    }

    /**
     * O(n*m) + O(n+m) = O(nm)
     * @param s1
     * @param s2
     * @return LCS between s1 and s2
     */
    public static String dynamicLCS(String s1, String s2) {

        // s1 and s2 lengths
        int n = s1.length(), m = s2.length();

        // build the matrix
        int[][] f = new int[n+1][m+1];

        // left column and top row are zeros
        for(int i = 0; i < n+1; i++) f[i][0] = 0;
        for(int j = 0; j < m+1; j++) f[0][j] = 0;

        // build the rest of the matrix
        for(int i = 1; i < n+1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) f[i][j] = 1 + f[i - 1][j - 1];
                else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }

        // f[n][m] is the size of the LCS

        // build back the LCS
        int i = n, j = m;
        String ans = "";

        // going backward on the matrix - O(n+m)
        while(f[i][j] != 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                ans = s1.charAt(i-1) + ans;
                i--;
                j--;
            } else {
                if(f[i][j-1] > f[i-1][j]) j--;
                else i--;
            }
        }
        return ans;
    }


    /**
     * base case:
     * f(0,j,k) = f(i,0,k) = f(i,j,0) = 0
     * f(i,j,k) = 1 + f(i-1,j-1,k-1), if s1[i] == s2[j] == s3[k]
     *
     * f(i,j,k) = max(f(i-1,j,k), f(i,j-1,k), f(i,j,k-1))
     *
     * complexity = O(n*m*l)
     * n = s1.length
     * m = s2.length
     * l = s3.length
     * @param s1
     * @param s2
     * @param s3
     */
    public static void dynamicLCS3(String s1, String s2, String s3) {

    }

    /**
     * main function
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "eafddbac";
        System.out.println(dynamicLCS(s1, s2)); // output: "abc"
        System.out.println(dynamicLCS_size(s1, s2)); // output: 3
    }
}
