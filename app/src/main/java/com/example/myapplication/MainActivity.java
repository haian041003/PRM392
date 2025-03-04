package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.example.myapplication.lab1.Lab1MainActivity;
import com.example.myapplication.lab2.Lab2q1MainActivity;
import com.example.myapplication.lab2.Lab2q2MainActivity;
import com.example.myapplication.lab2.Lab2q3MainActivity;
import com.example.myapplication.lab3.Lab3q1MainActivity;
import com.example.myapplication.lab3.Lab3q2MainActivity;
import com.example.myapplication.lab4.Lab4MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static class ListLabItem {
        String id;
        Class<?> activityClass;

        ListLabItem(String id, Class<?> activityClass) {
            this.id = id;
            this.activityClass = activityClass;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout layout = findViewById(R.id.buttonContainer);

        layout.setOnApplyWindowInsetsListener((v, insets) -> {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.topMargin = insets.getSystemWindowInsetTop();
            params.bottomMargin = insets.getSystemWindowInsetBottom();
            v.setLayoutParams(params);
            return insets.consumeSystemWindowInsets();
        });

        List<ListLabItem> labItems = new ArrayList<>();
        labItems.add(new ListLabItem("lab1", Lab1MainActivity.class));
        labItems.add(new ListLabItem("lab2q1", Lab2q1MainActivity.class));
        labItems.add(new ListLabItem("lab2q2", Lab2q2MainActivity.class));
        labItems.add(new ListLabItem("lab2q3", Lab2q3MainActivity.class));
        labItems.add(new ListLabItem("lab3q1", Lab3q1MainActivity.class));
        labItems.add(new ListLabItem("lab3q2", Lab3q2MainActivity.class));
        labItems.add(new ListLabItem("lab4", Lab4MainActivity.class));

        for (ListLabItem item : labItems) {
            Button button = new Button(this);
            button.setText(item.id);
            button.setId(View.generateViewId());
            button.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, item.activityClass)));
            layout.addView(button);
        }
    }
}


