package com.taurus.modernandroiddevelopmentkata.core.sharedpreference

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class BaseSharedPreferences(key: String) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        fun init(application: Application) {
            this.context = application
        }
    }

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(key, Context.MODE_PRIVATE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    operator fun SharedPreferences.set(key: String, value: Any?) = when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }

    inline operator fun <reified T> SharedPreferences.get(key: String, defaultValue: T? = null): T =
        when (T::class) {
            String::class -> getString(key, defaultValue as? String ?: "") as T
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T
            else -> throw UnsupportedOperationException("Not yet implemented")
        }

    protected inline fun <reified T> SharedPreferences.delegation(
        prefKey: String,
        defaultValue: T
    ): ReadWriteProperty<BaseSharedPreferences, T> {
        return object : ReadWriteProperty<BaseSharedPreferences, T> {

            override fun getValue(thisRef: BaseSharedPreferences, property: KProperty<*>): T =
                this@delegation[prefKey, defaultValue]

            override fun setValue(thisRef: BaseSharedPreferences, property: KProperty<*>, value: T) {
                this@delegation[prefKey] = value
            }
        }
    }

    protected fun stringPref(prefKey: String, defaultValue: String? = null) = prefs.delegation(prefKey, defaultValue)

    protected fun intPref(prefKey: String, defaultValue: Int = 0) = prefs.delegation(prefKey, defaultValue)

    protected fun floatPref(prefKey: String, defaultValue: Float = 0f) = prefs.delegation(prefKey, defaultValue)

    protected fun booleanPref(prefKey: String, defaultValue: Boolean = false) = prefs.delegation(prefKey, defaultValue)

    protected fun longPref(prefKey: String, defaultValue: Long = 0L) = prefs.delegation(prefKey, defaultValue)
}

