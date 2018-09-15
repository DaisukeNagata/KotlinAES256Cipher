package com.example.nagatadaisuke.aes256cipher

import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.InvalidAlgorithmParameterException


object AES256Cipher {

    @Throws(java.io.UnsupportedEncodingException::class, NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class, InvalidAlgorithmParameterException::class, IllegalBlockSizeException::class, BadPaddingException::class)
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

    @Throws(java.io.UnsupportedEncodingException::class, NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class, InvalidAlgorithmParameterException::class, IllegalBlockSizeException::class, BadPaddingException::class)
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