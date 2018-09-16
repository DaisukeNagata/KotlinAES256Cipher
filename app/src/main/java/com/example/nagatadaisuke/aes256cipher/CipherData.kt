package com.example.nagatadaisuke.aes256cipher

import java.util.*

class CipherData {

    fun cipherData(textArray: Array<String>): Array<String> {
        val buffer = StringBuilder()
        val key = UUID.randomUUID().toString()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var base64Text: String
        var cipherData: ByteArray

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, textArray[0].toByteArray(charset("UTF-8")))
        base64Text = Base64.getEncoder().encodeToString(cipherData)
        cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(base64Text))

        val stringArray: Array<String> = arrayOf(base64Text, String(cipherData))
        return stringArray
    }
}