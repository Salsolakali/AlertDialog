package com.example.fernana6.alertdialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;
    Context context = this;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlert=findViewById(R.id.btnAlertDialog);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Titulo");
                alertDialogBuilder.setMessage("Mensaje")

                    .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast toast = Toast.makeText(context,R.string.aceptar,Toast.LENGTH_LONG);
                            toast.show();
                        }
                    })
                    .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast toast = Toast.makeText(context,R.string.cancelar,Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }
        });
    }
}
