import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class DataMahasiswa : ActionListener {
    var frame:JFrame = JFrame()
    var lb1:JLabel = JLabel()
    var lb2:JLabel = JLabel()
    var lb3:JLabel = JLabel()
    var lb4:JLabel = JLabel()
    var lb5:JLabel = JLabel()
    var tf1: JTextField = JTextField()
    var tf2: JTextField = JTextField()
    var tf3: JTextField = JTextField()
    var b1: JButton = JButton()

    init {
        lb1.setBounds(10,0,150,20)
        lb1.text = "Data Mahasiswa"
        lb2.setBounds(30,50,150,20)
        lb2.text = "Nama   : "
        tf1.setBounds(90,50,100,20)
        lb3.setBounds(30,90,150,20)
        lb3.text = "NIM    : "
        tf2.setBounds(90,90,100,20)
        lb4.setBounds(30,130,150,20)
        lb4.text = "Alamat : "
        tf3.setBounds(90,130,100,20)
        b1.setBounds(90,170,100,20)
        b1.text = "Input"
        b1.addActionListener(this)
        lb5.setBounds(95,240,500,20)
        lb5.text = "Data akan muncul disini"
        frame.add(lb1)
        frame.add(lb2)
        frame.add(lb3)
        frame.add(lb4)
        frame.add(tf1)
        frame.add(tf2)
        frame.add(tf3)
        frame.add(b1)
        frame.add(lb5)
        frame.setSize(900,500)
        frame.layout = null
        frame.isVisible = true
    }

    override fun actionPerformed(e: ActionEvent) {
        val s1 = tf1.text
        val s2 = tf2.text
        val s3 = tf3.text
        if (e.source == b1){
            if(s1 != "" && s2 != "" && s3 != "") {
                lb5.text = "Data Mahasiswa : $s1 dengan NIM $s2 beralamat di $s3"
            }
            else {
                lb5.text = "Data belum lengkap"
            }
        }
    }
}

fun main(){
    DataMahasiswa()
}