package net.lzzy.practicesonline.activities.models;

import net.lzzy.practicesonline.activities.constants.ApiConstants;
import net.lzzy.practicesonline.activities.models.BaseEntity;
import net.lzzy.sqllib.Ignored;
import net.lzzy.sqllib.Jsonable;
import net.lzzy.sqllib.Sqlitable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class Option extends BaseEntity implements Sqlitable , Jsonable {
    @Ignored
    public static  final String COL_QUESTION_ID="questionld";
    private String content;
    private String label;
    private UUID questionId;
    private boolean isAnswer;
    private int apiId;

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
        return questionId;
    }

    public void setQuestionld(UUID questionld) {
        this.questionId = questionld;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    public int getApild() {
        return apiId;
    }

    public void setApild(int apild) {
        this.apiId = apild;
    }

    @Override
    public boolean needUpdate() {
        return false;
    }

    @Override
    public JSONObject toJson() throws JSONException {
        return null;
    }

    @Override
    public void fromJson(JSONObject jsonObject) throws JSONException {
        content=jsonObject.getString(ApiConstants.JSON_OPTION_CONTENT);
        label=jsonObject.getString(ApiConstants.JSON_OPTION_LABEL);
        apiId=jsonObject.getInt(ApiConstants.JSON_OPTION_API_ID);

    }
}
