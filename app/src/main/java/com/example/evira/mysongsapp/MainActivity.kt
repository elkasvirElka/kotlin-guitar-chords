package com.example.evira.mysongsapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.example.evira.mysongsapp.newsong.NewSongFragment
import com.example.evira.mysongsapp.songList.SongList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                val fragment = NewSongFragment.Companion.newInstance()
                addFragment(fragment)
              /*  message.setText(R.string.title_home)*/
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = SongList.Companion.newInstance()
                addFragment(fragment)
               // message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.chords -> {
              //  message.setText(R.string.chords)
                return@OnNavigationItemSelectedListener true
            }
            R.id.settings -> {
             //   message.setText(R.string.settings)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val fragmentAdapter = MainPagerAdapter(supportFragmentManager)
        navigation.adapter = fragmentAdapter*/


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = NewSongFragment.Companion.newInstance()
        addFragment(fragment)
    }
    /**
     * add/replace fragment in container [FrameLayout]
     */
     fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
