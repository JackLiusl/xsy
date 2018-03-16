package com.sys.Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: Shanlin Liu
 * @Email: liushanlin1127@163.com
 * @QQ: 757712582
 * @Blog: www.lausl.com
 * @Date: 2017/12/24 22:42
 */
public abstract class BaseModel<T> implements Serializable {
    protected String id;
    protected Date createDate;
    protected Date updateDate;

    public void preInsert(){
        setId(IdGen.uuid());
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
