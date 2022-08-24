package ds.array;

import javax.sound.sampled.LineEvent;
import javax.swing.colorchooser.ColorSelectionModel;

/*  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.*/
public class GameOfLife {
    public static void main(String args[])
    {

        GameOfLife gameoflife= new GameOfLife();
        int arr[][] = {
            { 0, 1, 0 },
            { 0, 0, 1 },
            { 1, 1, 1 },
            { 0, 0, 0 }
    };
        //int [][]output=gameoflife.solvedGameOfLifeApproach1(arr);
        printArray(gameoflife.solvedGameOfLifeApproach2(arr));

    }

    private int[][] solvedGameOfLifeApproach2(int[][] arr) {

        int neighbours[][]={{0,1},{1,0},{1,1},{-1,-1},{0,-1},{-1,0},{-1,1},{1,-1}};
        int rows=arr.length;
        int cols=arr[0].length;
        printArray(arr);
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int liveNeighbour=0;
                for(int neighbour=0;neighbour<neighbours.length;neighbour++)
                { 
                    int r=(neighbours[neighbour][0])+i;
                    int c=(neighbours[neighbour][1])+j;
                    if(r>-1 && r<rows && c>-1 && c<cols && (arr[r][c]==1 || arr[r][c]==-1))
                    {
                        liveNeighbour+=1;
                    }
                }
                if((arr[i][j]==1 || arr[i][j]==-1) &&  (liveNeighbour <2 || liveNeighbour>3 ))
                {
                    arr[i][j]=-1;
                }
                  if((arr[i][j]==0 || arr[i][j]==2) && liveNeighbour==3 )
                {
                    arr[i][j]=2;
                }
            }
        }

        for (int i = 0; i < arr.length; i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
               if(arr[i][j]==-1)
               {
                arr[i][j]=0;
               }
               else if (arr[i][j]==2)
               {
                arr[i][j]=1;
               }
            }
        } 

        return arr;
    }

    private int[][] solvedGameOfLifeApproach1(int[][] arr) {
        int[][] copy_of_input= new int[arr.length][];
        for (int r = 0; r < arr.length; r++) {
            copy_of_input[r] = arr[r].clone();
        }
        int neighbours[][]={{0,1},{1,0},{1,1},{-1,-1},{0,-1},{-1,0},{-1,1},{1,-1}};
        int rows=arr.length;
        int cols=arr[0].length;
        printArray(copy_of_input);
        for(int i=0;i<rows;i++)
        {
            System.out.println("i"+i);
            for(int j=0;j<cols;j++)
            {
                System.out.println("j"+j);
                int liveNeighbour=0;
                for(int neighbour=0;neighbour<neighbours.length;neighbour++)
                { 
                    int r=(neighbours[neighbour][0])+i;
                    int c=(neighbours[neighbour][1])+j;
                    if(r>-1 && r<rows && c>-1 && c<cols && arr[r][c]==1)
                    {
                        liveNeighbour+=1;
                    }
                }
                System.out.println("liveneigh :"+liveNeighbour);
                if(arr[i][j]==1 &&  (liveNeighbour <2 || liveNeighbour>3 ))
                {
                    copy_of_input[i][j]=0;
                }
                 else if(arr[i][j]==0 && liveNeighbour==3 )
                {
                    copy_of_input[i][j]=1;
                }
            }
        }
        return copy_of_input;
    }
    static void printArray(int[][] input) {
        int rows=input.length;
        int cols=input[0].length;
        System.out.println("Output array: ");
        for (int i = 0; i < rows; i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        } 

    }
}
