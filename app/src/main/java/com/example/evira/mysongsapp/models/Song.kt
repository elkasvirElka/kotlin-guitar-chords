package com.example.evira.mysongsapp.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
open class Song {
    @PrimaryKey (autoGenerate = true)
    var id: Long = 0
    var title: String = ""
    var text: String = ""
}