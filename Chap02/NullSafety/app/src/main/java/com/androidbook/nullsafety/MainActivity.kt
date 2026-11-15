package com.androidbook.nullsafety

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var name1: String? = "John"
        name1 = null
        Log.d("코틀린 : Nullable", "name1 = $name1")

        val name2: String? = "John"
        val length2 = name2?.length
        Log.d("코틀린 : 널 안전 호출 연산자", "length2 = $length2")

        val name3: String? = null
        val length3 = name3?.length
        Log.d("코틀린 : 널 안전 호출 연산자", "length3 = $length3")

        val name4: String? = null
        val length4 = name4?.length ?: 0
        Log.d("코틀린 : 엘비스 연산자", "length4 = $length4")

        val name5: String? = "John"
        val length5 = name5!!.length
        Log.d("코틀린 : 강제 호출 연산자", "length5 = $length5")

        val name6: String? = "John"
        name6?.let {
            Log.d("코틀린 : let", "이름의 길이는 ${it.length}입니다.")
        }
    }
}
