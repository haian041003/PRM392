package com.example.myapplication.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.Random;

public class Lab2q1MainActivity extends AppCompatActivity {
    private EditText editTextMin;
    private EditText editTextMax;
    private Button buttonGenerate;
    private TextView textViewResult;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bật chế độ Edge-to-Edge
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2q1_main);

        // Áp dụng WindowInsets cho view cha có id "main"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các view dùng cho chức năng tạo số ngẫu nhiên
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        textViewResult = findViewById(R.id.textViewResult);

        random = new Random();

        // Set sự kiện cho button
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        // Lấy dữ liệu nhập vào
        String minStr = editTextMin.getText().toString();
        String maxStr = editTextMax.getText().toString();

        // Kiểm tra dữ liệu nhập
        if (minStr.isEmpty() || maxStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập giá trị tối thiểu và tối đa", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            if (min >= max) {
                Toast.makeText(this, "Giá trị tối đa phải lớn hơn giá trị tối thiểu", Toast.LENGTH_SHORT).show();
                return;
            }

            // Sinh số ngẫu nhiên trong khoảng [min, max]
            int randomNumber = random.nextInt((max - min) + 1) + min;
            textViewResult.setText(String.valueOf(randomNumber));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
