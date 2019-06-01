package com.example.chapter3_9.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.chapter3_9.R;

/**
 * @author Alexander Jiajiason
 * @date 2019-06-01 14:01
 */
public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button insert = (Button) findViewById(R.id.m_insert);
        Button delete = (Button) findViewById(R.id.m_delete);
        Button set = (Button) findViewById(R.id.m_set);
        Button select = (Button) findViewById(R.id.m_select);
        ButtonListener buttonListener = new ButtonListener();
        insert.setOnClickListener(buttonListener);
        delete.setOnClickListener(buttonListener);
        set.setOnClickListener(buttonListener);
        select.setOnClickListener(buttonListener);
    }

    class ButtonListener implements OnClickListener {

        public void onClick(View v) {
            int id = v.getId();
            Intent intent = new Intent();
            switch (id) {
                case R.id.m_insert:
                    intent.setClass(MainActivity.this, InsertActivity.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_delete:
                    intent.setClass(MainActivity.this, DeleteActivity.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_set:
                    intent.setClass(MainActivity.this, SetActivity.class);
                    MainActivity.this.startActivity(intent);
                    break;
                case R.id.m_select:
                    intent.setClass(MainActivity.this, SelectActivity.class);
                    MainActivity.this.startActivity(intent);
                    break;
            }
        }

    }
}
