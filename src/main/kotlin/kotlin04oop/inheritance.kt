package kotlin04oop

open class Worker1(val name: String, var age: Int){
    open fun work(){
        println("Работаю...")
    }
}

class Worker2(val name: String, var age: Int){
    fun work(){
        println("Работаю...")
    }
}

class Programmist(name: String, age: Int, var lang: String): Worker1(name, age){
    override fun work(){
        println("Пишу код на $lang")
    }
}

class Programmist2(name: String, age: Int, var lang: String): Worker1(name, age){
    override fun work(){
        println("Пишу код на $lang")
    }
}

fun main(){
    val workers: Array<Worker1> = arrayOf(
        Worker1("Иван", 20),
        Programmist("Ваня", 22, "kotlin"),
        Worker1("Юра", 20),
    )
    for (elem in workers) elem.work()

    val workers2: Array<Worker2> = arrayOf(
        Worker2("Иван", 20),
        Worker2("Юра", 20),
        //Programmist("Ваня", 22, "kotlin") as Worker2, //error
    )
    for (elem in workers2) elem.work()

}
