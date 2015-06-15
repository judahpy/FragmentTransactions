package com.judahmarsh.fragmenttransactions;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
    }

    public void addA(View view){
        //create the object of fragment
        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction= manager.beginTransaction();
        //select where the transaction to be made
        //the id group
        //pASS OBJECT CREATED
        //create a hashmap reference
        transaction.add(R.id.group, f1, "A");
        //always commit
        transaction.commit();

    }

    public void addB(View view){
        //same again
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.group, f2, "B");
        transaction.commit();

    }

    public void removeA(View view){
        //find the tag we created in the hashmap
        FragmentA f1 = (FragmentA) manager.findFragmentByTag("A");
        FragmentTransaction transaction =manager.beginTransaction();

        //if statement to check if fragment exists
        if (f1 != null){
            transaction.remove(f1);
            transaction.commit();
        }else {
            Toast.makeText(this,"Fragment A was not found",Toast.LENGTH_SHORT).show();

        }

    }

    public void removeB(View view){
        FragmentB f2 = (FragmentB) manager.findFragmentByTag("B");
        FragmentTransaction transaction =manager.beginTransaction();

        //if statement to check if fragment exists
        if (f2 != null){
            transaction.remove(f2);
            transaction.commit();
        }else {
            Toast.makeText(this,"Fragment B was not found",Toast.LENGTH_SHORT).show();

        }

    }

    public void replaceA(View view){
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,f2,"B");
        transaction.commit();

    }

    public void replaceB(View view){

        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,f1,"A");
        transaction.commit();

    }

    public void attach(View view){

        FragmentA f1 = (FragmentA)manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();

        //check if fragment exist
        if (f1!= null){

            transaction.attach(f1);
            transaction.commit();
        }

    }

    public void detach(View view){

        FragmentA f1 = (FragmentA)manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();

        if (f1!=null){

            transaction.detach(f1);
            transaction.commit();

        }

    }


}