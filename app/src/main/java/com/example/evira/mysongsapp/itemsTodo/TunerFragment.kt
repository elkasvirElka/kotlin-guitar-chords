package com.example.evira.mysongsapp.itemsTodo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.evira.mysongsapp.R
import com.example.evira.mysongsapp.models.Song

class TunerFragment : Fragment() {

    companion object {
        fun newInstance(): TunerFragment {
            val fragmentHome = TunerFragment()
             return fragmentHome
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tuner, container, false)

        return view
    }

}