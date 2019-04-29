package net.lzzy.practicesonline.activities.activities;

import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import net.lzzy.practicesonline.R;
import net.lzzy.practicesonline.activities.fragment.PracticesFragment;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class ExplashActivity extends BaseActivity{
    private ServiceConnection connection;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchView searchView=findViewById(R.id.bar_title_sv);
        searchView.setQueryHint("请输入关键词搜索");
        SearchView.SearchAutoComplete auto = searchView.findViewById(R.id.search_src_text);
        auto.setHintTextColor(Color.WHITE);
        auto.setTextColor(Color.WHITE);
        ImageView icon=findViewById(R.id.search_button);
        ImageView icX=searchView.findViewById(R.id.search_close_btn);
        ImageView icG=searchView.findViewById(R.id.search_go_btn);
        icon.setColorFilter(Color.WHITE);
        icG.setColorFilter(Color.WHITE);
        icX.setColorFilter(Color.WHITE);
    }


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
