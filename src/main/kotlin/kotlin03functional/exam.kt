package kotlin03functional

import kotlin.random.Random

var collection3 = mutableListOf<Int?>() //(5, null)

fun main(){

    val map = mapOf(
        Pair("Январь", listOf(34,7,23,11)),
        Pair("Февраль", listOf(33,17,3,-45)),
        Pair("Март", listOf(34,7,23,4)),
        Pair("Апрель", listOf(34,7,23,5)),
        Pair("Май", listOf(34,7,23,-100)),
        Pair("Июнь", listOf(34,7,23,3)),
        Pair("Август", listOf(34,7,23,32))
    )

    //exam1
    //printInfo(map)

    //exam2
//    val list = List<Int>(1000){ Random.nextInt(1000) }
//    with(list){
//        println(sum())
//        println(average())
//        println(minOf { it })
//        println(maxOf{ it })
//        println(first())
//        println(last())
//    }
    //list.forEach{ println(it) }

    //exam3
    with(collection3){
        for( index in 0 until 10 ) add(Random.nextInt(1000)*2)
        add(null)
        val result = filter { it1 -> it1?.rem(2) == 0 }
            .take(100)
            .forEach{ println(it)}
    }

    //exam3 - old
    //collection3.let{ it ->
//        with(it){
//            for( index in 0 until 10 ) add(Random.nextInt(1000)*2)
//            add(null)
//            val result = filter { it1 -> it1?.rem(2) == 0 }
//                .take(100)
//                .forEach{ println(it)}
//        }
    //}

}

fun printInfo(data: Map<String, List<Int>>) {

    val validData = data.filterNot { it1 -> it1.value.any { it < 0 } }
    val averageAll = validData.flatMap { it.value }.average()
    println("Средняя выручка: $averageAll")

    val dataSum = validData.map { Pair(it.key, it.value.sum()) }
    val max = dataSum.maxOf { it.second }
    println("Максимальныя выручка $max была в месяце")
    dataSum.filter { it.second == max }.forEach { print(it.first + " ") }

    println(" ")
    val min = dataSum.minOf { it.second }
    println("Минимальная выручка $min была в месяце")
    dataSum.filter { it.second == min }.forEach { print(it.first + " ") }

    //Месяцы с ошибками
    println(" ")
    println("Месяцы с ошибками:")
    data.filter { it1 -> it1.value.any { it < 0 } }.forEach { println(it.key + " ") }
}