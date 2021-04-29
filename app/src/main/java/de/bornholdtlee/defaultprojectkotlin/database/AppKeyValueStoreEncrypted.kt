package de.bornholdtlee.defaultprojectkotlin.database

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import de.bornholdtlee.defaultprojectkotlin.R

class AppKeyValueStoreEncrypted(context: Context) {

    private companion object {
        const val EXAMPLE = "example"
    }

    private val masterKeyAlias = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
    private val sharedPreferencesReader = EncryptedSharedPreferences.create(
        context,
        context.getString(R.string.app_name) + "_encrypted",
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    private val sharedPreferencesWriter: SharedPreferences.Editor = sharedPreferencesReader.edit()

    var qloudAuthToken: String
        get() = getString(EXAMPLE, "")
        set(value) = putString(EXAMPLE, value)

    private fun putString(key: String, value: String) = sharedPreferencesWriter.putString(key, value).apply()

    fun remove(key: String) = sharedPreferencesWriter.remove(key).apply()
    fun removeAll() = sharedPreferencesWriter.clear().apply()

    private fun getString(key: String, defaultValue: String): String = sharedPreferencesReader.getString(key, defaultValue) ?: defaultValue
}
