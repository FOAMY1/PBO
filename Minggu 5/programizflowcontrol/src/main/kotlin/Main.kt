fun main(args: Array<String>) {

    //Programiz if expresion

    println("Programiz if expression")
    val number = -10

    val result = if (number > 0) {
        "Positive number"
    } else {
        "Negative number"
    }

    println(result)

    //Programiz when expression
    println("Programiz when expression")
    val a = 12
    val b = 5

    println("Enter operator either +, -, * or /")
    val operator = readLine()

    when (operator) {
        "+" -> println("$a + $b = ${a + b}")
        "-" -> println("$a - $b = ${a - b}")
        "*" -> println("$a * $b = ${a * b}")
        "/" -> println("$a / $b = ${a / b}")
        else -> println("$operator is invalid")
    }
    //Programiz while loop
    println("Programiz while loop")
    var i = 1

    while (i <= 5) {
        println("Line $i")
        ++i
    }

    //Programiz for loop
    println("Programiz for loop")
    var language = arrayOf("Ruby", "Kotlin", "Python","Java")

    for (item in language)
        println(item)

    //Programiz break
    println("Programiz break")
    var sum = 0
    var numb: Int

    while (true) {
        print("Enter a number: ")
        numb = readLine()!!.toInt()

        if (numb == 0)
            break

        sum += numb
    }

    println("sum = $sum")

    //Programiz Continue
    println("Programiz continue")
    for (z in 1..5) {
        println("$z Always printed.")
        if (z > 1 && z < 5) {
            continue
        }
        println("$z Not always printed.")
    }

}