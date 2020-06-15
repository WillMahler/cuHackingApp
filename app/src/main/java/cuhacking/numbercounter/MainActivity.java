package cuhacking.numbercounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String NUMBER_VALUE = "NumberValue";
    private TextView mNumberText;
    private int mNumberValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button incrementNumberButton = findViewById(R.id.numberButton);
        mNumberText = findViewById(R.id.numberTextView);
        mNumberText.setText(String.valueOf(mNumberValue));

        incrementNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++mNumberValue;
                mNumberText.setText(String.valueOf(mNumberValue));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(NUMBER_VALUE, mNumberValue);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mNumberValue = savedInstanceState.getInt(NUMBER_VALUE);
        mNumberText.setText(String.valueOf(mNumberValue));
    }
}
