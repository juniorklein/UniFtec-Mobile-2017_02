package br.com.uniftec.fteclistview.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.fteclistview.model.ResponseStatus;
import br.com.uniftec.fteclistview.model.Resposta;
import br.com.uniftec.fteclistview.model.Usuario;
import br.com.uniftec.fteclistview.service.UsuarioService;
import br.com.uniftec.fteclistview.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by marioklein on 16/11/17.
 */

public class IncluirUsuarioTask extends AsyncTask<Usuario, Void, Resposta<String>> {

    private IncluirUsuarioDelegate delegate;
    private UsuarioService usuarioService;

    public IncluirUsuarioTask(IncluirUsuarioDelegate delegate){
        this.usuarioService = ServerCommunicationUtil.getInstance()
                .getRetrofit()
                .create(UsuarioService.class);

        this.delegate = delegate;
    }

    @Override
    protected Resposta<String> doInBackground(Usuario... parameters) {

        Call<Resposta<String>> call = usuarioService.salvarUsuario(parameters[0]);
        try {
            Response<Resposta<String>> response = call.execute();
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Resposta<String> resposta) {
        if(resposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.incluirUsarioSucesso(resposta.getData());
        } else {
            delegate.incluirUsuarioFalha(resposta.getMessage());
        }
    }

    public interface IncluirUsuarioDelegate {
        public void incluirUsarioSucesso(String token);
        public void incluirUsuarioFalha(String mensagem);
    }
}

