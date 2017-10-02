package com.codecube.switch_list_to_grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.codecube.switch_list_to_grid.adapters.LanguagesAdapter;
import com.codecube.switch_list_to_grid.models.Language;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private GridView gridView;
    List<Language> languages;
    private int GRID_TO_LIST = 0;
    private int LIST_TO_GRID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languages = new ArrayList<Language>();
        listView = (ListView) findViewById(R.id.listView);
        gridView = (GridView) findViewById(R.id.gridView);

        setLanguages();

        LanguagesAdapter listAdapter = new LanguagesAdapter(this, R.layout.list_item, languages);
        LanguagesAdapter gridAdapter = new LanguagesAdapter(this, R.layout.grid_item, languages);

        listView.setAdapter(listAdapter);
        gridView.setAdapter(gridAdapter);


    }

    public void setLanguages(){
        Language language1 = new Language("Java", R.mipmap.ic_java, "James Gosling");
        Language language2 = new Language("PHP" , R.mipmap.ic_php, "Rasmus Lerdorf");
        Language language3 = new Language("Javascript", R.mipmap.ic_js, "Brendan Eich");
        Language language4 = new Language("C#", R.mipmap.ic_c_sharp, "Anders Hejlsberg");
        this.languages.add(language1);
        this.languages.add(language2);
        this.languages.add(language3);
        this.languages.add(language4);
    }
}

