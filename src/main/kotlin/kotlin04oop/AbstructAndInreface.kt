package kotlin04oop

abstract class Worker3(val name: String, var age: Int) {
    abstract fun work()

    companion object {
        fun listCleaner(list: List<Worker3>): List<Worker3> {

            return list.filter { it is Cleaner }
//            val result = mutableListOf<Worker3>()
//            for (elem in list) {
//                if (elem is Cleaner) result.add(elem)
//            }
//            return result
        }
    }
}

interface Cleaner {
    fun clean()
}

class Seller(name: String, age: Int) : Worker3(name, age), Cleaner {
    override fun work() {
        println("Работает продавец...")
    }

    override fun clean() {
        println("Убираю...")
    }
}

class Sailer(name: String, age: Int) : Worker3(name, age) {
    override fun work() {
        println("Работает моряк...")
    }
}


class Programmist3(name: String, age: Int, var lang: String) : Worker3(name, age) {
    override fun work() {
        println("Пишу код на $lang")
    }
}

//exam
interface WaterCarry {
    fun carry(){
        println("Думаю принести воды")
    }

}

class Sportman(){
    fun callWaterCarry(man: WaterCarry){
        println("Вызавать водоноса")
        man.carry()
    }
}

fun main() {
    var workers = mutableListOf<Worker3>(
        Seller("Иван", 20),
        Programmist3("Ваня", 22, "kotlin"),
        Sailer("Юра", 20),
    )
    for (elem in workers) {
        elem.work()
        if (elem is Cleaner) elem.clean()
    }

    val cleaners = Worker3.listCleaner(workers)
    println("Уборщики: ")
    for (elem in cleaners) {
        print("${elem.name},")
    }

    println("")
    val man = Sportman()
    man.callWaterCarry(object:WaterCarry{
        override fun carry(){
            println("Приношу воду")
        }
    })

}

