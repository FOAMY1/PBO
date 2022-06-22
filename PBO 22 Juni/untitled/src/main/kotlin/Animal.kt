interface Animal{
    var Size : String
    var Foots : Int
    fun Move() : String
}
class Mammals(override var Size: String, override var Foots: Int) : Animal{
    var Foods = arrayOf("fruits","meat")
    var Skin = "non-feathers"
    override fun Move(): String = "Run"
}

open class Birds (override var Size: String, override var Foots: Int):Animal{
    open var Foods = arrayOf("insect","fish","grain")
    var Skin = "Feathers"
    override fun Move(): String = "Fly"
}

class Penguin(Size: String, Foots: Int): Birds(Size, Foots) {
    override var Foods = arrayOf("fish")
}
fun main(){
    val a = Mammals("Small",4)
    println("Mamals")
    println(a.Size)
    println(a.Foots)
    println(a.Foods.contentToString())
    println(a.Skin)
    println(a.Move())
    println("")
    val b = Birds("Small",2)
    println("Birds")
    println(b.Size)
    println(b.Foots)
    println(b.Foods.contentToString())
    println(b.Skin)
    println(b.Move())
    println("")
    val c = Penguin("Big",2)
    println("Penguin")
    println(c.Size)
    println(c.Foots)
    println(c.Foods.contentToString())
    println(c.Skin)
    println(c.Move())

}