package br.com.heiderlopes.demoactivityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tvNovoUsuario)
    TextView tvNovoUsuario;

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etSenha)
    EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvNovoUsuario)
    public void novoUsuarioClick() {
        Intent i = new Intent(this, NovoUsuarioActivity.class);
        startActivityForResult(i, 1);
    }

    @OnClick(R.id.btLogar)
    public void logarClick() {
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            switch (resultCode) {
                case RESULT_OK:
                    etUsername.setText(data.getStringExtra("USERNAME"));
                    break;

                case RESULT_CANCELED:
                    break;
            }
        }
    }
}
