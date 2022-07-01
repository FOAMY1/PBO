import java.io.File
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import javax.imageio.ImageIO
import javax.swing.*


class DataMahasiswa{
    var frame = JFrame("Data Mahasiswa")
    var frame1 = JFrame("Daftar Semua Mahasiswa")

    init {
        Pilih(frame,frame1)
        frame.isVisible = true
    }
}
class Pilih(frame:JFrame,frame1:JFrame){
    var panel = JPanel()
    var panel1 = JPanel()
    var panel2 = JPanel()
    var buttonshow = JButton("Show All")
    var buttonedit = JButton("Add/Edit/Hapus")
    var buttonkembali = JButton("Kembali")
    var buttonpic1 = JButton("Gambar 1")
    var buttonpic2 = JButton("Gambar 2")
    var buttonpic3 = JButton("Gambar 3")
    var buttonpic4 = JButton("Gambar 4")
    var buttonupdate = JButton("Update Data")
    var buttontambah = JButton("Tambah Data")
    var buttonhapus = JButton("Hapus Data")
    var nimsearch = JTextField(8)
    var fieldnim = JTextField(8)
    var fieldnama = JTextField(8)
    var fieldipk = JTextField(8)
    var fieldmatkul = JTextField(8)
    var labelsearch = JLabel("Masukkan NIM untuk edit atau hapus data kosongkan jika ingin add adata")
    var labelnama = JLabel("Nama")
    var labelnim = JLabel("NIM")
    var labelipk = JLabel("IPK")
    var labelmatkul = JLabel("Matkul")
    var labelfoto = JLabel()
    var scrollpane = JScrollPane()
    var imagestring = "user1.png"
    var img = ImageIO.read(File("gambar/$imagestring"))
    var nomordata = ""

    init{
        panel.setBounds(0, 0, 500, 500)
        panel1.setBounds(0,0,500,500)
        panel2.setBounds(0,500,500,500)
        nimsearch.setSize(50,50)
        buttonshow.addActionListener{
            panel.remove(scrollpane)
            val showall = ShowAll()
            val list: MutableList<Array<String>> = mutableListOf()
            val kolom = arrayOf("NAMA", "NIM", "IPK", "MATA KULIAH")
            while (showall.rs.next()) {
                list.add(
                    arrayOf(
                        showall.rs.getString("nama"),
                        showall.rs.getString("nim"),
                        showall.rs.getString("ipk"),
                        showall.rs.getString("matkul")
                    )
                )
            }
            showall.con.close()
            val data = list.toTypedArray()
            val jt = JTable(data, kolom)
            jt.setDefaultEditor(Any::class.java, null)
            jt.cellSelectionEnabled = false
            scrollpane = JScrollPane(jt)
            panel.add(scrollpane)
            panel.revalidate()
            panel.repaint()
        }

        buttonpic1.addActionListener{
            panel2.remove(labelfoto)
            imagestring = "user1.png"
            img = ImageIO.read(File("gambar/$imagestring"))
            labelfoto = JLabel(ImageIcon(img))
            panel2.add(labelfoto)
            panel2.revalidate()
            panel2.repaint()
        }

        buttonpic2.addActionListener{
            panel2.remove(labelfoto)
            imagestring = "user2.png"
            img = ImageIO.read(File("gambar/$imagestring"))
            labelfoto = JLabel(ImageIcon(img))
            panel2.add(labelfoto)
            panel2.revalidate()
            panel2.repaint()
        }

        buttonpic3.addActionListener{
            panel2.remove(labelfoto)
            imagestring = "user3.png"
            img = ImageIO.read(File("gambar/$imagestring"))
            labelfoto = JLabel(ImageIcon(img))
            panel2.add(labelfoto)
            panel2.revalidate()
            panel2.repaint()
        }

        buttonpic4.addActionListener{
            panel2.remove(labelfoto)
            imagestring = "user4.png"
            img = ImageIO.read(File("gambar/$imagestring"))
            labelfoto = JLabel(ImageIcon(img))
            panel2.add(labelfoto)
            panel2.revalidate()
            panel2.repaint()
        }

        buttonupdate.addActionListener{
            UpdateData(nomordata, fieldnama.text, fieldnim.text, fieldipk.text, fieldmatkul.text, imagestring)
            frame1.dispose()
            frame.isVisible = true

        }

        buttontambah.addActionListener{
            val showall = ShowAll()
            while (showall.rs.next()) {
                if(fieldnim.text == showall.rs.getString("nim")){
                    JOptionPane.showMessageDialog(
                        JFrame(), "NIM sudah ada!", "Warning",
                        JOptionPane.ERROR_MESSAGE
                    )
                }
            }
            if(fieldnim.text.length != 5 && fieldnama.text == "" && fieldipk.text == "" && fieldmatkul.text == ""){
                JOptionPane.showMessageDialog(
                    JFrame(), "Semua field harus terisi! dan nim harus 5 angka!", "Warning",
                    JOptionPane.ERROR_MESSAGE
                )
            }
            else{
                AddData(fieldnama.text, fieldnim.text, fieldipk.text, fieldmatkul.text, imagestring)
                frame1.dispose()
                frame.isVisible = true
            }
        }

        buttonhapus.addActionListener{

            DeleteData(nomordata)
            frame1.dispose()
            frame.isVisible = true
        }

        buttonedit.addActionListener{
            var count = 0
            if(nimsearch.text == ""){
                JOptionPane.showMessageDialog(
                    JFrame(), "nim kosong akan dialihkan ke add data!", "Information",
                    JOptionPane.INFORMATION_MESSAGE
                )
                panel2.remove(labelfoto)
                frame.dispose()
                frame1.isVisible = true
                fieldnama.text = ""
                fieldnim.text = ""
                fieldipk.text = ""
                fieldmatkul.text = ""
                imagestring = "user1.png"
                img = ImageIO.read(File("gambar/$imagestring"))
                labelfoto = JLabel(ImageIcon(img))
                panel2.remove(buttonupdate)
                panel2.remove(buttonhapus)
                panel2.remove(buttontambah)
                panel2.add(buttontambah)
                panel2.add(labelfoto)
                panel2.revalidate()
                panel2.repaint()
            }
            else{
                val showspecific = ShowSpecific(nimsearch.text)
                while(showspecific.rs.next()) {
                    count++
                    nomordata = showspecific.rs.getString("nomor")
                    fieldnama.text = showspecific.rs.getString("nama")
                    fieldnim.text = showspecific.rs.getString("nim")
                    fieldipk.text = showspecific.rs.getString("ipk")
                    fieldmatkul.text = showspecific.rs.getString("matkul")
                    panel2.remove(labelfoto)
                    imagestring = showspecific.rs.getString("foto")
                    img = ImageIO.read(File("gambar/$imagestring"))
                    labelfoto = JLabel(ImageIcon(img))
                }
                showspecific.con.close()
                if (count == 0 && nimsearch.text != ""){
                    JOptionPane.showMessageDialog(
                        JFrame(), "nim tidak ditemukan!", "Warning",
                        JOptionPane.ERROR_MESSAGE
                    )
                }
                else{
                    panel2.remove(buttonupdate)
                    panel2.remove(buttonhapus)
                    panel2.remove(buttontambah)
                    panel2.add(buttonupdate)
                    panel2.add(buttonhapus)
                    panel2.add(labelfoto)
                    panel2.revalidate()
                    panel2.repaint()
                    frame.dispose()
                    frame1.isVisible = true
                }
            }

        }

        buttonkembali.addActionListener{
            frame1.dispose()
            frame.isVisible = true
        }
        panel.add(labelsearch)
        panel.add(nimsearch)
        panel.add(buttonedit)
        panel.add(buttonshow)
        panel.add(scrollpane)
        frame.add(panel)
        frame.setSize(500,500)
        frame.layout = null
        panel1.add(labelnama)
        panel1.add(fieldnama)
        panel1.add(labelnim)
        panel1.add(fieldnim)
        panel1.add(labelipk)
        panel1.add(fieldipk)
        panel1.add(labelmatkul)
        panel1.add(fieldmatkul)
        panel2.add(buttonpic1)
        panel2.add(buttonpic2)
        panel2.add(buttonpic3)
        panel2.add(buttonpic4)
        panel2.add(labelfoto)
        panel2.add(buttonkembali)
        panel1.add(panel2)
        panel1.layout = BoxLayout(panel1, BoxLayout.PAGE_AXIS)
        frame1.add(panel1)
        frame1.setSize(600,1000)
    }
}

open class Conn{
    private val host = "jdbc:mysql://localhost:3306/db_mahasiswa"
    private val user = "root"
    private val pass = ""
    val con: Connection = DriverManager.getConnection(host, user, pass)
    val state: Statement = con.createStatement()
}

class ShowAll : Conn() {
    private val show = "select * from mahasiswa"
    val rs: ResultSet = state.executeQuery(show)
}

class ShowSpecific(nim:String) : Conn(){
    private val show = "select * from mahasiswa where nim = $nim"
    val rs: ResultSet = state.executeQuery(show)
}

class AddData(nama:String, nim:String, ipk:String, matkul:String, foto:String) : Conn(){
    private val add = "INSERT INTO `mahasiswa`(`nama`, `nim`, `ipk`, `matkul`, `foto`) " +
            "VALUES ('$nama', '$nim', '$ipk', '$matkul', '$foto')"
    init{
        state.use { state ->
            state.executeUpdate(add)
        }
    }

}

class UpdateData(nomor:String, nama:String, nim:String, ipk:String, matkul:String, foto:String) :Conn(){
    private val update = "UPDATE `mahasiswa` SET `nama`= '$nama',`nim`= '$nim',`ipk`= '$ipk'," +
            "`matkul`= '$matkul',`foto`= '$foto' WHERE nomor = '$nomor'"
    init{
        state.executeUpdate(update)
        con.close()
    }
}
class DeleteData(nomor:String):Conn(){
    private val delete = "DELETE FROM `mahasiswa` WHERE nomor = $nomor"

    init{
        state.executeUpdate(delete)
    }
}

fun main(){
    DataMahasiswa()
}