package com.victorteka.noteappkmm.data.note

import com.victorteka.noteappkmm.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note = Note(
    id = id,
    title = title,
    content = content,
    colorHex = colorHex,
    created = Instant.fromEpochMilliseconds(created)
        .toLocalDateTime(TimeZone.currentSystemDefault())
)