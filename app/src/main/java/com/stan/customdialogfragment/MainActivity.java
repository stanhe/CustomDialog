package com.stan.customdialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showCustomDialog(View view) {
        new CustomDialog()
                .setSize(0.7f,400)
                .noTitle(true) // default false
                .setStyleAnimation(R.style.DialogAnimation) // in/out animation
                .setConfirmListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Ok click!", Toast.LENGTH_SHORT).show();
                    }
                })
                .isCancelable(false)
                .show(getFragmentManager());
    }
}
