package com.example.shoppingmanager;

import android.content.Intent; // CHANGED THIS LINE
import android.os.Bundle;
import android.view.View; // CHANGED THIS LINE
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

        // Button functionality
        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() { // CHANGED THIS LINE
            @Override
            public void onClick(View view) {
                // Redirect to RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class); // CHANGED THIS LINE
                startActivity(intent); // CHANGED THIS LINE
            }
        });

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() { // CHANGED THIS LINE
            @Override
            public void onClick(View view) {
                // Redirect to LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class); // CHANGED THIS LINE
                startActivity(intent); // CHANGED THIS LINE
            }
        });
    }
}
