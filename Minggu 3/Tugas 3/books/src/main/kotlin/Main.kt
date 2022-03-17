class Buku(Judul:String,Pengarang:String,Penerbit:String,Tahun:Int){
    var judulBuku = Judul
    var pengarangBuku = Pengarang
    var penerbitBuku = Penerbit
    var tahunBuku = Tahun
    fun cetakBuku(){
        println(judulBuku+", "+pengarangBuku+", "+penerbitBuku+", "+tahunBuku)
    }
}

fun main(args: Array<String>) {
    var buku1 = Buku("Pemrograman Berbasis Objek dengan Java","Indrajani","Elexmedia Komputindo",2007);
    var buku2 = Buku("Dasar Pemrograman Java","Abdul Kadir","Andi Offset",2004);
    buku1.cetakBuku()
    buku2.cetakBuku()
}