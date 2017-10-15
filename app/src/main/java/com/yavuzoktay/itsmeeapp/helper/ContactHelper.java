package com.yavuzoktay.itsmeeapp.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by Yavuz on 15.10.2017.
 */

public class ContactHelper {
    public static Cursor getContactCursor(ContentResolver contactHelper, String startsWith) {
        String[] projection = {ContactsContract.CommonDataKinds.Phone._ID,
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cur=null;
        try {
            if (startsWith !=null && !startsWith.equals(""))
            {
                cur=contactHelper.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        projection,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " line \""
                        +startsWith + "%\"",null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        +" ASC");
            }
            else
            {
                cur=contactHelper.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        projection,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");
            }
            cur.moveToFirst();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cur;
    }

    public static void deleteContact(ContentResolver contactHelper,String number)
    {
        ArrayList<ContentProviderOperation> ops =new ArrayList<>();
        String[] args=new String[]{
                String.valueOf(getContactID(contactHelper,number))
        };
        ops.add(ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI).withSelection(ContactsContract.RawContacts.CONTACT_ID+"=?",args).build());
        try
        {
            contactHelper.applyBatch(ContactsContract.AUTHORITY,ops);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (OperationApplicationException e)
        {
            e.printStackTrace();
        }
    }

    private static long getContactID(ContentResolver contactHelper, String number)
    {
        Uri contactUri= Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,Uri.encode(number));
        String[] projection={ContactsContract.PhoneLookup._ID};
        Cursor cur=null;
        try
        {
            cur=contactHelper.query(contactUri,projection,null,null,null);
            if (cur.moveToFirst())
            {
                int personID=cur.getColumnIndex(ContactsContract.PhoneLookup._ID);
                return cur.getLong(personID);
            }
            return -1;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (cur!=null){
                cur.close();
                cur=null;
            }

        }
        return -1;
    }

    
}
