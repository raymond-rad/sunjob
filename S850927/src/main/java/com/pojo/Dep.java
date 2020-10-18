package com.pojo;

import java.util.HashSet;
import java.util.Set;

public class Dep {
    private int depId;
    private String depName;
    private Set<Emp> emps = new HashSet<Emp>();

    public Set getEmps() {
        return emps;
    }

    public void setEmps(Set emps) {
        this.emps = emps;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }




}
