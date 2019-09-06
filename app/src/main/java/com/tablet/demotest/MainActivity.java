package com.tablet.demotest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_CONTENT_PUSH = "com.lenovo.smartedu.action.CONTENT_PUSH";
    public static final String EDU_COURSE = "101";
    public static final String ORAL_TRAINING = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init101CourseWebView();
        initOralTrainingWebView();
    }

    private void init101CourseWebView() {
        WebView webView = (WebView) findViewById(R.id.video_course_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://static.chinaedu.com/commonplayer/play.html?uid=c6dc74d05b69495c8922d4bf1c83016c&c=1");
    }

    private void initOralTrainingWebView() {
        WebView webView = (WebView) findViewById(R.id.oral_training_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://kouxunspeak.lenovoresearch2019.cn/mhome/");
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {

            case R.id.button_edu_course:
                Intent intent = new Intent(ACTION_CONTENT_PUSH);
                intent.setPackage("com.tablet.smartedu");
                String content = getLessonContent();
                intent.putExtra("type", EDU_COURSE);
                intent.putExtra("content", content);
                sendBroadcast(intent);
                break;

            case R.id.button_oral_training:
                intent = new Intent(ACTION_CONTENT_PUSH);
                intent.setPackage("com.tablet.smartedu");
                intent.putExtra("type", ORAL_TRAINING);
                intent.putExtra("content", "oral training");
                sendBroadcast(intent);
                break;
        }
    }

    private String getLessonContent() {
        Gson gson = new Gson();
        Lesson lesson = new Lesson();
        lesson.setGrade("初一");
        lesson.setCode("c1ywf149");
        lesson.setSubject("数学");
        lesson.setName("暑假专题——归纳与猜想");
        lesson.setTeacher("101老师");
        lesson.setUrl("https://static.chinaedu.com/commonplayer/play.html?uid=c6dc74d05b69495c8922d4bf1c83016c&c=1");
        return gson.toJson(lesson);
    }
}
