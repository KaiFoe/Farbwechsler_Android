package foerstermann.kai.farbwechsler.logic;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.SeekBar;
import android.widget.TextView;

import foerstermann.kai.farbwechsler.R;
import foerstermann.kai.farbwechsler.gui.MainActivity;

public class MainAcitivtyListener implements SeekBar.OnSeekBarChangeListener, TextWatcher {

    MainActivity mainActivity;
    int red, green, blue;
    TextView txtvResult;

    public MainAcitivtyListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        txtvResult = mainActivity.findViewById(R.id.txtvResult);
    }

    //region SeekBar-Methode(n)
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.sbRed:
                red = progress;
                mainActivity.txtRed.setText(String.valueOf(progress));
                break;
            case R.id.sbGreen:
                green = progress;
                mainActivity.txtGreen.setText(String.valueOf(progress));
                break;
            case R.id.sbBlue:
                blue = progress;
                mainActivity.txtBlue.setText(String.valueOf(progress));
                break;
        };
        txtvResult.setBackgroundColor(Color.rgb(red, green, blue));
        txtvResult.setText("#" + String.format("%02X", red) + String.format("%02X", green) + String.format("%02X", blue));
    }
    //region ungenutzte Methoden
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
    //endregion
    //endregion


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.equals(mainActivity.txtRed.getText())) {
            mainActivity.sbRed.setProgress((Integer.parseInt(s.toString())));
            mainActivity.txtRed.setSelection(s.length());
        }

        if (s.equals(mainActivity.txtGreen.getText())) {
            mainActivity.sbGreen.setProgress((Integer.parseInt(s.toString())));
            mainActivity.txtGreen.setSelection(s.length());
        }

        if (s.equals(mainActivity.txtBlue.getText())) {
            mainActivity.sbBlue.setProgress((Integer.parseInt(s.toString())));
            mainActivity.txtBlue.setSelection(s.length());
        }

    }
}
