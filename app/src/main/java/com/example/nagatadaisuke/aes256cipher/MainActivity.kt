package com.example.nagatadaisuke.aes256cipher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dbank.KotlinAES256Cipher.CipherData
import com.dbank.KotlinAES256Cipher.EnumCount
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var key = UUID.randomUUID().toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (edit_text.text.toString() != "") {
                val textArray: java.util.ArrayList<String> = arrayListOf("Test", edit_text.text.toString())
                text_view.text = CipherData().cipherData(textArray, key)[EnumCount.Test.number]
                edit_text.getEditableText().clear()
            }
        }
        button2.setOnClickListener {
            if (edit_text2.text.toString() != "") {
                val textArray: java.util.ArrayList<String> = arrayListOf("Test", edit_text2.text.toString())
                text_view.text = CipherData().cipherData(textArray, key)[EnumCount.Value.number]
                edit_text2.getEditableText().clear()
            }
        }
        button3.setOnClickListener {
            if(edit_text3.text.toString() != "") {
                val textArray: Array<String> = arrayOf(edit_text3.text.toString())
                text_view.text = CipherData().encrypt(textArray,EnumCount.Decrypt.number,key)
            }
        }
        button4.setOnClickListener {
            if(edit_text3.text.toString() != "") {
                val textArray: Array<String> = arrayOf(text_view.text.toString())
                text_view.text = CipherData().decrypt(textArray,EnumCount.Decrypt.number,key)
                edit_text3.getEditableText().clear()
                key = UUID.randomUUID().toString()
            }
        }
        button5.setOnClickListener {
            if(edit_text5.text.toString() != "") {
                val textArray: java.util.ArrayList<String> = arrayListOf("Test",edit_text5.text.toString())
                CipherData().saveText(this, key, textArray)
                text_view.text = CipherData().loadText(this, key).toString()
                edit_text5.getEditableText().clear()
            }
        }
    }
}