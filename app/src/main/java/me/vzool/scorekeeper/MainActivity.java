package me.vzool.scorekeeper;

import android.content.DialogInterface;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private int ps4_score = 0;
    private int xbox_score = 0;

    private TextView ps4_textview;
    private TextView xbox_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ps4_textview = (TextView) findViewById(R.id.ps4_score);
        xbox_textview = (TextView) findViewById(R.id.xbox_score);
    }

    public void PS4_AddPoint(View view) {

        if (ps4_textview != null) {

            ps4_textview.setText(String.format("%02d", ++ps4_score));
        }
    }

    public void PS4_MinusPoint(View view) {

        if (ps4_textview != null) {

            ps4_textview.setText(String.format("%02d", --ps4_score));
        }
    }

    public void xBox_AddPoint(View view) {

        if(xbox_textview != null){

            xbox_textview.setText(String.format("%02d", ++xbox_score));
        }
    }

    public void xBox_MinusPoint(View view) {

        if(xbox_textview != null){

            xbox_textview.setText(String.format("%02d", --xbox_score));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.reset_scores:
                confirmResetScore();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void confirmResetScore(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Warning!!!")
                .setMessage("You're about to delete scores, Are you sure?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                        resetScores();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void resetScores() {

        ps4_score = 0;
        xbox_score = 0;

        if (ps4_textview != null) {

            ps4_textview.setText(String.format("%02d", ps4_score));
        }

        if(xbox_textview != null){

            xbox_textview.setText(String.format("%02d", xbox_score));
        }
    }
}
