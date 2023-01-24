package com.victorteka.noteappkmm.data

import com.victorteka.noteappkmm.data.note.toNote
import com.victorteka.noteappkmm.database.NoteDatabase
import com.victorteka.noteappkmm.domain.note.Note
import com.victorteka.noteappkmm.domain.note.NoteDataSource
import com.victorteka.noteappkmm.domain.time.DateTimeUtil

class SqlDelightDataSource(
    db: NoteDatabase
): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(dateTime = note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map {
            it.toNote()
        }
    }

    override suspend fun deleteNoteById(id: Long) {
        return queries.deleteNoteById(id)
    }
}