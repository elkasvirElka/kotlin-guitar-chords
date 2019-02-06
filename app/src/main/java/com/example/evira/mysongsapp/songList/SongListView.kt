package com.example.evira.mysongsapp.songList

import com.example.evira.mysongsapp.models.Song

interface SongListView {
    fun setSongList(list: List<Song>)
}