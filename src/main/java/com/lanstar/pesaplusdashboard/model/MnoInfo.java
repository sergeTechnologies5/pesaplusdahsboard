package com.lanstar.pesaplusdashboard.model;

public class MnoInfo {
    private Long id;

    public MnoInfo() {
    }

    public MnoInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MnoInfo{" +
                "id=" + id +
                '}';
    }
}
