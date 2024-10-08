package com.example.mygame.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.example.mygame.model.Records
import com.google.gson.Gson

class MySharedPreferences {

    companion object {
        private var INSTANCE: SharedPreferences? = null


        fun getInstance(context: Context): SharedPreferences {
            if (INSTANCE == null) {
                INSTANCE = context.getSharedPreferences("records", Context.MODE_PRIVATE)
            }
            return INSTANCE!!
        }
    }
}