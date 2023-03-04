package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {

        if (note.title.isEmpty()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isEmpty()){
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }
}