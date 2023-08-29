package com.example.alert_dialog_box;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms and Conditions"); // Corrected the typo here
        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog.setMessage("Read all terms and conditions?");

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "yes, I've read", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
            }
        });

        // Add this line to show the AlertDialog
        alertDialog.show();

        delete = findViewById(R.id.delBTN);

        AlertDialog.Builder delAlert = new AlertDialog.Builder(MainActivity.this);
        delAlert.setTitle("DELETE?");
        delAlert.setIcon(R.drawable.ic_baseline_delete_24);
        delAlert.setMessage("Are you sure want to delete?");

        delAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Delete successfully.", Toast.LENGTH_SHORT).show();
            }
        });
        delAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });
        delAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel.", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delAlert.show();
            }
        });
    }
}
