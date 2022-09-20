package kotlin04oop

import java.util.*

class Dog(){

    var age: Int = 0
        set(value) { if(value >= 0) field = value }

    var weight: Float = 0f
        set(value) { if(value >= 0) field = value }

    var name: String = ""
        get() {
            //return field.substring(0,1).uppercase() + field.substring(1)
            return field.lowercase(Locale.getDefault())
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }

}

fun main(){
    val dog = Dog()
    dog.age = 10
    dog.age = -19
    dog.name = "шаРИк"
    println("Dog: age=${dog.age} name=${dog.name}")

}