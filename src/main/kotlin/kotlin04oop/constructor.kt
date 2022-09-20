package kotlin04oop

class Book(val name: String, var year: Int? = null, var price: Float? = null )

fun main(){
    val book = Book("book1")
    book.year = 1999
    book.price = 2.55f
    println(book.name)
}
