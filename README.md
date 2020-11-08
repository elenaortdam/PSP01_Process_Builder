# Ejercicio 1 de PSP de Segundo de DAM
En estas actividades usaremos las clases ProcessBuilder, Process y Runtime. 
EJERCICIO 1) (7 PUNTOS) 
Realiza un programa Java que lea por teclado en un proceso repetitivo datos de alumnos: 
 Los datos de alumnos a leer son el nombre (String) y la edad (int). 
 El proceso repetitivo finaliza cuando el nombre sea *. 
 Si el nombre leído es blanco o su longitud de caracteres es 0 se debe volver a leer. 
 Si la edad no está comprendida entre 1 y 99, se debe volver a leer. 
 Igualmente se vuelve a leer la edad si se introduce una cadena en vez de un número en dicho 
campo. 
 Se deben visualizar mensajes al pedir los datos y cuando no son correctos. 
Una vez finalizado el proceso de lectura de datos se debe mostrar al final un mensaje, el número de 
alumnos leídos, el nombre de alumno con más edad y el nombre con menos edad. 
Nombra al programa Ejercicio_parte1.java. 
EL EJERCICIO SE COMPILARÁ Y EJECUTARÁ DESDE LA LINEA DE COMANDOS DEL DOS. 
EJEMPLO DE COMPILACIÓN Y EJECUCIÓN DE ESTE EJERCICIO:

javac Ejercicio_parte1.java 
java Ejercicio_parte1 
1 -Introduce datos de alumnos: 
 Escribe un nombre: JUAN 
 Introduce la EDAD entre 1 y 99: 10
 Datos introducidos: JUAN, 10 
2 -Introduce datos de alumnos: 
 Escribe un nombre: PEDRO
 Introduce la EDAD entre 1 y 99: 16 
 Datos introducidos: PEDRO, 16 
3 -Introduce datos de alumnos: 
 Escribe un nombre: 
 Incorrecto, escribelo de nuevo: 
 Escribe un nombre: ANA 
 Introduce la EDAD entre 1 y 99: 0
 Incorrecto, debe estar entre: 1, y 99 
 Introduce la EDAD entre 1 y 99: 33
 Datos introducidos: ANA, 33 
4 -Introduce datos de alumnos: 
 Escribe un nombre: *
Fin de proceso de lectura... 
Datos leidos: 3 
Alumno con más edad: ANA 
Alumno con menos edad: JUAN 
Realiza otro programa Java para ejecutar Ejercicio_parte1: 
 Este programa recibe desde los argumentos de main() el nombre de los ficheros que contendrán 
los datos de entrada para la ejecución del Ejercicio_parte1. Pueden ser varios ficheros. El programa 
Ejercicio_parte1 se ejecutará tantas veces como ficheros hay en los argumentos de main(). 
 La salida de las distintas ejecuciones del programa se debe almacenar en un fichero, el nombre de 
este fichero coincidirá con el nombre del fichero de entrada, pero añadiendo la letra S al principio 
del nombre del mismo. También la salida de error de cada ejecución se almacenará en otro fichero,
el nombre de este será el mismo que el nombre del fichero de entrada pero añadiendo la letra E al 
principio del nombre del mismo. 
 Si el programa no recibe los argumentos requeridos (1 o más) debe mostrar un mensaje y finalizar 
la ejecución. 
 Si alguno de los nombres de fichero indicados en los argumentos de main() no existe, se debe 
mostrar mensaje indicándolo. 
 El programa debe mostrar en pantalla el número de veces que se ejecuta Ejercicio_parte1 y el 
mensaje de Fin de proceso. 
 El programa debe crear tantos ficheros de salida como ficheros de entrada existan. Por ejemplo si 
los ficheros de entrada se llaman Fichero1.txt, Fichero2.txt Y Fichero3.txt y existen, se deben 
generar los ficheros de salida SFichero1.txt, SFichero2.txt y SFichero3.txt. 
 Y se deben crear tantos ficheros de salida de error como ficheros de entrada (siempre y cuando los 
ficheros de entrada existan). En este caso EFichero1.txt, EFichero2.txt y EFichero3.txt que estarán 
vacios si no se produce ningún error
Este programa se llamará Ejercicio_ejecutaparte1.java
EL EJERCICIO SE COMPILARÁ Y EJECUTARÁ DESDE LA LINEA DE COMANDOS DEL DOS.
COMPILAMOS 
javac Ejercicio_parte1.java 
javac Ejercicio_ejecutaparte1.java 
Y EJECUTAMOS LA CLASE JAVA Ejercicio_ejecutaparte1: 
java Ejercicio_ejecutaparte1 Fichero1.txt Fichero2.txt Fichero3.txt 
Se va a probar el programa 3 veces 
Fin de proceso...
