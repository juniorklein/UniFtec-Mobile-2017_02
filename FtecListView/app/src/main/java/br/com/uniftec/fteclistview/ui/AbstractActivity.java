package br.com.uniftec.fteclistview.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.uniftec.fteclistview.R;

/**
 * Created by marioklein on 05/10/17.
 */

public abstract class AbstractActivity extends AppCompatActivity {

    protected ActionBar actionBar;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setupView();
    }

    protected abstract int getLayoutRes();
    protected abstract void setupView();

}
