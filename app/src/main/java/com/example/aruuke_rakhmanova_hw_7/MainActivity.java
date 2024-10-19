package com.example.aruuke_rakhmanova_hw_7;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Integer firstNumber, secondNumber;
    boolean isOperation;
    String currentOperation;
    String currentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                result.setText("");
            }
            result.append(text);
        }
        isOperation = false;
    }

    public void operationClick(View view) {
        if (view.getId() == R.id.clearBtn) {
            result.setText("");
        } else if (view.getId() == R.id.plusBtn) {
            firstNumber = Integer.valueOf(result.getText().toString());
            currentOperation = "+";
        } else if (view.getId() == R.id.minusBtn) {
            firstNumber = Integer.valueOf(result.getText().toString());
            currentOperation = "-";
        } else if (view.getId() == R.id.multiplyBtn) {
            firstNumber = Integer.valueOf(result.getText().toString());
            currentOperation = "*";
        } else if (view.getId() == R.id.divideBtn) {
            firstNumber = Integer.valueOf(result.getText().toString());
            currentOperation = "/";

        } else if (view.getId() == R.id.equalBtn) {
            secondNumber = Integer.valueOf(result.getText().toString());

            if (currentOperation == ("+")) {
                Integer resultPlus = firstNumber + secondNumber;
                result.setText(String.valueOf(resultPlus));
            } else if (currentOperation == ("-")) {
                Integer resultMinus = firstNumber - secondNumber;
                result.setText(String.valueOf(resultMinus));
            } else if (currentOperation == ("*")) {
                Integer resultMultiply = firstNumber * secondNumber;
                result.setText(String.valueOf(resultMultiply));
            } else if (currentOperation == ("/")) {
                Integer resultDivine = firstNumber / secondNumber;
                result.setText(String.valueOf(resultDivine));
            }
        }
        isOperation = true;
    }
}
