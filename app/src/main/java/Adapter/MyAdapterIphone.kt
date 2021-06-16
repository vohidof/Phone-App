package Adapter

import Utils.ModelIphone
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phoneapphw.R
import kotlinx.android.synthetic.main.item.view.*

class MyAdapterIphone(context: Context, val list:List<ModelIphone>):
    ArrayAdapter<ModelIphone>(context, R.layout.item, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        }else{
            itemView = convertView
        }
        itemView.txt_name.text = list[position].nameIphone

        return itemView
    }
}