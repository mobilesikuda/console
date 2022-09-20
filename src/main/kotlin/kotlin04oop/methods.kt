package kotlin04oop

import kotlin04oop.Worker.Companion.work
import java.time.LocalDate
import java.util.*

class Worker(val name: String, var position: String, val year: Int = 2021) {

    val experience: Int
        get() =  LocalDate.now().year - year

    //val now = Calendar.getInstance().get(Calendar.YEAR) - year

    companion object{
        fun work(){ println("Work...")}
    }

}

fun Worker.printInfo(){
    println(experience)
    work()
}

fun main( ){
    val worker = Worker("Иванов", "Менеджер")
    worker.printInfo()
}