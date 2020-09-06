import json

import firebase_admin
from firebase_admin import credentials
from firebase_admin import firestore

def main():
    db = get_database()
    write_database(db)
    read_database(db)


def read_database(db):
    users_ref = db.collection(u'users')
    docs = users_ref.stream()
    for doc in docs:
        print(f'{doc.id} => {doc.to_dict()}')


def write_database(db):
    COLLECTION_NAME = u'courses'
    collection = db.collection(COLLECTION_NAME)

    courses = json.load(open("courses.json", "r", encoding="utf-8"))["courses"]
    for c in courses:
        doc_ref = collection.document(c["name"])
        doc_ref.set(c)



def get_database():
    cred = credentials.Certificate("po-english-firebase-adminsdk-orw1q-a444d0207b.json")
    firebase_admin.initialize_app(cred)
    db = firestore.client()
    return db


if __name__ == '__main__':
    main()