package net.lzzy.practicesonline.activities.models;

import net.lzzy.sqllib.AsPrimaryKey;

import java.util.UUID;

/**
 *
 * @author lzzy_gxy
 * @date 2019/3/11
 * Description:
 */
public class BaseEntity {
    @AsPrimaryKey
    protected UUID id;
    public  BaseEntity(){
        id = UUID.randomUUID();
    }

    public Object getIdentityValue() {
        return id;
    }

    public UUID getId() {
        return id;
    }
}
