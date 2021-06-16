package com.example.phoneapphw

import Cache.MySharedPreference
import Cache.MySharedPreferenceIphone
import Cache.MySharedPreferenceSamsung
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phones_info.*

class PhonesInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones_info)
        supportActionBar?.hide()

        MySharedPreference.init(this)
        MySharedPreferenceIphone.init(this)
        MySharedPreferenceSamsung.init(this)

        val listIphone = MySharedPreferenceIphone.obektString
        val listSamsung = MySharedPreferenceSamsung.obektString

        val positions = intent.getIntExtra("position", 0)

        if (MySharedPreference.defaultValue == 1) {
            txtShowTitle.text = listIphone[positions].nameIphone

            txtShowInfo.text = listIphone[positions].informationIphone
        } else if (MySharedPreference.defaultValue == 2) {
            txtShowTitle.text = listSamsung[positions].nameSamsung

            txtShowInfo.text = listSamsung[positions].informationSamsung
        }

    }
}