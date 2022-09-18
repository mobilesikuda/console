package kotlin03functional

fun main() {

    val list = generateSequence( 1 ){it + 1}
        .take(5)

    list.forEach { println(it) }
    //operationOfNums(list) { println(sum(list)) }
    operationOfNums(list) { sum(list) }
}

fun sum(data: Sequence<Int>): Int {
    var result = 0
    for(elem in data) result += elem
    return  result
}

inline fun operationOfNums( data: Sequence<Int>, operation: (Sequence<Int>) -> Unit) = operation(data)
