package jp.techacademy.shintarou.nakajima.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    /*TimePickerDialogを表示*/
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        //条件分岐 時間によって表示させる挨拶
                        if (2 <= hourOfDay &&  hourOfDay < 10) {
                            //「おはよう」テキスト表示
                            mTextView.setText("おはよう");
                        } else if (10 <= hourOfDay && hourOfDay < 18){
                            //「こんにちは」テキスト表示
                            mTextView.setText("こんにちは");
                        } else {
                            //「こんばんは」テキスト表示
                            mTextView.setText("こんばんは");
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

    public void onClick(View v) {
        showTimePickerDialog();
    }
}
