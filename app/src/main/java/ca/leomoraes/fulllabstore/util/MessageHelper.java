package ca.leomoraes.fulllabstore.util;

import android.app.Activity;
import android.graphics.Color;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import org.jetbrains.annotations.NotNull;

public final class MessageHelper {

    private Activity context;
    private SweetAlertDialog loadingDialog;

    public MessageHelper(Activity context) {
        this.context = context;
        loadingDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        loadingDialog.setCancelable(false);
        loadingDialog.getProgressHelper().setBarColor(Color.parseColor("#00bfa5"));
        loadingDialog.setTitleText("Carregando...");
    }

    public void displayLoading() {
        loadingDialog.show();
    }

    public void hideLoading() {
        loadingDialog.dismiss();
    }

    public void displayErrorMessage(@NotNull String message, MessageCallback callback) {
        displayDialog("Ops...", message, callback, SweetAlertDialog.ERROR_TYPE);
    }

    private void displayDialog(String title, String message, MessageCallback callback, int alertType) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, alertType);
        dialog.setCancelable(false);
        dialog.setTitleText(title)
                .setContentText(message)
                .setConfirmText("Fechar")
                .setConfirmClickListener(sDialog -> {
                    sDialog.dismissWithAnimation();
                    if (callback != null) {
                        callback.execute();
                    }
                })
                .show();

    }

    // -- Callback interfaces ---------------------------------------------------------------------

    public interface MessageCallback {
        void execute();
    }

}