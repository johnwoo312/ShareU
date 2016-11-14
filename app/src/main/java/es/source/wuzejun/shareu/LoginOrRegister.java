package es.source.wuzejun.shareu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import es.source.wuzejun.shareu.activity.MainActivity;

/**
 * Created by wuzejun on 2016/11/1.
 */
public class LoginOrRegister extends AppCompatActivity{

    private Button denglu;
    private Button zhuce;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginorregister);

        denglu = (Button) findViewById(R.id.denglu);
        zhuce = (Button) findViewById(R.id.zhuce);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOrRegister.this,Main.class);
                startActivity(intent);
            }
        });

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOrRegister.this,Main.class);
                startActivity(intent);
            }
        });
    }
}
