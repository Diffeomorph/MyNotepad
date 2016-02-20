package com.nicae.Notepad.note_list;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.nicae.Notepad.BuildConfig;
import com.nicae.Notepad.R;

public class AboutDialog extends AlertDialog {

    private String aboutMessage;

    public AboutDialog(Context context) {
        super(context);
        setTitle(R.string.about_dialog_title);
        buildAboutMessage();
        setMessage("");
        setButton(BUTTON_POSITIVE, getContext().getString(R.string.action_close), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
    }

    private void buildAboutMessage() {
        String appVersion = BuildConfig.VERSION_NAME;
        aboutMessage = String.format(getContext().getString(R.string.about_dialog_msg_description), appVersion)
                + getContext().getString(R.string.about_dialog_msg_license_title)
                + getContext().getString(R.string.about_dialog_msg_license)
                + getContext().getString(R.string.about_dialog_msg_credits_title)
                + getContext().getString(R.string.about_dialog_msg_credits);
    }

    @Override
    public void show() {
        super.show();
        /* Get TextView from the original AlertDialog layout */
        TextView aboutContent = (TextView) findViewById(android.R.id.message);
        aboutContent.setText(Html.fromHtml(aboutMessage));
        aboutContent.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
