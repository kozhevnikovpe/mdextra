package com.pavelekozhevnikov.extraproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputActivity extends AppCompatActivity {

    TextInputLayout text_hw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        text_hw2 = findViewById(R.id.text_hw2);
        Button button_hw2 = findViewById(R.id.button_hw2);
        button_hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(text_hw2.getEditText().getText().toString().equals(""))
                    Snackbar.make(v, "Sorry man. Your text input is empty", Snackbar.LENGTH_LONG).show();
                else if(!TextUtils.isEmpty(text_hw2.getHint())) {
                    Snackbar.make(v, "Sorry man. U've got an error", Snackbar.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(TextInputActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
