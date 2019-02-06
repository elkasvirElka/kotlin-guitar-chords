package com.example.evira.mysongsapp.itemsTodo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.evira.mysongsapp.R

class ChordsFragment : Fragment(){
    companion object {
        fun newInstance(): ChordsFragment {
            val fragmentHome = ChordsFragment()
            return fragmentHome
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chords, container, false)
        //realm = Realm.getDefaultInstance()


        return view
    }
}