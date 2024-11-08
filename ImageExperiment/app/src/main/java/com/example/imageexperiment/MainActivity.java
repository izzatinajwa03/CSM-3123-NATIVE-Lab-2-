package com.example.imageexperiment;

import android.os.Bundle;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private int[] backgrounds = {
            R.drawable.background_image1,
            R.drawable.background_image2,
            R.drawable.background_image3 // Add more backgrounds as needed
    };
    private int currentBackgroundIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        Button switchBackgroundButton = findViewById(R.id.switchBackgroundButton);

        switchBackgroundButton.setOnClickListener(v -> {
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length; // Cycle through backgrounds
            // Implement animation when switching backgrounds
            animateBackgroundChange(backgrounds[currentBackgroundIndex]);
        });
    }

    private void animateBackgroundChange(int newBackground) {
        // Create an animator to fade the background in/out
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(layout, "alpha", 1f, 0f);
        fadeOut.setDuration(300); // Fade out duration
        fadeOut.setInterpolator(new DecelerateInterpolator());

        fadeOut.addListener(new android.animation.AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                layout.setBackgroundResource(newBackground); // Change the background
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(layout, "alpha", 0f, 1f);
                fadeIn.setDuration(300); // Fade in duration
                fadeIn.start();
            }
        });
        fadeOut.start();
    }


}
