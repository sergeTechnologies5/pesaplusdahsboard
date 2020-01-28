package com.lanstar.pesaplusdashboard.Response;

public class SaccoResponse {

        Long saccoId;
        String saccoName;

    public SaccoResponse() {
    }

    public SaccoResponse(Long saccoId, String saccoName) {
        this.saccoId = saccoId;
        this.saccoName = saccoName;
    }

    public Long getSaccoId() {
        return saccoId;
    }

    public void setSaccoId(Long saccoId) {
        this.saccoId = saccoId;
    }

    public String getSaccoName() {
        return saccoName;
    }

    public void setSaccoName(String saccoName) {
        this.saccoName = saccoName;
    }
}
