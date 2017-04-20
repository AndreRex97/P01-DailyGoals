package sg.edu.rp.c346.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup RG1, RG2, RG3;
    EditText etReflection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RG1 = (RadioGroup) findViewById(R.id.RadioGroup1);
        RG2 = (RadioGroup) findViewById(R.id.RadioGroup2);
        RG3 = (RadioGroup) findViewById(R.id.RadioGroup3);
        etReflection = (EditText) findViewById(R.id.editTextReflection);

        int RB1 = RG1.getCheckedRadioButtonId();
        int RB2 = RG2.getCheckedRadioButtonId();
        int RB3 = RG3.getCheckedRadioButtonId();

        RadioButton rb1 = (RadioButton) findViewById(RB1);
        RadioButton rb2 = (RadioButton) findViewById(RB2);
        RadioButton rb3 = (RadioButton) findViewById(RB3);

        String[] info = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), etReflection.getText().toString()};

        Intent i = new Intent(MainActivity.this,
                Main2Activity.class);
        // Pass the String array holding the name & age to new activity
        i.putExtra("info", info);
        // Start the new activity
        startActivity(i);
    }
}
