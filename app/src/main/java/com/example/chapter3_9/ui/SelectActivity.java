package com.example.chapter3_9.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.chapter3_9.R;
import com.example.chapter3_9.control.Controller;
import com.example.chapter3_9.model.Book;
import com.example.chapter3_9.model.BookList;

/**
 * @author Alexander Jiajiason
 * @date 2019-06-01 14:01
 */
public class SelectActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        Controller control = new Controller();
        BookList booklist = control.searchBook();
        CreateTable(booklist);
    }

    private void CreateTable(BookList booklist) {
        TableLayout table = (TableLayout) findViewById(R.id.SELECT_ACTIVITY_TableLayout);

        for (int i = 0; i < booklist.size(); ++i) {
            Book book = booklist.get(i);
            String id = book.getId();
            String name = book.getName();
            String price = book.getPrice();
            TableRow row = new TableRow(this);
            TextView tid = new TextView(this);
            TextView tname = new TextView(this);
            TextView tprice = new TextView(this);
            tid.setText(id);
            tname.setText(name);
            tprice.setText(price);
            row.addView(tid);
            row.addView(tname);
            row.addView(tprice);
            table.addView(row);
        }
    }
}
