package com.example.kotlin_foodpanda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

class Main2Activity : AppCompatActivity() {

    var sugar = "無糖"
    var ice_opt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val rg1 = findViewById<RadioGroup>(R.id.radioGroup)
        rg1.setOnCheckedChangeListener { radioGroup, i ->
            if (R.id.radioButton1 == 1){
                sugar = "無糖"
            }
            else if(R.id.radioButton2 == 1){
                sugar = "少糖"
            }
            else if(R.id.radioButton3 == 1){
                sugar = "半糖"
            }
            else if(R.id.radioButton4 == 1){
                sugar = "全糖"
            }
        }

        val rg2 = findViewById<RadioGroup>(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { radioGroup2, i ->
            if (R.id.radioButton5 == 1){
                ice_opt = "去冰"
            }
            else if(R.id.radioButton6 == 1){
                ice_opt = "微冰"
            }
            else if(R.id.radioButton7 == 1){
                ice_opt = "少冰"
            }
            else if(R.id.radioButton8 == 1){
                ice_opt = "正常冰"
            }
        }

        val send_btn = findViewById<Button>(R.id.btn_send)
        send_btn.setOnClickListener(View.OnClickListener {
                val set_drink = findViewById<EditText>(R.id.ed_drink)
                val drink : String = set_drink.text.toString()
                val i = Intent()
                val b = Bundle()
                b.putString("sugar" , sugar)
                b.putString("drink",drink)
                b.putString("ice", ice_opt)
                i.putExtras(b)
                setResult(101,i)
                finish()
            })
        }
    }