package com.yavuzoktay.itsmeeapp;


import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.content.ContentResolverCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.yavuzoktay.itsmeeapp.helper.ContactHelper;

public class PhoneContactFragment extends Fragment {
    ListView listView ;
    SimpleCursorAdapter adapter ;

    int PERMISSION_READ_WRITE_CONTACTS=1000;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_phone_contact,container,false);

        listView = view.findViewById(R.id.list_view);

        showContacts();

        return  view;
    }

    private void showContacts() {
        Cursor cursor = ContactHelper.getContactCursor(getActivity().getContentResolver(),""); // get all contacts
        String[] fields=new String[]{ContactsContract.Data.DISPLAY_NAME};

        adapter=new SimpleCursorAdapter(getActivity(),android.R.layout.simple_list_item_multiple_choice,
                cursor,fields,new int[]{android.R.id.text1});
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
