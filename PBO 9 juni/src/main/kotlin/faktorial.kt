fun main(){
    print("Masukkan Bilangan : ")
    var bilangan = readLine()!!.toInt()
    val arr: MutableList<Int> = ArrayList()
    var i = 1
    var faktorial = 1
    while (i <= bilangan) {
        faktorial *= i
        arr.add(bilangan-(i-1))
        i++
    }
    println("Nilai $bilangan! adalah :")
    for (element in arr) {
            if(element==1){
                print(element)
            }else{
            print("$element * ")
            }
    }
    print(" = $faktorial")
    }