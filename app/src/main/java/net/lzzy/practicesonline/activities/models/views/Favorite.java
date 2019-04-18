package net.lzzy.practicesonline.activities.models.views;

import net.lzzy.practicesonline.activities.models.BaseEntity;
import net.lzzy.sqllib.Ignored;
import net.lzzy.sqllib.Sqlitable;

import java.util.UUID;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class Favorite extends BaseEntity implements Sqlitable {
    @Ignored
    public static final  String COL_QUESTINON_IP ="questionld";
    private UUID questionld;


    public UUID getQuestionld() {
        return questionld;
    }

    public void setQuestionld(UUID questionld) {
        this.questionld = questionld;
    }


    @Override
    public boolean needUpdate() {
        return false;
    }
}
