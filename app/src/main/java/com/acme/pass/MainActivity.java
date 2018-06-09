package com.acme.pass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When R.id.validate is clicked,
        Button validateButton = findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  save the pw value as pw
                EditText pw = findViewById(R.id.passwordInput);
                TextView output = findViewById(R.id.strengthOutput);
                Validator validator = new Validator();
                int strength = 0;

                // get it's strength from the validate method
                try {
                    strength = validator.validate(pw.getText().toString());
                }
                catch (Exception e) { e.getStackTrace(); }

                // if the strength is bigger than 3
                if (strength > 3) {
                    // set strengthOutput to "Strong enough"
                    output.setText(new String("Strong enough"));
                }
                else {
                    // set strengthOutput to "Not strong enough"
                    output.setText(new String("Not strong enough"));
                }
            }
        });

    }
}
