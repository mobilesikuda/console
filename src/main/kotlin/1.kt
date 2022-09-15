import kotlin.random.Random

data class myString(val str: String){
    fun sarcastic(): String {
        return str.asIterable().joinToString {
            if( Random.nextBoolean()) it.uppercase() else it.lowercase()
        }
    }
}

fun main()  {
    greetingTransform{
        sarcastic()
    }
}

fun greetingTransform(transform: myString.() -> String){

    val greeting = myString("Hello World!")
    val transformed = greeting.transform()
    println(transformed)

}

