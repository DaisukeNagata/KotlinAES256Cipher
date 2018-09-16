package com.example.nagatadaisuke.aes256cipher

import java.util.*
import android.content.Context
import android.preference.PreferenceManager
import org.json.JSONArray
import org.json.JSONException
import android.text.TextUtils


class CipherData {

    val key = UUID.randomUUID().toString()
    fun cipherData(textArray: ArrayList<String>): Array<String> {
        val buffer = StringBuilder()

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