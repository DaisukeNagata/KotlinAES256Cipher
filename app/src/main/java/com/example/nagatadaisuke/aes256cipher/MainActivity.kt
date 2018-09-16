package com.example.nagatadaisuke.aes256cipher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if (edit_text.text != null) {
                val textArray: ArrayList<String> = arrayListOf("Test", edit_text.text.toString())
                text_view.text = CipherData().cipherData(textArray)[EnumCount.Test.number]  }
        }
        button2.setOnClickListener {
            if (edit_text2.text != null) {
                val textArray: ArrayList<String> = arrayListOf("Test", edit_text2.text.toString())
                text_view.text = CipherData().cipherData(textArray)[EnumCount.Value.number] }
        }
        button3.setOnClickListener {
            if(edit_text3.text != null) {
                val textArray: Array<String> = arrayOf(edit_text3.text.toString())
                text_view.text = CipherData().decrypt(textArray)[EnumCount.Decrypt.number]
            }
        }
    }
}
