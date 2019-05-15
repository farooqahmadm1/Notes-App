package com.example.farooq.roomdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }
    public void Insert(Note note){
        noteRepository.Insert(note);
    }
    public void Update(Note note){
        noteRepository.Update(note);
    }
    public void Delete(Note note){
        noteRepository.Delete(note);
    }
    public void DeleteAllNotes(){
        noteRepository.DeleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
