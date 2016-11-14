package es.source.wuzejun.shareu;

/**
 * Created by wuzejun on 2016/11/1.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Entry extends AppCompatActivity {

    private RelativeLayout entry;
    private GestureDetector myGestureDetector;

    class myGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX()-e2.getX()>50){
                Intent intent = new Intent(Entry.this,LoginOrRegister.class);
                startActivity(intent);
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        entry = (RelativeLayout) findViewById(R.id.entry);
        myGestureDetector = new GestureDetector(new myGestureListener());
        entry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                myGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

}
