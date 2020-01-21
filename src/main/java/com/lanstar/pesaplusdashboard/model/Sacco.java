package com.lanstar.pesaplusdashboard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Sacco implements Serializable {
    private String saccoName;

    private String saccoPin;

    private String saccoCsno;

    private String address;

    private String email;

    private String phoneNumber;

    private BigDecimal balanceAmount;

    private BigDecimal commission;

    private String paybill;
    private String initiator;
    private String initiatorPassword;
    private Boolean active;
    private Boolean chargeRequests;
    private BigDecimal maximumWithdrawable;

    private BigDecimal airtimeBalance;

    private int smsBalance;
    private String smsUsername;
    private String smsPassword;
    private Boolean hasAirtimePurchase;
    private BigDecimal mpesaBalance;
    private BigDecimal equityBalance;
    private String ip;
    private String machineId;
    private BigInteger transactionLimit;

    public Sacco() {
    }

    public Sacco(String saccoName, String saccoPin, String saccoCsno, String address, String email, String phoneNumber, BigDecimal balanceAmount, BigDecimal commission, String paybill, String initiator, String initiatorPassword, boolean active, boolean chargeRequests, BigDecimal maximumWithdrawable, BigDecimal airtimeBalance, int smsBalance, String smsUsername, String smsPassword, boolean hasAirtimePurchase, BigDecimal mpesaBalance, BigDecimal equityBalance, String ip, String machineId, BigInteger transactionLimit) {
        this.saccoName = saccoName;
        this.saccoPin = saccoPin;
        this.saccoCsno = saccoCsno;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balanceAmount = balanceAmount;
        this.commission = commission;
        this.paybill = paybill;
        this.initiator = initiator;
        this.initiatorPassword = initiatorPassword;
        this.active = active;
        this.chargeRequests = chargeRequests;
        this.maximumWithdrawable = maximumWithdrawable;
        this.airtimeBalance = airtimeBalance;
        this.smsBalance = smsBalance;
        this.smsUsername = smsUsername;
        this.smsPassword = smsPassword;
        this.hasAirtimePurchase = hasAirtimePurchase;
        this.mpesaBalance = mpesaBalance;
        this.equityBalance = equityBalance;
        this.ip = ip;
        this.machineId = machineId;
        this.transactionLimit = transactionLimit;
    }

    public String getSaccoName() {
        return saccoName;
    }

    public void setSaccoName(String saccoName) {
        this.saccoName = saccoName;
    }

    public String getSaccoPin() {
        return saccoPin;
    }

    public void setSaccoPin(String saccoPin) {
        this.saccoPin = saccoPin;
    }

    public String getSaccoCsno() {
        return saccoCsno;
    }

    public void setSaccoCsno(String saccoCsno) {
        this.saccoCsno = saccoCsno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getPaybill() {
        return paybill;
    }

    public void setPaybill(String paybill) {
        this.paybill = paybill;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getInitiatorPassword() {
        return initiatorPassword;
    }

    public void setInitiatorPassword(String initiatorPassword) {
        this.initiatorPassword = initiatorPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isChargeRequests() {
        return chargeRequests;
    }

    public void setChargeRequests(boolean chargeRequests) {
        this.chargeRequests = chargeRequests;
    }

    public BigDecimal getMaximumWithdrawable() {
        return maximumWithdrawable;
    }

    public void setMaximumWithdrawable(BigDecimal maximumWithdrawable) {
        this.maximumWithdrawable = maximumWithdrawable;
    }

    public BigDecimal getAirtimeBalance() {
        return airtimeBalance;
    }

    public void setAirtimeBalance(BigDecimal airtimeBalance) {
        this.airtimeBalance = airtimeBalance;
    }

    public int getSmsBalance() {
        return smsBalance;
    }

    public void setSmsBalance(int smsBalance) {
        this.smsBalance = smsBalance;
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    public boolean isHasAirtimePurchase() {
        return hasAirtimePurchase;
    }

    public void setHasAirtimePurchase(boolean hasAirtimePurchase) {
        this.hasAirtimePurchase = hasAirtimePurchase;
    }

    public BigDecimal getMpesaBalance() {
        return mpesaBalance;
    }

    public void setMpesaBalance(BigDecimal mpesaBalance) {
        this.mpesaBalance = mpesaBalance;
    }

    public BigDecimal getEquityBalance() {
        return equityBalance;
    }

    public void setEquityBalance(BigDecimal equityBalance) {
        this.equityBalance = equityBalance;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public BigInteger getTransactionLimit() {
        return transactionLimit;
    }

    public void setTransactionLimit(BigInteger transactionLimit) {
        this.transactionLimit = transactionLimit;
    }
}
