package com.example.evira.mysongsapp.itemsTodo

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.evira.mysongsapp.R
import kotlinx.android.synthetic.main.fragment_tuner.view.*
import com.example.evira.mysongsapp.models.Song

class TunerFragment : Fragment() {

    lateinit var playEButton: Button
    lateinit var playAButton: Button
    lateinit var playDButton: Button
    lateinit var playGButton: Button
    lateinit var playBButton: Button
    lateinit var playESmallButton: Button

    private var soundpool: SoundPool? = null
    private var soundsmap: SparseIntArray? = null
    private val SixthStringE = 6
    private val FifthStringA = 5
    private val FourthStringD = 4
    private val ThirdStringG = 3
    private val SecondStringB = 2
    private val FirstStringESmall = 1

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
        playEButton = view.playEButton
        playAButton = view.playAButton
        playDButton = view.playDButton
        playGButton = view.playGButton
        playBButton = view.playBButton
        playESmallButton = view.playESmallButton

        soundpool = SoundPool(6, AudioManager.STREAM_MUSIC, 100)
        soundsmap = SparseIntArray()
        soundsmap!!
            .put(SixthStringE, soundpool!!.load(activity, R.raw.six_string_e, 1))
        soundsmap!!.put(
            FifthStringA,
            soundpool!!.load(activity, R.raw.fifth_string_a, 1)
        )
        soundsmap!!.put(
            FourthStringD,
            soundpool!!.load(activity, R.raw.fourth_string_d, 1)
        )
        soundsmap!!.put(
            ThirdStringG,
            soundpool!!.load(activity, R.raw.third_string_g, 1)
        )
        soundsmap!!.put(
            SecondStringB,
            soundpool!!.load(activity, R.raw.second_string_b, 1)
        )
        soundsmap!!.put(
            FirstStringESmall,
            soundpool!!.load(activity, R.raw.first_string_e, 1)
        )

        this.playEButton!!.setOnClickListener(PlayNoteListener)
        this.playAButton!!.setOnClickListener(PlayNoteListener)
        this.playDButton!!.setOnClickListener(PlayNoteListener)
        this.playGButton!!.setOnClickListener(PlayNoteListener)
        this.playBButton!!.setOnClickListener(PlayNoteListener)
        this.playESmallButton!!.setOnClickListener(PlayNoteListener)

        return view
    }


    /**
     * Gets called whenever a note is clicked on. It plays the sound based on the note.
     *
     * @param sound - The note being played.
     */
    fun playSound(sound: Int) {
        val mgr = activity!!.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val streamVolumeCurrent = mgr
            .getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        val streamVolumeMax = mgr
            .getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
        val volume = streamVolumeCurrent / streamVolumeMax

        soundpool!!.play(soundsmap!!.get(sound), volume, volume, 1, 0, 1f)
    }

    /**
     * A click listener that determines which note was clicked.
     */
    private val PlayNoteListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.playEButton -> playSound(SixthStringE)
            R.id.playAButton -> playSound(FifthStringA)
            R.id.playDButton -> playSound(FourthStringD)
            R.id.playGButton -> playSound(ThirdStringG)
            R.id.playBButton -> playSound(SecondStringB)
            R.id.playESmallButton -> playSound(FirstStringESmall)
        }
    }
}