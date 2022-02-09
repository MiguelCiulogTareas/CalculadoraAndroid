package ciulog.miguel.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numero1: Double = 0.0

    var oper: String = ""
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.buttonOpClear)
        val btnIgual: Button = findViewById(R.id.buttonOpEquals)

        btnIgual.setOnClickListener {
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: String = ""

            when (oper) {
                "+" -> resp = "" + (numero1 + numero2)
                "-" -> resp = "" + (numero1 - numero2)
                "*" -> resp = "" + (numero1 * numero2)
                "/" -> {
                    if (numero1 != 0.0) {
                        resp = "" + (numero1 / numero2)

                    } else {
                        resp = "ERROR"
                    }
                } //TODO validar division por 0
            }

            tv_num2.setText(resp)
            tv_num1.setText("")
            oper = ""
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = ""
        }
    }

    fun presionarDigito(view: View) {
        var num2: String = tv_num2.text.toString()

        when (view.id) {
            R.id.buttonNum0 -> tv_num2.setText(num2 + "0")
            R.id.buttonNum1 -> tv_num2.setText(num2 + "1")
            R.id.buttonNum2 -> tv_num2.setText(num2 + "2")
            R.id.buttonNum3 -> tv_num2.setText(num2 + "3")
            R.id.buttonNum4 -> tv_num2.setText(num2 + "4")
            R.id.buttonNum5 -> tv_num2.setText(num2 + "5")
            R.id.buttonNum6 -> tv_num2.setText(num2 + "6")
            R.id.buttonNum7 -> tv_num2.setText(num2 + "7")
            R.id.buttonNum8 -> tv_num2.setText(num2 + "8")
            R.id.buttonNum9 -> tv_num2.setText(num2 + "9")
            // TODO ver que no se pongan mas de 1 punto
            R.id.buttonOpDot -> {
                if (!tv_num1.toString().contains(".")) {
                    tv_num2.setText(num2 + ".")
                }
            }
        }
    }

    fun clicOperacion(view: View) {
        var num2_text: String = tv_num2.text.toString()
        numero1 = num2_text.toDouble()

        tv_num2.setText("")

        when (view.id) {
            R.id.buttonOpPlus -> {
                tv_num1.setText(num2_text + " +")
                oper = "+"
            }
            R.id.buttonOpMinus -> {
                tv_num1.setText(num2_text + " -")
                oper = "-"
            }
            R.id.buttonOpMultiply -> {
                tv_num1.setText(num2_text + " *")
                oper = "*"
            }
            R.id.buttonOpDivide -> {
                tv_num1.setText(num2_text + " /")
                oper = "/"
            }
        }

    }

}