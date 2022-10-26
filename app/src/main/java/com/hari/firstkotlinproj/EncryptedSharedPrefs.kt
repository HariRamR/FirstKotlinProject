package com.hari.firstkotlinproj

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import kotlin.random.Random

class EncryptedSharedPrefs: AppCompatActivity() {

//    AppComponentActivity vs ComponentActivity
    companion object EncryptedComp{

    private const val fileName = "SharedFile"
    private const val keyName = "KeyName"
}
    private val masterKey by lazy {

        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }

    private val pref: SharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            fileName,
            masterKey,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(keyName, "Some New Key ${Random.nextInt(10000)}")
        editor.apply()
    }
}