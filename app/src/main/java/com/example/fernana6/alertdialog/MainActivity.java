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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAlert, btnList;
    Context context = this;
    ArrayList mSelectedItems = new ArrayList();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnAlert = findViewById(R.id.btnAlertDialog);
        btnList = findViewById(R.id.AlertDialogList);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Titulo");
                alertDialogBuilder.setMessage("Mensaje")

                        .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(context, R.string.aceptar, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        })
                        .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(context, R.string.cancelar, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                alertDialog.show();

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertListDialogBuilder = new AlertDialog.Builder(context);
                mSelectedItems.removeAll(mSelectedItems);
                alertListDialogBuilder.setTitle(R.string.colores)
                        .setMultiChoiceItems(R.array.colores, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if (b) {
                                    mSelectedItems.add(i);
                                } else if (mSelectedItems.contains(i)) {
                                    mSelectedItems.remove(Integer.valueOf(i));
                                }
                            }
                        })
                        .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(context, mSelectedItems.toString(), Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        })
                        .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast toast = Toast.makeText(context, R.string.cancelar, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });
                alertListDialogBuilder.create().show();
            }
        });
    }
}
