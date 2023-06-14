package com.example.poweroptimizationforpixelalwaysonvoicerecognition;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sampleText);
        tv.setText(stringFromJNI());

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNextButtonClick();
            }
        });

        enableBlackAndWhiteTheme(); // Enable the black and white theme
    }

    /**
     * A native method that is implemented by the 'poweroptimizationforpixelalwaysonvoicerecognition' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Native method for handling the next button click
    public native void handleNextButtonClick();

    // Native method for enabling the black and white theme
    public native void enableBlackAndWhiteTheme();

    // Used to load the 'poweroptimizationforpixelalwaysonvoicerecognition' library on application startup.
    static {
        System.loadLibrary("poweroptimizationforpixelalwaysonvoicerecognition");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        enableBlackAndWhiteTheme(); // Enable the black and white theme when configuration changes
    }
}
