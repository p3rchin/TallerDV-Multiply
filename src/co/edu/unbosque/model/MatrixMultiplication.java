/**
 * Package containing the class
 */
package co.edu.unbosque.model;


/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class MatrixMultiplication {
	
	
	/**
	 * This method multiply each row by each column.
	 * <b>pre</b>The first matrix must have the columns equal two the rows of the second one.<br>
	 * <b>post</b>The multiplication would be done.<br>
	 * @param a is a matrix. a must be != " " and != null.
	 * @param b is a matrix. b must be != " " and != null.
	 * @return c: the multiplication matrix.
	 */
	public static int[][] multiply(int[][] a, int[][] b) {
	    int[][] c = new int[a.length][b[0].length];
	    // se comprueba si las matrices se pueden multiplicar
	    if (a[0].length == b.length) {
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    // aquí se multiplica la matriz
	                    c[i][j] += a[i][k] * b[k][j];
	                }
	            }
	        }
	    }
	    /**
	     * si no se cumple la condición se retorna una matriz vacía
	     */
	    return c;
	}
	
	/**
	 * This method multiply each row by each column.
	 * <b>pre</b>The matrixes must have the same sizes.<br>
	 * <b>post</b>The multiplication would be done.<br>
	 * @param A is a matrix. A must be != " " and != null.
	 * @param B is a matrix. B must be != " " and != null.
	 * @param rowA is a number of rows of A. rowA != null and rowA >= 0.
	 * @param colA is a number of columns of A. colA != null and colA >= 0.
	 * @param rowB is a number of rows of B. rowB != null and rowB >= 0.
	 * @param colB is a number of columns of B. colB != null and colB >= 0.
	 * @param size is the size of the matrixes. size != null and size > 0.
	 * @return C: the multiplication matrix.
	 */
	
	public static int[][] multiplyStrassen(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int size) {
		int[][] C = new int[size][size];
		if (size == 1) {
			C[0][0] = A[rowA][colA] * B[rowB][colB];
		} else {
			int newSize = size / 2;
// C11 = A11 * B11 + A12 * B21
			add(C, multiplyStrassen(A, B, rowA, colA, rowB, colB, newSize), // A11*B11
					multiplyStrassen(A, B, rowA, colA + newSize, rowB + newSize, colB, newSize), // A12*B21
					0, 0);// C11

// C12 = A11 * B12 + A12 * B22
			add(C, multiplyStrassen(A, B, rowA, colA, rowB, colB + newSize, newSize), // A11*B12
					multiplyStrassen(A, B, rowA, colA + newSize, rowB + newSize, colB + newSize, newSize), // A12*B22
					0, newSize);// C12

// C21 = A21 * B11 + A22 * B21
			add(C, multiplyStrassen(A, B, rowA + newSize, colA, rowB, colB, newSize), // A21*B11
					multiplyStrassen(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB, newSize), // A22*B21
					newSize, 0);// C21

// C22 = A21 * B12 + A22 * B22
			add(C, multiplyStrassen(A, B, rowA + newSize, colA, rowB, colB + newSize, newSize), // A21*B12
					multiplyStrassen(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB + newSize, newSize), // A22*B22
					newSize, newSize);// C22
		}

		return C;
	}

	/**
	 * This method support the method of the multiplication by Strassen.
	 * <b>pre</b>Must be exist an instance of the multiplyStrassen method.<br>
	 * <b>post</b>The partition of the matrixes should be ran.<br>
	 * @param C    Matrix of size n x n to add to
	 * @param A    A matrix of size n/2 x n/2 to add from
	 * @param B    A matrix of size n/2 x n/2 to add from
	 * @param rowC The starting row of the C matrix
	 * @param colC The starting column of the C matrix
	 */
	private static void add(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i + rowC][j + colC] = A[i][j] + B[i][j];
			}
		}

	}
}