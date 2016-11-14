package es.source.wuzejun.shareu.activity;

import android.support.v4.app.FragmentTransaction;

import es.source.wuzejun.shareu.R;
import es.source.wuzejun.shareu.activity.basic.BaseActivity;
import es.source.wuzejun.shareu.fragment.basic.BaseFragment;
import es.source.wuzejun.shareu.fragment.MainFragment;

/**
 * Created by wuzejun on 2016/11/2.
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        initMainFragment();
    }

    /**
     * 初始化内容Fragment
     *
     * @return void
     */
    public void initMainFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment mFragment = MainFragment.newInstance();
        transaction.replace(R.id.main_act_container, mFragment, mFragment.getFragmentName());
        transaction.commit();
    }

    @Override
    protected void initEvents() {

    }
}
