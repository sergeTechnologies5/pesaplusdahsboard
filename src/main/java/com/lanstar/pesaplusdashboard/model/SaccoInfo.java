package com.lanstar.pesaplusdashboard.model;

public class SaccoInfo {
    private Long id;

    public SaccoInfo() {
    }

    public SaccoInfo(Long id) {
        this.id = id;
    }

    // Getter Methods

    public float getId() {
        return id;
    }

    // Setter Methods


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
