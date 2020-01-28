package com.lanstar.pesaplusdashboard.model;

public class SaccoInfo {
    private Long id;

    public SaccoInfo() {
    }

    public SaccoInfo(Long id) {
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
        return "SaccoInfo{" +
                "id=" + id +
                '}';
    }
}
