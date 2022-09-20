package kotlin04oop

class student1( name: String, lastname: String, id: Long)
data class student2(val name: String, val lastname: String, val id: Long)

fun main(){

    val man1 = student1("Иван", "Иванов", 10001)
    val man2 = student1("Иван", "Иванов", 10001)

    println(man1)
    println(man2)
    println(man1.hashCode())
    println(man2.hashCode())
    println(man1 == man2 )
    println(man1 === man2 )

    val man3 = student2("Иван", "Иванов", 10001)
    val man4 = student2("Иван", "Иванов", 10001)
    val (name, _ , unit) = man3

    println(name)
    println(man3)
    println(man4)
    println(man3.hashCode())
    println(man4.hashCode())
    println(man3 == man4 )
    println(man3 === man4 )
}