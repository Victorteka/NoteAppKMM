package com.victorteka.noteappkmm.di

import com.victorteka.noteappkmm.data.SqlDelightDataSource
import com.victorteka.noteappkmm.data.local.DatabaseDriverFactory
import com.victorteka.noteappkmm.database.NoteDatabase
import com.victorteka.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightDataSource(NoteDatabase(factory.createDriver()))
    }
}