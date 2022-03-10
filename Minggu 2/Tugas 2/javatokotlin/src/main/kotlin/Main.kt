class Mobil {
    var warna = ""
    var tahunProduksi = 0
}
fun main(args : Array<String>) {
    val mobilku = Mobil()
    mobilku.warna = "Hitam"
    mobilku.tahunProduksi = 2006
    println("Warna : "+mobilku.warna)
    println("Tahun Produksi : "+mobilku.tahunProduksi)
}
