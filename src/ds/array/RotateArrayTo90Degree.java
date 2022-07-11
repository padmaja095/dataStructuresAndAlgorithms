package ds.array;

public class RotateArrayTo90Degree {
    // Q: rotate array to 90 degree.
    // approach: Do transpose and reverse the column values.
    public static void main(String[] args) {
        int N = 3;
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        rotateArrayTo90Degree(N, arr);
    }

    private static void rotateArrayTo90Degree(int n, int[][] arr) {
        // convert to transpose ie., row to columns and columns to rows
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(i, j, arr);
            }
        }
        // reverse each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < Math.floor(n / 2); i++) {
                int temp = arr[n - i - 1][j];
                arr[n - i - 1][j] = arr[i][j];
                arr[i][j] = temp;

            }

        }
        displayMatrix(3, arr);
    }

    private static void swap(int i, int j, int arr[][]) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    static void displayMatrix(int N, int mat[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
