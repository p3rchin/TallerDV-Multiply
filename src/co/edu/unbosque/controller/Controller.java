/**
 * Package containing the class
 */
package co.edu.unbosque.controller;
import co.edu.unbosque.model.MatrixMultiplication;
import co.edu.unbosque.view.View;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class Controller {
	
	/**
	 * matrix is the instance of MatrixMultiplication.
	 */
	private MatrixMultiplication matrix;
	/**
	 * view is the instance of View.
	 */
	private View view;

	/**
	 * This constructor define the instances.
	 * <b>pre</b>Must exist declarations of the instances.<br>
	 * <b>post</b>The instances of a class.<br>
	 */
	public Controller() {
		matrix = new MatrixMultiplication();
		view = new View();
		run();

	}

	/**
	 * This method verifies that the received String only has numbers. <b>pre</b>The
	 * parameter String must be a number.<br>
	 * <b>post</b> If the method complete correctly is because the String had a
	 * number. In other case the method return a false.<br>
	 * 
	 * @param pNumber is the String number: pNumber need to be != null and != " ".
	 * @return is the boolean value that is returned of the method.
	 */

	public boolean onlyNumbers(String pNumber) {
		for (int i = 0; i < pNumber.length(); i++) {
			char aux = pNumber.charAt(i);
			int digit = aux - '0';
			if (digit > 9 || digit < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method is the execution of the program.
	 * <b>pre</b>The instances in the constructor must be exist.<br>
	 * <b>post</b>The program should show results.<br>
	 */
	public void run() {
		String message = "\n————————————————————————————————————————————————\n"
				+ "         BosqueSW - Divide & Conquer\n" + "————————————————————————————————————————————————\n"
				+ "1. Use the multiplication matrix\n" + "2. Finish" + "\n";

		view.showMessage(message);
		String option = view.readData();
		switch (option) {
		case "1":
			String op = "1. Multiply by normal way\n" + "2. Multiply by divide and conquer way\n" + "3. Finish" + "\n";
			view.showMessage(op);
			String opMultiply = view.readData();
			switch (opMultiply) {
			case "1":
				view.showMessage(
						"For this way the columns of the first matrix must be the same as the rows of the second matrix");
				view.showMessage("Write the number of rows of the first matrix");
				String s1 = view.readData();
				while (!onlyNumbers(s1) || s1.equals("")) {
					view.showMessage("Error. Rewrite the number of rows of the first matrix");
					s1 = view.readData();
				}
				int row = Integer.parseInt(s1);

				view.showMessage("Write the number of columns of the first matrix");
				String s2 = view.readData();
				while (!onlyNumbers(s2) || s2.equals("")) {
					view.showMessage("Error. Rewrite the number of columns of the first matrix");
					s2 = view.readData();
				}
				int col = Integer.parseInt(s2);
				view.showMessage("Write the number of rows of the second matrix");
				String s3 = view.readData();
				while (!onlyNumbers(s3) || s3.equals("")) {
					view.showMessage("Error. Rewrite the number of rows of the second matrix");
					s3 = view.readData();
				}
				int row1 = Integer.parseInt(s3);
				view.showMessage("Write the number of columns of the second matrix");
				String s4 = view.readData();
				while (!onlyNumbers(s4) || s4.equals("")) {
					view.showMessage("Error. Rewrite the number of columns of the second matrix");
					s4 = view.readData();
				}
				int col1 = Integer.parseInt(s4);
				if (col == row1) {
					int a[][] = new int[row][col];
					int b[][] = new int[row1][col1];
					for (int i = 0; i < row; i++) {
						for (int j = 0; j < col; j++) {
							view.showMessage("\nWrite the values of the first matrix");
							String s5 = view.readData();
							while (!onlyNumbers(s5) || s5.equals("")) {
								view.showMessage("Error. Rewrite the values of the first matrix");
								s5 = view.readData();
							}
							a[i][j] = Integer.parseInt(s5);
						}

					}
					view.showMessage("\n--------------" + "\nSecond Matrix" + "\n--------------");
					for (int i = 0; i < row1; i++) {
						for (int j = 0; j < col1; j++) {
							view.showMessage("\nWrite the values of the second matrix");
							String s6 = view.readData();
							while (!onlyNumbers(s6) || s6.equals("")) {
								view.showMessage("Error. Rewrite the values of the first matrix");
								s6 = view.readData();
							}
							b[i][j] = Integer.parseInt(s6);
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
			case "2":
				view.showMessage("For this way the matrixes must be square");
				view.showMessage("Write the size of the matrixes");
				String s7 = view.readData();
				while (!onlyNumbers(s7) || s7.equals("")) {
					view.showMessage("Error. Rewrite the size of the matrixes");
					s7 = view.readData();
				}
				int size = Integer.parseInt(s7);
				int a[][] = new int[size][size];
				int b[][] = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						view.showMessage("\nWrite the values of the first matrix");
						String s8 = view.readData();
						while (!onlyNumbers(s8) || s8.equals("")) {
							view.showMessage("Error. Rewrite the values of the first matrix");
							s8 = view.readData();
						}
						a[i][j] = Integer.parseInt(s8);
					}
				}
				view.showMessage("\n--------------" + "\nSecond Matrix" + "\n--------------");
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						view.showMessage("\nWrite the values of the second matrix");
						String s9 = view.readData();
						while (!onlyNumbers(s9) || s9.equals("")) {
							view.showMessage("Error. Rewrite the values of the second matrix");
							s9 = view.readData();
						}
						b[i][j] = Integer.parseInt(s9);
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
			default:
				view.showMessage("Invalid option, please try again");
				run();
				break;

			}
			run();
			break;
		case "2":
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
