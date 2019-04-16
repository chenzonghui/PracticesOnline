package net.lzzy.practicesonline.activities.activities;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import net.lzzy.practicesonline.R;
import net.lzzy.practicesonline.activities.fragment.SplashFragment;
import net.lzzy.practicesonline.activities.utils.AppUtils;

/**
 * Created by lzzy_gxy on 2019/4/11.
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutRes());
        populate();
        splashFragment();


    }
    public void splashFragment(){
        AppUtils.addActivity(this);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(getContainerId());
        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction().add(getContainerId(),fragment).commit();
        }
    }

    public abstract int getLayoutRes();
    /**
     * 绑定视图
     */

    protected abstract void populate();

    /**
     * 托管fragment 视图
     */
    protected abstract int getContainerId();
    /**
     * 生成托管fragment 对象
     */
    protected abstract Fragment createFragment();

    /**
     * @return
     */


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppUtils.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppUtils.setRunning(getLocalClassName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppUtils.setStopped(getLocalClassName());
    }
}




