package com.example.nagatadaisuke.aes256cipher

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.zip.Inflater

class CipherData {

    fun cipherData(textArray: ArrayList<String>): Array<String> {
        val buffer = StringBuilder()
        val key = UUID.randomUUID().toString()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var base64Text: String
        var cipherData: ByteArray

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, textArray.toString().toByteArray(charset("UTF-8")))
        base64Text = Base64.getEncoder().encodeToString(cipherData)
        cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(base64Text))

        val array = arrayOfNulls<String>(cipherData.size)
        textArray.toArray(array)

        return textArray.toArray(array)
    }

    fun decrypt(textArray: Array<String>): Array<String> {
        val buffer = StringBuilder()
        val key = UUID.randomUUID().toString()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var base64Text: String
        var cipherData: ByteArray

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, textArray.contentToString().toByteArray(charset("UTF-8")))
        base64Text = Base64.getEncoder().encodeToString(cipherData)

        return arrayOf(base64Text)
    }
}