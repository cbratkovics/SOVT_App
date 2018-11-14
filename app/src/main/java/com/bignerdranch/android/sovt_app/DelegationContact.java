package com.bignerdranch.android.sovt_app;

public class DelegationContact {

    private String mDelegationName;
    private String mContactName;
    private String mContactEmail;

    public DelegationContact(String dName, String cName, String cEmail) {
        this.mDelegationName = dName;
        this.mContactName = cName;
        this.mContactEmail = cEmail;
    }

    public String getDelegationName() {
        return mDelegationName;
    }

    public void setDelegationName(String delegationName) {
        mDelegationName = delegationName;
    }

    public String getContactName() {
        return mContactName;
    }

    public void setContactName(String contactName) {
        mContactName = contactName;
    }

    public String getContactEmail() {
        return mContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        mContactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "DelegationContact{" +
                "mDelegationName='" + mDelegationName + '\'' +
                ", mContactName='" + mContactName + '\'' +
                ", mContactEmail='" + mContactEmail + '\'' +
                '}';
    }
}
