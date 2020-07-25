import json

import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore


class Course(object):
    def __init__(self, name, number_of_words, number_of_topics):
        self.name = name
        self.introduction = name + " have " + str(number_of_topics) + " topics and " + str(number_of_words) + " words"
        self.numberOfWords = number_of_words
        self.numberOfTopics = number_of_topics

    def to_dict(self):
        return {
            "name": self.name,
            "introduction": self.introduction,
            "numberOfWords": self.numberOfWords,
            "numberOfTopics": self.numberOfTopics,
        }

    @staticmethod
    def from_dict(data):
        return Course(data["name"], data["numberOfWords"], data["numberOfTopics"])

def main():
    db = get_database()
    write_data(db)


def write_data(db):
    data = json.load(open("courses.json", "r", encoding="utf-8"))

    courses_ref = db.collection(u'courses')
    words_ref = db.collection(u'words')
    for course in data["courses"]:
        course_obj = Course.from_dict(course)
        doc = courses_ref.document(course_obj.name)
        doc.set(course_obj.to_dict())

        for topic in course["topics"]:
            topic_name = topic["name"]
            for word in topic["words"]:
                word_doc = words_ref.document(course_obj.name + "_" + topic_name + "_" + word["value"])
                word_doc.set({
                    u"value": word["value"],
                    u"meaning": word["meaning"],
                    u"topic": topic_name,
                    u"course": course_obj.name,
                })

    return data

def get_database():
    cred = credentials.Certificate("po-english-firebase-adminsdk-orw1q-a444d0207b.json")
    firebase_admin.initialize_app(cred)
    db = firestore.client()
    return db


if __name__ == '__main__':
    main()
