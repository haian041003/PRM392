package com.example.myapplication.lab2;

import android.os.Bundle;
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

public class Lab2q2MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2q2_main);

        // Áp dụng WindowInsets cho layout chính
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các thành phần giao diện
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewResult = findViewById(R.id.textViewResult);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        // Gán sự kiện click cho các button
        buttonAdd.setOnClickListener(v -> calculate(Operation.ADD));
        buttonSubtract.setOnClickListener(v -> calculate(Operation.SUBTRACT));
        buttonMultiply.setOnClickListener(v -> calculate(Operation.MULTIPLY));
        buttonDivide.setOnClickListener(v -> calculate(Operation.DIVIDE));
    }

    private void calculate(Operation operation) {
        // Lấy dữ liệu từ EditText và loại bỏ khoảng trắng thừa
        String num1Str = editTextNumber1.getText().toString().trim();
        String num2Str = editTextNumber2.getText().toString().trim();

        // Kiểm tra xem người dùng có nhập đủ số không
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ hai số", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result;
            String operationSymbol;

            switch (operation) {
                case ADD:
                    result = num1 + num2;
                    operationSymbol = "+";
                    break;
                case SUBTRACT:
                    result = num1 - num2;
                    operationSymbol = "-";
                    break;
                case MULTIPLY:
                    result = num1 * num2;
                    operationSymbol = "×";
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    operationSymbol = "÷";
                    break;
                default:
                    return;
            }

            // Định dạng kết quả để tránh hiển thị số thập phân dư thừa
            String formattedResult = (result == (long) result) ?
                    String.format("%d", (long) result) : String.format("%.2f", result);

            // Hiển thị kết quả
            textViewResult.setText(String.format("%s %s %s = %s", num1Str, operationSymbol, num2Str, formattedResult));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
