package dev.merz.webdavuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.thegrizzlylabs.sardineandroid.DavResource;
import com.thegrizzlylabs.sardineandroid.Sardine;
import com.thegrizzlylabs.sardineandroid.impl.OkHttpSardine;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Sardine sardine = new OkHttpSardine();
        sardine.setCredentials("admin", "admin");

        try {
            List<DavResource> resources = sardine.list("http://192.168.178.104:2342/originals/");

            for (DavResource res : resources)
            {
                System.out.println(res); // calls the .toString() method.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}