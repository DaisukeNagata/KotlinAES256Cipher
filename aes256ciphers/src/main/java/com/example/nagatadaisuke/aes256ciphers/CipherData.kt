package com.dbank.KotlinAES256Cipher

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.preference.PreferenceManager
import android.text.TextUtils
import org.json.JSONArray
import org.json.JSONException
import java.util.Base64
import java.util.Base64.getEncoder
import kotlin.collections.ArrayList

class CipherData() {

    fun cipherData(textArray: ArrayList<String>,key: String): Array<String> {
        val buffer = StringBuilder()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var base64Text: String
        var cipherData: ByteArray

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, textArray.toString().toByteArray(charset("UTF-8")))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            base64Text = getEncoder().encodeToString(cipherData)
            cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(base64Text))
        } else {
            base64Text = android.util.Base64.encodeToString(cipherData,0)
            cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, android.util.Base64.decode(base64Text,0))
        }

        val array = arrayOfNulls<String>(cipherData.size)
        textArray.toArray(array)

        return textArray.toArray(array)
    }

    fun encrypt(textArray: Array<String>, type: Int, key: String): String {
        val buffer = StringBuilder()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var base64Text = ""
        var cipherData: ByteArray

        cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, textArray[type].toByteArray(charset("UTF-8")))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            base64Text = getEncoder().encodeToString(cipherData)
        } else {
            base64Text = android.util.Base64.encodeToString(cipherData,0)
        }

        return base64Text
    }

    fun decrypt(textArray: Array<String>,type: Int, key: String): String {
        val buffer = StringBuilder()
        val keySplit = key.split("-")

        val ivBytes = ByteArray(16)
        keySplit.forEach { buffer.append(it) }

        val keyBytes = buffer.toString().toByteArray(charset("UTF-8"))
        var cipherData: ByteArray

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, Base64.getDecoder().decode(textArray[type]))
        } else {
            cipherData = AES256Cipher.decrypt(ivBytes, keyBytes, android.util.Base64.decode(textArray[type],0))
        }
        val cipherSt = String(cipherData)

        return cipherSt
    }

    fun saveText(context: Context?, key: String, items: ArrayList<String>) {
        val json = JSONArray(items).toString()
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        pref.edit().putString(key, json).commit()
    }

    fun loadText(context: Context?, key: String): ArrayList<String> {
        val items = ArrayList<String>()
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val json = pref.getString(key, "")
        if (!TextUtils.isEmpty(json)) {
            try {
                val arr = JSONArray(json)
                for (i in 0 until arr.length()) {
                    items.add(arr.getString(i))
                }
            } catch (e: JSONException) {
            }
        }
        return items
    }
}