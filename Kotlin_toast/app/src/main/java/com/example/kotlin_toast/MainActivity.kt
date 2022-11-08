package com.example.kotlin_toast

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(){
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
                .setMessage("請根據下方接鈕選擇要顯示的物件")

            dialog.setNeutralButton("取消", DialogInterface.OnClickListener(){ dialog, which ->
                Toast.makeText(this, "dialog開關", Toast.LENGTH_SHORT).show()
            })

            dialog.setNegativeButton("自訂義Toast", DialogInterface.OnClickListener(){ dialog, which ->
                showToast()
            })

            dialog.setPositiveButton("顯示List", DialogInterface.OnClickListener(){ dialog, which ->
                showListDialog()
            })
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.duration = Toast.LENGTH_SHORT;
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast,  findViewById<ViewGroup>(R.id.toast));
        toast.setView(layout);
        toast.show();
    }

    private fun showListDialog() {
        val list = arrayOf("messsage1", "messsage2", "messsage3", "messsage4", "messsage5")
        val dialog_list = AlertDialog.Builder(this)
        dialog_list.setTitle("使用LIST呈現");
        dialog_list.setItems(list, DialogInterface.OnClickListener() { dialog_list, i ->
                Toast.makeText(this, "你選得是" + list[i], Toast.LENGTH_SHORT).show();
        })
        dialog_list.show();
    }
}