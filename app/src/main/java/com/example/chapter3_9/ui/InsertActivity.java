package com.example.chapter3_9.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.example.chapter3_9.R;
import com.example.chapter3_9.control.Controller;

/**
 * @author Alexander Jiajiason
 * @date 2019-06-01 14:00
 */
public class InsertActivity extends Activity {
    private EditText name;
    private EditText id;
    private EditText price;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        name = (EditText) findViewById(R.id.name);
        id = (EditText) findViewById(R.id.id);
        price = (EditText) findViewById(R.id.price);
        Button insert = (Button) findViewById(R.id.i_insert);
        insert.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {

        public void onClick(View v) {
            String bookname = name.getText().toString();
            String bookid = id.getText().toString();
            String bookprice = price.getText().toString();

            Controller control = new Controller();
            if (bookname.equals("") || bookid.equals("")
                    || bookprice.equals("")) {
                new Builder(InsertActivity.this).setMessage("图书信息不能为空").show();
            } else {
                if (control.addBook(bookid, bookname, bookprice)) {
                    id.setText("");
                    name.setText("");
                    price.setText("");
                    buildDialog();
                } else {
                    new Builder(InsertActivity.this).setMessage("已有此图书").show();
                }
            }
        }

        private void buildDialog() {
            Builder builder = new Builder(InsertActivity.this);
            builder.setTitle("插入成功,是否继续插入图书");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续插入", null);
            builder.show();
        }

    }
}
