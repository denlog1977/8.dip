package com.example.a8dip;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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

        final Note note = getNote(position);
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
        final String dateText = dateFormat.format(note.getDeadLineDay());

//        ((TextView) (view.findViewById(R.id.textViewBody))).setText(Note.getBody());
//        ((TextView) (view.findViewById(R.id.textViewHeadLine))).setText(Note.getHeadLine());
//        ((TextView) (view.findViewById(R.id.textViewDeadLineDay))).setText(dateText);
        TextView textViewHeadLine = view.findViewById(R.id.textViewHeadLine);
        TextView textViewBody = view.findViewById(R.id.textViewBody);
        TextView textViewDeadLineDay = view.findViewById(R.id.textViewDeadLineDay);


        textViewHeadLine.setText(note.getHeadLine());
        textViewBody.setText(note.getBody());
        textViewDeadLineDay.setText(dateText);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ctx, " view onClick Позиция № " + Integer.toString(position + 1), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ctx, NoteActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("position", position);
                extras.putString("headLine", note.getHeadLine());
                extras.putString("body", note.getBody());
                extras.putBoolean("hasDeadLine", note.getHasDeadLine());
                extras.putString("deadLineDay", dateText);
                intent.putExtras(extras);
                ctx.startActivity(intent);
            }
        });

        return view;

    }


}