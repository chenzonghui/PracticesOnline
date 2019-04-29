package net.lzzy.practicesonline.activities.models;

import android.content.Context;
import android.content.SharedPreferences;

import net.lzzy.practicesonline.activities.utils.AppUtils;
import net.lzzy.practicesonline.activities.utils.DateTimeUtils;

import java.util.Date;

/**
 * Created by lzzy_gxy on 2019/4/24.
 * Description:
 */
public class UserCookies  {
    public static final String KEY_TIME = "keyTime";
    private SharedPreferences seTime;
    private static final UserCookies INSTANCE =new UserCookies();

    private UserCookies(){
        seTime = AppUtils.getContext().getSharedPreferences("refresh_time", Context.MODE_PRIVATE);
    }
    public static UserCookies getInstance(){
        return INSTANCE;
    }
    public void updateLastRefreshTime(){
        String time = DateTimeUtils.DATE_TIME_FORMOT.format(new Date());
        seTime.edit().putString(KEY_TIME,time).apply();
    }
    public String getLastRefreshTime(){
        return seTime.getString(KEY_TIME,"");
    }
}
