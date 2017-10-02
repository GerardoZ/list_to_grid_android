package com.codecube.switch_list_to_grid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private int counter = 0;

    LanguagesAdapter listAdapter;
    LanguagesAdapter gridAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languages = new ArrayList<Language>();
        listView = (ListView) findViewById(R.id.listView);
        gridView = (GridView) findViewById(R.id.gridView);

        setLanguages();

        listAdapter = new LanguagesAdapter(this, R.layout.list_item, languages);
        gridAdapter = new LanguagesAdapter(this, R.layout.grid_item, languages);

        listView.setAdapter(listAdapter);
        gridView.setAdapter(gridAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Language newLan = new Language("New No " + ++counter, R.mipmap.ic_generic, "Unknown");
                this.languages.add(newLan);
                this.listAdapter.notifyDataSetChanged();
                this.gridAdapter.notifyDataSetChanged();
                return true;
            case R.id.switch_to_grid:
                return true;
            case R.id.switch_to_list:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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

