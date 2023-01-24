//
//  NoteDetailViewModel.swift
//  iosApp
//
//  Created by Victor Teka on 23/01/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension NoteDetailScreen {
    @MainActor class NoteDetailViewModel: ObservableObject {
        
        private var noteDataSource: NoteDataSource?
        private var noteId: Int64? = nil
        
        @Published var noteTitle = ""
        @Published var noteContent = ""
        @Published private(set) var noteColor = Note.Companion().generateRandomColor()
        
        init(noteDataSource: NoteDataSource? = nil){
            self.noteDataSource = noteDataSource
        }
        
        func loadNoteIfExists(noteId: Int64?) {
            if noteId != nil {
                noteDataSource?.getNoteById(id: noteId!, completionHandler: { note, error in
                    self.noteTitle = note?.title ?? ""
                    self.noteContent = note?.content ?? ""
                    self.noteColor = note?.colorHex ?? Note.Companion().generateRandomColor()
                })
            }
        }
        
//        func saveNote(onSaved: @escaping () -> Void) {
//            noteDataSource?.insertNote(note: Note(id: noteId == nil ? nil : KotlinLong(value: noteId!), title: self.noteTitle, content: self.noteContent, colorHex: self.noteColor, created: DateTimeUtil().now()), completionHandler: { error in
//                onSaved()
//            })
//        }
        
        func saveNote(onSaved: @escaping () -> Void) {
                  noteDataSource?.insertNote(
                      note: Note(id: noteId == nil ? nil : KotlinLong(value: noteId!), title: self.noteTitle, content: self.noteContent, colorHex: self.noteColor, created: DateTimeUtil().now()), completionHandler: { error in
                          onSaved()
                      })
              }
        
        func setParamsAndLoadNote(noteDataSource: NoteDataSource, noteId: Int64?) {
            self.noteDataSource = noteDataSource
            loadNoteIfExists(noteId: noteId)
        }
    }
}
