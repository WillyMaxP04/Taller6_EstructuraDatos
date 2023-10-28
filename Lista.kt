class Lista {
    var primero: Nodo? = null
    var ultimo: Nodo? = null

    init {
        primero = null
        ultimo = null
    }

    fun insertarCabezaLista(entrada: String): Lista {
        val nuevo = Nodo(entrada)
        nuevo.enlace = primero
        primero = nuevo

        if (ultimo == null) {
            ultimo = nuevo
        }
        println("Juego añadido al inicio de la lista")
        return this
    }

    fun insertarColaLista(entrada: String): Lista {
        val nuevo = Nodo(entrada)

        if (ultimo == null) {
            ultimo = nuevo
        } else {
            ultimo?.enlace = nuevo
            ultimo = nuevo
        }
        println("Juego añadido al final de la lista")

        return this
    }

    fun insertarDetrasDe(entrada: String, detras: String): Lista {
        val nuevo = Nodo(entrada)
        var n = primero
        var aux: Nodo? // Guardará la información que tenía el anterior enlace del nodo n para no perder la información
        var encontrado = false // Indica si se encontró el elemento o no

        while (n != null) {
            if (n.dato == detras) {
                aux = n.enlace
                n.enlace = nuevo
                nuevo.enlace = aux
                println("Juego añadido detrás de $detras")
                encontrado = true
                break
            } else {
                n = n.enlace
            }
        }

        if (!encontrado) {
            println("$detras no se encuentra en la lista.")
        }

        return this
    }

    fun visualizar() {
        var n = primero

        while (n != null) {
            print("${n.dato} ")
            n = n.enlace
        }
    }
}