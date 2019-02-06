package com.example.evira.mysongsapp.songList

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import com.example.evira.mysongsapp.R
import com.example.evira.mysongsapp.models.Song
import com.example.evira.mysongsapp.newsong.NewSongFragment
import com.example.evira.mysongsapp.oneSong.OneSongFragment
import kotlinx.android.synthetic.main.fragment_song_list.view.*

class SongList : Fragment(), SongListView, SongListAdapter.OnItemClickListener{

     override fun onItemClicked(model : Song) {
         val fragment = OneSongFragment.Companion.newInstance(model)
         addFragment(fragment)
    }

    override fun setSongList(list: List<Song>) {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = SongListAdapter(list, this@SongList)
        }
    }

    lateinit var recyclerView: RecyclerView
  //  lateinit var emptyView: ConstraintLayout

    lateinit var vehicles: List<Song>
    lateinit var service: SongListService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_song_list, container, false)

        service = SongListService(this)
        recyclerView = view.songList

     //   emptyView = view.emptyView

        service.getAllSongs()
        return view
    }
    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): SongList {
            val fragmentHome = SongList()
            return fragmentHome
        }

    }
    /**
     * TODO вынести в общий метод
     * add/replace fragment in container [FrameLayout]
     */
    fun addFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        // transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
     //   transaction.addToBackStack(myFragment)
        transaction.add(R.id.fragment_mainLayout, fragment).commit()

    }
}

