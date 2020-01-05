package alexsgi.utils;

import android.os.CountDownTimer;
import android.view.View;

public class FutureTaskExecutor {

    /**
     * @param runnable       Runnable to run after given time
     * @param millisInFuture Time to wait
     */
    public static void runDelayed(final Runnable runnable, int millisInFuture) {
        new CountDownTimer(millisInFuture, millisInFuture) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                runnable.run();
            }
        }.start();
    }

    /**
     * @param runnable       Runnable to run after given time
     * @param millisInFuture Time to wait
     * @param view           View to execute runnable on UI / main thread
     */
    public static void runDelayed(final Runnable runnable, int millisInFuture, final View view) {
        new CountDownTimer(millisInFuture, millisInFuture) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                view.post(runnable);
            }
        }.start();
    }

}
