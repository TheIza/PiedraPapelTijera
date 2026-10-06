package baixcamp.org.piedrapapeltijera

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 1 piedra 2 papel 3 tijera
    var seleccionadoTu: Int = 0
    var seleccionadoCPU: Int = 0

    var contadorPuntTu: Int = 0
    var contadorPuntCPU: Int = 0
    var contadorEmpates: Int = 0

    lateinit var imgTu: ImageView
    lateinit var imgCPU: ImageView

    lateinit var resultado: TextView

    lateinit var botPiedra: Button
    lateinit var botPapel: Button
    lateinit var botTijera: Button
    lateinit var botReiniciar: Button

    lateinit var puntTu: TextView
    lateinit var puntCPU: TextView
    lateinit var cantEmpates: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }



        imgTu = findViewById(R.id.iv_tu)
        imgCPU = findViewById(R.id.iv_CPU)

        imgTu.setImageResource(R.drawable.fondo)
        imgCPU.setImageResource(R.drawable.fondo)

        resultado = findViewById(R.id.tv_qnGana)

        botPiedra = findViewById(R.id.bt_piedra)
        botPapel = findViewById(R.id.bt_papel)
        botTijera = findViewById(R.id.bt_tijera)
        botReiniciar = findViewById(R.id.bt_reiniciar)

        puntTu = findViewById(R.id.tv_puntTu)
        puntCPU = findViewById(R.id.tv_puntCPU)
        cantEmpates = findViewById(R.id.tv_empates)

        botPiedra.setOnClickListener {
            imgTu.setImageResource(R.drawable.piedra)
            seleccionadoTu = 1

            seleccionadoCPU = aleatorioCPU()

            quienGana(tu = seleccionadoTu, CPU = seleccionadoCPU)
        }

        botPapel.setOnClickListener {
            imgTu.setImageResource(R.drawable.papel)
            seleccionadoTu = 2

            seleccionadoCPU = aleatorioCPU()

            quienGana(tu = seleccionadoTu, CPU = seleccionadoCPU)
        }

        botTijera.setOnClickListener {
            imgTu.setImageResource(R.drawable.tijera)
            seleccionadoTu = 3

            seleccionadoCPU = aleatorioCPU()

            quienGana(tu = seleccionadoTu, CPU = seleccionadoCPU)
        }
        botReiniciar.setOnClickListener {

            imgTu.setImageResource(R.drawable.fondo)
            imgCPU.setImageResource(R.drawable.fondo)

            contadorPuntCPU = 0
            contadorPuntTu = 0
            contadorEmpates = 0

            puntTu.text = "Tú: " + contadorPuntTu.toString()
            puntCPU.text = "CPU: " + contadorPuntCPU.toString()
            cantEmpates.text = "Empates: " + contadorEmpates.toString()

            resultado.text = "reiniciado"

        }

    }

    fun aleatorioCPU(): Int {
        val seleccion: Int = (1..3).random()

        if (seleccion == 1) {
            imgCPU.setImageResource(R.drawable.piedra)
        } else if (seleccion == 2) {
            imgCPU.setImageResource(R.drawable.papel)
        } else if (seleccion == 3) {
            imgCPU.setImageResource(R.drawable.tijera)
        }

        return seleccion
    }

    fun quienGana(tu: Int, CPU: Int) {

        if ((tu == 1 && CPU == 1) ||
            (tu == 2 && CPU == 2) ||
            (tu == 3 && CPU == 3)
        ) {
            // empate
            contadorEmpates += 1
            resultado.text = "EMPATE"
            cantEmpates.text = "Empates: " + contadorEmpates.toString()

        } else if (tu == 1 && CPU == 3) {
            // ganas con piedra
            contadorPuntTu += 1
            resultado.text = "¡GANAS!"
            puntTu.text = "Tú: " + contadorPuntTu.toString()

        } else if (CPU == 1 && tu == 3) {
            // pierdes por piedra
            contadorPuntCPU += 1
            resultado.text = "...PIERDES..."
            puntCPU.text = "CPU: " + contadorPuntCPU.toString()

        } else if (tu == 2 && CPU == 1) {
            // ganas con papel
            contadorPuntTu += 1
            resultado.text = "¡GANAS!"
            puntTu.text = "Tú: " + contadorPuntTu.toString()

        } else if (CPU == 2 && tu == 1) {
            // pierdes por papel
            contadorPuntCPU += 1
            resultado.text = "...PIERDES..."
            puntCPU.text = "CPU: " + contadorPuntCPU.toString()

        } else if (tu == 3 && CPU == 2) {
            // ganas con tijera
            contadorPuntTu += 1
            resultado.text = "¡GANAS!"
            puntTu.text = "Tú: " + contadorPuntTu.toString()

        } else if (CPU == 3 && tu == 2) {
            // pierdes por tijera
            contadorPuntCPU += 1
            resultado.text = "...PIERDES..."
            puntCPU.text = "CPU: " + contadorPuntCPU.toString()

        }
    }


}