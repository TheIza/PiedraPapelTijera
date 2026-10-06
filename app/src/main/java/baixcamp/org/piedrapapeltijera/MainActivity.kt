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
    //1 piedra 2 papel 3 tijera
    var seleccionadoTu: Int = 0
    var seleccionadoCPU: Int = 0

    var contadorPuntTu: Int = 0
    var contadorPuntCPU: Int = 0
    var contadorEmpates: Int = 0


    var imgTu: ImageView = findViewById(R.id.iv_tu)
    var imgCPU: ImageView = findViewById(R.id.iv_CPU)

    var resultado: TextView = findViewById(R.id.tv_qnGana)

    var botPiedra: Button = findViewById(R.id.bt_piedra)
    var botPapel: Button = findViewById(R.id.bt_papel)
    var botTijera: Button = findViewById(R.id.bt_tijera)
    var botReiniciar: Button = findViewById(R.id.bt_reiniciar)

    var puntTu: TextView = findViewById(R.id.tv_puntTu)
    var puntCPU: TextView = findViewById(R.id.tv_puntCPU)
    var cantEmpates: TextView = findViewById(R.id.tv_empates)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        botPiedra.setOnClickListener {
            imgTu.setImageResource(R.drawable.piedra)
            seleccionadoTu = 1

            //funcion aletorio de enemigo
            seleccionadoCPU = aleatorioCPU()
            //comparacion de selecciones


        }




    }

    fun aleatorioCPU(): Int {
        return (1..3).random()
    }

    fun quienGana(tu: Int, CPU: Int){

        if(( tu == 1 && CPU == 1) || ( tu == 2 && CPU == 2) || ( tu == 3 && CPU == 3)){
            //empate
            contadorEmpates += 1
            resultado.text = "EMPATE"
        } 

    }
}