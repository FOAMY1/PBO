fun main(){
    var arr: MutableList<Int> = ArrayList()
    var arr2: MutableList<Int> = ArrayList()
    var arrgabungan: MutableList<Int> = ArrayList()
    var arrterurut: MutableList<Int> = ArrayList()

    print("Masukkan panjang array pertama : ")
    var bilangan = readln().toInt()
    var i = 1
    while(i <= bilangan){
        print("masukkan bilangan pada array : ")
        arr.add(readln().toInt())
        arrgabungan.add(arr[i-1])
        i++
    }
    print("Masukkan panjang array kedua : ")
    bilangan = readln().toInt()
    i = 1
    while(i<= bilangan){
        print("masukkan bilangan pada array : ")
        arr2.add(readln().toInt())
        arrgabungan.add(arr2[i-1])
        i++
    }
    arrterurut = arrgabungan
    fun sorting(arr:MutableList<Int>):MutableList<Int>{
        if (arr.isEmpty() || arr.size<2){
            return arr
        }
        for (isi in 1..arr.size - 1){
            val angka = arr[isi]
            var i = isi
            while (i>0 && angka < arr[i - 1]){
                arr[i] = arr[i - 1]
                i -= 1
            }
            arr[i] = angka
        }
        return arr
    }
    println("$arr")
    println("$arr2")
    println("$arrgabungan")
    println("${sorting(arrterurut)}")
}