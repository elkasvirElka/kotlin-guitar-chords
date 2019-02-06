package com.example.evira.mysongsapp.songList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.evira.mysongsapp.R
import com.example.evira.mysongsapp.models.Song
import kotlinx.android.synthetic.main.item_song_list.view.*

class SongListAdapter(
    private val mValues: List<Song>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SongListAdapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClicked(vehicle: Song)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song_list, parent, false)

        return ViewHolder(view)
    }


    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.textCategory.text = "#мураками #364 #до рассвета"
        holder.textTitle.text = mValues[position].title
        holder.textBody.text = mValues[position].text
        holder.textSum.text = mValues[position].id.toString()
        holder.textDate.text = "24.01.2019"



        holder.mView.setOnClickListener {
            listener.onItemClicked(item)
         /*   holder.mView.context.alert("Удалить этот автомобиль?") {
                positiveButton("Да!") {
                    listener.onItemClicked(item)
                }
                negativeButton("Нет") {
                    it.dismiss()
                }
            }.show()*/
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val textCategory: TextView = mView.textCategory
        val textTitle: TextView = mView.textTitle
        val textBody: TextView = mView.textBody
        val textSum: TextView = mView.textSum
        val textDate: TextView = mView.textDate
    }
}