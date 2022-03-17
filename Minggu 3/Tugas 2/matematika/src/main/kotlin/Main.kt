class Matematika {
    fun pertambahan(x:Int,y:Int): Int {
        return(x+y)
    }
    fun pengurangan(x: Int,y: Int):Int{
        return (x - y)
    }
    fun perkalian(x: Int,y: Int):Int{
        return(x * y)
    }
    fun pembagian(x: Int,y: Int):Int{
        return (x/y)
    }
}

fun main() {
    val math = Matematika()
    println("20 + 20 = "+math.pertambahan(20,20))
    println("10 - 5 = "+math.pengurangan(10,5))
    println("10 x 20 = "+math.perkalian(10,20))
    println("20 / 2 = "+math.pembagian(20,2))
}