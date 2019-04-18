package net.lzzy.practicesonline.activities.models.views;

import net.lzzy.practicesonline.activities.models.BaseEntity;
import net.lzzy.sqllib.Ignored;
import net.lzzy.sqllib.Sqlitable;

import java.util.UUID;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class Option extends BaseEntity implements Sqlitable {
    @Ignored
    public static  final String COL_QUESTION_ID="questionld";
    private String content;
    private String label;
    private UUID questionld;
    private boolean isAnswer;
    private int apild;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public UUID getQuestionld() {
        return questionld;
    }

    public void setQuestionld(UUID questionld) {
        this.questionld = questionld;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    public int getApild() {
        return apild;
    }

    public void setApild(int apild) {
        this.apild = apild;
    }

    @Override
    public boolean needUpdate() {
        return false;
    }
}
