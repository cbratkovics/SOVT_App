package com.bignerdranch.android.sovt_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


//Class based on BNR ch 8 & 9
public class TeamInfoFragment extends Fragment {

    private static final String TAG = "TeamInfoFragment";
    private RecyclerView mContactRecyclerView;
    private ContactAdapter mAdapter;

    //when fragment is created, onCreateView is called
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.i(TAG, "onCreateView() called");

        //create view, inflated from contact_list layout
        View view = inflater.inflate(R.layout.contact_list, container, false);

        //link to RecyclerView, set LayoutManager
        mContactRecyclerView = (RecyclerView) view.findViewById(R.id.contact_recycler_view);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //function to update the UI when scrolling
        updateUI();

        return view;
    }

    private void updateUI() {
        Log.d(TAG, "updateUI()");
        ContactList contactList = ContactList.get(getActivity());
        List<Contact> contacts = contactList.getContacts();

        mAdapter = new ContactAdapter(contacts);
        mContactRecyclerView.setAdapter(mAdapter);
    }

    //ContactHolder class
    //extends ViewHolder which inflates a layout into a view in the RecyclerView
    private class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Contact mContact;
        private TextView mDelegationTextView;
        private TextView mNameTextView;
        private TextView mEmailTextView;

        //constructor
        public ContactHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.contact, parent, false));
            itemView.setOnClickListener(this);  //set onClickListener

            mDelegationTextView = (TextView) itemView.findViewById(R.id.delegation);
            mNameTextView = (TextView) itemView.findViewById(R.id.name);
            mEmailTextView = (TextView) itemView.findViewById(R.id.email);

        }

        public void bind(Contact contact) {
            mContact = contact;
            mDelegationTextView.setText(mContact.getDelegationName());
            mNameTextView.setText(mContact.getContactName());
            mEmailTextView.setText(mContact.getContactEmail());
        }

        @Override
        public void onClick(View view){
            Toast.makeText(getActivity(), mContact.getContactName() + " clicked!",
                            Toast.LENGTH_SHORT).show();
        }

    }


    //ContactAdapter class
    //Adapter manages ViewHolder
    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {

        private List<Contact> mContacts;

        public ContactAdapter(List<Contact> contacts) {
            mContacts = contacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ContactHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact contact = mContacts.get(position);
            holder.bind(contact);
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }
    }

}