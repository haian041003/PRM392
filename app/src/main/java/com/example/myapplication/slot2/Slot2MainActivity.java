package com.example.myapplication.slot2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Slot2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_slot2_main);
        EditText txt1,txt2;
        TextView tv1;
        Button btn1;
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt1 = findViewById(R.id.slot2_txt1);
        txt2 = findViewById(R.id.slot2_txt2);
        btn1 = findViewById(R.id.slot2_btn1);
        tv1 = findViewById(R.id.slot2_tv1);

        btn1.setOnClickListener(v -> {
            int a = Integer.parseInt(txt1.getText().toString());
            int b = Integer.parseInt(txt2.getText().toString());
            int tong = a + b;
            tv1.setText(String.valueOf(tong));
        });
    }
}