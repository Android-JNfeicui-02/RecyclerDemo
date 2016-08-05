package edu.feicui.recyclerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        TextView tv = (TextView) findViewById(R.id.detail_tv);
        ImageView iv = (ImageView) findViewById(R.id.detail_iv);

        if (getIntent().getSerializableExtra("key") != null) {
            ItemBean bean = (ItemBean) getIntent().getSerializableExtra("key");
            //Toast.makeText(DetailActivity.this, ""+ bean.img, Toast.LENGTH_SHORT).show();
            Picasso.with(this).load(bean.img).into(iv);

            tv.setText(bean.text);
        }
    }
}
