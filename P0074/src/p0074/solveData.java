
package p0074;

import java.util.Scanner;

public class solveData {
    private final int minInt = Integer.MIN_VALUE;
    private final int maxInt = Integer.MAX_VALUE;
    private final Scanner sc = new Scanner(System.in);
    private final String GUI_RES = "-------RESULT-------";
    
    public int checkInteger(String mess, int min, int max) {
        int n;
        String err = "Only permits integer in range " + min + " to " + max;
        while(true) {
            try{
                System.out.print(mess);
                n = Integer.parseInt(sc.nextLine());
                if(n < min || n > max) {
                    System.err.println(err);
                    continue;
                }
                return n;
            }
            catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }
    
    public int[][] getMatrix(int position) {
        int row = checkInteger("Enter row matrix "+ position +" : ", 0, maxInt);
        int column = checkInteger("Enter column matrix " + position +" : ", 0, maxInt);
        int r;
        int c;
        int[][] matrix = new int[row][column];
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                r = i+1;
                c = j+1;
                matrix[i][j] = checkInteger("The Matrix" + position +
                        " [" + r + "]" + "[" + c + "] = " ,minInt, maxInt );
            }
        }
        return matrix;
    }
    
    public void displayMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; j++) {
                System.out.print("[" + mat[i][j] + "]");
            }
            System.out.println("");
        }
    }
    
    public void matrixAddition (int[][] mat1, int[][] mat2){
        
        int row1 = mat1.length;
        int column1 = mat1[0].length;
        int row2 = mat2.length;
        int column2 = mat2[0].length;
        
        if(row1 != row2 && column1 != column2) {
            System.err.println("Can not add 2 matrices with different dimension!");
            return;
        }
        
        System.out.println(GUI_RES);
        displayMatrix(mat1);
        System.out.println("+");
        displayMatrix(mat2);
        System.out.println("=");
        
        for(int i = 0; i < row1; ++i) {
            for( int j = 0; j < column1; ++j) {
                int result = mat1[i][j] + mat2[i][j];
                System.out.print("[" + result + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void matrixSubtraction (int[][] mat1, int[][] mat2) {       
        
        int row1 = mat1.length;
        int column1 = mat1[0].length;
        int row2 = mat2.length;
        int column2 = mat2[0].length;
        
        if(row1 != row2 && column1 != column2) {
            System.err.println("Can not subtract 2 matrices with different dimension!");
            return;
        }
        
        System.out.println(GUI_RES);
        displayMatrix(mat1);
        System.out.println("-");
        displayMatrix(mat2);
        System.out.println("=");
        
        for(int i = 0; i < row1; ++i) {
            for( int j = 0; j < column1; ++j) {
                int result = mat1[i][j] - mat2[i][j];
                System.out.print("[" + result + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void matrixMultiplication (int[][] mat1, int[][] mat2) {
        int row1 = mat1.length;
        int column1 = mat1[0].length;
        int row2 = mat2.length;
        int column2 = mat2[0].length;
        
        if(row2 != column1) {
            System.err.println("Can not multiply!");
            return;
        }
        
        System.out.println(GUI_RES);
        displayMatrix(mat1);
        System.out.println("*");
        displayMatrix(mat2);
        System.out.println("=");
        
        int[][] Matrix = new int[row1][column2];
        
        for (int i = 0; i < row1; ++i) {
            for (int j = 0; j < column2; ++j) {
                for (int k = 0; k < column1; ++k) {
                    Matrix[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        
        displayMatrix(Matrix);
        System.out.println("");
    }
    
    public void menu(){
        int[][] mat1;
        int[][] mat2;
         while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = checkInteger("Enter your choice: ",1, 4);
            switch (choice) {
                case 1 -> {
                    System.out.println("-------Addition-------");
                    mat1 = getMatrix(1);
                    mat2 = getMatrix(2);
                    matrixAddition(mat1, mat2);
                }
                case 2 -> {
                    System.out.println("-------Subtraction-------");
                    mat1 = getMatrix(1);
                    mat2 = getMatrix(2);
                    matrixSubtraction(mat1, mat2);
                }
                case 3 -> {
                    System.out.println("-------Multiplication-------");
                    mat1 = getMatrix(1);
                    mat2 = getMatrix(2);
                    matrixMultiplication(mat1, mat2);
                }
                case 4 -> {
                    return;
                }
            }
        }
    }
}
