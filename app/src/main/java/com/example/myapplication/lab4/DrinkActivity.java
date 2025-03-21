package com.example.myapplication.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
    private ArrayList<Drink> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_drink_activity);
        ListView drinkListView = findViewById(R.id.drinkListView);
        drinkList = new ArrayList<>();
        drinkList.add(new Drink(R.drawable.pepsi, "Pepsi", "10,000 VND"));
        drinkList.add(new Drink(R.drawable.heineken, "Heineken", "20,000 VND"));
        drinkList.add(new Drink(R.drawable.tiger, "Tiger", "15,000 VND"));
        drinkList.add(new Drink(R.drawable.saigon_do, "Sài Gòn Đỏ", "12,000 VND"));
        DrinkAdapter adapter = new DrinkAdapter(this, drinkList);
        drinkListView.setAdapter(adapter);

        drinkListView.setOnItemClickListener((parent, view, position, id) -> {
            Drink selectedDrink = drinkList.get(position);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selection", selectedDrink.getName());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
