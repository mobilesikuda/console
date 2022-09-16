fun main(){

    val array = arrayOf("Иванов Иван", "Степанов Степан", "Сергеев Сергей")
    val result = array.map {
        //val temp = it.split(" ")
        //Pair(temp[0],temp[1])
        Pair(it.substringBefore(" "), it.substringAfter(" "))
    }
    for (elem in result) println(elem)




}


