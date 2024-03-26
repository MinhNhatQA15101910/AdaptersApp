package com.donhat.adaptersapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter {
    private final Context _context;
    private final String[] _countries;

    public CountryAdapter(Context context, String[] countries) {
        _context = context;
        _countries = countries;
    }

    @Override
    public int getCount() {
        return _countries.length;
    }

    @Override
    public Object getItem(int position) {
        return _countries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater
                    .from(_context)
                    .inflate(R.layout.item_country, parent, false);

            holder = new CountryViewHolder();
            holder.countryTextView = convertView.findViewById(R.id.country_text_view);
            convertView.setTag(holder);
        } else {
            holder = (CountryViewHolder) convertView.getTag();
        }

        holder.countryTextView.setText(_countries[position]);

        return convertView;
    }

    static class CountryViewHolder {
        TextView countryTextView;
    }
}
