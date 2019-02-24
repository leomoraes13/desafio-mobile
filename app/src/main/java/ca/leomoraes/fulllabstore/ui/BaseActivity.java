package ca.leomoraes.fulllabstore.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ca.leomoraes.fulllabstore.R;
import ca.leomoraes.fulllabstore.util.MessageHelper;

public abstract class BaseActivity extends AppCompatActivity {

    private MessageHelper messageHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        messageHelper = new MessageHelper(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        ButterKnife.bind(this);
        setupViewModel();
    }

    // Método para informar o id do layout
    abstract @LayoutRes int getLayoutResId();

    // Método pra criar o ViewModel e observar as variáveis
    abstract void setupViewModel();


    public void displayLoading() {
        messageHelper.displayLoading();
    }

    public void hideLoading() {
        messageHelper.hideLoading();
    }


    // Mensagens
    // Erros
    public void displayErrorMessage(@StringRes int messageResId,
                                    MessageHelper.MessageCallback callback) {
        displayErrorMessage(getString(messageResId), callback);
    }

    public void displayErrorMessage(@NonNull String message,
                                    MessageHelper.MessageCallback callback) {
        this.messageHelper.displayErrorMessage(message, callback);
    }
}
