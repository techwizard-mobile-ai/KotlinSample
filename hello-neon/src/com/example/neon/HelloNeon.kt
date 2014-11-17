package com.example.neon

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

public class HelloNeon : Activity() {
    /** Called when the activity is first created. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* Create a TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        val tv = TextView(this)
        tv.setText(stringFromJNI())
        setContentView(tv)
    }

    /* A native method that is implemented by the
     * 'helloneon' native library, which is packaged
     * with this application.
     */
    native fun stringFromJNI(): String = null!!

    class object {

        /* this is used to load the 'helloneon' library on application
     * startup. The library has already been unpacked into
     * /data/data/com.example.neon/lib/libhelloneon.so at
     * installation time by the package manager.
     */
        {
            System.loadLibrary("helloneon")
        }
    }
}
