package com.example.farooq.roomdatabase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    List<Note> notes=new ArrayList<>();

    public NoteAdapter() {
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout_room,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.title.setText(currentNote.getTitle());
        holder.description.setText(currentNote.getDescription());
        holder.priority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes1){
        notes=notes1;
    }

    public Note getPosition(int position){
        return notes.get(position);
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        public TextView title,description,priority;

        public NoteViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.text_view_title);
            description= (TextView) itemView.findViewById(R.id.text_view_desc);
            priority= (TextView) itemView.findViewById(R.id.text_view_priority);
        }
    }
}
