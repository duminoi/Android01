package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            // Tạo và khởi tạo Intent để chuyển đến MainActivity2
            Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
            // Truyền dữ liệu bằng Bundle
            Bundle bundle = new Bundle();
            bundle.putString("greeting","Xin chào Đức Minh"); //đính kèm dữ liệu vào bundle
            bundle.putString("greeting2", "Chào mừng bạn");
            myIntent.putExtras(bundle); // đính thèm bundle vào intent
            startActivity(myIntent);
        });
    }
}
