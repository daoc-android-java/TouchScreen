package ute.fcii.dsii.touchscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawingView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.puntoYfondo:
                setContentView(new DrawingView(this));
                break;
            case R.id.lineas:
                setContentView(new DrawingView2(this));
                break;
            case R.id.dedos:
                setContentView(new DrawingView3(this));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
