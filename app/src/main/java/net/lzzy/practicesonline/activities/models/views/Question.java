package net.lzzy.practicesonline.activities.models.views;

import net.lzzy.practicesonline.activities.models.BaseEntity;
import net.lzzy.practicesonline.activities.models.views.Option;
import net.lzzy.practicesonline.activities.models.views.QuestionType;
import net.lzzy.sqllib.Ignored;
import net.lzzy.sqllib.Sqlitable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lzzy_gxy on 2019/4/16.
 * Description:
 */
public class Question  extends BaseEntity implements Sqlitable {
    public static  final  String COL_PRACTICE_ID="practiceld";
    private String content;
    @Ignored
    private QuestionType type;
    @Ignored
    private List<Option> options;
    private  int dbType;
    private  String analysis;
    private UUID practiceld;

    public Question(){
        options = new ArrayList<>();
    }
    @Override
    public boolean needUpdate() {
        return false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;

    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options.clear();
        this.options.addAll(options);
    }

    public int getDbType() {
        return dbType;

    }

    public void setDbType(int dbType) {
        this.dbType = dbType;
        type =QuestionType.getInstance(dbType);
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public UUID getPracticeld() {
        return practiceld;
    }

    public void setPracticeld(UUID practiceld) {
        this.practiceld = practiceld;
    }
}
