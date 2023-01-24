package com.victorteka.noteappkmm.data.local

import android.content.Context
import com.squareup.sqldelight.db.SqlDriver
import com.victorteka.noteappkmm.database.NoteDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NoteDatabase.Schema, context, "note.db")
    }
}