import java.security.MessageDigest
import kotlin.reflect.typeOf
import kotlin.text.Charsets.UTF_8

//fun sha256(str: String): ByteArray = MessageDigest.getInstance("SHA-256").digest(str.toByteArray(UTF_8))
//fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

class Main{

}


fun main()  {

    //println(sha256("Hello, world!").toHex())

    data class Obj(
        val amount: Int,
        val category: String,
        val date: String
        )

//    val DataObj  = Array( 5, { Obj( it, it.toString(), "") })
//    for( elem in DataObj) println(elem)

//    val DataObj2  = arrayOf(1,2,3, "4")
//    for( elem in DataObj2) println(elem.toString()+"="+elem.javaClass.typeName )

    val array = Array<Int>( 301 ){ it+300 }
    for( i in 300 downTo 0 step 5)
        //if(array[i] % 5 == 0 )
            println(array[i])

    //var array = IntArray(10){ 0 }
    //for( elem in array) println(elem)

}
