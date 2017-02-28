package com.yuan.offlinedyna.kit.view;

import android.app.Activity;
import android.os.Bundle;

import com.yuan.offlinedyna.kit.OfflineDynaUtil;
import com.yuan.offlinedyna.kit.action.NetWorkStateReceiver;

/**
 * Created by Yuan on 2017/2/28.
 * Detail
 */

public abstract class OfflineActionActivity extends Activity{

    private OfflineDynaUtil offlineDynaUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        offlineDynaUtil = new OfflineDynaUtil();
        offlineDynaUtil.onCreate(this, new NetWorkStateReceiver.NetWorkStateListener() {
            @Override
            public void disConnect() {
                disConnectListenter();
            }

            @Override
            public void resumeConnect() {
                resumeConnecListentert();
            }
        });

    }

    @Override
    protected void onDestroy() {
        offlineDynaUtil.onDestory(this);
        super.onDestroy();
    }

    public abstract void disConnectListenter();
    public abstract void resumeConnecListentert();
}
