package com.tablet.demotest;

class Lesson {
    private String grade;
    private String subject;
    private String code;
    private String name;
    private String teacher;
    private String url;

    String getGrade() {
        return grade;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }

    String getSubject() {
        return subject;
    }

    void setSubject(String subject) {
        this.subject = subject;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getTeacher() {
        return teacher;
    }

    void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public Lesson() {
    }

    public Lesson(String grade, String subject, String code, String name, String teacher, String url) {
        this.grade = grade;
        this.subject = subject;
        this.code = code;
        this.name = name;
        this.teacher = teacher;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "grade='" + grade + '\'' +
                ", subject='" + subject + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
