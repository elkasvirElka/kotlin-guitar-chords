package com.example.evira.mysongsapp.newsong

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.jetbrains.anko.support.v4.alert
import com.example.evira.mysongsapp.R
import com.example.evira.mysongsapp.models.Song
import kotlinx.android.synthetic.main.fragment_new_song.view.*
import com.example.evira.mysongsapp.App




class NewSongFragment : Fragment() {

     //lateinit var realm: Realm

    lateinit var text_info: EditText
    lateinit var title : EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_new_song, container, false)
        //realm = Realm.getDefaultInstance()

        text_info = view.text_info
        title = view.title
        view.button_add.setOnClickListener { view ->
            saveItem()
        }

        return view
    }
    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): NewSongFragment {
            val fragmentHome = NewSongFragment()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }

    }
    private fun saveItem() {
        val db = App.getInsta()!!.getDatabase()

        if (text_info.text.trim().isNotEmpty() && title.text.trim().isNotEmpty() ) {
            //todo вынести в сервис
            with(Song()){

                text  = text_info.text.toString().trim()
                title = this@NewSongFragment.title.text.toString().trim()
                db!!.employeeDao().insert(this)
            }
            /*realm.executeTransaction { realm ->
                val vehicle = realm.createObject(Song::class.java, UUID.randomUUID().mostSignificantBits)
                with(vehicle) {
                    android.util.Log.d("UUID", "for vehicle: $id")
                    text = text_info.text.toString().trim()
                    title = this@NewSongFragment.title.text.toString().trim()
                }
            }*/
            alertAdd()
        } else
            alertFill()

    }

    private fun alertAdd() {
        alert("Ваша песня успешно добавлена") {
            positiveButton("Хорошо") {
                text_info.setText("")
                this@NewSongFragment.title.setText("")
                it.dismiss()
                fragmentManager!!.popBackStack()
            }
        }.show()
    }

    private fun alertFill() {
        alert("Заполните все поля") {
            positiveButton("Хорошо") {
                it.dismiss()
            }
        }.show()
    }


 /*   companion object {
        @JvmStatic
        fun newInstance() =
            AddVehicleFragment().apply {

            }
    }*/
}
