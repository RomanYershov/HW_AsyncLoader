package kz.exampleandroid.tom.hw_asyncloader;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Intent> {

    private static final int LOADER_ID=6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Loader<Intent> loader = getSupportLoaderManager().initLoader(LOADER_ID, null, this);

        ImageView setAlarmImage = findViewById(R.id.ma_set_alarm_iv);
        setAlarmImage.setOnClickListener(view -> loader.forceLoad());
    }

    @NonNull
    @Override
    public Loader<Intent> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new AsyncLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Intent> loader, Intent intent) {
         if(intent.resolveActivity(getPackageManager()) != null)
             startActivity(intent);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Intent> loader) {

    }
}
