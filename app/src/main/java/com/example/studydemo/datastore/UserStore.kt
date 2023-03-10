package com.example.studydemo.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserStore(private val context: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

        val USER_NAME = stringPreferencesKey("userName")

        val USER_CODE = intPreferencesKey("userCode")
    }

    fun getStoreForUserName(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_NAME] ?: "Default"
        }
    }

    suspend fun save(userName: String) {
        context.dataStore.edit { settings ->
            settings[USER_NAME] = userName
        }
    }

    suspend fun clear() {
        context.dataStore.edit {
            it.clear()
        }
    }
}
