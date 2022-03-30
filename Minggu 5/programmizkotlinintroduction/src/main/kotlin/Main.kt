fun main() {

    //Programiz Hello world

    println("Hello World!")

    //Programiz data type

    val temperature: Short = -11245
    println("$temperature")

    //Programiz Operators

    val start = "Talk is cheap. "
    val middle = "Show me the code. "
    val end = "- Linus Torvalds"

    val result = start + middle + end
    println(result)

    //Programiz Type Conversion

    val number1: Int = 545344
    val number2: Byte = number1.toByte()
    println("number1 = $number1")
    println("number2 = $number2")

    //Programiz Expression and Statement

    val flag = true

    if (flag == true) {      // start of if block
        //flag==true adalah expression
        //val flag=true adalah statement
        print("Hey ")
        println("jude!")
    }

    //programiz comment, ini comment
    /*ini juga comment*/

    //programiz Input Output

    print("Enter text: ")

    val stringInput = readLine()!!
    println("You entered: $stringInput")
}