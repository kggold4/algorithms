package maraton1;

public class AirPlane {

    /**
     * f(i,j) = the minimum price for the path from (0,0) to (i,j)
     * result = f(n,m)
     *
     * define f function:
     *
     * base case:
     * f(0,0) = 0
     *
     * moving right:
     * f(0,i) = f(0,i-1) + M[0][i-1].x
     *
     * moving up:
     * f(i,0) = f(i-1,0) + M[i-1][0].y
     *
     * general case:
     * f(i,j) = MIN(f(i-1,j) + M[i-1][j].y, f(i,j-1) + M[i][j-1].x)
     *
     */

    public static int minPrice(Node[][] mat) { // O(n * m)
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0;

        for(int i = 1; i < n; i++) mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;
        for(int i = 1; i < m; i++) mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                mat[i][j].price = Math.min(mat[i-1][j].price + mat[i-1][j].y, mat[i][j-1].price + mat[i][j-1].x);
            }
        }
        return mat[n-1][m-1].price;
    }

    public static String minPricePath(Node[][] mat) { // O(n * m)
        int n = mat.length, m = mat[0].length;
        mat[0][0].price = 0;

        for(int i = 1; i < n; i++) mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;
        for(int i = 1; i < m; i++) mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                mat[i][j].price = Math.min(mat[i-1][j].price + mat[i-1][j].y, mat[i][j-1].price + mat[i][j-1].x);
            }
        }
        return path(mat);
    }

    private static String path(Node[][] mat) { // O(n + m)
        int i = mat.length -1, j = mat[0].length - 1;
        String ans = "";
        while (i != 0 && j != 0) {
            if(mat[i-1][j].price + mat[i-1][j].y < mat[i][j-1].price + mat[i][j-1].x) { ans = "1" + ans;i--; }
            else { ans = "0" + ans; j--; }
        }

        while(i != 0) { ans = "1" + ans; i--; }
        while(j != 0) { ans = "0" + ans; j--; }
        return ans;
    }

    public static void main(String[] args) {
        Node[][] mat = {
                { new Node(1, 5), new Node(4, 1), new Node(0, 6) },
                { new Node(4, 7), new Node(2, 8), new Node(0, 3) },
                { new Node(1, 0), new Node(2, 0), new Node(0, 0) }
            };
        System.out.println(minPrice(mat));
        System.out.println(minPricePath(mat));
    }
}
