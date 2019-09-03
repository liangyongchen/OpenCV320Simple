package org.opencv.samples.facedetect;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
//    static {
//        //System.loadLibrary("DetectionBasedTracker_jni");
//        System.loadLibrary("native-lib");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
    final private static int requiresCameraPermission = 1004;
    //申请相机权限
    public static boolean requiresCameraPermission(Activity activity) {
        String[] perms = {Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(activity, perms)) {
            // Already have permission, do the thing
            // ...
            return true;
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(
                    activity,
                    "需要相机权限，来支持程序功能",
                    requiresCameraPermission,
                    perms);
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (requiresCameraPermission(MainActivity.this)){
            startActivity(new Intent(MainActivity.this, FdActivity.class));
        }
    }
}
