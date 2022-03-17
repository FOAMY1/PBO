class Mobil2 {
    var warna = ""
    var tahunProduksi = 0
    fun MobilNyala(){
        println("Mobil nyala")
    }
    fun MobilLampu(){
        println("Lampu nyala")
    }
    fun GantiGear(gear:Int){
        println("Ganti gear ke gear "+gear)
    }
}
fun main(args : Array<String>) {
    val mobilku = Mobil2()
    mobilku.warna = "Hitam"
    mobilku.tahunProduksi = 2006
    println("Warna : "+mobilku.warna)
    println("Tahun Produksi : "+mobilku.tahunProduksi)
    mobilku.MobilNyala()
    mobilku.MobilLampu()
    mobilku.GantiGear(2)
}
