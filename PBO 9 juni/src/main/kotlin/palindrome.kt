fun main(args : Array<String>) {
    print("Masukkan Bilangan : ")
    var bilangan = readLine()!!.toInt()
    var nilaipalindrome = 0
    var bilanganasli = bilangan
    var checkpalindrome = false
    while(bilangan != 0){
        nilaipalindrome = nilaipalindrome * 10 + (bilangan % 10)
        bilangan /= 10
    }
    if(bilanganasli == nilaipalindrome){
        checkpalindrome = true
    }
    println("$checkpalindrome")

}
