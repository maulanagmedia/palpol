package com.maulana.custommodul.CustomView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maulana.custommodul.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Shinmaul on 1/25/2018.
 */

public class DialogBox {

    private Context context;
    private AlertDialog.Builder builder;
    private AlertDialog alert;


    public DialogBox(Context context){

        this.context = context;
        builder = new AlertDialog.Builder(context);
        alert = builder.create();
    }

    public void showDialog(boolean showButton){

        if(!alert.isShowing()){
            builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) ((Activity)context).getSystemService(LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.layout_loading, null);
            builder.setView(viewDialog);
            builder.setCancelable(false);

            final TextView tvText1 = (TextView) viewDialog.findViewById(R.id.tv_text1);
            final Button btnOK = (Button) viewDialog.findViewById(R.id.btn_ok);
            final ImageView ivCancel = (ImageView) viewDialog.findViewById(R.id.iv_cancel);

            if(!showButton) btnOK.setVisibility(View.GONE);

            alert = builder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            final AlertDialog alertDialogs = alert;

            ivCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog dialogCancel = new AlertDialog.Builder(context)
                            .setTitle("Konfirmasi")
                            .setMessage("Apakah anda yakin ingin membatalkan proses?")
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    try {
                                        alertDialogs.dismiss();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                }
            });

            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {

                    if(alert != null) {

                        try {
                            alert.dismiss();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            try {

                alert.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void showDialog(View.OnClickListener onClickListener, String buttonText, String message){

        if(!alert.isShowing()){

            builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) ((Activity)context).getSystemService(LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.layout_loading, null);
            builder.setView(viewDialog);
            builder.setCancelable(false);

            final TextView tvText1 = (TextView) viewDialog.findViewById(R.id.tv_text1);
            final Button btnOK = (Button) viewDialog.findViewById(R.id.btn_ok);
            final ImageView ivCancel = (ImageView) viewDialog.findViewById(R.id.iv_cancel);

            tvText1.setText(message);
            btnOK.setText(buttonText);

            alert = builder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            final AlertDialog alertDialogS = alert;

            btnOK.setOnClickListener(onClickListener);

            ivCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog dialogCancel = new AlertDialog.Builder(context)
                            .setTitle("Konfirmasi")
                            .setMessage("Apakah anda yakin ingin membatalkan proses?")
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    try {
                                        alertDialogS.dismiss();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                }
            });

            try {

                alert.show();
            }catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    public void dismissDialog(){

        if(alert != null && alert.isShowing()){

            try {
                alert.dismiss();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void showDialog(Context context,int state, String message){

        if(state == 1){

            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) ((Activity)context).getSystemService(LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.layout_success, null);
            builder.setView(viewDialog);
            builder.setCancelable(false);

            final TextView tvText1 = (TextView) viewDialog.findViewById(R.id.tv_text1);
            tvText1.setText(message);
            final Button btnOK = (Button) viewDialog.findViewById(R.id.btn_ok);

            final AlertDialog alert = builder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {

                    if(alert != null) {

                        try {
                            alert.dismiss();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            try {

                alert.show();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(state == 2){

            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) ((Activity)context).getSystemService(LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.layout_failed, null);
            builder.setView(viewDialog);
            builder.setCancelable(false);

            final TextView tvText1 = (TextView) viewDialog.findViewById(R.id.tv_text1);
            tvText1.setText(message);
            final Button btnOK = (Button) viewDialog.findViewById(R.id.btn_ok);

            final AlertDialog alert = builder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {

                    if(alert != null){

                        try {
                            alert.dismiss();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            try {
                alert.show();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(state == 3){

            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = (LayoutInflater) ((Activity)context).getSystemService(LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater.inflate(R.layout.layout_warning, null);
            builder.setView(viewDialog);
            builder.setCancelable(false);

            final TextView tvText1 = (TextView) viewDialog.findViewById(R.id.tv_text1);
            tvText1.setText(message);
            final Button btnOK = (Button) viewDialog.findViewById(R.id.btn_ok);

            final AlertDialog alert = builder.create();
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {

                    if(alert != null) {

                        try {
                            alert.dismiss();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            });

            try {
                alert.show();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
