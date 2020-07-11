package com.example.recyclerview.data;

import android.content.Context;

import java.util.ArrayList;

public class TopicInitializer implements DataInitializable {
    @Override
    public void runInitialization(Context context) {
        ArrayList<Topic> topics = new ArrayList<>();
        topics.addAll(createBasicEnglishCourseTopics(context));
        topics.addAll(createChildrenEnglishCourseTopics(context));
        topics.addAll(createHighSchoolEnglishCourseTopics(context));
        topics.addAll(createOfficeEnglishCourseTopics(context));
        topics.addAll(createProgrammingEnglishCourseTopics(context));
        topics.addAll(createTravelEnglishCourseTopics(context));
        topics.addAll(createIeltsCourseTopics(context));
        topics.addAll(createToeicCourseTopics(context));
        TopicDAO topicDAO = new TopicDAO(new DatabaseHelper(context));
        topicDAO.addTopics(topics);
    }

    ArrayList<Topic> createBasicEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.BASIC_ENGLISH);
        int courseId = course.getId();

        ArrayList<Topic> arrayListBasicEnglish = new ArrayList<>();
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ANIMAL));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.FAMILY));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.CLOTHES));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.COLOR));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.FRUIT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.COOKING));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.MUSIC));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.NUMBER));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.SCHOOL));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.SPORT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.TRAFFIC));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.VEGETABLE));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.WEATHER));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.HOSPITAL));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.RESTAURANT));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ADJECTIVE));
        arrayListBasicEnglish.add(new Topic(courseId, TopicDAO.ACTION));
        return arrayListBasicEnglish;
    }

    ArrayList<Topic> createChildrenEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_CHILDREN);
        int courseId = course.getId();

        ArrayList<Topic> arrayListChildrenEnglish = new ArrayList<>();

        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS1));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS2));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS3));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS4));
        arrayListChildrenEnglish.add(new Topic(courseId, TopicDAO.CLASS5));
        return arrayListChildrenEnglish;
    }

    ArrayList<Topic> createHighSchoolEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_HIGH_SCHOOL);
        int courseId = course.getId();

        ArrayList<Topic> arrayListHighSchoolEnglish = new ArrayList<>();
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 6"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 7"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 8"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 9"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 10"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 11"));
        arrayListHighSchoolEnglish.add(new Topic(courseId, "English class 12"));
        return arrayListHighSchoolEnglish;
    }

    ArrayList<Topic> createOfficeEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_OFFICE);
        int courseId = course.getId();

        ArrayList<Topic> arrayListOfficeEnglish = new ArrayList<>();
        arrayListOfficeEnglish.add(new Topic(courseId, "Position"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Department"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Office supplies"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Benefit"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Conference"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Machines"));
        arrayListOfficeEnglish.add(new Topic(courseId, "Common"));
        return arrayListOfficeEnglish;
    }

    ArrayList<Topic> createProgrammingEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_PROGRAMMING);
        int courseId = course.getId();

        ArrayList<Topic> arrayListProgrammingEnglish = new ArrayList<>();
        arrayListProgrammingEnglish.add(new Topic(courseId, "Computer structure"));
        arrayListProgrammingEnglish.add(new Topic(courseId, "Jobs"));
        arrayListProgrammingEnglish.add(new Topic(courseId, "Peripherals"));
        arrayListProgrammingEnglish.add(new Topic(courseId, "Meeting"));
        arrayListProgrammingEnglish.add(new Topic(courseId, "Machines"));
        arrayListProgrammingEnglish.add(new Topic(courseId, "Technology"));
        return arrayListProgrammingEnglish;
    }

    ArrayList<Topic> createTravelEnglishCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.ENGLISH_FOR_TRAVEL);
        int courseId = course.getId();

        ArrayList<Topic> arrayListTravelEnglish = new ArrayList<>();
        arrayListTravelEnglish.add(new Topic(courseId, "Tour guide"));
        arrayListTravelEnglish.add(new Topic(courseId, "Travel agency"));
        arrayListTravelEnglish.add(new Topic(courseId, "Hotel"));
        arrayListTravelEnglish.add(new Topic(courseId, "Sea"));
        arrayListTravelEnglish.add(new Topic(courseId, "Planes"));
        return arrayListTravelEnglish;
    }

    ArrayList<Topic> createIeltsCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.IELTS);
        int courseId = course.getId();

        ArrayList<Topic> arrayListIeltsEnglish = new ArrayList<>();
        arrayListIeltsEnglish.add(new Topic(courseId, "Overview"));
        arrayListIeltsEnglish.add(new Topic(courseId, "Listening"));
        arrayListIeltsEnglish.add(new Topic(courseId, "Speaking"));
        arrayListIeltsEnglish.add(new Topic(courseId, "Reading"));
        arrayListIeltsEnglish.add(new Topic(courseId, "Writing"));
        return arrayListIeltsEnglish;
    }

    ArrayList<Topic> createToeicCourseTopics(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        CourseDAO courseDAO = new CourseDAO(helper);
        Course course = courseDAO.getCourseByTitle(CourseInitializer.TOEIC);
        int courseId = course.getId();

        ArrayList<Topic> arrayListToeicEnglish = new ArrayList<>();
        arrayListToeicEnglish.add(new Topic(courseId, "Contracts"));
        arrayListToeicEnglish.add(new Topic(courseId, "Shopping"));
        arrayListToeicEnglish.add(new Topic(courseId, "Marketing"));
        arrayListToeicEnglish.add(new Topic(courseId, "Movies"));
        arrayListToeicEnglish.add(new Topic(courseId, "Accounting"));
        return arrayListToeicEnglish;
    }
}
