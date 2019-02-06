package com.example.evira.mysongsapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.example.evira.mysongsapp.itemsTodo.ChordsFragment
import com.example.evira.mysongsapp.itemsTodo.TunerFragment
import com.example.evira.mysongsapp.models.Song
import com.example.evira.mysongsapp.newsong.NewSongFragment
import com.example.evira.mysongsapp.songList.SongList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                val fragment = NewSongFragment.Companion.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = SongList.Companion.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.chords -> {
                val fragment = ChordsFragment.Companion.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.settings -> {
                val fragment = TunerFragment.Companion.newInstance()
                addFragment(fragment)
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

        firstDataForExample()

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

    /**
     * TODO убрать
     * песня для примера
     */
    fun firstDataForExample(){
        val db = App.getInsta()!!.getDatabase()
        val data = db!!.employeeDao().getAll()
        if(data.size == 0){
            with(Song()){

                title = "Мураками - 364"
                text  = "Am                          F\n" +
                        "Все бывает не так как хочется \n" +
                        "                       C\n" +
                        "Я сегодня не буду добрая\n" +
                        "                      Em\n" +
                        "Я надену ногти красные\n" +
                        "Am                      F\n" +
                        "Может выгоню одиночество\n" +
                        "                   C\n" +
                        "Нарисую себя я новая\n" +
                        "                           Em\n" +
                        "Так бывает давай расслабимся\n" +
                        " Dm                      G\n" +
                        "Бесполезно меняться лицами\n" +
                        "                              Am\n" +
                        "Все равно никуда не скрыться нам\n" +
                        "          Em                  Dm\n" +
                        "И я кусаю постоянно губы в кровь\n" +
                        "             G\n" +
                        "На расстрел фонарями улицы\n" +
                        "                       Am\n" +
                        "Выхожу и плечи сутулятся \n" +
                        "           Em                   Dm  G\n" +
                        "И я пытаюсь потеряться вновь и вновь  \n" +
                        "\n" +
                        "Припев:\n" +
                        "Am               F              C   G\n" +
                        "До рассвета нам осталось ровно 364 дня\n" +
                        "Am                  F           C             G     F  G\n" +
                        "Ничего не поменялось  Завтра будет точно так же как вчера\n" +
                        "        C\n" +
                        "Как вчера\n" +
                        "\n" +
                        "Am Dm G }x2\n" +
                        "\n" +
                        "Am                    F\n" +
                        "Я иду в никуда холодная\n" +
                        "                      C\n" +
                        "И считаю шаги не думая\n" +
                        "                            Em\n" +
                        "Надоело всегда быть паинькой\n" +
                        "Am                   F\n" +
                        "Состояние безысходное \n" +
                        "                           C\n" +
                        "Пусть я буду всегда безумною\n" +
                        "                               Em\n" +
                        "Для меня стал ты очень маленьким\n" +
                        " Dm                     G\n" +
                        "Бесполезно меняться лицами\n" +
                        "                              Am\n" +
                        "Все равно никуда не скрыться нам\n" +
                        "          Em                   Dm\n" +
                        "И я кусаю постоянно губы в кровь\n" +
                        "             G\n" +
                        "На расстрел фонарями улицы\n" +
                        "                        Am\n" +
                        "Выхожу и плечи сутулятся \n" +
                        "           Em                 Dm  G\n" +
                        "И я пытаюсь потеряться вновь и вновь \n" +
                        "\n" +
                        "Припев:\n" +
                        "Am               F                 C  G\n" +
                        "До рассвета нам осталось ровно 364 дня\n" +
                        "Am                  F           C             G     F  G\n" +
                        "Ничего не поменялось  Завтра будет точно так же как вчера\n" +
                        "         C\n" +
                        "Как вчера\n" +
                        "Am F            C G  \n" +
                        "         Как вчера\n" +
                        "\n" +
                        "Припев:\n" +
                        "Am               F                 C   G\n" +
                        "До рассвета нам осталось ровно 364 дня\n" +
                        "Am                  F           C            G     F  G\n" +
                        "Ничего не поменялось  Завтра будет точно так же как вчера\n" +
                        "        Am\n" +
                        "Как вчера\n" +
                        "\n" +
                        "Outro: Am Dm G }x4"
                db!!.employeeDao().insert(this)
            }
        }

    }
}
