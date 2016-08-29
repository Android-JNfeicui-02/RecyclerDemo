package edu.feicui.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    Button btn_frag1;
    Button btn_frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1 = (Button) findViewById(R.id.btn_frag1);
        btn_frag2 = (Button) findViewById(R.id.btn_frag2);

        btn_frag1.setOnClickListener(this);
        btn_frag2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.btn_frag1:
                transaction.replace(R.id.insert_fragment,new FirstFragment());
                break;
            case R.id.btn_frag2:
                transaction.replace(R.id.insert_fragment,new SecondFragment());
                break;
        }
        transaction.commit();
    }
}
