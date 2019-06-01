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
 * @date 2019-06-01 14:02
 */
public class SetActivity extends Activity {
    private EditText name;
    private EditText id;
    private EditText price;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        name = (EditText) findViewById(R.id.sname);
        id = (EditText) findViewById(R.id.sid);
        price = (EditText) findViewById(R.id.sprice);
        Button set = (Button) findViewById(R.id.s_set);
        set.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {

        public void onClick(View v) {
            String bookname = name.getText().toString();
            String bookid = id.getText().toString();
            String bookprice = price.getText().toString();
            Controller control = new Controller();
            if (bookname.equals("") || bookid.equals("")
                    || bookprice.equals("")) {
                new Builder(SetActivity.this).setMessage("图书信息不能为空").show();
            } else {
                if (control.setBook(bookid, bookname, bookprice)) {
                    name.setText("");
                    id.setText("");
                    price.setText("");
                    buildDialog();
                } else {
                    new Builder(SetActivity.this).setMessage("没有此编号的图书,请重新输入")
                            .show();

                }
            }
        }

        private void buildDialog() {
            Builder builder = new Builder(SetActivity.this);
            builder.setTitle("修改成功,是否继续修改图书");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续修改", null);
            builder.show();
        }
    }

}
