class Mobil2 {
    var warna = ""
    var tahunProduksi = 0
    fun mobilNyala(){
        println("Mobil nyala")
    }
    fun mobilMati(){
        println("Mobil mati")
    }
    fun gantiGear(gear:Int){
        println("Ganti gear ke gear $gear")
    }
}
fun main() {
    val mobilku = Mobil2()
    mobilku.warna = "Hitam"
    mobilku.tahunProduksi = 2006
    println("Warna : "+mobilku.warna)
    println("Tahun Produksi : "+mobilku.tahunProduksi)
    mobilku.mobilNyala()
    mobilku.mobilMati()
    mobilku.gantiGear(2)
}
