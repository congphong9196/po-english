package com.example.recyclerview.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {

    public static void runInitialization(Context context) {
        final String DATABASE_INITIALIZED_KEY = "DatabaseInitialized";

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isDatabaseInitialized = sp.getBoolean(DATABASE_INITIALIZED_KEY, false);
        isDatabaseInitialized = false;
        if (!isDatabaseInitialized) {
            List<Word> words = new ArrayList<>();
            initializeAnimals(words);
            initializeFamily(words);
            initializeClothes(words);
            initializeColors(words);
            initializeFruits(words);
            initializeNumbers(words);
            initializeClass1(words);
            initializeClass2(words);
            initializeClass3(words);
            initializeClass6(words);
            initializeClass7(words);
            initializePositions(words);
            initializeDepartments(words);
            initializeConferences(words);
            initializeEquipments(words);
            initializeHotels(words);
            initializeOverview(words);
            initializeContracts(words);

            DatabaseHelper db = new DatabaseHelper(context);
            db.dropTables();
            db.createTables();
            db.addWord(words);

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(DATABASE_INITIALIZED_KEY, true);
            editor.apply();
        }
    }

    private static void initializeAnimals(List<Word> words) {
        words.add(new Word(WordCategory.ANIMAL, "Cat", "Con Mèo", "My cat has very beautiful eyes"));
        words.add(new Word(WordCategory.ANIMAL, "Dog", "Con Chó", "Dogs are very loyal animals"));
        words.add(new Word(WordCategory.ANIMAL, "Pig", "Con Lợn", "Pigs are very lazy animals"));
        words.add(new Word(WordCategory.ANIMAL, "Duck", "Con vịt", "Ducks can lay a maximum of 250 eggs per year"));
        words.add(new Word(WordCategory.ANIMAL, "Ant", "Con Kiến", "The ants are really hardworking"));
        words.add(new Word(WordCategory.ANIMAL, "Cow", "Con bò", "The cow has 2 very sharp horns"));
        words.add(new Word(WordCategory.ANIMAL, "Fish", "Con cá", "Fish meat provides a lot of protein"));
        words.add(new Word(WordCategory.ANIMAL, "Monkey", "Con khỉ", "Monkeys are very intelligent animals"));
        words.add(new Word(WordCategory.ANIMAL, "Rabbit", "Con thỏ", "Rabbits have very long ears"));
        words.add(new Word(WordCategory.ANIMAL, "Ostrich", "Con đà điểu", "Ostrich is the fastest bird"));
        words.add(new Word(WordCategory.ANIMAL, "Elephant", "Con voi", "Elephants have a very large body"));
        words.add(new Word(WordCategory.ANIMAL, "Bid", "Con chim", "Birds can fly very fast"));
        words.add(new Word(WordCategory.ANIMAL, "Turtle", "Con rùa", "Turtles crawl very slowly"));
        words.add(new Word(WordCategory.ANIMAL, "Snake", "Con rắn", "Snakes are animals without legs"));
        words.add(new Word(WordCategory.ANIMAL, "Lion", "Con sư tử", "Lion is very good at hunting"));
        words.add(new Word(WordCategory.ANIMAL, "Rooster", "Con gà trống"));
        words.add(new Word(WordCategory.ANIMAL, "Mouse", "Con chuột"));
        words.add(new Word(WordCategory.ANIMAL, "Cow", "Con bò sữa"));
        words.add(new Word(WordCategory.ANIMAL, "Bear", "Con gấu"));
        words.add(new Word(WordCategory.ANIMAL, "Horse", "Con ngựa"));
        words.add(new Word(WordCategory.ANIMAL, "Butterfly", "Con bướm"));
        words.add(new Word(WordCategory.ANIMAL, "Panda", "Con gấu trúc"));
        words.add(new Word(WordCategory.ANIMAL, "Penguin", "Con chim cánh cụt"));
        words.add(new Word(WordCategory.ANIMAL, "Kangaroo", "Con chuột túi"));
        words.add(new Word(WordCategory.ANIMAL, "Tiger", "Con hổ"));
        words.add(new Word(WordCategory.ANIMAL, "Owl", "Con cú mèo"));
        words.add(new Word(WordCategory.ANIMAL, "Peacock", "Con công"));
        words.add(new Word(WordCategory.ANIMAL, "Swan", "Con thiên nga"));
        words.add(new Word(WordCategory.ANIMAL, "Pelican", "Con bồ nông"));
        words.add(new Word(WordCategory.ANIMAL, "Cheetah", "Con báo"));
        words.add(new Word(WordCategory.ANIMAL, "Deer", "Con hươu"));
        words.add(new Word(WordCategory.ANIMAL, "Giraffe", "Con hươu cao cổ"));
        words.add(new Word(WordCategory.ANIMAL, "Hippopotamus", "Con hà mã"));
        words.add(new Word(WordCategory.ANIMAL, "Zebra", "Con ngựa vằn"));
        words.add(new Word(WordCategory.ANIMAL, "Rhinoceros", "Con tê giác"));
        words.add(new Word(WordCategory.ANIMAL, "Sheep", "Con cừu"));
        words.add(new Word(WordCategory.ANIMAL, "Squirrel", "Con sóc"));
        words.add(new Word(WordCategory.ANIMAL, "Stag", "Con nai"));
        words.add(new Word(WordCategory.ANIMAL, "Frog", "Con ếch"));
        words.add(new Word(WordCategory.ANIMAL, "Toad", "Con cóc"));
        words.add(new Word(WordCategory.ANIMAL, "Shark", "Con cá mập"));
        words.add(new Word(WordCategory.ANIMAL, "Starfish", "Con sao biển"));
        words.add(new Word(WordCategory.ANIMAL, "Sealion", "Con hải cẩu"));
        words.add(new Word(WordCategory.ANIMAL, "Walrus", "Con hà mã"));
        words.add(new Word(WordCategory.ANIMAL, "Whale", "Con cá voi"));
        words.add(new Word(WordCategory.ANIMAL, "Crocodile", "Con cá sấu"));
        words.add(new Word(WordCategory.ANIMAL, "Dolphin", "Con cá heo"));
        words.add(new Word(WordCategory.ANIMAL, "Eagle", "Con đại bàng"));
        words.add(new Word(WordCategory.ANIMAL, "Pigeon", "Con chim bồ câu"));
        words.add(new Word(WordCategory.ANIMAL, "Fly", "Con ruồi"));
        words.add(new Word(WordCategory.ANIMAL, "Mosquito", "Con muỗi"));
        words.add(new Word(WordCategory.ANIMAL, "Stork", "Con cò"));
        words.add(new Word(WordCategory.ANIMAL, "Cuttle", "Con mực"));
        words.add(new Word(WordCategory.ANIMAL, "Crab", "Con cua"));
        words.add(new Word(WordCategory.ANIMAL, "Fox", "Con cáo"));
        words.add(new Word(WordCategory.ANIMAL, "Weasel", "Con chồn"));
        words.add(new Word(WordCategory.ANIMAL, "Chimpanzee", "Con tinh tinh"));
        words.add(new Word(WordCategory.ANIMAL, "Goat", "Con dê"));
        words.add(new Word(WordCategory.ANIMAL, "Dragon", "Con rồng"));
        words.add(new Word(WordCategory.ANIMAL, "Dinosaur", "Con khủng long"));
        words.add(new Word(WordCategory.ANIMAL, "Cicada", "Con ve"));
        words.add(new Word(WordCategory.ANIMAL, "Mantis", "Con bọ ngựa"));
        words.add(new Word(WordCategory.ANIMAL, "Grasshopper", "Con châu chấu"));
        words.add(new Word(WordCategory.ANIMAL, "Buffalo", "Con trâu"));
        words.add(new Word(WordCategory.ANIMAL, "Parrot", "Con vẹt"));
        words.add(new Word(WordCategory.ANIMAL, "Blackbird", "Con sáo"));
        words.add(new Word(WordCategory.ANIMAL, "Hedgehog", "Con nhím"));
        words.add(new Word(WordCategory.ANIMAL, "Snail", "Con sên"));
        words.add(new Word(WordCategory.ANIMAL, "Bee", "Con ong"));
        words.add(new Word(WordCategory.ANIMAL, "Ladybug", "Con bọ rùa"));
        words.add(new Word(WordCategory.ANIMAL, "Worm", "Con sâu"));
        words.add(new Word(WordCategory.ANIMAL, "Goose", "Con ngỗng"));
        words.add(new Word(WordCategory.ANIMAL, "Koala", "Con gấu túi"));
    }

    private static void initializeFamily(List<Word> words) {
        words.add(new Word(WordCategory.FAMILY, "Mother", "Mẹ"));
        words.add(new Word(WordCategory.FAMILY, "Father", "Bố"));
        words.add(new Word(WordCategory.FAMILY, "Younger sister", "Em gái"));
        words.add(new Word(WordCategory.FAMILY, "Younger brother", "Em trai"));
        words.add(new Word(WordCategory.FAMILY, "Sister", "Chị gái"));
        words.add(new Word(WordCategory.FAMILY, "Brother", "Anh trai"));
        words.add(new Word(WordCategory.FAMILY, "Aunt", "Cô, thím"));
        words.add(new Word(WordCategory.FAMILY, "Uncle", "Chú, bác"));
        words.add(new Word(WordCategory.FAMILY, "Stepfather", "Cha dượng"));
        words.add(new Word(WordCategory.FAMILY, "Step mother", "Mẹ kế"));
    }

    private static void initializeClothes(List<Word> words) {
        words.add(new Word(WordCategory.CLOTHES, "Shirt", "Áo sơ mi"));
        words.add(new Word(WordCategory.CLOTHES, "T-shirt", "Áo phông"));
        words.add(new Word(WordCategory.CLOTHES, "Dress", "Váy liền"));
        words.add(new Word(WordCategory.CLOTHES, "Skirt", "Chân váy"));
        words.add(new Word(WordCategory.CLOTHES, "Jeans", "Quần bò"));
        words.add(new Word(WordCategory.CLOTHES, "Shorts", "Quần soóc"));
        words.add(new Word(WordCategory.CLOTHES, "Jacket", "Áo khoác"));
        words.add(new Word(WordCategory.CLOTHES, "Tie", "Cà vạt"));
        words.add(new Word(WordCategory.CLOTHES, "Hat", "Mũ"));
        words.add(new Word(WordCategory.CLOTHES, "Gloves", "Găng tay"));
    }

    private static void initializeColors(List<Word> words) {
        words.add(new Word(WordCategory.COLOR, "Blu", "Màu xanh da trời"));
        words.add(new Word(WordCategory.COLOR, "Green", "Màu xanh lá cây"));
        words.add(new Word(WordCategory.COLOR, "Yellow", "Màu vàng"));
        words.add(new Word(WordCategory.COLOR, "Red", "Màu đỏ"));
        words.add(new Word(WordCategory.COLOR, "Pink", "Màu hồng"));
        words.add(new Word(WordCategory.COLOR, "Black", "Màu đen"));
        words.add(new Word(WordCategory.COLOR, "Gray", "Màu xám"));
        words.add(new Word(WordCategory.COLOR, "Orange", "Màu cam"));
        words.add(new Word(WordCategory.COLOR, "Brown", "Màu nâu"));
        words.add(new Word(WordCategory.COLOR, "White", "Màu trắng"));
    }

    private static void initializeFruits(List<Word> words) {
        words.add(new Word(WordCategory.FRUIT, "Apple", "Quả táo"));
        words.add(new Word(WordCategory.FRUIT, "Banana", "Quả chuối"));
        words.add(new Word(WordCategory.FRUIT, "Orange", "Quả cam"));
        words.add(new Word(WordCategory.FRUIT, "Lemon", "Quả chanh"));
        words.add(new Word(WordCategory.FRUIT, "Peach", "Quả đào"));
        words.add(new Word(WordCategory.FRUIT, "Pear", "Quả lê"));
        words.add(new Word(WordCategory.FRUIT, "Berry", "Quả dâu"));
        words.add(new Word(WordCategory.FRUIT, "Watermelon ", "Quả dưa hấu"));
        words.add(new Word(WordCategory.FRUIT, "Pineapple", "Quả dứa"));
    }

    private static void initializeNumbers(List<Word> words) {
        words.add(new Word(WordCategory.NUMBER, "Zero", "Số 0"));
        words.add(new Word(WordCategory.NUMBER, "One", "Số 1"));
        words.add(new Word(WordCategory.NUMBER, "Two", "Số 2"));
        words.add(new Word(WordCategory.NUMBER, "Three", "Số 3"));
        words.add(new Word(WordCategory.NUMBER, "Four", "Số 4"));
        words.add(new Word(WordCategory.NUMBER, "Five", "Số 5"));
        words.add(new Word(WordCategory.NUMBER, "Six", "Số 6"));
        words.add(new Word(WordCategory.NUMBER, "Seven", "Số 7"));
        words.add(new Word(WordCategory.NUMBER, "Eight", "Số 8"));
    }

    private static void initializeClass1(List<Word> words) {
        words.add(new Word(WordCategory.CLASS1, "Be quiet", "Trật tự"));
        words.add(new Word(WordCategory.CLASS1, "Listen", "Lắng nghe"));
        words.add(new Word(WordCategory.CLASS1, "Look", "Quan sát"));
        words.add(new Word(WordCategory.CLASS1, "Repeat", "Nhắc lại"));
        words.add(new Word(WordCategory.CLASS1, "Mother", "Mẹ"));
        words.add(new Word(WordCategory.CLASS1, "Father", "Bố"));
        words.add(new Word(WordCategory.CLASS1, "Baby", "Em bé"));
        words.add(new Word(WordCategory.CLASS1, "Good morning", "Chào buổi sáng"));
        words.add(new Word(WordCategory.CLASS1, "Good afternoon", "Chiều buổi chiều"));
    }

    private static void initializeClass2(List<Word> words) {
        words.add(new Word(WordCategory.CLASS2, "Bus", "Xe buýt"));
        words.add(new Word(WordCategory.CLASS2, "Classroom", "Phòng học"));
        words.add(new Word(WordCategory.CLASS2, "Library", "Thư viện"));
        words.add(new Word(WordCategory.CLASS2, "Teacher", "Giáo viên"));
        words.add(new Word(WordCategory.CLASS2, "Board", "Bảng"));
        words.add(new Word(WordCategory.CLASS2, "Monday", "Thứ 2"));
        words.add(new Word(WordCategory.CLASS2, "Tuesday", "Thứ 3"));
        words.add(new Word(WordCategory.CLASS2, "Wednesday", "Thứ 4"));
        words.add(new Word(WordCategory.CLASS2, "Thursday", "Thứ 5"));
    }

    private static void initializeClass3(List<Word> words) {
        words.add(new Word(WordCategory.CLASS3, "Red", "Màu đỏ", "My jacket is red"));
        words.add(new Word(WordCategory.CLASS3, "Yellow", "Màu vàng", "I like yellow skirts"));
        words.add(new Word(WordCategory.CLASS3, "Book", "Quyển sách", "I have 2 beautiful books"));
        words.add(new Word(WordCategory.CLASS3, "Chair", "Ghế", "I just bought this chair"));
        words.add(new Word(WordCategory.CLASS3, "Table", "Bàn", "This table is beautiful"));
        words.add(new Word(WordCategory.CLASS3, "Left", "Bên trái", "It is on the left side of the road"));
        words.add(new Word(WordCategory.CLASS3, "Right", "Bên phải", "Turn right at the fork"));
        words.add(new Word(WordCategory.CLASS3, "Next to", "Bên cạnh", "It is next to the book"));
        words.add(new Word(WordCategory.CLASS3, "Under", "Bên dưới", "Ants under the Bridge"));
        words.add(new Word(WordCategory.CLASS3, "Street", "Đường phố", "The street is bustling"));
        words.add(new Word(WordCategory.CLASS3, "Tree", "Cây", "Trees are green on both sides of the road"));
        words.add(new Word(WordCategory.CLASS3, "Plane", "Máy bay", "The plane is flying overhead"));
        words.add(new Word(WordCategory.CLASS3, "Ship", "Tàu biển", "Ships are leaving port"));
        words.add(new Word(WordCategory.CLASS3, "Shoe", "Giày", "This shoe I really like"));
        words.add(new Word(WordCategory.CLASS3, "Hat", "Mũ", "The black hat is cool"));
    }

    private static void initializeClass6(List<Word> words) {
        words.add(new Word(WordCategory.CLASS6, "Country", "Đất nước", "My country is wonderful"));
        words.add(new Word(WordCategory.CLASS6, "Live", "Sống", "They need to live through tonight"));
        words.add(new Word(WordCategory.CLASS6, "Busy", "Bận rộn", "I am very busy today"));
        words.add(new Word(WordCategory.CLASS6, "Large", "Lớn", "The plane is large"));
        words.add(new Word(WordCategory.CLASS6, "Beautiful", "Đẹp", "The flower is beautiful"));
        words.add(new Word(WordCategory.CLASS6, "Quiet", "Yên tĩnh", "I need quiet in the room"));
        words.add(new Word(WordCategory.CLASS6, "Small", "Nhỏ", "The ant has a very small body"));
        words.add(new Word(WordCategory.CLASS6, "Flat", "Căn hộ", "That flat is very large"));
        words.add(new Word(WordCategory.CLASS6, "Glass", "Kính", "This glass is very fragile"));
        words.add(new Word(WordCategory.CLASS6, "Address", "Địa chỉ", "Address is on paper"));
        words.add(new Word(WordCategory.CLASS6, "House", "Ngôi nhà", "The house is yellow"));
        words.add(new Word(WordCategory.CLASS6, "Bedroom", "Phòng ngủ", "This bedroom is so big"));
        words.add(new Word(WordCategory.CLASS6, "Kitchen", "Nhà bếp", "She is cooking in the kitchen"));
        words.add(new Word(WordCategory.CLASS6, "Drink", "Đồ uống", "The drink is delicious"));
        words.add(new Word(WordCategory.CLASS6, "Meal", "Bữa ăn", "The meal is special"));
    }

    private static void initializeClass7(List<Word> words) {
        words.add(new Word(WordCategory.CLASS7, "Far", "Xa"));
        words.add(new Word(WordCategory.CLASS7, "Different", "Khác nhau"));
        words.add(new Word(WordCategory.CLASS7, "Nice", "Vui"));
        words.add(new Word(WordCategory.CLASS7, "Fine", "Ổn"));
        words.add(new Word(WordCategory.CLASS7, "Parent", "Bố mẹ"));
        words.add(new Word(WordCategory.CLASS7, "Market", "Chợ"));
        words.add(new Word(WordCategory.CLASS7, "Movie", "Bộ phim"));
        words.add(new Word(WordCategory.CLASS7, "Join", "Tham gia"));
        words.add(new Word(WordCategory.CLASS7, "Finish", "Kết thúc"));
    }

    private static void initializePositions(List<Word> words) {
        words.add(new Word(WordCategory.POSITION, "Boss", "Sếp", "The boss is on a business trip in Hanoi"));
        words.add(new Word(WordCategory.POSITION, "President", "Chủ tịch", "The president is the head of the company"));
        words.add(new Word(WordCategory.POSITION, "Vice president", "Phó chủ tịch", " Vice president is the 2nd largest position in the company"));
        words.add(new Word(WordCategory.POSITION, "Director", "Giám đốc", "My director is very caring staff"));
        words.add(new Word(WordCategory.POSITION, "Manager", "Quản lý", "Mr. Nam is the PO project manager"));
        words.add(new Word(WordCategory.POSITION, "Leader", "Lãnh đạo", "The leader of Mama Company is very young"));
        words.add(new Word(WordCategory.POSITION, "Secretary", "Thư ký", "The secretary always arranges a schedule for the director"));
        words.add(new Word(WordCategory.POSITION, "Expert", "Chuyên gia", "Mrs Juner is a famous expert"));
        words.add(new Word(WordCategory.POSITION, "Department manage", "Trưởng phòng", "I'm going to eat with the department manager"));
        words.add(new Word(WordCategory.POSITION, "Founder", "Chuyên gia", "Mr Honda is the founder of this company"));
        words.add(new Word(WordCategory.POSITION, "Chief accountant", "Kế toán trưởng", "Chief accountant is very busy today"));
        words.add(new Word(WordCategory.POSITION, "Supervisor", "Người dám sát", "I am the supervisor of this project"));
    }

    private static void initializeDepartments(List<Word> words) {
        words.add(new Word(WordCategory.DEPARTMENT, "Accounting department", "Phòng kế toán"));
        words.add(new Word(WordCategory.DEPARTMENT, "Audit department", "Phòng kiểm toán"));
        words.add(new Word(WordCategory.DEPARTMENT, "Sales department", "Phòng kinh doanh"));
        words.add(new Word(WordCategory.DEPARTMENT, "Administration department", "Phòng hành chính"));
        words.add(new Word(WordCategory.DEPARTMENT, "Human Resources department", "Phòng nhân sự"));
        words.add(new Word(WordCategory.DEPARTMENT, "Financial department", "Phòng tài chính"));
        words.add(new Word(WordCategory.DEPARTMENT, "Quality department", "Phòng chất lượng"));
    }

    private static void initializeConferences(List<Word> words) {
        words.add(new Word(WordCategory.CONFERENCE, "Arrange", "Sắp xếp"));
        words.add(new Word(WordCategory.CONFERENCE, "Meeting", "Cuộc họp"));
        words.add(new Word(WordCategory.CONFERENCE, "Projector", "Máy chiếu"));
        words.add(new Word(WordCategory.CONFERENCE, "Select", "Lựa chọn"));
        words.add(new Word(WordCategory.CONFERENCE, "Register", "Đăng ký"));
        words.add(new Word(WordCategory.CONFERENCE, "Take part in", "Tham gia"));
        words.add(new Word(WordCategory.CONFERENCE, "Micro", "Míc"));
        words.add(new Word(WordCategory.CONFERENCE, "Screen", "Màn hình"));
    }

    private static void initializeEquipments(List<Word> words) {
        words.add(new Word(WordCategory.EQUIPMENT, "Lights", "Đèn điện", "The lights is on all night"));
        words.add(new Word(WordCategory.EQUIPMENT, "Computer", "Máy tính", "This computer is very beautiful"));
        words.add(new Word(WordCategory.EQUIPMENT, "Projector", "Máy chiếu", "I need a projector now"));
        words.add(new Word(WordCategory.EQUIPMENT, "Print", "Máy in", "Take it to the printer"));
        words.add(new Word(WordCategory.EQUIPMENT, "Scanner", "Máy scan", "I need a scanner now"));
        words.add(new Word(WordCategory.EQUIPMENT, "Television", "Tivi", "The program is broadcast on television"));
        words.add(new Word(WordCategory.EQUIPMENT, "Fax", "Máy fax", "Paper on fax machine"));
        words.add(new Word(WordCategory.EQUIPMENT, "Harmonic", "Điều hòa", "Harmonic is widely used"));
        words.add(new Word(WordCategory.EQUIPMENT, "Fan", "Quạt", "The fan is very cool in this weather"));

    }

    private static void initializeHotels(List<Word> words) {
        words.add(new Word(WordCategory.HOTEL, "Reservation", "Đặt phòng", "You need to make a reservation before traveling"));
        words.add(new Word(WordCategory.HOTEL, "Vacancy", "Phòng trống", "The hotel has 2 rooms vacancy"));
        words.add(new Word(WordCategory.HOTEL, "Lobby", "Sảnh", "She is down the lobby"));
        words.add(new Word(WordCategory.HOTEL, "Receptionist", "Lễ tân", "The receptionist is very funny"));
        words.add(new Word(WordCategory.HOTEL, "Key", "Chìa khóa", "You need a key to open a room"));
        words.add(new Word(WordCategory.HOTEL, "Pay", "Thanh toán", "Pay in the lobby"));
        words.add(new Word(WordCategory.HOTEL, "Luggage", "Hành lý", "Bring luggage for me"));
        words.add(new Word(WordCategory.HOTEL, "Meal", "Bữa ăn", "The hotel has prepared meals"));
        words.add(new Word(WordCategory.HOTEL, "Room", "Phòng", "Room needs to be locked"));
        words.add(new Word(WordCategory.HOTEL, "Drink", "Đồ uống", "Do you have a drink?"));
        words.add(new Word(WordCategory.HOTEL, "Corridor", "Hành lang", "It is located in the left corridor"));
        words.add(new Word(WordCategory.HOTEL, "Balcony", "Ban công", "Very cool balcony"));
        words.add(new Word(WordCategory.HOTEL, "Clean", "Sạch sẽ", "The room must be clean"));
        words.add(new Word(WordCategory.HOTEL, "Safe", "An toàn", "Pay attention to safe"));
        words.add(new Word(WordCategory.HOTEL, "Manager", "Quản lý", "She is the manager here"));
    }

    private static void initializeOverview(List<Word> words) {
        words.add(new Word(WordCategory.OVERVIEW, "Education", "Giáo dục", "Education is growing"));
        words.add(new Word(WordCategory.OVERVIEW, "Crime", "Tội phạm","Crime reward lurks very carefully"));
        words.add(new Word(WordCategory.OVERVIEW, "Technology", "Công nghệ", "Technology is popular in the world"));
        words.add(new Word(WordCategory.OVERVIEW, "Environment", "Môi trường", "The marine environment is polluted"));
        words.add(new Word(WordCategory.OVERVIEW, "Science", "Khoa học", "Khám phá khoa học trên thư viện"));
        words.add(new Word(WordCategory.OVERVIEW, "Advertising ", "Quảng cáo", "Advertising appear on the television"));
        words.add(new Word(WordCategory.OVERVIEW, "Work", "Công việc", "IT is my favorite work"));
        words.add(new Word(WordCategory.OVERVIEW, "City", "Thành phố", "Hanoi is a modern city"));
        words.add(new Word(WordCategory.OVERVIEW, "Contact", "Liên lạc", "I could not contact anyone"));
        words.add(new Word(WordCategory.OVERVIEW, "Student", "Sinh viên", "Students are very active"));
        words.add(new Word(WordCategory.OVERVIEW, "Company", "Công ty", "I am working at the company"));
        words.add(new Word(WordCategory.OVERVIEW, "Bank", "Ngân hàng", "Banks are in trouble"));
        words.add(new Word(WordCategory.OVERVIEW, "Book", "Quyển sách", "This book is quite good"));
        words.add(new Word(WordCategory.OVERVIEW, "Clothes", "Quần áo", "This store a lot of beautiful clothes"));
        words.add(new Word(WordCategory.OVERVIEW, "Color", "Màu sắc", "What is your favorite color?"));


    }

    private static void initializeContracts(List<Word> words) {
        words.add(new Word(WordCategory.CONTRACTS, "Agree ", "Đồng ý", "I agree with this decision"));
        words.add(new Word(WordCategory.CONTRACTS, "Assure ", "Đảm bảo","I assure you will not be late"));
        words.add(new Word(WordCategory.CONTRACTS, "Determine ", "Quyết định", "She determine to leave"));
        words.add(new Word(WordCategory.CONTRACTS, "Engage ", "Thuê", "I engage this motorbike 3 days"));
        words.add(new Word(WordCategory.CONTRACTS, "Provide ", "Cung cấp", "PO Company provides drinking water"));
        words.add(new Word(WordCategory.CONTRACTS, "Specify ", "Xác định", "You have to specify the way"));
        words.add(new Word(WordCategory.CONTRACTS, "Resolve ", "Giải quyết", "This issue has not been resolved"));
        words.add(new Word(WordCategory.CONTRACTS, "Cooperate", "Hợp tác", "Happy cooperation"));
        words.add(new Word(WordCategory.CONTRACTS, "Establish ", "Thiết lập", "This company has been established for 2 years"));
    }

}
