package org.computerized.pl.model.classStd;

import java.util.List;

public class ClassStdListVO {
    private Integer classId;
    private List<Integer> userList;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public List<Integer> getUserList() {
        return userList;
    }

    public void setUserList(List<Integer> userList) {
        this.userList = userList;
    }
}
