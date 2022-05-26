package id.polbeng.yun.listview

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.Myholder> {
    private var c: Activity? = null
    private var databuah: Array<String>? = null
    private var datagambar: Array<Int>? = null
    constructor(recylerActivity: RecylerActivity, dataBuah: Array<String>,
                dataGambar: Array<Int>) {
        c = recylerActivity
        databuah = dataBuah
        datagambar = dataGambar
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {

        holder.txt?.text = databuah?.get(position)
        holder.img?.setImageResource(datagambar?.get(position)!!)
        holder.img?.setOnClickListener {
            var intent = Intent(c, DetailBuahActivity::class.java)
            intent.putExtra("txt", databuah?.get(position))
            intent.putExtra("img", datagambar?.get(position))
            c?.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Myholder {
        var view = LayoutInflater.from(c).inflate(R.layout.list_item,
            parent, false)
        return Myholder(view)
    }

    override fun getItemCount(): Int {

        return databuah?.size!!
    }

    class Myholder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {
        var txt: TextView? = itemView?.findViewById(R.id.namabuah)
        var img: ImageView? = itemView?.findViewById(R.id.imglsitietm)
    }
}