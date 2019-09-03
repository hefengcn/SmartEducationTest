package com.tablet.demotest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {

            case R.id.button_edu_course:
                Intent intent = new Intent(ACTION_CONTENT_PUSH);
                String content = getLessonContent();
                intent.putExtra("type", EDU_COURSE);
                intent.putExtra("content", content);
                sendBroadcast(intent);
                break;

            case R.id.button_oral_training:
                intent = new Intent(ACTION_CONTENT_PUSH);
                intent.putExtra("type", ORAL_TRAINING);
                sendBroadcast(intent);
                break;
        }
    }

    private String getLessonContent() {
        Gson gson = new Gson();
        Lesson lesson = new Lesson();
        lesson.setGrade("初一");
        lesson.setCode("c1lsp05");
        lesson.setSubject("历史");
        lesson.setName("千古一帝秦始皇");
        lesson.setTeacher("王宗琦");
        lesson.setUrl("https://static.chinaedu.com/commonplayer/play.html?uid=a03d10f4-b4ac-4d0b-8fde-10e4b6716a36&c=1");
        return gson.toJson(lesson);
    }
}
