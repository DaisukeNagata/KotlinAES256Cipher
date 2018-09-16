package com.example.nagatadaisuke.aes256cipher

import java.util.*

class CipherData {

    fun cipherData(plainText: String): Array<String> {
        val buffer = StringBuilder()
        val key = UUID.randomUUID().toString()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }
        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))

        var plain = plainText
        var cipherData: ByteArray
        var base64Text: String

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, plainText.toByteArray(charset("UTF-8")))
        base64Text = Base64.getEncoder().encodeToString(cipherData)

        cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(base64Text))
        plain = String(cipherData)

        val stringArray: Array<String> = arrayOf(base64Text, plain)
        return stringArray
    }
}