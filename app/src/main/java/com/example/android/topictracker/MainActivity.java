package com.example.android.topictracker;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.key;

public class MainActivity extends AppCompatActivity{
    private String keyWord;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitst_page);

        /*Create the search notice text, textbox .*/
        final TextView searchNotice = (TextView) findViewById(R.id.notice_text);
        searchNotice.setText(R.string.search);
        final EditText keyWordTextBox = (EditText) findViewById(R.id.search_key);
        /*and search button and a onclick listener*/
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                keyWord = keyWordTextBox.getText().toString();

                //Create the intent to the list Activity to show search result
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    Intent searchBookIntent = new Intent(MainActivity.this, ShowNews.class);
                    //pass the String keyWord to another activity for request URL.
                    searchBookIntent.putExtra("message", keyWord);
                    startActivity(searchBookIntent);
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "No internet connection";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });


    }

}


