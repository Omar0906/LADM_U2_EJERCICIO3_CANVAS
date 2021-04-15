package mx.tecnm.tepic.ladm_u2_ejercicio3_canvas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View
var textoX :Float = 0f
var solX :Float = 0f
class Lienzo(p:MainActivity) : View(p) {
    fun getView():View{
        return this
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val pincel = Paint();
        //Fondo
        c.drawColor(Color.parseColor("#CEF6FF"))
        //Montañas
        pincel.color=Color.parseColor("#81B339")
        c.drawCircle(720f,1520f,800f,pincel)
        pincel.color=Color.parseColor("#BAD433")
        c.drawCircle(0f,1520f,720f,pincel)

        //ArbolCerca
        pincel.color = Color.parseColor("#A26523")
        pincel.strokeWidth = 2f
        c.drawRect(90f,1100f,150f,1260f,pincel)
        pincel.color = Color.parseColor("#269639")
        c.drawOval(65f,1020f,165f,1115f,pincel)
        c.drawOval(69f,1000f,135f,1080f,pincel)
        c.drawOval(89f,1000f,155f,1080f,pincel)
        c.drawOval(109f,1000f,185f,1080f,pincel)
        c.drawOval(109f,1060f,185f,1120f,pincel)
        c.drawOval(109f,1040f,185f,1100f,pincel)
        //ArbolFondo
        pincel.color = Color.parseColor("#A26523")
        pincel.strokeWidth = 2f
        c.drawRect(610f,620f,660f,760f,pincel)
        pincel.color = Color.parseColor("#269639")
        c.drawOval(580f,590f,640f,640f,pincel)
        c.drawOval(580f,560f,650f,620f,pincel)
        c.drawOval(610f,590f,670f,650f,pincel)
        c.drawOval(610f,570f,690f,640f,pincel)
        c.drawOval(620f,580f,690f,650f,pincel)
        c.drawOval(610f,560f,680f,630f,pincel)
        //Casas
        pincel.color = Color.parseColor("#F7C97B")
        c.drawRect(300f,1120f,450f,1260f,pincel)
        pincel.color = Color.parseColor("#C86168")
        c.drawRect(315f,1200f,350f,1260f,pincel)
        pincel.color = Color.parseColor("#1F7EBA")
        c.drawCircle(400f,1200f,20f,pincel)
        pincel.color = Color.parseColor("#E5474A")
        pincel.style = Paint.Style.FILL
        var poligono = Path()
        poligono.moveTo(280f,1140f)
        poligono.lineTo(470f,1140f)
        poligono.lineTo(460f,1070f)
        poligono.lineTo(290f,1070f)
        poligono.lineTo(280f,1140f)
        c.drawPath(poligono,pincel)
        pincel.color = Color.BLACK
        pincel.textSize = 40f
        c.drawText("Oswaldo Rivera",textoX,400f,pincel)
        //Sol
        sol(solX,200f,c,pincel)
    }
    private fun sol(posX:Float,posY:Float,canv:Canvas,pinter:Paint){
        //Sol
        pinter.color = Color.parseColor("#FFE52D")
        canv.drawCircle(posX,posY,100f,pinter)
        //canv.drawCircle(200f,250f,100f,pinter)
        //Ojos
        pinter.color = Color.BLACK
        canv.drawLine((posX-25f),posY+5f,posX-25f,posY-45f,pinter)
        canv.drawLine(posX+25f,posY+5f,posX+25f,posY-45f,pinter)
        //Boca
        canv.drawArc(posX-40f,posY-30f,posX+40f,posY+50f,30f,100f,false,pinter)
        //Lineas del sol
        pinter.color = Color.YELLOW
        pinter.strokeWidth = 5f
        canv.drawLine(posX,(posY-110f),posX,posY-150f,pinter)
        canv.drawLine(posX,posY+110f,posX,posY+150f,pinter)
        canv.drawLine(posX-120f,posY,posX-160f,posY,pinter)
        canv.drawLine(posX+120f,posY,posX+160f,posY,pinter)

        canv.drawLine(posX-90f,posY-70f,posX-125f,posY-115f,pinter)
        canv.drawLine(posX-90f,posY+70f,posX-125f,posY+115f,pinter)

        canv.drawLine(posX+90f,posY-70f,posX+125f,posY-115f,pinter)
        canv.drawLine(posX+90f,posY+70f,posX+125f,posY+115f,pinter)
    }
}
class Hilo(lienzo : View):Thread(){
    var canvas = lienzo
    var bandera = true
    override fun run() {
        super.run()
        while(bandera){
            if(textoX>600f){
                textoX = 0f
                solX = 0f
            }
            textoX += 60f
            solX += 60f
            canvas.invalidate()
            sleep(600)
        }
    }
}