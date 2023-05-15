package JavaBase.Other;

import java.util.Date;

public class Student {

    private Integer id;
    private String name;
    private Boolean deleteFlag;
    private Date createTime;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createTime=" + createTime +
                '}';
    }

    public Student() {
    }

    public Student(Integer id, String name, Boolean deleteFlag, Date createTime) {
        this.id = id;
        this.name = name;
        this.deleteFlag = deleteFlag;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
