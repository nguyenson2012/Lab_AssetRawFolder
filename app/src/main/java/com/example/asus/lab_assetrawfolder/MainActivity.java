package com.example.asus.lab_assetrawfolder;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewCenter;
    TextView tvExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewCenter=(ImageView)findViewById(R.id.image_center);
        tvExample=(TextView)findViewById(R.id.tv_example);
        //tvExample.setText(getResources().getString(R.string.article));
        setCustomFont();
        openImageFromAsset();


    }

    private void openImageFromAsset() {
        // load image
        try {
            // get input stream
            InputStream ims = getAssets().open("heart.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageViewCenter.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }

    private void setCustomFont() {
        tvExample.setText(readFileTxtFromAsset("example.txt"));
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/blownormal.ttf");
        tvExample.setTypeface(face);
    }


    public  String readFileTxtFromAsset(String nameFile){
        StringBuilder buf=new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(nameFile)));
            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                buf.append(mLine);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return buf.toString();
    }
}
