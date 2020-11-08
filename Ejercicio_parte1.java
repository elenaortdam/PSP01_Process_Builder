import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ejercicio_parte1 {

	class Alumno implements Comparable<Alumno> {
		private String nombre;
		private int edad;

		public Alumno(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
		}

		public String getNombre() {
			return nombre;
		}

		public int getEdad() {
			return edad;
		}

		@Override
		public int compareTo(Alumno o) {
			if (this.edad < o.edad) {
				return -1;
			}else if(this.edad == o.edad){
				return 0;
			} else {
				return 1;
			}
		}

		@Override public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Alumno alumno = (Alumno) o;
			return edad == alumno.edad &&
					Objects.equals(nombre, alumno.nombre);
		}

		@Override public int hashCode() {
			return Objects.hash(nombre, edad);
		}
	}

	void pedirDatosUsuario() {
		List<Alumno> alumnos = new ArrayList<>();
		int contador = 1;
		String nombre = "";
		Integer edad = null;
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		do {
			try {
				nombre = getNombre(br, contador);
				if (nombre.trim().equals("*")) {
					System.out.println("Fin de proceso de lectura...");
					System.out.printf("Datos leídos: %d\n", alumnos.size());
					TreeSet<Alumno> alumnosOrdenadosPorEdad = new TreeSet<>(alumnos);
					Alumno masMayor = alumnosOrdenadosPorEdad.last();
					System.out.printf("Alumno con más edad: %s\n", masMayor.getNombre());
					Alumno masJoven = alumnosOrdenadosPorEdad.first();
					System.out.printf("Alumno con menos edad: %s\n", masJoven.getNombre());
				} else {
					edad = getEdad(br);
				}
				if (edad != null) {
					alumnos.add(new Alumno(nombre, edad));
				}
				contador++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (!nombre.equals("*"));

	}

	private String getNombre(BufferedReader br, int contador) throws IOException {
		String nombre = "";
		do {

			System.out.printf("%d -Introduce datos de alumnos: \n", contador);
			System.out.print("Escribe un nombre: ");
			nombre = br.readLine();
			while (nombre == null || nombre.isEmpty()) {
				System.out.print("\tIncorrecto, escribelo de nuevo:");
				nombre = br.readLine();
			}

		} while (nombre.isEmpty());
		return nombre;
	}

	private int getEdad(BufferedReader br) {
		Integer edad = null;
		do {

			try {
				System.out.print("Introduce la EDAD entre 1 y 99: ");
				String entradaEdad = br.readLine();
				while (!validarEdad(entradaEdad)) {
					System.out.println("\tIncorrecto, debe estar entre: 1, y 99");
					System.out.print("Introduce la EDAD entre 1 y 99:");
					entradaEdad = br.readLine();
				}
				edad = Integer.parseInt(entradaEdad);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (edad == null);
		return edad;
	}

	//TODO: ¿Validar que la edad no sea un número?

	boolean validarEdad(String edad) {
		if (edad == null || edad.isEmpty()) {
			return false;
		}
		edad = edad.trim();
		//Si tiene más de 3 caracteres ha puesto un número mayor que 99
		if (edad.length() > 2) {
			return false;
		}
		try {
			int edadInt = Integer.parseInt(edad);
			if (edadInt < 1) {
				return false;
			} else return edadInt <= 99;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		Ejercicio_parte1 parte1 = new Ejercicio_parte1();
		parte1.pedirDatosUsuario();
	}
}
