package com.example.kotlin_foodpanda

import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_choice)
        btn.setOnClickListener() {
            val intent = Intent(this, Main2Activity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestcode: Int, resultcode: Int, data: Intent?) {
        super.onActivityResult(requestcode, resultcode, data)
        val tv_meal = findViewById<TextView>(R.id.tv_meal)

        if (data == null) return
        if (requestcode == 1) {
            if (resultcode == 101) {

                var  b = data.extras!!
                var  str1 = b.getString("drink")
                var  str2 = b.getString("sugar")
                var  str3 = b.getString("ice")

                tv_meal.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                    str1,
                    str2,
                    str3)
            }
        }
    }
}