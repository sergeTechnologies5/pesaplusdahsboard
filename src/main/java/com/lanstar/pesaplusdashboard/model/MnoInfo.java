package com.lanstar.pesaplusdashboard.model;

public class MnoInfo {
    private Long id;

    public MnoInfo() {
    }

    public MnoInfo(Long id) {
        this.id = id;
    }

    // Getter Methods

    public Long getId() {
        return id;
    }


    // Setter Methods


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
