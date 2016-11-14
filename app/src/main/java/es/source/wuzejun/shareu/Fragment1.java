package es.source.wuzejun.shareu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wuzejun on 2016/11/2.
 */
public class Fragment1 extends Fragment{

    private View view;
    private Button btn_wifi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment1,container,false);

        btn_wifi = (Button) view.findViewById(R.id.btn_wifi);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WiFiDirectActivity.class);
                startActivity(intent);
            }
        });
    }
}
