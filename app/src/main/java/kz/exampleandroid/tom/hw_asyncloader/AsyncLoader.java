package kz.exampleandroid.tom.hw_asyncloader;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.time.LocalDate;
import java.util.Date;

public class AsyncLoader extends AsyncTaskLoader<Intent> {
    public AsyncLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Intent loadInBackground() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "")
                .putExtra(AlarmClock.EXTRA_HOUR, 20)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);
    }
}
