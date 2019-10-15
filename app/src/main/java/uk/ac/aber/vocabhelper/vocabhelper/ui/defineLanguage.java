package uk.ac.aber.vocabhelper.vocabhelper.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uk.ac.aber.vocabhelper.vocabhelper.R;


public class defineLanguage extends AppCompatActivity {
    public  EditText learn;
    public EditText language;

    public EditText getLearn() {
        return learn;
    }

    public void setLearn(EditText learn) {
        this.learn = learn;
    }

    public EditText getLanguage() {
        return language;
    }

    public String getStringLearn(){
        return learn.toString();
    }
    public String getStringLanguage(){
        return language.toString();
    }
    public void setLanguage(EditText language) {
        this.language = language;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.define_language);


        language = findViewById(R.id.defineInput);
         learn = findViewById(R.id.learnInput);
        Button enterBtn = (Button) findViewById(R.id.enter_button);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent startIntent = new Intent(getApplicationContext(),main.class);
           startActivity(startIntent);
            }
        });

    }

    public String getlang(){
        return language.toString();
    }
    public String getlearn(){
        return learn.toString();
    }
}
