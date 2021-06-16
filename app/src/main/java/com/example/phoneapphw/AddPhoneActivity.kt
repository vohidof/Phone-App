package com.example.phoneapphw

import Cache.MySharedPreference
import Cache.MySharedPreferenceIphone
import Cache.MySharedPreferenceSamsung
import Utils.ModelIphone
import Utils.ModelSamsung
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_phone.*

class AddPhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)

        title = "Add Phone"

        MySharedPreference.init(this)
        MySharedPreferenceIphone.init(this)
        MySharedPreferenceSamsung.init(this)

        btnSave.setOnClickListener {
            val name = edtPhoneName.text.toString().trim()
            val info = edtInformation.text.toString().trim()

            if (MySharedPreference.defaultValue == 1) {
                val list = MySharedPreferenceIphone.obektString
                list.add(ModelIphone(name, info))
                MySharedPreferenceIphone.obektString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            } else if (MySharedPreference.defaultValue == 2) {
                val list = MySharedPreferenceSamsung.obektString
                list.add(ModelSamsung(name, info))
                MySharedPreferenceSamsung.obektString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

