package br.com.uniftec.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button button;
    private Button button2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.botao);
        button2 = (Button) findViewById(R.id.botao2);

        textView.setText("");

        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == button){

        } else if(view == button2){

        }

        String text = "Hello World " + editText.getText();
        textView.setText(text);
    }
}
