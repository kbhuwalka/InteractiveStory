package com.app.kunal.interactivestory.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.kunal.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField= (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                if(name.equals("")) Toast.makeText(MainActivity.this, "Please enter a name",Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                    startStory(name);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }

    private void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

    private EditText mNameField ;
    private Button mStartButton;
}
