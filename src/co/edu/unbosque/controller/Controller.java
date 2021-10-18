package co.edu.unbosque.controller;

import co.edu.unbosque.model.MatrixMultiplication;
import co.edu.unbosque.view.View;

public class Controller {
	private MatrixMultiplication matrix;
	private View view;

	public Controller() {
		matrix = new MatrixMultiplication();
		view = new View();
		run();

	}

	public void run() {
		String message = "\n————————————————————————————————————————————————\n"
				+ "         BosqueSW - Divide & Conquer\n" + "————————————————————————————————————————————————\n"
				+ "1. Use the multiplication matrix\n" + "2. Finish" + "\n";

		view.showMessage(message);
		int option = Integer.parseInt(view.readData());
		switch (option) {
		case 1:
			String op = "1. Multiply by normal way\n" + "2. Multiply by divide and conquer way\n" + "3. Finish" + "\n";
			view.showMessage(op);
			int opMultiply = Integer.parseInt(view.readData());
			switch (opMultiply) {
			case 1:
				view.showMessage(
						"For this way the columns of the first matrix must be the same as the rows of the second matrix");
				view.showMessage("Write the number of rows of the first matrix");
				int row = Integer.parseInt(view.readData());
				view.showMessage("Write the number of columns of the first matrix");
				int col = Integer.parseInt(view.readData());
				view.showMessage("Write the number of rows of the second matrix");
				int row1 = Integer.parseInt(view.readData());
				view.showMessage("Write the number of columns of the second matrix");
				int col1 = Integer.parseInt(view.readData());
				if (col == row1) {
					int a[][] = new int[row][col];
					int b[][] = new int[row1][col1];
					for (int i = 0; i < row; i++) {
						for (int j = 0; j < col; j++) {
							view.showMessage("\nWrite the values of the first matrix");
							a[i][j] = Integer.parseInt(view.readData());
						}

					}
					view.showMessage("\n--------------" + "\nSecond Matrix" + "\n--------------");
					for (int i = 0; i < row1; i++) {
						for (int j = 0; j < col1; j++) {
							view.showMessage("\nWrite the values of the second matrix");
							b[i][j] = Integer.parseInt(view.readData());
						}

					}
					int c[][] = matrix.multiply(a, b);
					view.showMessage("The multiplication of the matrix is\n");
					for (int x = 0; x < c.length; x++) {
						System.out.print("|");
						for (int y = 0; y < c[x].length; y++) {
							System.out.print(c[x][y]);
							if (y != c[x].length - 1)
								System.out.print("\t");
						}
						System.out.println("|");
					}
				} else {
					view.showMessage("The format to multiply does not worth, please try again");
					run();
				}

				break;
			case 2:
				view.showMessage("For this way the matrixes must be square");
				view.showMessage("Write the size of the matrixes");
				int size = Integer.parseInt(view.readData());
				int a[][] = new int[size][size];
				int b[][] = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						view.showMessage("\nWrite the values of the first matrix");
						a[i][j] = Integer.parseInt(view.readData());
					}
				}
				view.showMessage("\n--------------" + "\nSecond Matrix" + "\n--------------");
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						view.showMessage("\nWrite the values of the second matrix");
						b[i][j] = Integer.parseInt(view.readData());
					}
				}

				int c[][] = matrix.multiplyStrassen(a, b, 0, 0, 0, 0, size);
				view.showMessage("The multiplication of the matrix is\n");
				for (int x = 0; x < c.length; x++) {
					System.out.print("|");
					for (int y = 0; y < c[x].length; y++) {
						System.out.print(c[x][y]);
						if (y != c[x].length - 1)
							System.out.print("\t");
					}
					System.out.println("|");
				}
				break;

			}
			run();
			break;
		case 2:
			view.showMessage("See you soon");
			System.exit(0);
			break;
		default:
			view.showMessage("Invalid option, please try again");
			run();
			break;
		}
	}

}
