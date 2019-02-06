package com.example.evira.mysongsapp.models

import android.arch.persistence.room.*

@Dao
interface SongDao {
    @Query("SELECT * FROM Song")
    fun getAll(): List<Song>

    @Query("SELECT * FROM Song WHERE id = :id")
    fun getById(id: Int): Song

    @Insert
    fun insert(song: Song)

    @Update
    fun update(song: Song)

    @Delete
    fun delete(song: Song)
}