package com.nano.nanofiber


import android.R
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Half.toFloat
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nano.nanofiber.databinding.ActivityMainNanoFiberBinding


//модель фильтра, цвет фильтра, цвет профиля, ширина, высота, применяемая скидка.

class MainNanoFiber : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainNanoFiberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainNanoFiberBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)




        // Обработка нажатия на бтн

        bindingClass.button.setOnClickListener {

            val width = bindingClass.edTextWidth.text
                 // Получили данные с edText(Цвет Ширина)

            val height = bindingClass.edTextHeight.text // Получили данные с edText(Высота)

            if (width.toString() != "" && height.toString() != "") {

                val modelFilterPrice = 6970.18f   // профиль
                val jumper = 268.61f    //перемычка
                val corner = 60f    // уголок
                val handle = 60f    //ручка
                val jumpermm: Float = width.toString().toFloat()    //перемычка в мм
                val yardage: Float = width.toString().toFloat() * height.toString().toFloat()   //площадь
                val profileLength: Float = (width.toString().toFloat() + height.toString().toFloat()) * 2  //длина профиля
                val canvas: Float = yardage * modelFilterPrice   //полотно

                // Обработка
                val color_profile = bindingClass.colorFilterProfile
                val color_profile_selected =
                    color_profile.selectedItem.toString() // Получили данные со спиннера(Цвет профиля)

                val qwe: Float = if (color_profile_selected ==
                    "Коричневый внутренний" || color_profile_selected == "Белый внутренний"
                ) {
                    630.3f
                } else {
                    309.96f
                }

                val profile: Float = profileLength * qwe   //профиль из выборки (ПРИСВОЕНИЕ)
                val jumper2: Float = jumper * jumpermm   //перемычка
                val corner4: Float = corner * 4  //уголок
                val handle2: Float = handle * 2   //ручка
                val price = canvas + profile + jumper2 + corner4 + handle2



                bindingClass.result.text = price.toString()
                bindingClass.tvResult.setTextColor(Color.parseColor("#000000"))
                bindingClass.tvResult.text = "Стоимость:"
            }

            else {
                bindingClass.tvResult.text = "Заполните поля Ширина и Высота!"
                bindingClass.tvResult.setTextColor(Color.parseColor("#FF0000"))
            }
        }

        bindingClass.button2.setOnClickListener {
            val discond = bindingClass.edTextDiscount.text
            val discond2 = bindingClass.result.text

            if (discond.toString() != "") {
                val discond3 = (discond2.toString().toFloat() / 100) * discond.toString().toFloat()
                val discondResutl = discond2.toString().toFloat() - discond3
                bindingClass.result.text = discondResutl.toString()
            }else
            {
                bindingClass.result.text = discond2.toString()
            }
        }

    }
}
















