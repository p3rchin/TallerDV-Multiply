/**
 * Package containing the class
 */
package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class AplMain {
	
	/**
	 * This class execute the program using the controller.
	 * <b>pre</b>The syntax must be correct.<br>
	 * <b>post</b>Program run.<br>
	 * @param args is the argument that use the parameter String[].
	 * @throws Exception if some class does not exist or some access are not available to use or there are some characters that the program unsupported, the program throws indicating that there are some errors in the execution.
	 */

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		Controller controller = new Controller();

	}
}
