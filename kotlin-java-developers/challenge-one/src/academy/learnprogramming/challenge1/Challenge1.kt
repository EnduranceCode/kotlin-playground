package academy.learnprogramming.challenge1

import java.util.Locale.getDefault

fun main() {
    val hello1 = "Hello"
    val hello2 = "Hello"

    println("hello1 is referential equal to hell2: ${hello1 === hello2}")

    println("hello1 is referential equal to hell2: ${hello1 == hello2}")

    var value = 2988

    val text: Any = "The Any type is the root of the Kotlin class hierarchy"
    if (text is String) {
        println(text.uppercase(getDefault()))
    }

    var ones = """
        |   1
        |  11
        | 111
    """.trimMargin()
    println(ones)

    ones = """
        1   1
        1  11
        1 111
    """.trimMargin("1")
    println(ones)
}