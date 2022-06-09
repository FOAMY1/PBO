fun main(){
    print("Masukkan Bilangan : ")
    var number = readln().toInt()
    var arr: MutableList<Int> = ArrayList()
    var i = 0
    repeat(number){
        print("Masukkan Bilangan : ")
        arr.add(readln().toInt())
    }
    for(element in arr){
        if(element % 3 == 0){
            println("Element $element ditemukan di index ke $i merupakan kelipatan bilangan 3")
            i++
        }
    }
}