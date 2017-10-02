package com.codecube.switch_list_to_grid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codecube.switch_list_to_grid.R;
import com.codecube.switch_list_to_grid.models.Language;

import java.util.List;

public class LanguagesAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Language> languages;

    public LanguagesAdapter(Context context, int layout, List<Language> languages) {
        this.context = context;
        this.layout = layout;
        this.languages = languages;
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public Object getItem(int position) {
        return languages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.textViewCreator = (TextView) convertView.findViewById(R.id.textViewCreator);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.imageView.setImageResource(this.languages.get(position).getImg());
        holder.textViewName.setText(this.languages.get(position).getName());
        holder.textViewCreator.setText(this.languages.get(position).getCreator());
        return convertView;
    }

    static class ViewHolder{
        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewCreator;
    }
}
