package cs10.apps.quini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // splash screen
        new Handler().postDelayed(() -> {
            Intent i = new Intent(this, DrawerActivity.class);
            startActivity(i);
            finish();
        }, 1000);
    }
}