package com.example.storageexternalprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText fileName, fileText;
    String filePath = "MyFileDir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = findViewById(R.id.fileName);
        fileText = findViewById(R.id.fileText);
    }

    public boolean isExternalStorageWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return true;
        }else{
            return false;
        }
    }

    public void saveData(View view) {
        if (isExternalStorageWritable()){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
            }

            File txtFile = new File(getExternalFilesDir(filePath),fileName.getText().toString());

            try {
                FileOutputStream fos=new FileOutputStream(txtFile);
                fos.write(fileText.getText().toString().getBytes());
                fos.close();
                Toast.makeText(this,"File is saved",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            fileText.setText("");
        }
        else {
            Toast.makeText(this,"Cannot Save the file",Toast.LENGTH_LONG).show();
        }
    }

    public void loadData(View view) {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
        }
        FileReader fr = null;
        File txtFile = new File(getExternalFilesDir(filePath),fileName.getText().toString());

        StringBuilder sb = new StringBuilder();

        try {
            fr = new FileReader(txtFile);
            BufferedReader br = new BufferedReader(fr);
            String text = br.readLine();

            while (text!=null) {
                sb.append(text).append("\n");
                text = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String Content = "File Content is :"+sb.toString();
        fileText.setText(Content);

    }
}