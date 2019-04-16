package net.lzzy.practicesonline.activities.activities;

import androidx.fragment.app.Fragment;

import net.lzzy.practicesonline.R;
import net.lzzy.practicesonline.activities.fragment.PracticesFragment;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class ExplashActivity extends BaseActivity{
    @Override
    public int getLayoutRes() {
        return R.layout.activity_practives;
    }

    @Override
    protected void populate() {

    }


    @Override
    protected int getContainerId() {
       return R.id.activity_practices_container;
    }

    @Override
    protected Fragment createFragment() {
        return new PracticesFragment();
    }
}
