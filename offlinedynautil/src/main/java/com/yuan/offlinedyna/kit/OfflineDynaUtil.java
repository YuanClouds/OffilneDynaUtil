package com.yuan.offlinedyna.kit;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

import com.yuan.offlinedyna.kit.action.NetWorkStateReceiver;

/**
 * Created by Yuan on 2017/2/20.
 * Detail
 */

public class OfflineDynaUtil {

    private NetWorkStateReceiver mNetWorkStateReceiver;
    private NetWorkStateReceiver.NetWorkStateListener netWorkStateListener;

    public void onCreate(Context context, NetWorkStateReceiver.NetWorkStateListener netWorkStateListener){
        this.netWorkStateListener = netWorkStateListener;
        initNetWorkStateReceiver(context);
    }

    public void onDestory(Context context){
        context.unregisterReceiver(mNetWorkStateReceiver);
    }

    private void initNetWorkStateReceiver(Context context){
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mNetWorkStateReceiver = new NetWorkStateReceiver();
        mNetWorkStateReceiver.setNetWorkStateListenerl(this.netWorkStateListener);

        context.registerReceiver(mNetWorkStateReceiver,filter);

    }

}
