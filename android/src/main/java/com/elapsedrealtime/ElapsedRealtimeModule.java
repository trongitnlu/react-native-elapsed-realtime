package com.elapsedrealtime;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ElapsedRealtimeModule.NAME)
public class ElapsedRealtimeModule extends ReactContextBaseJavaModule {
  public static final String NAME = "ElapsedRealtime";

  public ElapsedRealtimeModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  /**
   * Return a relative unit of time in seconds that cannot be influenced by the user
   */
  @ReactMethod(isBlockingSynchronousMethod = true)
  public String getElapsedRealtime() {
    // System time in milliseconds
    long time = android.os.SystemClock.elapsedRealtime();

    // Return the elapsed time in seconds
    return Long.toString(time / 1000);
  }
}
