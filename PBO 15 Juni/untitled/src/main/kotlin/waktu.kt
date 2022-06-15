fun main (){
    print ("Masukkan bilangan untuk dijadikan satuan waktu : ")
    var bilangan = readln().toInt()
    var jam = bilangan / 3600
    var menit = (bilangan % 3600) / 60
    var detik = (bilangan % 3600) % 60
    println("$jam:$menit:$detik")
}