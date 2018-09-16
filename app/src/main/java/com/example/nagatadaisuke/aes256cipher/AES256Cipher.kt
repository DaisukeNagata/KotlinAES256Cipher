package com.example.nagatadaisuke.aes256cipher

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


object AES256Cipher {

    fun encrypt(ivBytes: ByteArray, keyBytes: ByteArray, textBytes: ByteArray): ByteArray {
        val ivSpec = IvParameterSpec(ivBytes)
        val newKey = SecretKeySpec(keyBytes, "AES")
        var cipher: Cipher? = null
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        try {
            cipher!!.init(Cipher.ENCRYPT_MODE, newKey, ivSpec)
        } catch (e: Exception) {
            println(e.message)
        }
        return cipher.doFinal(textBytes)
    }

    fun decrypt(ivBytes: ByteArray, keyBytes: ByteArray, textBytes: ByteArray): ByteArray {

        val ivSpec = IvParameterSpec(ivBytes)
        val newKey = SecretKeySpec(keyBytes, "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        try {
            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec)
        } catch (e: Exception) {
            println(e.message)
        }
        return cipher.doFinal(textBytes)
    }
}