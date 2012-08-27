package com.quietretreat.util;

import com.quietretreat.WHOOPEE.R;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class OkDialog extends Dialog implements OnClickListener {
    Button okButton;

    public OkDialog(Context context, int message) {
    super(context);
    requestWindowFeature(Window.FEATURE_NO_TITLE);      /** 'Window.FEATURE_NO_TITLE' - Used to hide the title */
    setContentView(message);                                                    /**layout for dialog */
    okButton = (Button) findViewById(R.id.OkButton);
    okButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    /** When OK Button is clicked, dismiss the dialog */
    if (v == okButton)
    dismiss();
    }

    }
