package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup RG1, RG2, RG3;
    EditText etReflection;
    Button btnOK;
    RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RG1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        RG2 = (RadioGroup) findViewById(R.id.RadioGroup2);
        RG3 = (RadioGroup) findViewById(R.id.RadioGroup3);
        etReflection = (EditText) findViewById(R.id.editTextReflection);

        btnOK = (Button) findViewById(R.id.ButtonOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int RB1 = RG1.getCheckedRadioButtonId();
                int RB2 = RG2.getCheckedRadioButtonId();
                int RB3 = RG3.getCheckedRadioButtonId();

                rb1 = (RadioButton) findViewById(RB1);
                rb2 = (RadioButton) findViewById(RB2);
                rb3 = (RadioButton) findViewById(RB3);

                String[] info = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), etReflection.getText().toString()};

                Intent i = new Intent(MainActivity.this,
                        Main2Activity.class);
                // Pass the String array holding the name & age to new activity
                i.putExtra("info", info);
                // Start the new activity
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        int rbFirst = RG1.getCheckedRadioButtonId();
        int rbSecond = RG2.getCheckedRadioButtonId();
        int rbThird = RG3.getCheckedRadioButtonId();
        String strReflection = etReflection.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("first", rbFirst);
        prefEdit.putInt("second", rbSecond);
        prefEdit.putInt("third", rbThird);
        prefEdit.putString("reflection", strReflection);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int strFirst = prefs.getInt("first", 0);
        int strSecond = prefs.getInt("second", 0);
        int strThird = prefs.getInt("third", 0);
        String strReflection = prefs.getString("reflection", "");

        etReflection.setText(strReflection);
        RG1.check(strFirst);
        RG2.check(strSecond);
        RG3.check(strThird);
    }
}
