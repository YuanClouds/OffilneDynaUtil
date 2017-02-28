package com.yuan.sample.offlinedyna;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuan.offlinedyna.kit.view.OfflineActionActivity;

public class MainActivity extends OfflineActionActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.cat);

    }

    @Override
    public void disConnectListenter() {
        Toast.makeText(this,"网络已经断开",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resumeConnecListentert() {
        Toast.makeText(this,"网络已经恢复",Toast.LENGTH_SHORT).show();
    }
}
