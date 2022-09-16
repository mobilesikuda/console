//take and drop

fun main(){

    //exec1
    val list = generateSequence( 1 ){it + 1}
        .map { "Сотрудник №$it" }
        .take(100)
        .forEach { println(it) }

}
