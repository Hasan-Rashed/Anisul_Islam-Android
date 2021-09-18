package com.rashed.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter
{
    private String[] countryNames, population;
    int [] flags;
    Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int[] flags, String[] countryNames, String[] population)
    {
        this.countryNames = countryNames;
        this.population = population;
        this.flags = flags;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sample_view, null, false);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(i);

        TextView country = view.findViewById(R.id.countryName);
        country.setText(countryNames[i]);

        TextView populationText = view.findViewById(R.id.population);
        populationText.setText(population[i]);

        return view;
    }
}
