package academy.learnprogramming.challenge2

fun main() {

    // 1.
    val myFirstFloatVariable = -3847.384f
    val mySecondFloatVariable: Float = -3847.384f

    // 2.
    val myThirdFloatVariable: Float? = 3847.384f

    // 3.
    val myShortArray = shortArrayOf(1, 2, 3, 4, 5)

    // 4.
    val myNullableIntArray = Array<Int?>(40) { i -> (i + 1) * 5}

    // 5.
    val myPrimitiveCharArray = charArrayOf('a', 'b', 'c')

    // 6.
    val x: String? = "I AM IN UPPERCASE"
    val myStringVariable = x?.lowercase() ?: "I give up!"

    // 7.
    x?.let { it.lowercase().replace("am", "am not") }

    //8.
    val muNonNullVaraible: Int? = null
    muNonNullVaraible!!.toDouble()
}
