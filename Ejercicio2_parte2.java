import java.io.*;

public class Ejercicio2_parte2 {

	private static final int CADENA_VACIA = 1;
	private static final int ES_PALINDROMO = 2;
	private static final int NO_ES_PALINDROMO = 3;

	void ejecutarProceso() {

		File directorio = new File(System.getProperty("user.dir"));
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio2_parte1",
											   String.valueOf(directorio));
		pb.directory(directorio);
		try (InputStreamReader in = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(in)) {
			System.out.print("Introduzca una cadena: ");
			String cadena = br.readLine();
			System.out.printf("Cadena: %s\n", cadena);
			Process p = pb.start();
			OutputStream os = p.getOutputStream();
			os.write(cadena.getBytes());
			os.write("\n".getBytes());
			os.flush();
			int exitValue;
			try {
				exitValue = p.waitFor();
				System.out.printf("Valor de salida: %s\n", exitValue);
				switch (exitValue) {
					case CADENA_VACIA:
						System.out.println("Cadena vacía...");
						break;
					case ES_PALINDROMO:
						System.out.println("La cadena es palíndromo...");
						break;
					case NO_ES_PALINDROMO:
						System.out.println("La cadena no es palíndromo...");
						break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Ejercicio2_parte2 parte2 = new Ejercicio2_parte2();
		parte2.ejecutarProceso();
	}
}
