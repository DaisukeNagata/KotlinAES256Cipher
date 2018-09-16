package com.example.nagatadaisuke.aes256cipher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(edit_text.text != null){
                text_view.text = CipherData().cipherData(arrayOf(edit_text.text.toString()))[0]
            }
        }
    }
}
