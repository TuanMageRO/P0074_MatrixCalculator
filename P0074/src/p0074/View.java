 
package p0074;


public class View {
    

    public void menu() {
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print("[" + cell + "]");
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] mat1, int[][] mat2, int[][] result, String operation) {
        System.out.println("-------RESULT-------");
        displayMatrix(mat1);
        System.out.println(operation);
        displayMatrix(mat2);
        System.out.println("=");
        displayMatrix(result);
        System.out.println();
    }

    public void displayErrorMessage(String message) {
        System.err.println(message);
    }  
}
