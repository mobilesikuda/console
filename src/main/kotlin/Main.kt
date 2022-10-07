import kotlin03functional.sum
import java.security.MessageDigest
import kotlin.random.Random
import kotlin.reflect.typeOf
import kotlin.text.Charsets.UTF_8

//fun sha256(str: String): ByteArray = MessageDigest.getInstance("SHA-256").digest(str.toByteArray(UTF_8))
//fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

fun main()  {

    //println(sha256("Hello, world!").toHex())

    data class Obj(
        val amount: Int,
        val category: String,
        val date: String
        )

    val DataObj  = Array( 5, { Obj( it+1, "--", "2022/01/01") })
    for( elem in DataObj) println(elem)

    val result = DataObj.groupBy { it.category }
        .mapValues { it ->  it.value.sumOf { it.amount }}
    for( elem in result) println(elem)

    //val DataObj2  = arrayOf(1,2,3, "4")
    //for( elem in DataObj2) println(elem.toString()+"="+elem.javaClass.typeName )

//    val array = Array<Int>( 301 ){ it+300 }
//    for( i in 300 downTo 0 step 5)
//        //if(array[i] % 5 == 0 )
//            println(array[i])

    //var array = IntArray(10){ 0 }
    //for( elem in array) println(elem)

}

