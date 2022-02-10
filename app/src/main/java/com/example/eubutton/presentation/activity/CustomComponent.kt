package com.example.eubutton.presentation.activity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.marginTop
import com.example.eubutton.R

import android.graphics.drawable.Drawable
import android.hardware.camera2.params.ColorSpaceTransform


class CustomComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context,attrs,defStyleAttr){

    var  quantity : Int = 0
    var passed = 0
    var whiteColor : Int = 0
    var greenColor : Int = 0
    var grayColor : Int = 0

    private val paint = Paint().apply {
        style = Paint.Style.FILL
    }







    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val x = x
        val y = y
        val width = this.width

        paint.strokeWidth = 15.0f

        val div = width/(quantity+1)
        var antcx = 0.0f
        if(passed <= quantity){
            for (i in 1..quantity) {
                val cx = x + (div * i)
                if(i < passed+1){
                    paint.color = greenColor
                    canvas?.drawLine(x, y,cx-25, y, paint)
                    canvas?.drawCircle(cx,y,25.0f,paint)
                }else if(i == passed+1){
                    paint.color = greenColor
                    canvas?.drawLine(x, y,cx-25, y, paint)
                    canvas?.drawCircle(cx,y,25.0f,paint)
                    paint.color = whiteColor
                    canvas?.drawCircle(cx,y,13.0f,paint)
                } else {
                    paint.color = grayColor
                    canvas?.drawLine(antcx+25, y,cx-25, y, paint)
                    canvas?.drawCircle(cx,y,25.0f,paint)

                }
                antcx = cx
            }
            if(quantity == passed){
                paint.color = greenColor
                canvas?.drawLine(antcx+25, y,width.toFloat(), y, paint)
            } else {
                paint.color = grayColor
                canvas?.drawLine(antcx+25, y,width.toFloat(), y, paint)
            }
        } else {
            for (i in 1..quantity) {
                val cx = x + (div * i)
                paint.color = greenColor
                canvas?.drawLine(x, y, x + width, y, paint)
                canvas?.drawCircle(cx, y, 25.0f, paint)
            }
        }



    }
//
//    private fun drawableToBitmap(draw : Drawable) : Bitmap {
//        val bitmap = Bitmap.createBitmap(draw.intrinsicWidth,draw.intrinsicHeight, Bitmap.Config.ARGB_8888)
//        val can = Canvas(bitmap)
//        draw.draw(can)
//        return bitmap
//    }


}