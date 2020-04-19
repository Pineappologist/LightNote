package com.nanasdev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity implements NoteOpener {
    private RecyclerView recyclerView;
    private NotesAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.notesView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final String[] files = this.fileList();

        // specify an adapter (see also next example)
        mAdapter = new NotesAdapter(files, this);
        recyclerView.setAdapter(mAdapter);
    }

    public void goTo(View view) {
        Intent i = new Intent(this, NoteActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void openNote(String filename) {
        Intent i = new Intent(this, NoteActivity.class);
        Gson gson = new Gson();
        try {
            FileInputStream fis = this.openFileInput(filename);
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            JsonReader reader = new JsonReader(inputStreamReader);
            Note note = gson.fromJson(reader, Note.class);
            if (note != null) {
                i.putExtra("noteBean", note);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        startActivity(i);
        finish();
    }
}