import java.io.*;

public class Ejercicio_ejecutaparte1 {

	void cargaFicheros(String... args) throws IOException, InterruptedException {
		for (String nombreFichero : args) {
			File directorio = new File(System.getProperty("user.dir"));
			File ficheroResultados = new File("S" + nombreFichero);
			File ficheroError = new File("E" + nombreFichero);
			ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio_parte1",
												   String.valueOf(directorio));
			pb.directory(directorio);
			pb.redirectOutput(ficheroResultados);
			pb.redirectError(ficheroError);
			Process p = pb.start();

			try (OutputStream os = p.getOutputStream();
				 BufferedReader br = new BufferedReader(
						 new FileReader(directorio + "\\" + nombreFichero))) {

				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					line = line + "\n";
					os.write(line.getBytes());
					os.flush();
				}

			} catch (FileNotFoundException e) {
				System.out.printf("Fichero: %s no existe...", nombreFichero);
			} catch (IOException e) {
				e.printStackTrace();
			}

			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.println((char) c);
			is.close();

/*
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.println((char) c);
			is.close();
			int exitValue;
			try {

				exitValue = p.waitFor();
				System.out.println("Valor de salida: " + exitValue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

 */
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args == null || args.length == 0) {
			System.out.println("Faltan argumentos...");
		} else {
			Ejercicio_ejecutaparte1 lanzador = new Ejercicio_ejecutaparte1();
			System.out.printf("Se va a probar el programa %d veces\n", args.length);
			lanzador.cargaFicheros(args);
		}
	}
}
