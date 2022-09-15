
class Logger(val name: String) {
    fun log (s:String){
        println("$name: $s")
    }
}

fun Logger.store(s: String){
    log("Store $s on the disk")
}

fun main()  {
    val logger = Logger("Main")
    with(logger){
        store("A image")
        store("A text file")
        store("A cheese burger")
    }
}