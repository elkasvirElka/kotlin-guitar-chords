package com.example.evira.mysongsapp.oneSong

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.evira.mysongsapp.R
import com.example.evira.mysongsapp.models.Song
import com.example.evira.mysongsapp.songList.SongList
import kotlinx.android.synthetic.main.fragment_new_song.view.*
import kotlinx.android.synthetic.main.fragment_one_song.view.*
import kotlinx.android.synthetic.main.item_song_list.view.*

class OneSongFragment : Fragment() {

    companion object {
        fun newInstance(model: Song): OneSongFragment {
            val fragmentHome = OneSongFragment()
            fragmentHome.data = model
            return fragmentHome
        }

    }

    lateinit var text_info: TextView
    lateinit var title: TextView
    lateinit var data: Song

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one_song, container, false)
        //realm = Realm.getDefaultInstance()

        text_info = view.text_body
        title = view.text_title
        if (data != null) {
            text_info.setText(data.text)
            title.setText(data.title)
        }
        return view
    }

}