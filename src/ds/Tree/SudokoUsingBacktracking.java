package ds.Tree;

public class SudokoUsingBacktracking {
    
    public static void main(String args[])
    {
        int board[][]= new int[][]{
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int length=board.length;
        if(solveSudoko(board,length))
        {
            printSudoko(board,length);
        }
        else{
            System.out.println("No solution");
        }    
    }
    private static boolean solveSudoko(int[][] board, int length) {
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<length;j++)
            {
                if(board[i][j]==0)
                {
                    for(int setValue=1;setValue<=9;setValue++)
                    {
                        if(isValidSet(setValue,board,i,j))
                        {
                            board[i][j]=setValue;
                            if(solveSudoko(board, length))
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValidSet(int setValue, int[][] board, int row, int col) {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==setValue)
            {
                return false;
            }if(board[i][col]==setValue)
            {
                return false;
            }if(board[3*(row/3)+i/3][3*(col/3)+i%3]==setValue)
            {
                return false;
            }
        }
        return true;
    }
    private static void printSudoko(int[][] board, int length) {
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }    
}
