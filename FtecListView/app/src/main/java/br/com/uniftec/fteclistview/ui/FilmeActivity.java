package br.com.uniftec.fteclistview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.model.Filme;

public class FilmeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILME_PARAMETER = "FILME_PARAMETER";

    private Button fecharButton;
    private TextView tituloTextView;

    private Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        tituloTextView = (TextView)findViewById(R.id.activity_file_titulo);
        fecharButton = (Button)findViewById(R.id.activity_filme_fechar_button);
        fecharButton.setOnClickListener(this);

        filme = (Filme) getIntent().getSerializableExtra(FILME_PARAMETER);
        tituloTextView.setText(filme.getTitulo());
    }

    @Override
    public void onClick(View view) {
        if(view == fecharButton){
            finish();
        }
    }
}
