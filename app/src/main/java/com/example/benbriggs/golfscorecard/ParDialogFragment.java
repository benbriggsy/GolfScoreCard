package com.example.benbriggs.golfscorecard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by benbriggs on 22/09/2016.
 */
public class ParDialogFragment extends DialogFragment {

    public interface ParDialogListener {
        void onClick(DialogFragment dialog, int i, String[] types);
    }

    // Use this instance of the interface to deliver action events
    ParDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (ParDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    private String[] mParChoices = {
            "2",
            "3",
            "4",
            "5",
            "6"
    };

    public ParDialogFragment(){
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select par of next hole:");
        builder.setItems(mParChoices, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onClick(ParDialogFragment.this, i, mParChoices);
            }
        });
        return builder.create();
    }
}

