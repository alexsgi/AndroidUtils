package alexsgi.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class ActivityUtils {

    public static void setLightStatusBar(View view, Activity activity) {
        int flags = view.getSystemUiVisibility();
        flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        view.setSystemUiVisibility(flags);
        activity.getWindow().setStatusBarColor(Color.WHITE);
    }

    public static void clearLightStatusBar(Activity activity, int color) {
        activity.getWindow().setStatusBarColor(color);
    }

    public static void setPortraitMode(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void setLandscapeMode(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public static void setAutomaticMode(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    public static int getRequestedOrientation(Activity activity) {
        return activity.getRequestedOrientation();
    }

    public static void startActivity(Activity activity, Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
    }

    public static void startActivity(Activity activity, Class<?> cls, boolean finishActivity) {
        activity.startActivity(new Intent(activity, cls));
        if (finishActivity) activity.finish();
    }

    public static void startActivity(final Activity activity, final Class<?> cls, int delay) {
        new CountDownTimer(delay, delay) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                activity.startActivity(new Intent(activity, cls));
            }
        }.start();
    }

    public static void startActivity(final Activity activity, final Class<?> cls, final boolean finishActivity, int delay) {
        new CountDownTimer(delay, delay) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                activity.startActivity(new Intent(activity, cls));
                if (finishActivity) activity.finish();
            }
        }.start();
    }

    public static void clearTextOnViews(View... views) {
        for (View view : views) {
            if (view instanceof TextView) {
                ((TextView) view).setText("");
            }
        }
    }

}