
import java.util.Scanner

class Nodo(var dato: String, var enlace: Nodo? = null)

fun main(args: Array<String>) {
    // Inicialización de variables clave
    var opc: Int
    var k = 0
    var nombre: String
    var otro: String
    var seguir = true
    val entrada = Scanner(System.`in`) // Necesario para guardar información digitada
    val lista = Lista() // Crear lista vacía

    println("Inserción de nombres de videojuegos de PC")
    do {
        println("Ingrese el nombre de un videojuego: ")
        nombre = entrada.next() // Guarda el nombre del juego que quiera guardar

        if (k != 0) { // Condición que se ejecuta después de añadir el primer elemento a la lista
            println("1. Insertar al principio de la lista")
            println("2. Insertar al final de la lista")
            println("3. Insertar detrás de un juego en específico")
            print("Opción: ")
            opc = entrada.nextInt() // Determina la opción seleccionada y por la que se ejecuta el when

            when (opc) {
                1 -> lista.insertarCabezaLista(nombre) // Si se quiere insertar en la cabeza de la lista
                2 -> lista.insertarColaLista(nombre) // Si se quiere insertar al final de la lista (como si fuera el primer elemento añadido)
                3 -> {
                    print("Nombre del otro juego: ")
                    otro = entrada.next() // El juego al que se quiere conectar el nuevo elemento
                    lista.insertarDetrasDe(nombre, otro) // Comprobando si el otro elemento existe y si es así uniéndolo en ese espacio
                }
                else -> println("No es una opción válida, intenta de nuevo.") // Cuando la opción no está entre 1-3
            }
        } else {
            lista.insertarCabezaLista(nombre) // Inserta el primer elemento a incluir en la lista
            k++ // Ya así siempre nos va a mandar a la parte del menú, pues la condición siempre se va a dar
        }

        print("¿Añadir otro jueguito? (S/N): ")
        nombre = entrada.next().toUpperCase() // Determinar la opción que ingrese pero siempre escribiéndola en mayúsculas
        if (nombre != "S") {
            seguir = false // Determina que ya no queremos incluir más juegos en la lista, es decir, que se termine el ciclo do-while
        }
    } while (seguir)

    // Recorre la lista para escribir sus elementos
    println("Elementos de la lista:")
    lista.visualizar()
}
