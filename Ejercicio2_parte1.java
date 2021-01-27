import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2_parte1 {

	void comprobarPalindromos() {
		System.out.println("Introduzca una cadena:");

		try (InputStreamReader in = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(in)) {
			String cadena = br.readLine();
			System.out.printf("Cadena: %s\n", cadena);
			if (cadena.length() == 0) {
				System.exit(1);
			}
			if (esPalindromo(cadena)) {
				System.exit(2);
			} else {
				System.exit(3);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Compara una letra del principio y una del final para saber si el caracter coincide
	 * Si todos los carácteres de la palabra hasta la mitad de la palabra coinciden es palíndromo
	 *
	 * @param cadena texto que queremos saber si es palíndromo
	 * @return true si es palíndromo
	 */
	boolean esPalindromo(String cadena) {
		boolean esPalindromo = true;

		cadena = cadena.replaceAll("\\s+", "").toLowerCase();
		int max = cadena.length() / 2;
		int i = 0;
		int j = cadena.length() - 1;
		do {
			if (cadena.charAt(i) != cadena.charAt(j)) {
				esPalindromo = false;
			}
			i++;
			j--;
		} while (esPalindromo && i < max);

		return esPalindromo;

	}

	public static void main(String[] args) {
		Ejercicio2_parte1 parte2 = new Ejercicio2_parte1();
		parte2.comprobarPalindromos();
	}
}
