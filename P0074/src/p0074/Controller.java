
package p0074;

import java.util.Scanner;


public class Controller {
    private final Scanner sc = new Scanner(System.in);
    private final Model model = new Model();
    private final View view = new View();

    public int getIntInput(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Only permits integer in range " + min + " to " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }
    }
    
    public int[][] getMatrix(int position) {
        int rows = getIntInput("Enter row matrix " + position + " : ", 1, Integer.MAX_VALUE);
        int cols = getIntInput("Enter column matrix " + position + " : ", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getIntInput("The Matrix" + position + " [" + (i+1) + "][" + (j+1) + "] = ", 
                                           Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    public void processUserChoice() {
        while (true) {
            view.menu();
            int choice = getIntInput("Enter your choice: ", 1, 4);
            if (choice == 4) {
                System.out.println("Program Terminated.");
                break;
            }

            int[][] mat1 = getMatrix(1);
            int[][] mat2 = getMatrix(2);

            if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
                view.displayErrorMessage("Matrices must have the same dimensions for addition and subtraction.");
                continue;
            }

            int[][] result;
            String operation;

            switch (choice) {
                case 1:
                    result = model.addMatrices(mat1, mat2);
                    operation = "+";
                    break;
                case 2:
                    result = model.subtractMatrices(mat1, mat2);
                    operation = "-";
                    break;
                case 3:
                    if (mat1[0].length != mat2.length) {
                        view.displayErrorMessage("Number of columns in first matrix must equal number of rows in second matrix for multiplication.");
                        continue;
                    }
                    result = model.multiplyMatrices(mat1, mat2);
                    operation = "*";
                    break;
                default:
                    continue;
            }
            view.displayResult(mat1, mat2, result, operation);
        }
    }
}
