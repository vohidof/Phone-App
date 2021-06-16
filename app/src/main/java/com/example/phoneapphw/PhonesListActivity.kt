package com.example.phoneapphw

import Adapter.MyAdapterIphone
import Adapter.MyAdapterSamsung
import Cache.MySharedPreference
import Cache.MySharedPreferenceIphone
import Cache.MySharedPreferenceSamsung
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phones_list.*

class PhonesListActivity : AppCompatActivity() {

    lateinit var myAdapterIphone: MyAdapterIphone
    lateinit var myAdapterSamsung: MyAdapterSamsung

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones_list)

        MySharedPreferenceIphone.init(this)
        MySharedPreferenceSamsung.init(this)
        MySharedPreference.init(this)


        if (MySharedPreference.defaultValue == 1) {
            val listIphone = MySharedPreferenceIphone.obektString
            myAdapterIphone = MyAdapterIphone(this, listIphone)
            listPhones.adapter = myAdapterIphone
        } else if (MySharedPreference.defaultValue == 2) {
            val listSamsung = MySharedPreferenceSamsung.obektString
            myAdapterSamsung = MyAdapterSamsung(this, listSamsung)
            listPhones.adapter = myAdapterSamsung
        }


        listPhones.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, PhonesInfoActivity::class.java)
            if(listPhones.adapter == myAdapterIphone){
                intent.putExtra("positionIphone", position)
            }else if(listPhones.adapter == myAdapterSamsung){
                intent.putExtra("positionSamsung", position)
            }
            startActivity(intent)
        }
    }
}