package com.yavuzoktay.itsmeeapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button itsMeContact,phoneContact;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=getFragmentManager();

        itsMeContact= (Button) findViewById(R.id.its_me_contact);
        phoneContact= (Button) findViewById(R.id.phone_contact);

        itsMeContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager = getFragmentManager();
                UserFragment userFragment = new UserFragment();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frame_layout, userFragment, "userFragment");

                transaction.commit();
            }
        });

        phoneContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                PhoneContactFragment phoneContact = new PhoneContactFragment();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frame_layout, phoneContact,"phoneContact");
                transaction.commit();
//
//                    PhoneContactFragment phoneContact= (PhoneContactFragment) manager.findFragmentByTag("fragg");
//                    FragmentTransaction transaction=manager.beginTransaction();
//                    if (phoneContact!=null){
//                        transaction.hide(phoneContact);
//                        transaction.commit();
//                    }
//                    else
//                        Toast.makeText(MainActivity.this, "fragmnetBulunamadı", Toast.LENGTH_SHORT).show();
//
           }
        });



    }




}