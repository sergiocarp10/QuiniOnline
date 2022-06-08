package cs10.apps.quini;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import cs10.apps.quini.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_QuiniOnline_SplashScreen);

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // splash screen
        new Handler().postDelayed(this::moveBalls, 100);
        new Handler().postDelayed(this::moveBalls, 600);

        new Handler().postDelayed(() -> {
            Intent i = new Intent(this, DrawerActivity.class);
            startActivity(i);
            finish();
        }, 1500);
    }

    private void moveBalls() {
        new Handler().postDelayed(() -> change(R.drawable.ic_mov2), 100);
        new Handler().postDelayed(() -> change(R.drawable.ic_mov3), 200);
        new Handler().postDelayed(() -> change(R.drawable.ic_mov4), 300);
        new Handler().postDelayed(() -> change(R.drawable.ic_mov5), 400);
        new Handler().postDelayed(() -> change(R.drawable.ic_quiniela), 500);
    }

    private void change(int drawable){
        binding.ivAppLogo.setImageDrawable(AppCompatResources.getDrawable(this, drawable));
    }
}