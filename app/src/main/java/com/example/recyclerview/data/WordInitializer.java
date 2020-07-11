package com.example.recyclerview.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class WordInitializer implements DataInitializable {

    @Override
    public void runInitialization(Context context) {
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
        WordDAO wordDAO = new WordDAO(db);
        wordDAO.addWord(words);
    }

    private static void initializeAnimals(List<Word> words) {
        words.add(new Word(TopicDAO.ANIMAL, "Cat", "Con Mèo", "My cat has very beautiful eyes"));
        words.add(new Word(TopicDAO.ANIMAL, "Dog", "Con Chó", "Dogs are very loyal animals"));
        words.add(new Word(TopicDAO.ANIMAL, "Pig", "Con Lợn", "Pigs are very lazy animals"));
        words.add(new Word(TopicDAO.ANIMAL, "Duck", "Con vịt", "Ducks can lay a maximum of 250 eggs per year"));
        words.add(new Word(TopicDAO.ANIMAL, "Ant", "Con Kiến", "The ants are really hardworking"));
        words.add(new Word(TopicDAO.ANIMAL, "Cow", "Con bò", "The cow has 2 very sharp horns"));
        words.add(new Word(TopicDAO.ANIMAL, "Fish", "Con cá", "Fish meat provides a lot of protein"));
        words.add(new Word(TopicDAO.ANIMAL, "Monkey", "Con khỉ", "Monkeys are very intelligent animals"));
        words.add(new Word(TopicDAO.ANIMAL, "Rabbit", "Con thỏ", "Rabbits have very long ears"));
        words.add(new Word(TopicDAO.ANIMAL, "Ostrich", "Con đà điểu", "Ostrich is the fastest bird"));
        words.add(new Word(TopicDAO.ANIMAL, "Elephant", "Con voi", "Elephants have a very large body"));
        words.add(new Word(TopicDAO.ANIMAL, "Bid", "Con chim", "Birds can fly very fast"));
        words.add(new Word(TopicDAO.ANIMAL, "Turtle", "Con rùa", "Turtles crawl very slowly"));
        words.add(new Word(TopicDAO.ANIMAL, "Snake", "Con rắn", "Snakes are animals without legs"));
        words.add(new Word(TopicDAO.ANIMAL, "Lion", "Con sư tử", "Lion is very good at hunting"));
        words.add(new Word(TopicDAO.ANIMAL, "Rooster", "Con gà trống"));
        words.add(new Word(TopicDAO.ANIMAL, "Mouse", "Con chuột"));
        words.add(new Word(TopicDAO.ANIMAL, "Cow", "Con bò sữa"));
        words.add(new Word(TopicDAO.ANIMAL, "Bear", "Con gấu"));
        words.add(new Word(TopicDAO.ANIMAL, "Horse", "Con ngựa"));
        words.add(new Word(TopicDAO.ANIMAL, "Butterfly", "Con bướm"));
        words.add(new Word(TopicDAO.ANIMAL, "Panda", "Con gấu trúc"));
        words.add(new Word(TopicDAO.ANIMAL, "Penguin", "Con chim cánh cụt"));
        words.add(new Word(TopicDAO.ANIMAL, "Kangaroo", "Con chuột túi"));
        words.add(new Word(TopicDAO.ANIMAL, "Tiger", "Con hổ"));
        words.add(new Word(TopicDAO.ANIMAL, "Owl", "Con cú mèo"));
        words.add(new Word(TopicDAO.ANIMAL, "Peacock", "Con công"));
        words.add(new Word(TopicDAO.ANIMAL, "Swan", "Con thiên nga"));
        words.add(new Word(TopicDAO.ANIMAL, "Pelican", "Con bồ nông"));
        words.add(new Word(TopicDAO.ANIMAL, "Cheetah", "Con báo"));
        words.add(new Word(TopicDAO.ANIMAL, "Deer", "Con hươu"));
        words.add(new Word(TopicDAO.ANIMAL, "Giraffe", "Con hươu cao cổ"));
        words.add(new Word(TopicDAO.ANIMAL, "Hippopotamus", "Con hà mã"));
        words.add(new Word(TopicDAO.ANIMAL, "Zebra", "Con ngựa vằn"));
        words.add(new Word(TopicDAO.ANIMAL, "Rhinoceros", "Con tê giác"));
        words.add(new Word(TopicDAO.ANIMAL, "Sheep", "Con cừu"));
        words.add(new Word(TopicDAO.ANIMAL, "Squirrel", "Con sóc"));
        words.add(new Word(TopicDAO.ANIMAL, "Stag", "Con nai"));
        words.add(new Word(TopicDAO.ANIMAL, "Frog", "Con ếch"));
        words.add(new Word(TopicDAO.ANIMAL, "Toad", "Con cóc"));
        words.add(new Word(TopicDAO.ANIMAL, "Shark", "Con cá mập"));
        words.add(new Word(TopicDAO.ANIMAL, "Starfish", "Con sao biển"));
        words.add(new Word(TopicDAO.ANIMAL, "Sealion", "Con hải cẩu"));
        words.add(new Word(TopicDAO.ANIMAL, "Walrus", "Con hà mã"));
        words.add(new Word(TopicDAO.ANIMAL, "Whale", "Con cá voi"));
        words.add(new Word(TopicDAO.ANIMAL, "Crocodile", "Con cá sấu"));
        words.add(new Word(TopicDAO.ANIMAL, "Dolphin", "Con cá heo"));
        words.add(new Word(TopicDAO.ANIMAL, "Eagle", "Con đại bàng"));
        words.add(new Word(TopicDAO.ANIMAL, "Pigeon", "Con chim bồ câu"));
        words.add(new Word(TopicDAO.ANIMAL, "Fly", "Con ruồi"));
        words.add(new Word(TopicDAO.ANIMAL, "Mosquito", "Con muỗi"));
        words.add(new Word(TopicDAO.ANIMAL, "Stork", "Con cò"));
        words.add(new Word(TopicDAO.ANIMAL, "Cuttle", "Con mực"));
        words.add(new Word(TopicDAO.ANIMAL, "Crab", "Con cua"));
        words.add(new Word(TopicDAO.ANIMAL, "Fox", "Con cáo"));
        words.add(new Word(TopicDAO.ANIMAL, "Weasel", "Con chồn"));
        words.add(new Word(TopicDAO.ANIMAL, "Chimpanzee", "Con tinh tinh"));
        words.add(new Word(TopicDAO.ANIMAL, "Goat", "Con dê"));
        words.add(new Word(TopicDAO.ANIMAL, "Dragon", "Con rồng"));
        words.add(new Word(TopicDAO.ANIMAL, "Dinosaur", "Con khủng long"));
        words.add(new Word(TopicDAO.ANIMAL, "Cicada", "Con ve"));
        words.add(new Word(TopicDAO.ANIMAL, "Mantis", "Con bọ ngựa"));
        words.add(new Word(TopicDAO.ANIMAL, "Grasshopper", "Con châu chấu"));
        words.add(new Word(TopicDAO.ANIMAL, "Buffalo", "Con trâu"));
        words.add(new Word(TopicDAO.ANIMAL, "Parrot", "Con vẹt"));
        words.add(new Word(TopicDAO.ANIMAL, "Blackbird", "Con sáo"));
        words.add(new Word(TopicDAO.ANIMAL, "Hedgehog", "Con nhím"));
        words.add(new Word(TopicDAO.ANIMAL, "Snail", "Con sên"));
        words.add(new Word(TopicDAO.ANIMAL, "Bee", "Con ong"));
        words.add(new Word(TopicDAO.ANIMAL, "Ladybug", "Con bọ rùa"));
        words.add(new Word(TopicDAO.ANIMAL, "Worm", "Con sâu"));
        words.add(new Word(TopicDAO.ANIMAL, "Goose", "Con ngỗng"));
        words.add(new Word(TopicDAO.ANIMAL, "Koala", "Con gấu túi"));
    }

    private static void initializeFamily(List<Word> words) {
        words.add(new Word(TopicDAO.FAMILY, "Mother", "Mẹ"));
        words.add(new Word(TopicDAO.FAMILY, "Father", "Bố"));
        words.add(new Word(TopicDAO.FAMILY, "Younger sister", "Em gái"));
        words.add(new Word(TopicDAO.FAMILY, "Younger brother", "Em trai"));
        words.add(new Word(TopicDAO.FAMILY, "Sister", "Chị gái"));
        words.add(new Word(TopicDAO.FAMILY, "Brother", "Anh trai"));
        words.add(new Word(TopicDAO.FAMILY, "Aunt", "Cô, thím"));
        words.add(new Word(TopicDAO.FAMILY, "Uncle", "Chú, bác"));
        words.add(new Word(TopicDAO.FAMILY, "Stepfather", "Cha dượng"));
        words.add(new Word(TopicDAO.FAMILY, "Step mother", "Mẹ kế"));
    }

    private static void initializeClothes(List<Word> words) {
        words.add(new Word(TopicDAO.CLOTHES, "Shirt", "Áo sơ mi"));
        words.add(new Word(TopicDAO.CLOTHES, "T-shirt", "Áo phông"));
        words.add(new Word(TopicDAO.CLOTHES, "Dress", "Váy liền"));
        words.add(new Word(TopicDAO.CLOTHES, "Skirt", "Chân váy"));
        words.add(new Word(TopicDAO.CLOTHES, "Jeans", "Quần bò"));
        words.add(new Word(TopicDAO.CLOTHES, "Shorts", "Quần soóc"));
        words.add(new Word(TopicDAO.CLOTHES, "Jacket", "Áo khoác"));
        words.add(new Word(TopicDAO.CLOTHES, "Tie", "Cà vạt"));
        words.add(new Word(TopicDAO.CLOTHES, "Hat", "Mũ"));
        words.add(new Word(TopicDAO.CLOTHES, "Gloves", "Găng tay"));
    }

    private static void initializeColors(List<Word> words) {
        words.add(new Word(TopicDAO.COLOR, "Blu", "Màu xanh da trời"));
        words.add(new Word(TopicDAO.COLOR, "Green", "Màu xanh lá cây"));
        words.add(new Word(TopicDAO.COLOR, "Yellow", "Màu vàng"));
        words.add(new Word(TopicDAO.COLOR, "Red", "Màu đỏ"));
        words.add(new Word(TopicDAO.COLOR, "Pink", "Màu hồng"));
        words.add(new Word(TopicDAO.COLOR, "Black", "Màu đen"));
        words.add(new Word(TopicDAO.COLOR, "Gray", "Màu xám"));
        words.add(new Word(TopicDAO.COLOR, "Orange", "Màu cam"));
        words.add(new Word(TopicDAO.COLOR, "Brown", "Màu nâu"));
        words.add(new Word(TopicDAO.COLOR, "White", "Màu trắng"));
    }

    private static void initializeFruits(List<Word> words) {
        words.add(new Word(TopicDAO.FRUIT, "Apple", "Quả táo"));
        words.add(new Word(TopicDAO.FRUIT, "Banana", "Quả chuối"));
        words.add(new Word(TopicDAO.FRUIT, "Orange", "Quả cam"));
        words.add(new Word(TopicDAO.FRUIT, "Lemon", "Quả chanh"));
        words.add(new Word(TopicDAO.FRUIT, "Peach", "Quả đào"));
        words.add(new Word(TopicDAO.FRUIT, "Pear", "Quả lê"));
        words.add(new Word(TopicDAO.FRUIT, "Berry", "Quả dâu"));
        words.add(new Word(TopicDAO.FRUIT, "Watermelon ", "Quả dưa hấu"));
        words.add(new Word(TopicDAO.FRUIT, "Pineapple", "Quả dứa"));
    }

    private static void initializeNumbers(List<Word> words) {
        words.add(new Word(TopicDAO.NUMBER, "Zero", "Số 0"));
        words.add(new Word(TopicDAO.NUMBER, "One", "Số 1"));
        words.add(new Word(TopicDAO.NUMBER, "Two", "Số 2"));
        words.add(new Word(TopicDAO.NUMBER, "Three", "Số 3"));
        words.add(new Word(TopicDAO.NUMBER, "Four", "Số 4"));
        words.add(new Word(TopicDAO.NUMBER, "Five", "Số 5"));
        words.add(new Word(TopicDAO.NUMBER, "Six", "Số 6"));
        words.add(new Word(TopicDAO.NUMBER, "Seven", "Số 7"));
        words.add(new Word(TopicDAO.NUMBER, "Eight", "Số 8"));
    }

    private static void initializeClass1(List<Word> words) {
        words.add(new Word(TopicDAO.CLASS1, "Be quiet", "Trật tự"));
        words.add(new Word(TopicDAO.CLASS1, "Listen", "Lắng nghe"));
        words.add(new Word(TopicDAO.CLASS1, "Look", "Quan sát"));
        words.add(new Word(TopicDAO.CLASS1, "Repeat", "Nhắc lại"));
        words.add(new Word(TopicDAO.CLASS1, "Mother", "Mẹ"));
        words.add(new Word(TopicDAO.CLASS1, "Father", "Bố"));
        words.add(new Word(TopicDAO.CLASS1, "Baby", "Em bé"));
        words.add(new Word(TopicDAO.CLASS1, "Good morning", "Chào buổi sáng"));
        words.add(new Word(TopicDAO.CLASS1, "Good afternoon", "Chiều buổi chiều"));
    }

    private static void initializeClass2(List<Word> words) {
        words.add(new Word(TopicDAO.CLASS2, "Bus", "Xe buýt"));
        words.add(new Word(TopicDAO.CLASS2, "Classroom", "Phòng học"));
        words.add(new Word(TopicDAO.CLASS2, "Library", "Thư viện"));
        words.add(new Word(TopicDAO.CLASS2, "Teacher", "Giáo viên"));
        words.add(new Word(TopicDAO.CLASS2, "Board", "Bảng"));
        words.add(new Word(TopicDAO.CLASS2, "Monday", "Thứ 2"));
        words.add(new Word(TopicDAO.CLASS2, "Tuesday", "Thứ 3"));
        words.add(new Word(TopicDAO.CLASS2, "Wednesday", "Thứ 4"));
        words.add(new Word(TopicDAO.CLASS2, "Thursday", "Thứ 5"));
    }

    private static void initializeClass3(List<Word> words) {
        words.add(new Word(TopicDAO.CLASS3, "Red", "Màu đỏ", "My jacket is red"));
        words.add(new Word(TopicDAO.CLASS3, "Yellow", "Màu vàng", "I like yellow skirts"));
        words.add(new Word(TopicDAO.CLASS3, "Book", "Quyển sách", "I have 2 beautiful books"));
        words.add(new Word(TopicDAO.CLASS3, "Chair", "Ghế", "I just bought this chair"));
        words.add(new Word(TopicDAO.CLASS3, "Table", "Bàn", "This table is beautiful"));
        words.add(new Word(TopicDAO.CLASS3, "Left", "Bên trái", "It is on the left side of the road"));
        words.add(new Word(TopicDAO.CLASS3, "Right", "Bên phải", "Turn right at the fork"));
        words.add(new Word(TopicDAO.CLASS3, "Next to", "Bên cạnh", "It is next to the book"));
        words.add(new Word(TopicDAO.CLASS3, "Under", "Bên dưới", "Ants under the Bridge"));
        words.add(new Word(TopicDAO.CLASS3, "Street", "Đường phố", "The street is bustling"));
        words.add(new Word(TopicDAO.CLASS3, "Tree", "Cây", "Trees are green on both sides of the road"));
        words.add(new Word(TopicDAO.CLASS3, "Plane", "Máy bay", "The plane is flying overhead"));
        words.add(new Word(TopicDAO.CLASS3, "Ship", "Tàu biển", "Ships are leaving port"));
        words.add(new Word(TopicDAO.CLASS3, "Shoe", "Giày", "This shoe I really like"));
        words.add(new Word(TopicDAO.CLASS3, "Hat", "Mũ", "The black hat is cool"));
    }

    private static void initializeClass6(List<Word> words) {
        words.add(new Word(TopicDAO.CLASS6, "Country", "Đất nước", "My country is wonderful"));
        words.add(new Word(TopicDAO.CLASS6, "Live", "Sống", "They need to live through tonight"));
        words.add(new Word(TopicDAO.CLASS6, "Busy", "Bận rộn", "I am very busy today"));
        words.add(new Word(TopicDAO.CLASS6, "Large", "Lớn", "The plane is large"));
        words.add(new Word(TopicDAO.CLASS6, "Beautiful", "Đẹp", "The flower is beautiful"));
        words.add(new Word(TopicDAO.CLASS6, "Quiet", "Yên tĩnh", "I need quiet in the room"));
        words.add(new Word(TopicDAO.CLASS6, "Small", "Nhỏ", "The ant has a very small body"));
        words.add(new Word(TopicDAO.CLASS6, "Flat", "Căn hộ", "That flat is very large"));
        words.add(new Word(TopicDAO.CLASS6, "Glass", "Kính", "This glass is very fragile"));
        words.add(new Word(TopicDAO.CLASS6, "Address", "Địa chỉ", "Address is on paper"));
        words.add(new Word(TopicDAO.CLASS6, "House", "Ngôi nhà", "The house is yellow"));
        words.add(new Word(TopicDAO.CLASS6, "Bedroom", "Phòng ngủ", "This bedroom is so big"));
        words.add(new Word(TopicDAO.CLASS6, "Kitchen", "Nhà bếp", "She is cooking in the kitchen"));
        words.add(new Word(TopicDAO.CLASS6, "Drink", "Đồ uống", "The drink is delicious"));
        words.add(new Word(TopicDAO.CLASS6, "Meal", "Bữa ăn", "The meal is special"));
    }

    private static void initializeClass7(List<Word> words) {
        words.add(new Word(TopicDAO.CLASS7, "Far", "Xa"));
        words.add(new Word(TopicDAO.CLASS7, "Different", "Khác nhau"));
        words.add(new Word(TopicDAO.CLASS7, "Nice", "Vui"));
        words.add(new Word(TopicDAO.CLASS7, "Fine", "Ổn"));
        words.add(new Word(TopicDAO.CLASS7, "Parent", "Bố mẹ"));
        words.add(new Word(TopicDAO.CLASS7, "Market", "Chợ"));
        words.add(new Word(TopicDAO.CLASS7, "Movie", "Bộ phim"));
        words.add(new Word(TopicDAO.CLASS7, "Join", "Tham gia"));
        words.add(new Word(TopicDAO.CLASS7, "Finish", "Kết thúc"));
    }

    private static void initializePositions(List<Word> words) {
        words.add(new Word(TopicDAO.POSITION, "Boss", "Sếp", "The boss is on a business trip in Hanoi"));
        words.add(new Word(TopicDAO.POSITION, "President", "Chủ tịch", "The president is the head of the company"));
        words.add(new Word(TopicDAO.POSITION, "Vice president", "Phó chủ tịch", " Vice president is the 2nd largest position in the company"));
        words.add(new Word(TopicDAO.POSITION, "Director", "Giám đốc", "My director is very caring staff"));
        words.add(new Word(TopicDAO.POSITION, "Manager", "Quản lý", "Mr. Nam is the PO project manager"));
        words.add(new Word(TopicDAO.POSITION, "Leader", "Lãnh đạo", "The leader of Mama Company is very young"));
        words.add(new Word(TopicDAO.POSITION, "Secretary", "Thư ký", "The secretary always arranges a schedule for the director"));
        words.add(new Word(TopicDAO.POSITION, "Expert", "Chuyên gia", "Mrs Juner is a famous expert"));
        words.add(new Word(TopicDAO.POSITION, "Department manage", "Trưởng phòng", "I'm going to eat with the department manager"));
        words.add(new Word(TopicDAO.POSITION, "Founder", "Chuyên gia", "Mr Honda is the founder of this company"));
        words.add(new Word(TopicDAO.POSITION, "Chief accountant", "Kế toán trưởng", "Chief accountant is very busy today"));
        words.add(new Word(TopicDAO.POSITION, "Supervisor", "Người dám sát", "I am the supervisor of this project"));
    }

    private static void initializeDepartments(List<Word> words) {
        words.add(new Word(TopicDAO.DEPARTMENT, "Accounting department", "Phòng kế toán"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Audit department", "Phòng kiểm toán"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Sales department", "Phòng kinh doanh"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Administration department", "Phòng hành chính"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Human Resources department", "Phòng nhân sự"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Financial department", "Phòng tài chính"));
        words.add(new Word(TopicDAO.DEPARTMENT, "Quality department", "Phòng chất lượng"));
    }

    private static void initializeConferences(List<Word> words) {
        words.add(new Word(TopicDAO.CONFERENCE, "Arrange", "Sắp xếp"));
        words.add(new Word(TopicDAO.CONFERENCE, "Meeting", "Cuộc họp"));
        words.add(new Word(TopicDAO.CONFERENCE, "Projector", "Máy chiếu"));
        words.add(new Word(TopicDAO.CONFERENCE, "Select", "Lựa chọn"));
        words.add(new Word(TopicDAO.CONFERENCE, "Register", "Đăng ký"));
        words.add(new Word(TopicDAO.CONFERENCE, "Take part in", "Tham gia"));
        words.add(new Word(TopicDAO.CONFERENCE, "Micro", "Míc"));
        words.add(new Word(TopicDAO.CONFERENCE, "Screen", "Màn hình"));
    }

    private static void initializeEquipments(List<Word> words) {
        words.add(new Word(TopicDAO.EQUIPMENT, "Lights", "Đèn điện", "The lights is on all night"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Computer", "Máy tính", "This computer is very beautiful"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Projector", "Máy chiếu", "I need a projector now"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Print", "Máy in", "Take it to the printer"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Scanner", "Máy scan", "I need a scanner now"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Television", "Tivi", "The program is broadcast on television"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Fax", "Máy fax", "Paper on fax machine"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Harmonic", "Điều hòa", "Harmonic is widely used"));
        words.add(new Word(TopicDAO.EQUIPMENT, "Fan", "Quạt", "The fan is very cool in this weather"));

    }

    private static void initializeHotels(List<Word> words) {
        words.add(new Word(TopicDAO.HOTEL, "Reservation", "Đặt phòng", "You need to make a reservation before traveling"));
        words.add(new Word(TopicDAO.HOTEL, "Vacancy", "Phòng trống", "The hotel has 2 rooms vacancy"));
        words.add(new Word(TopicDAO.HOTEL, "Lobby", "Sảnh", "She is down the lobby"));
        words.add(new Word(TopicDAO.HOTEL, "Receptionist", "Lễ tân", "The receptionist is very funny"));
        words.add(new Word(TopicDAO.HOTEL, "Key", "Chìa khóa", "You need a key to open a room"));
        words.add(new Word(TopicDAO.HOTEL, "Pay", "Thanh toán", "Pay in the lobby"));
        words.add(new Word(TopicDAO.HOTEL, "Luggage", "Hành lý", "Bring luggage for me"));
        words.add(new Word(TopicDAO.HOTEL, "Meal", "Bữa ăn", "The hotel has prepared meals"));
        words.add(new Word(TopicDAO.HOTEL, "Room", "Phòng", "Room needs to be locked"));
        words.add(new Word(TopicDAO.HOTEL, "Drink", "Đồ uống", "Do you have a drink?"));
        words.add(new Word(TopicDAO.HOTEL, "Corridor", "Hành lang", "It is located in the left corridor"));
        words.add(new Word(TopicDAO.HOTEL, "Balcony", "Ban công", "Very cool balcony"));
        words.add(new Word(TopicDAO.HOTEL, "Clean", "Sạch sẽ", "The room must be clean"));
        words.add(new Word(TopicDAO.HOTEL, "Safe", "An toàn", "Pay attention to safe"));
        words.add(new Word(TopicDAO.HOTEL, "Manager", "Quản lý", "She is the manager here"));
    }

    private static void initializeOverview(List<Word> words) {
        words.add(new Word(TopicDAO.OVERVIEW, "Education", "Giáo dục", "Education is growing"));
        words.add(new Word(TopicDAO.OVERVIEW, "Crime", "Tội phạm","Crime reward lurks very carefully"));
        words.add(new Word(TopicDAO.OVERVIEW, "Technology", "Công nghệ", "Technology is popular in the world"));
        words.add(new Word(TopicDAO.OVERVIEW, "Environment", "Môi trường", "The marine environment is polluted"));
        words.add(new Word(TopicDAO.OVERVIEW, "Science", "Khoa học", "Khám phá khoa học trên thư viện"));
        words.add(new Word(TopicDAO.OVERVIEW, "Advertising ", "Quảng cáo", "Advertising appear on the television"));
        words.add(new Word(TopicDAO.OVERVIEW, "Work", "Công việc", "IT is my favorite work"));
        words.add(new Word(TopicDAO.OVERVIEW, "City", "Thành phố", "Hanoi is a modern city"));
        words.add(new Word(TopicDAO.OVERVIEW, "Contact", "Liên lạc", "I could not contact anyone"));
        words.add(new Word(TopicDAO.OVERVIEW, "Student", "Sinh viên", "Students are very active"));
        words.add(new Word(TopicDAO.OVERVIEW, "Company", "Công ty", "I am working at the company"));
        words.add(new Word(TopicDAO.OVERVIEW, "Bank", "Ngân hàng", "Banks are in trouble"));
        words.add(new Word(TopicDAO.OVERVIEW, "Book", "Quyển sách", "This book is quite good"));
        words.add(new Word(TopicDAO.OVERVIEW, "Clothes", "Quần áo", "This store a lot of beautiful clothes"));
        words.add(new Word(TopicDAO.OVERVIEW, "Color", "Màu sắc", "What is your favorite color?"));


    }

    private static void initializeContracts(List<Word> words) {
        words.add(new Word(TopicDAO.CONTRACTS, "Agree ", "Đồng ý", "I agree with this decision"));
        words.add(new Word(TopicDAO.CONTRACTS, "Assure ", "Đảm bảo","I assure you will not be late"));
        words.add(new Word(TopicDAO.CONTRACTS, "Determine ", "Quyết định", "She determine to leave"));
        words.add(new Word(TopicDAO.CONTRACTS, "Engage ", "Thuê", "I engage this motorbike 3 days"));
        words.add(new Word(TopicDAO.CONTRACTS, "Provide ", "Cung cấp", "PO Company provides drinking water"));
        words.add(new Word(TopicDAO.CONTRACTS, "Specify ", "Xác định", "You have to specify the way"));
        words.add(new Word(TopicDAO.CONTRACTS, "Resolve ", "Giải quyết", "This issue has not been resolved"));
        words.add(new Word(TopicDAO.CONTRACTS, "Cooperate", "Hợp tác", "Happy cooperation"));
        words.add(new Word(TopicDAO.CONTRACTS, "Establish ", "Thiết lập", "This company has been established for 2 years"));
    }

}
