package com.example.a8dip;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NotesAdapter extends BaseAdapter {

    List<Note> notes;
    LayoutInflater layoutInflater;
    Context ctx;

    NotesAdapter(Context context, List<Note> Notes) {
        ctx = context;
        notes = Notes;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    public Note getNote(int position) {
        return notes.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.notes_item, parent, false);
        }

        final Note Note = getNote(position);

        ((TextView) (view.findViewById(R.id.textViewBody))).setText(Note.getBody());
        ((TextView) (view.findViewById(R.id.textViewHeadLine))).setText(Note.getHeadLine());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, " view onClick Позиция № " + Integer.toString(position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }


}