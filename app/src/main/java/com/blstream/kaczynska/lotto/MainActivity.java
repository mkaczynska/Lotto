package com.blstream.kaczynska.lotto;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static int BOARDSIZE = 112;
    private final static int ALLOWEDCLICKNO = 6;
    public static int clickCounter = 1;
    ArrayList<Integer> clickedTileList;
    GridView boardGridView;
    Context context;
    RelativeLayout mainLayout;
    private static boolean colorsChanged = false;

    TextViewAdapter textViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ArrayList<String> tileNumbersList = new ArrayList<>();
        clickedTileList = new ArrayList<>();
        for (int number = 1; number <= BOARDSIZE; number++) {
            tileNumbersList.add(Integer.toString(number));
        }
        boardGridView = (GridView) findViewById(R.id.gridViewId);
        mainLayout = (RelativeLayout) findViewById(R.id.root);
        textViewAdapter = new TextViewAdapter(this, tileNumbersList);
        boardGridView.setAdapter(textViewAdapter);

        setBoardColor();
        boardGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                checkIfClickAllowed(position);
            }
        });
    }

    void setBoardColor() {
        int currentBoardColor;
        if(colorsChanged) {
            currentBoardColor = ContextCompat.getColor(context, R.color.green);
        }
        else {
            currentBoardColor = ContextCompat.getColor(context, R.color.orange);
        }
        boardGridView.setBackgroundColor(currentBoardColor);
        mainLayout.setBackgroundColor(currentBoardColor);
        int textViewCount = boardGridView.getChildCount();
        for (int tileNo = 0; tileNo < textViewCount; tileNo++) {
            DrawingXTextView currentTextView = (DrawingXTextView) boardGridView.getChildAt(tileNo).findViewById(R.id.tileTextViewId);
            currentTextView.setTextColor(currentBoardColor);
        }
    }

    void checkIfClickAllowed(int itemPosition) {
        if (clickedTileList.contains(itemPosition)) {
            return;
        }
        if (clickCounter > ALLOWEDCLICKNO) {
            return;
        }
        clickedTileList.add(itemPosition);
        DrawingXTextView currentTextView = (DrawingXTextView) boardGridView.getChildAt(itemPosition).findViewById(R.id.tileTextViewId);
        currentTextView.drawX();

        if (clickCounter == ALLOWEDCLICKNO) {
            colorsChanged = true;
            setBoardColor();
        }
        clickCounter++;
    }
}
