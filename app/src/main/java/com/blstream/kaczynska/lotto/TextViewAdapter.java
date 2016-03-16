package com.blstream.kaczynska.lotto;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class TextViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> textViewValues = null;
    View gridView;

    public TextViewAdapter(Context context, ArrayList<String> textViewValues) {
        this.context = context;
        this.textViewValues = textViewValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.tile_layout, null);

            // set value into textview
            DrawingXTextView drawingXTextView = (DrawingXTextView)
                    gridView.findViewById(R.id.tileTextViewId);
            drawingXTextView.setText(textViewValues.get(position));

//            TextView textView = (TextView) gridView
//                    .findViewById(R.id.tileTextViewId);
//            textView.setText(textViewValues.get(position));
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }


    public ArrayList<String> getItems() {
        return textViewValues;
    }

    @Override
    public int getCount() {
        return textViewValues.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
