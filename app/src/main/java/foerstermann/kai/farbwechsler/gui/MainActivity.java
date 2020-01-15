package foerstermann.kai.farbwechsler.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

import foerstermann.kai.farbwechsler.R;
import foerstermann.kai.farbwechsler.logic.MainAcitivtyListener;

public class MainActivity extends AppCompatActivity {

    MainAcitivtyListener mainAcitivtyListener;
    public SeekBar sbRed, sbGreen, sbBlue;
    public EditText txtRed, txtGreen, txtBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainAcitivtyListener = new MainAcitivtyListener(this);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        txtRed = findViewById(R.id.txtRed);
        txtGreen = findViewById(R.id.txtGreen);
        txtBlue = findViewById(R.id.txtBlue);

        sbRed.setOnSeekBarChangeListener(mainAcitivtyListener);
        sbGreen.setOnSeekBarChangeListener(mainAcitivtyListener);
        sbBlue.setOnSeekBarChangeListener(mainAcitivtyListener);

        txtRed.addTextChangedListener(mainAcitivtyListener);
        txtGreen.addTextChangedListener(mainAcitivtyListener);
        txtBlue.addTextChangedListener(mainAcitivtyListener);
    }
}
