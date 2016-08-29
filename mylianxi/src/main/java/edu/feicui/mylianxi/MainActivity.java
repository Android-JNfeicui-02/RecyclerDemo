package edu.feicui.mylianxi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends Activity {
String path="http://op.juhe.cn/onebox/weather/query?cityname=济南&key=c02eb21b6b4fb509aef0d4c0640bdf3c";
    private TextView mtv;
    private OkHttpClient mMclient;
    private Button mMbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtv = (TextView) findViewById(R.id.tv);
        mMbtn = (Button) findViewById(R.id.btn);
        mMclient = new OkHttpClient();
    }
    public void click(View view) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Request request=new Request.Builder().url(path).build();
                Call call = mMclient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }
                    @Override
                    public void onResponse(Response response) throws IOException {
                        String s = response.body().string();
                        System.out.println(s);
                        try {
                            parsejson(s);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }.start();
    }
    private void parsejson(String s) throws JSONException {
        JSONObject object=new JSONObject(s);
        JSONObject result = object.getJSONObject("result");
        JSONObject data = result.getJSONObject("data");
        JSONArray weather = data.getJSONArray("weather");
        JSONObject jsonObject = weather.getJSONObject(1);
        String date = jsonObject.getString("date");
        System.out.println("date的zhishi："+date);
    }
}
