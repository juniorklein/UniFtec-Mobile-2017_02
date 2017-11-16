package br.com.uniftec.fteclistview.ui;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.uniftec.fteclistview.DataSource;
import br.com.uniftec.fteclistview.R;
import br.com.uniftec.fteclistview.adapter.FilmeAdapter;
import br.com.uniftec.fteclistview.model.Filme;
import br.com.uniftec.fteclistview.model.PopularResponse;
import br.com.uniftec.fteclistview.task.CarregarPapularesTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFilmesFragment extends Fragment implements AdapterView.OnItemClickListener, CarregarPapularesTask.CarregarPopularesDelegate {

    private ListView listViewFilmes;
    private FilmeAdapter adapter;
    private List<Filme> dataSource;
    private ProgressDialog progressDialog;

    public ListaFilmesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_filmes, container, false);

        listViewFilmes = (ListView)view.findViewById(R.id.list_view_filmes);
        listViewFilmes.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        dataSource = new ArrayList<>();
        adapter = new FilmeAdapter(getActivity(), 0, dataSource);
        listViewFilmes.setAdapter(adapter);

        progressDialog = ProgressDialog.show(getActivity(), "Aguarde", "Carregando filmes", true, false);

        CarregarPapularesTask task = new CarregarPapularesTask(this);
        task.execute("8cc65cc237509b082427cce84df4fe28");

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Filme filme = adapter.getItem(position);

        Intent intent = new Intent(getActivity(), FilmeActivity.class);
        intent.putExtra(FilmeActivity.FILME_PARAMETER, filme);

        startActivity(intent);
    }

    @Override
    public void sucesso(PopularResponse popularResponse) {
        dataSource.clear();
        dataSource.addAll(popularResponse.getFilmes());

        adapter.notifyDataSetChanged();

        progressDialog.dismiss();
        progressDialog = null;
    }

    @Override
    public void falha(String mensagem) {
        progressDialog.dismiss();
        progressDialog = null;

        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_LONG).show();
    }
}
