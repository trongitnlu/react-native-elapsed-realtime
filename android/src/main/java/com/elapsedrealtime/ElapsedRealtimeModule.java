package com.elapsedrealtime;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
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
     * @param promise
     */
    @ReactMethod
    public void getElapsedRealtime(Promise promise) {
      // System time in milliseconds
      long time = android.os.SystemClock.elapsedRealtime();

      // React Native bridge complains if we try to pass back a long directly
      promise.resolve(Long.toString(time / 1000));
    }
}
