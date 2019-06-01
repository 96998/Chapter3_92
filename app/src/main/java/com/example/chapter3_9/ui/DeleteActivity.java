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
 * @date 2019-06-01 13:58
 */
public class DeleteActivity extends Activity {
    private EditText name;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        name = (EditText) findViewById(R.id.dname);
        Button delete = (Button) findViewById(R.id.d_delete);
        delete.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {

        public void onClick(View v) {
            String bookname = name.getText().toString();
            Controller control = new Controller();
            if (bookname.equals("")) {
                new Builder(DeleteActivity.this).setMessage("图书名不能为空").show();
            } else {
                if (control.deleteBook(bookname)) {
                    name.setText("");
                    buildDialog();
                } else {
                    new Builder(DeleteActivity.this).setMessage("没有此图书").show();
                }
            }
        }

        private void buildDialog() {
            Builder builder = new Builder(DeleteActivity.this);
            builder.setTitle("删除成功,是否继续删除图书");
            builder.setNegativeButton("返回首页",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            finish();
                        }

                    });
            builder.setPositiveButton("继续删除", null);
            builder.show();
        }
    }
}
