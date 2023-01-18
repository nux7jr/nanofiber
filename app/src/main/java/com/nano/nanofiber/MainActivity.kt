package com.nano.nanofiber

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.nano.nanofiber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        var start_main_nano:Boolean=true
        Thread{
            while (start_main_nano){
                Thread.sleep(3000)
                runOnUiThread {
                    val intent = Intent(this, MainNanoFiber::class.java)
                    startActivity(intent)
                }
                start_main_nano = false
            }
        }.start()

    }
}
