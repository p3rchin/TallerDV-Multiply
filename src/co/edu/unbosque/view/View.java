/**
 * Package containing the class
 */
package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class View {
	
	/**
	 * This method is the constructor of the class.
	 */	

	public View() {
	}

	/**
	 * This method is for show messages.
	 * <b>pre</b>The String parameter must be defined.<br>
	 * <b>post</b> The message must be printed in the JOptionPane messages.<br>
	 * @param pSms is parameter String for show  the messages.
	 */
	
	public void showMessage(String pSms) {
		System.out.println(pSms);
	}

	/**
	 * This method is for read data.
	 * <b>post</b> The String returned must be different of null.<br>
	 * @param pSms is parameter String for read data.
	 * @return is the String returned that is captured.
	 */	
	
	public String readData() {
		Scanner scanner = new Scanner(System.in);
		String data = "";
		data = scanner.nextLine();
		return data;

	}
	

}
