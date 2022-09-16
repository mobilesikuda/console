import kotlin.random.Random

//filter and maps

fun main(){

    //execise 1 - filter
    val listNames = listOf("Andreay","Roy","Serg","victor","Vit","Tim","Zoya","Zerg","allex")
    //val listA = listNames.filter { it.substring(0,1).uppercase() == "A" }
    val listA = listNames.filter { it.startsWith("A", true) }
    for (elem in listA) println(elem)

    //execise 2 -map
    val numbers = Array<Int>(1000){  Random.nextInt(1000) }
    val result = numbers
        .filter { it % 3 == 0 || it % 5 == 0 }
        .map { it*it }
        .sortedDescending()
        .map { "Number $it" }
    for (elem in result) println(elem)


}