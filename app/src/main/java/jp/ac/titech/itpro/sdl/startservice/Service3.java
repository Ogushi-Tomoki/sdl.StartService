package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(1000); // 1 sec

            Intent broadcastIntent = new Intent();
            broadcastIntent.putExtra("message", "Servise3からBroadcastで受け取ったよ！" +
                    "やったね！課題終了だ！");
            broadcastIntent.setAction("MY_ACTION");
            getBaseContext().sendBroadcast(broadcastIntent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}
