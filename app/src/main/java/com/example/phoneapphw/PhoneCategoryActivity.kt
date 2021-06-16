package com.example.phoneapphw

import Cache.MySharedPreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone_category.*

class PhoneCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_category)
        MySharedPreference.init(this)

        cardIphone.setOnClickListener {
            MySharedPreference.defaultValue = 1
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }

        cardSamsung.setOnClickListener {
            MySharedPreference.defaultValue = 2
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }

        cardMi.setOnClickListener {
            MySharedPreference.defaultValue = 3
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }

        cardSony.setOnClickListener {
            MySharedPreference.defaultValue = 4
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }

        cardHuawei.setOnClickListener {
            MySharedPreference.defaultValue = 5
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }

        cardArtel.setOnClickListener {
            MySharedPreference.defaultValue = 6
            startActivity(Intent(this, AddPhoneActivity::class.java))
        }
    }
}