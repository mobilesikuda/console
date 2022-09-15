//Anonimous function

fun main()  {

    val square: (Int) -> Int = { x -> x*x }
    val sum: (Int, Int) -> Int = { a, b -> a+b }
    val Perimeter:(Int,Int) -> Int = {a,b -> 2*(a+b)}
    val Hello:(String) -> Unit = { str -> println("Hello $str")}
    Hello("Serg")

    //function as variable
    val sort: (Array<Int>) -> Array<Int> = { array ->

        for( j in 1 until array.size){
            var f = 0
            for ( i in array.size-j downTo j ){
                if (array[i]<array[i-1]){
                    val swap = array[i-1]
                    array[i-1] = array[i]
                    array[i] = swap
                    f = 1
                }
            }
            if(f==0) break
        }
        array
    }

    val array = sort(arrayOf(12,-47,8,47,-2,66,99))
    for(elem in array) println(elem)

}





