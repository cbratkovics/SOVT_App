package com.bignerdranch.android.sovt_app;

import java.util.UUID;

public class Contact {

    private UUID mId;
    private String mDelegationName;
    private String mContactName;
    private String mContactEmail;

    public Contact(String dName, String cName, String cEmail) {
        //mId = UUID.randomUUID();
        mDelegationName = dName;
        mContactName = cName;
        mContactEmail = cEmail;
    }
    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
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
        return "Contact{" +
                "mDelegationName='" + mDelegationName + '\'' +
                ", mContactName='" + mContactName + '\'' +
                ", mContactEmail='" + mContactEmail + '\'' +
                '}';
    }
}
