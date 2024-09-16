package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn2 = findViewById(R.id.button2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String greeting = bundle.getString("greeting");
            TextView txt_view2 = findViewById(R.id.txt_view2);
            txt_view2.setText(greeting);
            String greeting2 = bundle.getString("greeting2");
            Toast.makeText(this, greeting2, Toast.LENGTH_SHORT).show();
        }
        btn2.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(myIntent);
        });
    }
}