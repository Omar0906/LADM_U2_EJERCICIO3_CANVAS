package mx.tecnm.tepic.ladm_u2_ejercicio3_canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var canvas = Lienzo(this)
        setContentView(canvas)
        var hilo = Hilo(canvas.getView())
        hilo.start()
    }
}