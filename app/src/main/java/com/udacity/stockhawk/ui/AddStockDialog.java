package com.udacity.stockhawk.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.udacity.stockhawk.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddStockDialog extends DialogFragment {

    @BindView(R.id.dialog_stock)
    EditText stock;

    @BindView(R.id.bt_add)
    Button btAdd;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View custom = inflater.inflate(R.layout.add_stock_dialog, null);

        ButterKnife.bind(this, custom);

        stock.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                addStock();
                return true;
            }
        });
        stock.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 0)
                    btAdd.setEnabled(true);
                else
                    btAdd.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        builder.setView(custom);
        builder.setMessage(getString(R.string.dialog_title));

        Dialog dialog = builder.create();

        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }

        return dialog;
    }

    private void addStock() {
        Activity parent = getActivity();
        if (parent instanceof MainActivity) {
            ((MainActivity) parent).addStock(stock.getText().toString());
        }
        dismissAllowingStateLoss();
    }

    @OnClick(R.id.bt_add)
    public void add() {
        addStock();
    }

    @OnClick(R.id.bt_cancel)
    public void cancel() {
        dismissAllowingStateLoss();
    }
}