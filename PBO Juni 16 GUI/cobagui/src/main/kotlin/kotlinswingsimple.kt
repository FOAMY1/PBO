import java.awt.Color
import java.awt.GradientPaint
import javax.swing.*


class Simple {
    private var f: JFrame = JFrame("Contoh Label dan Button")

    init {
        val l1 = JLabel("Ini Label.")
        l1.setBounds(50, 50, 100, 30)
        val l2 = JLabel("Ini Label ke 2.")
        l2.setBounds(50, 100, 100, 30)
        f.add(l1)
        f.add(l2)
        val b = JButton("Ini Button")
        b.background = Color.red
        b.foreground = Color.white
        b.addActionListener { l2.text = "Button ganti text" }
        b.setBounds(150, 100, 200, 40)
        f.add(b)
        f.setSize(400, 500)
        f.layout = null
        f.isVisible = true
    }

}
fun main() {
    Simple()
}