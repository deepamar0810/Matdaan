package com.example20.matdaan;

import android.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class UserRegistration extends Activity {
    SQLiteDatabase db;
    DatePickerDialog pickerDialog;
    String []gender;
    Spinner enterGenderSpinner;
    EditText enterDob;
    AutoCompleteTextView autoCompleteState, autoCompleteCity;
    Button userRegisterBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        //Date of Birth
        enterDob=(EditText) findViewById(R.id.enterDob);
        enterDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                //Dialog picker
                pickerDialog=new DatePickerDialog(UserRegistration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        enterDob.setText(year+"/"+(month)+"/"+dayOfMonth);
                    }
                },year,month,day);
                pickerDialog.show();
            }
        });

       //DropDown or spinner
        gender= new String[]{"Select","Male", "Female"};
        enterGenderSpinner=(Spinner) findViewById(R.id.enterGenderSpinner);
        ArrayAdapter<String> genderAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,gender);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterGenderSpinner.setAdapter(genderAdapter);
       // Toast.makeText(this,"Selected"+enterGenderSpinner.getSelectedItem(),Toast.LENGTH_SHORT).show();

        //AutoCompleteTextView
      //AutoCompleteTextView for States
        String[] states = {

                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal"
        };

        autoCompleteState=(AutoCompleteTextView)findViewById(R.id.autoCompleteState);
        ArrayAdapter<String> stateAdapter=new ArrayAdapter<>(this, layout.simple_expandable_list_item_1,states);
        autoCompleteState.setAdapter(stateAdapter);


        //AutoCompleteTextView for Cities
        String []cities = {
                "Visakhapatnam",
                "Vijayawada",
                "Guntur",
                "Nellore",
                "Kurnool",
                "Rajahmundry",
                "Tirupati",
                "Kakinada",
                "Anantapur",
                "Eluru",
                "Ongole",
                "Vizianagaram",
                "Tenali",
                "Proddatur",
                "Chittoor",
                "Amalapuram",
                "Kadapa",
                "Srikakulam",
                "Anakapalle",
                "Bhimavaram",
                "Machilipatnam",
                "Madanapalle",
                "Gudivada",
                "Narasaraopet",
                "Tadepalligudem",
                "Chirala",
                "Bapatla",
                "Palasa-Kasibugga",
                "Srikalahasti",
                "Adoni",
                "Itanagar",
                "Naharlagun",
                "Pasighat",
                "Tawang",
                "Ziro",
                "Bomdila",
                "Roing",
                "Tezu",
                "Along",
                "Daporijo",
                "Anini",
                "Khonsa",
                "Yingkiong",
                "Mechuka",
                "Changlang",
                "Namsai",
                "Seppa",
                "Bhalukpong",
                "Aalo",
                "Dirang",
                "Jairampur",
                "Naharlagun",
                "Pasighat",
                "Guwahati",
                "Silchar",
                "Dibrugarh",
                "Jorhat",
                "Nagaon",
                "Tinsukia",
                "Tezpur",
                "Karimganj",
                "Sivasagar",
                "Goalpara",
                "Barpeta",
                "Hailakandi",
                "Dhubri",
                "Nalbari",
                "Mangaldoi",
                "Bongaigaon",
                "North Lakhimpur",
                "Diphu",
                "Lanka",
                "Dergaon",
                "Lumding",
                "Hoja",
                "Rangia",
                "Hojai",
                "Duliajan",
                "Lido Tikok",
                "Patna",
                "Gaya",
                "Bhagalpur",
                "Muzaffarpur",
                "Purnia",
                "Darbhanga",
                "Arrah",
                "Begusarai",
                "Katihar",
                "Chapra",
                "Nalanda",
                "Motihari",
                "Saharsa",
                "Samastipur",
                "Hajipur",
                "Siwan",
                "Gopalganj",
                "Jamalpur",
                "Bettiah",
                "Buxar",
                "Kishanganj",
                "Sitamarhi",
                "Munger",
                "Dehri",
                "Madhubani",
                "Aurangabad",
                "Bihar Sharif",
                "Begusarai",
                "Mokama",
                "Supaul",
                "Raipur",
                "Bhilai",
                "Bilaspur",
                "Korba",
                "Durg",
                "Raigarh",
                "Rajnandgaon",
                "Jagdalpur",
                "Ambikapur",
                "Chirmiri",
                "Dhamtari",
                "Mahasamund",
                "Kanker",
                "Bhatapara",
                "Jagdalpur",
                "Janjgir",
                "Kawardha",
                "Dongargarh",
                "Bilaspur",
                "Rajnandgaon",
                "Bhilai Nagar",
                "Baikunthpur",
                "Sakti",
                "Champa",
                "Pithora",
                "Katghora",
                "Takhatpur",
                "Jaijaipur",
                "Panaji",
                "Margao",
                "Vasco da Gama",
                "Mapusa",
                "Ponda",
                "Bicholim",
                "Curchorem",
                "Cuncolim",
                "Valpoi",
                "Canacona",
                "Sanguem",
                "Quepem",
                "Salcete",
                "Sattari",
                "Tiswadi",
                "Bardez",
                "Ahmedabad",
                "Surat",
                "Vadodara",
                "Rajkot",
                "Bhavnagar",
                "Jamnagar",
                "Junagadh",
                "Gandhinagar",
                "Anand",
                "Nadiad",
                "Morbi",
                "Surendranagar",
                "Bharuch",
                "Navsari",
                "Valsad",
                "Vapi",
                "Ankleshwar",
                "Dahod",
                "Godhra",
                "Palanpur",
                "Veraval",
                "Porbandar",
                "Botad",
                "Bhuj",
                "Gandhidham",
                "Mehsana",
                "Himatnagar",
                "Modasa",
                "Palanpur",
                "Patan",
                "Chandigarh",
                "Faridabad",
                "Gurgaon",
                "Panipat",
                "Ambala",
                "Hisar",
                "Karnal",
                "Sonipat",
                "Yamunanagar",
                "Rohtak",
                "Panchkula",
                "Bhiwani",
                "Sirsa",
                "Bahadurgarh",
                "Jind",
                "Thanesar",
                "Kaithal",
                "Rewari",
                "Palwal",
                "Hansi",
                "Narnaul",
                "Fatehabad",
                "Tohana",
                "Kosli",
                "Narwana",
                "Charkhi Dadri",
                "Shimla",
                "Manali",
                "Dharamshala",
                "Kullu",
                "Solan",
                "Mandi",
                "Chamba",
                "Kangra",
                "Bilaspur",
                "Hamirpur",
                "Nahan",
                "Una",
                "Palampur",
                "Kasauli",
                "Dalhousie",
                "Parwanoo",
                "Keylong",
                "Rohru",
                "Paonta Sahib",
                "Sundernagar",
                "Rampur",
                "Baddi",
                "Kalpa",
                "Naggar",
                "Joginder Nagar",
                "Karsog",
                "Kaza",
                "Bhuntar",
                "Tattapani",
                "Sarahan",
                "Janjehli",
                "Chail",
                "Rewalsar",
                "Spiti",
                "Kasol",
                "Sangla",
                "Narkanda",
                "Tirthan Valley",
                "Rekong Peo",
                "Kinnaur",
                "Ranchi",
                "Jamshedpur",
                "Dhanbad",
                "Bokaro Steel City",
                "Deoghar",
                "Hazaribagh",
                "Giridih",
                "Ramgarh",
                "Chirkunda",
                "Phusro",
                "Gumia",
                "Medininagar (Daltonganj)",
                "Chaibasa",
                "Adityapur",
                "Sahibganj",
                "Mango",
                "Ghatshila",
                "Lohardaga",
                "Simdega",
                "Pakur",
                "Jhumri Telaiya",
                "Chatra",
                "Gumla",
                "Godda",
                "Latehar",
                "Jharia",
                "Tenu Dam-cum-Kathhara",
                "Khunti",
                "Bundu",
                "Barughutu",
                "Patratu",
                "Garhwa",
                "Koderma",
                "Saraikela",
                "Hussainabad",
                "Chakulia",
                "Chandrapura",
                "Chaibasa",
                "Bermo",
                "Dumka",
                "Jamtara",
                "Mihijam",
                "Rajmahal",
                "Basukinath",
                "Noamundi",
                "Kiriburu",
                "Kashipur",
                "Barhi",
                "Sahibganj",
                "Rajrappa",
                "Chandil",
                "Dhanwar",
                "Gola",
                "Tenughat",
                "Bengaluru",
                "Mysuru",
                "Mangaluru",
                "Hubballi",
                "Dharwad",
                "Belagavi",
                "Kalaburagi",
                "Davangere",
                "Ballari",
                "Vijayapura",
                "Shivamogga",
                "Tumakuru",
                "Bidar",
                "Udupi",
                "Raichur",
                "Hosapete",
                "Gadag",
                "Robertsonpet",
                "Chikkamagaluru",
                "Bagalkot",
                "Hassan",
                "Bhadravati",
                "Chitradurga",
                "Ranebennur",
                "Ramanagara",
                "Sirsi",
                "Bailhongal",
                "Kolar",
                "Mandya",
                "Basavakalyan",
                "Tiptur",
                "Yadgir",
                "Gokak",
                "Doddaballapura",
                "Chikkaballapura",
                "Gangavathi",
                "Madhugiri",
                "Tadpatri",
                "Kanakapura",
                "Sindhanur",
                "Hoskote",
                "Athni",
                "Koppal",
                "Harihar",
                "Karwar",
                "Malur",
                "Sira",
                "Channapatna",
                "Sakleshpur",
                "Sidlaghatta",
                "Mudhol",
                "Kundapura",
                "Kollegal",
                "Bagarpet",
                "Yelahanka",
                "Shrirangapattana",
                "Savanur",
                "Ilkal",
                "Jamkhandi",
                "Ron",
                "Muddebihal",
                "Nagamangala",
                "Haveri",
                "Sorab",
                "Shiggaon",
                "Mundargi",
                "Nanjangud",
                "Shahabad",
                "Tarikere",
                "Siruguppa",
                "Humnabad",
                "Afzalpur",
                "Kadur",
                "Alnavar",
                "Sadalgi",
                "Banavar",
                "Bagepalli",
                "Kamalapuram",
                "Bhalki",
                "Hunasagi",
                "Jevargi",
                "Kotturu",
                "Raibag",
                "Ramadurga",
                "Rabkavi Banhatti",
                "Saligrama",
                "Sandur",
                "Sankeshwar",
                "Siddapur",
                "Sundarnagar",
                "Surathkal",
                "Terdal",
                "Tikota",
                "Yelbarga",
                "Yellapur",
                "Thiruvananthapuram",
                "Kochi",
                "Kozhikode",
                "Kollam",
                "Thrissur",
                "Alappuzha",
                "Palakkad",
                "Malappuram",
                "Kannur",
                "Kottayam",
                "Kasaragod",
                "Idukki",
                "Pathanamthitta",
                "Varkala",
                "Cherthala",
                "Kayamkulam",
                "Kanhangad",
                "Chalakudy",
                "Kunnamkulam",
                "Ottapalam",
                "Tirur",
                "Ponnani",
                "Changanassery",
                "Guruvayur",
                "Mavelikkara",
                "Kottarakkara",
                "Adoor",
                "Attingal",
                "Punalur",
                "Kothamangalam",
                "Kodungallur",
                "Perinthalmanna",
                "Taliparamba",
                "Thalassery",
                "Payyanur",
                "Neyyattinkara",
                "Kottayam",
                "Palai",
                "Nedumangad",
                "Paravur",
                "Pattambi",
                "Perumbavoor",
                "Mattannur",
                "Mahe",
                "Vadakara",
                "Kalpetta",
                "Muvattupuzha",
                "Kozhinjampara",
                "Aluva",
                "Chengannur",
                "Irinjalakuda",
                "Kunnathurmedu",
                "Kanhangad",
                "Manjeri",
                "Thodupuzha",
                "Sulthan Bathery",
                "Kalpetta",
                "Vatakara",
                "Azhikode",
                "Kumarakom",
                "Cherpulassery",
                "Peringathur",
                "Mananthavady",
                "Chittur-Thathamangalam",
                "Shoranur",
                "Chalakkudy",
                "Vaikom",
                "Pandalam",
                "Pathiriyad",
                "Adoor",
                "Vandiperiyar",
                "Rajakkad",
                "Malappuram",
                "Nilambur",
                "Mattancherry",
                "Peravoor",
                "Pala",
                "Piravom",
                "Manjapra",
                "Kunnamkulam",
                "Ottapalam",
                "Koothattukulam",
                "Alathur",
                "Palakkad",
                "Kollam",
                "Pathanamthitta",
                "Pappinisseri",
                "Ponnani",
                "Changanassery",
                "Adoor",
                "Varkala",
                "Payyannur",
                "Paravur",
                "Bhopal",
                "Indore",
                "Gwalior",
                "Jabalpur",
                "Ujjain",
                "Sagar",
                "Dewas",
                "Satna",
                "Ratlam",
                "Rewa",
                "Murwara (Katni)",
                "Singrauli",
                "Burhanpur",
                "Khandwa",
                "Bhind",
                "Chhindwara",
                "Vidisha",
                "Guna",
                "Shivpuri",
                "Mandsaur",
                "Hoshangabad",
                "Itarsi",
                "Sehore",
                "Betul",
                "Seoni",
                "Datia",
                "Nagda",
                "Mhow",
                "Neemuch",
                "Pithampur",
                "Damoh",
                "Chhatarpur",
                "Ashok Nagar",
                "Shahdol",
                "Panna",
                "Tikamgarh",
                "Morena",
                "Chhindwara",
                "Khargone",
                "Barwani",
                "Dhar",
                "Mandla",
                "Sidhi",
                "Raisen",
                "Dindori",
                "Anuppur",
                "Jhabua",
                "Alirajpur",
                "Sheopur",
                "Umaria",
                "Narsinghpur",
                "Rajgarh",
                "Shajapur",
                "Agar Malwa",
                "Shivpuri",
                "Ganjbasoda",
                "Sihora",
                "Maihar",
                "Niwari",
                "Harda",
                "Maheshwar",
                "Hatta",
                "Sarni",
                "Patharia",
                "Multai",
                "Pandhurna",
                "Pachmarhi",
                "Nagod",
                "Nagda",
                "Lahar",
                "Gadarwara",
                "Chicholi",
                "Bareli",
                "Balaghat",
                "Ambah",
                "Amla",
                "Akoda",
                "Mumbai",
                "Pune",
                "Nagpur",
                "Nashik",
                "Thane",
                "Solapur",
                "Kolhapur",
                "Amravati",
                "Nanded",
                "Sangli",
                "Latur",
                "Dhule",
                "Jalgaon",
                "Ahmadnagar",
                "Akola",
                "Chandrapur",
                "Parbhani",
                "Ichalkaranji",
                "Bhusawal",
                "Ratnagiri",
                "Wardha",
                "Badlapur",
                "Alibag",
                "Karad",
                "Ambarnath",
                "Panvel",
                "Bhiwandi",
                "Osmanabad",
                "Yavatmal",
                "Gondia",
                "Hingoli",
                "Baramati",
                "Beed",
                "Satara",
                "Achalpur",
                "Udgir",
                "Mahad",
                "Nandurbar",
                "Talegaon Dabhade",
                "Manmad",
                "Sinnar",
                "Pandharpur",
                "Shrirampur",
                "Akluj",
                "Malegaon",
                "Malkapur",
                "Mangalvedhe",
                "Paithan",
                "Jalna",
                "Chalisgaon",
                "Sillod",
                "Mehkar",
                "Nandgaon",
                "Sakri",
                "Washim",
                "Warud",
                "Wani",
                "Sangamner",
                "Shahada",
                "Shegaon",
                "Tumsar",
                "Vadgaon Kasba",
                "Wardha",
                "Warora",
                "Yavatmal",
                "Dombivli",
                "Virar",
                "Kalyan",
                "Ulhasnagar",
                "Amalner",
                "Paranda",
                "Pusad",
                "Rahuri",
                "Shrigonda",
                "Shirdi",
                "Morshi",
                "Navi Mumbai",
                "Goregaon",
                "Hinganghat",
                "Khamgaon",
                "Kinwat",
                "Lonavla",
                "Mira-Bhayandar",
                "Murbad",
                "Nashik Road",
                "Phaltan",
                "Sangole",
                "Saswad",
                "Shrirampur",
                "Shirpur",
                "Tuljapur",
                "Vaduj",
                "Vasai-Virar",
                "Yevla",
                "Talegaon Dabhade",
                "Manjlegaon",
                "Dondaicha-Warwade",
                "Talegaon Station",
                "Chopda",
                "Gadchiroli",
                "Aheri",
                "Bhandara",
                "Hingoli",
                "Kamptee",
                "Narkhed",
                "Pauni",
                "Ramtek",
                "Tumsar",
                "Wadgaon Road",
                "Wardha",
                "Warora",
                "Yavatmal",
                "Imphal",
                "Bishnupur",
                "Churachandpur",
                "Kakching",
                "Kangpokpi",
                "Mayang Imphal",
                "Moijing",
                "Moreh",
                "Nambol",
                "Sekmai Bazar",
                "Senapati",
                "Sikhong Sekmai",
                "Thoubal",
                "Ukhrul",
                "Wangjing",
                "Yairipok",
                "Lilong",
                "Sugnu",
                "Andro",
                "Wabagai",
                "Oinam",
                "Kumbi",
                "Moirang",
                "Kangchup",
                "Jiribam",
                "Lamshang",
                "Khurai",
                "Kakching Khunou",
                "Lamlai",
                "Mongkhang Lambi",
                "Porompat",
                "Lamjaotongba",
                "Wangkhei",
                "Lamjaotongba",
                "Keisampat",
                "Shillong",
                "Tura",
                "Nongstoin",
                "Jowai",
                "Baghmara",
                "Williamnagar",
                "Nongpoh",
                "Resubelpara",
                "Mairang",
                "Cherrapunji (Sohra)",
                "Mawkyrwat",
                "Mendipathar",
                "Shillong Cantonment",
                "Umiam",
                "Mawsynram",
                "Pynursla",
                "Smit",
                "Mawlai",
                "Dawki",
                "Byrnihat",
                "Mawkynrew",
                "Khliehriat",
                "Mawphlang",
                "Mairang",
                "Sohiong",
                "Patharkhmah",
                "Nartiang",
                "Chokpot",
                "Dadenggre",
                "Nongalbibra",
                "Tikrikilla",
                "Ranikor",
                "Ampati",
                "Dalu",
                "Balat",
                "Siju",
                "Aizawl",
                "Lunglei",
                "Saiha",
                "Champhai",
                "Serchhip",
                "Kolasib",
                "Lawngtlai",
                "Mamit",
                "Biate",
                "Bualpui NG",
                "Darlawn",
                "Hnahthial",
                "Khawhai",
                "Khawzawl",
                "Lengpui",
                "N. Kawnpui",
                "North Vanlaiphai",
                "Saitual",
                "Thenzawl",
                "Tlabung",
                "Vairengte",
                "Zawlnuam",
                "Zobawk",
                "Aibawk",
                "Ngopa",
                "Phullen",
                "Chawngte",
                "East Lungdar",
                "Kawnpui",
                "Kulikawn",
                "N. Vanlaiphai",
                "New Serchhip",
                "Reiek",
                "Sangau",
                "Seling",
                "Tlungvel",
                "Tuipang",
                "W.Phaileng",
                "Kohima",
                "Dimapur",
                "Mokokchung",
                "Tuensang",
                "Wokha",
                "Zunheboto",
                "Phek",
                "Mon",
                "Longleng",
                "Peren",
                "Kiphire",
                "Chumukedima",
                "Kohima Town",
                "Pfutsero",
                "Chumukedima",
                "Tuli",
                "Medziphema",
                "Bhandari",
                "Zunheboto Town",
                "Dimapur",
                "Mokokchung",
                "Phek",
                "Longleng",
                "Mon",
                "Wokha",
                "Tuensang",
                "Kohima Town",
                "Medziphema",
                "Zunheboto Town",
                "Pfutsero",
                "Tuli",
                "Bhandari",
                "Bhubaneswar",
                "Cuttack",
                "Rourkela",
                "Berhampur",
                "Sambalpur",
                "Puri",
                "Balasore",
                "Brahmapur",
                "Baripada",
                "Bhadrak",
                "Bargarh",
                "Jharsuguda",
                "Jeypore",
                "Kendujhar",
                "Rayagada",
                "Bolangir",
                "Jagatsinghpur",
                "Phulabani",
                "Boudh",
                "Nabarangpur",
                "Koraput",
                "Dhenkanal",
                "Paradip",
                "Anugul",
                "Talcher",
                "Athagarh",
                "Bhawanipatna",
                "Byasanagar",
                "Parlakhemundi",
                "Barbil",
                "Sunabeda",
                "Belpahar",
                "Padampur",
                "Nayagarh",
                "Jatani",
                "Kendrapara",
                "Paralakhemundi",
                "Malkangiri",
                "Soro",
                "Tarbha",
                "Titlagarh",
                "Udala",
                "Brahmagiri",
                "Rajgangpur",
                "Joda",
                "Ganjam",
                "Pipili",
                "Chhatrapur",
                "Bhuban",
                "Kantabanji",
                "Konark",
                "Bhadrak",
                "Gunupur",
                "Bhanjanagar",
                "Nimapada",
                "Boudh",
                "Bhubaneswar",
                "Anandpur",
                "Nayagarh",
                "Patnagarh",
                "Kavisuryanagar",
                "Pattamundai",
                "Pallahara",
                "Remuna",
                "Rairangpur",
                "Rambha",
                "Phulabani",
                "Phulbani",
                "Pipili",
                "Padampur",
                "Paradip",
                "Paikamal",
                "Sundargarh",
                "Talcher",
                "Titilagarh",
                "Umarkote",
                "Udala",
                "Amritsar",
                "Ludhiana",
                "Jalandhar",
                "Patiala",
                "Bathinda",
                "Pathankot",
                "Hoshiarpur",
                "Mohali",
                "Batala",
                "Moga",
                "Abohar",
                "Muktsar",
                "Barnala",
                "Rajpura",
                "Firozpur",
                "Kapurthala",
                "Phagwara",
                "Khanna",
                "Faridkot",
                "Gurdaspur",
                "Sangrur",
                "Nabha",
                "Malout",
                "Tarn Taran",
                "Malerkotla",
                "Fazilka",
                "Zirakpur",
                "Mansa",
                "Pathankot",
                "Fatehgarh Sahib",
                "Mandi Gobindgarh",
                "Sunam",
                "Gobindgarh",
                "Jagraon",
                "Samana",
                "Rupnagar",
                "Nakodar",
                "Ferozepur",
                "Sirhind-Fategarh",
                "Kharar",
                "Sultanpur Lodhi",
                "Rajpura",
                "Phillaur",
                "Patti",
                "Giddarbaha",
                "Banga",
                "Kotkapura",
                "Kharar",
                "Dera Bassi",
                "Raikot",
                "Bagha Purana",
                "Jalandhar Cantt",
                "Jaitu",
                "Payal",
                "Nawanshahr",
                "Zirakpur",
                "Patti",
                "Bholath",
                "Budhlada",
                "Lambi",
                "Banaur",
                "Bhadson",
                "Dasua",
                "Garhshankar",
                "Ghanaur",
                "Hariana",
                "Khamano",
                "Nangal",
                "Nurmahal",
                "Rampura Phul",
                "Rayya",
                "Rahon",
                "Sujanpur",
                "Talwara",
                "Uklanamandi",
                "Zira",
                "Lucknow",
                "Kanpur",
                "Agra",
                "Varanasi",
                "Allahabad",
                "Meerut",
                "Gorakhpur",
                "Aligarh",
                "Moradabad",
                "Saharanpur",
                "Jhansi",
                "Muzaffarnagar",
                "Mathura",
                "Bareilly",
                "Noida",
                "Firozabad",
                "Etawah",
                "Ayodhya",
                "Basti",
                "Faizabad",
                "Rampur",
                "Mirzapur",
                "Bulandshahr",
                "Sultanpur",
                "Budaun",
                "Hapur",
                "Azamgarh",
                "Ballia",
                "Bahraich",
                "Barabanki",
                "Ghaziabad",
                "Hathras",
                "Ajmer", "Alwar", "Banswara", "Baran", "Barmer", "Bharatpur", "Bhilwara",
                "Bikaner", "Bundi", "Chittorgarh", "Churu", "Dausa", "Dholpur", "Dungarpur",
                "Hanumangarh", "Jaipur", "Jaisalmer", "Jalor", "Jhalawar", "Jhunjhunu",
                "Jodhpur", "Karauli", "Kota", "Nagaur", "Pali", "Pratapgarh", "Rajsamand",
                "Sawai Madhopur", "Sikar", "Sirohi", "Sri Ganganagar", "Tonk", "Udaipur",
                "Gangtok", "Namchi", "Mangan", "Gyalshing", "Rangpo", "Jorethang",
                "Singtam", "Geyzing", "Pakyong",
                "Chennai", "Coimbatore", "Madurai", "Tiruchirappalli", "Salem", "Erode",
                "Tiruppur", "Vellore", "Thoothukudi", "Tirunelveli", "Dindigul", "Kanchipuram",
                "Karur", "Nagapattinam", "Nagercoil", "Namakkal", "Perambalur", "Pudukkottai",
                "Ramanathapuram", "Sivakasi", "Thanjavur", "Theni", "Tiruvannamalai",
                "Udhagamandalam", "Viluppuram", "Virudhunagar", "Cuddalore", "Kumbakonam",
                "Rajapalayam", "Sivaganga", "Tindivanam", "Arakkonam", "Pollachi",
                "Ambur", "Gudiyatham", "Karaikudi", "Manapparai", "Pattukkottai",
                "Arani", "Chengalpattu", "Kallakurichi", "Kovilpatti",
                "Hyderabad", "Warangal", "Nizamabad", "Khammam", "Karimnagar", "Ramagundam",
                "Mahbubnagar", "Nalgonda", "Adilabad", "Siddipet", "Suryapet", "Jagtial",
                "Mancherial", "Bhongir", "Miryalaguda", "Wanaparthy", "Kothagudem",
                "Mahabubabad", "Nagarkurnool", "Kamareddy", "Vikarabad", "Gadwal",
                "Bodhan", "Narayanpet", "Sircilla", "Zaheerabad", "Medak", "Mulugu",
                "Medchal", "Yellandu", "Sangareddy",
                "Agartala", "Dharmanagar", "Kailashahar", "Udaipur", "Kumarghat",
                "Belonia", "Ambassa", "Khowai", "Amarpur", "Sabroom", "Ranirbazar",
                "Sonamura", "Bishalgarh", "Teliamura", "Melaghar",
                "Dehradun", "Haridwar", "Roorkee", "Haldwani", "Rishikesh", "Kashipur",
                "Rudrapur", "Ramnagar", "Nainital", "Pithoragarh", "Almora", "Bageshwar",
                "Champawat", "Chamba", "Mussoorie", "Lansdowne", "Kotdwar", "Tehri",
                "Srinagar", "Joshimath", "Uttarkashi", "Doiwala", "Sitarganj",
                "Kichha", "Jaspur", "Manglaur", "Karnaprayag", "Khatima", "Ranikhet",
                "Kolkata", "Howrah", "Asansol", "Siliguri", "Durgapur", "Bardhaman",
                "Malda", "Alipurduar", "Jalpaiguri", "Darjeeling", "Cooch Behar",
                "Raiganj", "Kharagpur", "Haldia", "Suri", "Krishnanagar", "Nabadwip",
                "Naihati", "Bangaon", "Barrackpore", "Kalyani", "Chandannagar",
                "Bhatpara", "Bally", "Raniganj", "Konnagar", "Barasat", "Basirhat",
                "Serampore", "Uluberia", "Habra", "Dankuni", "Barddhaman", "Purulia",
                "Bankura", "Medinipur", "Balurghat", "Tamluk", "Bolpur", "Gangarampur",
                "Rampurhat", "Murshidabad", "Jangipur", "Beldanga", "Birbhum",
                "Delhi","Bangalore","Jammu","Mangalore","Unnao"
        };

        autoCompleteCity=(AutoCompleteTextView) findViewById(R.id.autoCompleteCity);
        ArrayAdapter<String> citiesAdapter=new ArrayAdapter<>(this, layout.simple_expandable_list_item_1,cities);
        autoCompleteCity.setAdapter(citiesAdapter);





         idFind();
         databaseConnectivity();
        // db.execSQL("DROP TABLE if exists voterDetails");

        userRegisterBtn=(Button)findViewById(R.id.userRegisterBtn);
        userRegisterBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               //fetching data from UserRegistration
               fetchingDataFromUserRegistration();

             if(1==insertingDataIntoDatabase())
             {
                 nextActivity();
             }

           }
       });



    }//end of onCreate


    public void  nextActivity()
    {
        Intent i=new Intent(UserRegistration.this,UserLoginPage.class);
        Toast.makeText(UserRegistration.this,"Registered",Toast.LENGTH_SHORT).show();
        startActivity(i);
        finish();
    }


    EditText enterAdhaar, enterName, enterFatherName, enterAddress, enterPincode, enterMobile, enterPassword;
    public void idFind()
    {
        enterAdhaar=(EditText) findViewById(R.id.enterAdhaar);
        enterName=(EditText) findViewById(R.id.enterName);
        enterFatherName=(EditText) findViewById(R.id.enterFatherName);

        enterAddress=(EditText) findViewById(R.id.enterAddress);
        enterPincode=(EditText) findViewById(R.id.enterPincode);
        enterMobile=(EditText) findViewById(R.id.enterMobile);
        enterPassword=(EditText) findViewById(R.id.enterPassword);

    }

    public void databaseConnectivity()
    {
        //database connectivity
        db=openOrCreateDatabase("VotersData.sql",MODE_PRIVATE,null);
    //    Toast.makeText(this,"database created",Toast.LENGTH_SHORT).show();
    }


    //user inputed values
    Long valueLongAdhaar;
    String  valueName, valueFatherName, valueAddress, valuePincode, valueMobile, valuePassword, valueCity,valueState, valueGender, valueDob;
    public void fetchingDataFromUserRegistration()
    {
        try{

             valueLongAdhaar = Long.parseLong(enterAdhaar.getText().toString());
             valueDob = enterDob.getText().toString();
             valuePincode = enterPincode.getText().toString();
             valueMobile = enterMobile.getText().toString();
             valuePassword = enterPassword.getText().toString();
             valueName = enterName.getText().toString().toUpperCase();
             valueFatherName = enterFatherName.getText().toString().toUpperCase();
             valueAddress = enterAddress.getText().toString().toUpperCase();


             valueCity = autoCompleteCity.getText().toString().toUpperCase();
             valueState = autoCompleteState.getText().toString().toUpperCase();
             valueGender = (String) enterGenderSpinner.getSelectedItem();

             //constraints Handler
             checkConstraints();
       }
       catch (NumberFormatException numberFormatException)
       {
           Toast.makeText(UserRegistration.this,"Empty Registration",Toast.LENGTH_SHORT).show();

       }
        catch(Exception ignored) {


        }
    }


    public int insertingDataIntoDatabase() {
        try {


            db.execSQL("INSERT INTO voterDetails(adhaarNo,voterName,voterFatherName,dob,gender,state,city,address,pincode,mobile,password)" +
                    " VALUES(" + valueLongAdhaar + ",'" + valueName + "','" + valueFatherName + "','" + valueDob + "','" + valueGender + "','" + valueState + "'," +
                    "'" + valueCity + "','" + valueAddress + "','" + valuePincode + "','" + valueMobile + "','" + valuePassword + "')");
            //      Toast.makeText(UserRegistration.this,"Data inserted",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e) {
            Log.d("ADebugTag", "Value: ");
            return 0;

        }
        return 1;

    }

    //contraints handler
    public void checkConstraints()
    {
       db.execSQL("drop table if exists adhaarCheck");
        db.execSQL("CREATE TABLE IF NOT EXISTS adhaarCheck(adhaarNo INTEGER PRIMARY KEY CHECK(adhaarNo LIKE '____________' AND (adhaarNo LIKE '9%' OR adhaarNo LIKE '8%' OR adhaarNo LIKE '7%' OR adhaarNo LIKE '6%' OR adhaarNo LIKE '5%' OR adhaarNo LIKE '4%' OR adhaarNo LIKE '3%' OR adhaarNo LIKE '2%')))");
       // Toast.makeText(UserRegistration.this,"adhaarCheck table created",Toast.LENGTH_SHORT).show();

          //Adhaar Constraints Handler
           try {
            //   Toast.makeText(UserRegistration.this,"value "+valueLongAdhaar,Toast.LENGTH_SHORT).show();
               db.execSQL("INSERT INTO adhaarCheck(adhaarNo) VALUES("+valueLongAdhaar+")");
             //  Toast.makeText(UserRegistration.this,"inserted",Toast.LENGTH_SHORT).show();

           }catch (Exception e) {
               // Log.d("constraint","error"+e);
               Toast.makeText(UserRegistration.this, "Invalid Adhaar Number", Toast.LENGTH_SHORT).show();
               return;
           }


           //Already Registered
        Cursor cAlreadyVote=db.rawQuery("SELECT * FROM voterDetails WHERE adhaarNo ="+valueLongAdhaar+" " ,null);
        if(cAlreadyVote.moveToNext())
        {
            // Toast.makeText(UserLoginPage.this,"Adhaar number"+userLoginAdhaarNumber +"password"+userLoginPassword,Toast.LENGTH_SHORT).show();
            Toast.makeText(UserRegistration.this,"Already Registered",Toast.LENGTH_SHORT).show();
            return;
        }


           //Name handler
        if(valueName.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty Name",Toast.LENGTH_SHORT).show();
            return;
        }


        //if DOB empty fills
        if(valueDob.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty DOB",Toast.LENGTH_SHORT).show();
            return;
        }

        //DOB Constraint Handler
        db.execSQL("drop table if exists dobCheck");
        db.execSQL("CREATE TABLE IF NOT EXISTS dobCheck( dob DATE NOT NULL CHECK(dob <'2006/12/32'))");
        try
        {
            db.execSQL("INSERT INTO dobCheck(dob) VALUES('" + valueDob + "')");
           // Toast.makeText(UserRegistration.this,"inserted",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(UserRegistration.this,"Below Age 18",Toast.LENGTH_SHORT).show();
            return;
        }

        //gender handler
        if(valueGender.equals("Select"))
        {
            Toast.makeText(UserRegistration.this,"Select Gender",Toast.LENGTH_SHORT).show();
            return;
        }

        //State handler
        if(valueState.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty State",Toast.LENGTH_SHORT).show();
            return;
        }

        //City handler
        if(valueCity.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty City",Toast.LENGTH_SHORT).show();
            return;
        }

       //if pin code is Empty
        if(valuePincode.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty Pincode",Toast.LENGTH_SHORT).show();
            return;
        }

           //Pin code Constraint Handler
        db.execSQL("drop table if exists pincodeCheck");
        db.execSQL("CREATE TABLE IF NOT EXISTS pincodeCheck( pincode TEXT NOT NULL CHECK(pincode LIKE '______'))");
        try
        {
            db.execSQL("INSERT INTO pincodeCheck(pincode) VALUES('" + valuePincode + "')");
          //  Toast.makeText(UserRegistration.this,"inserted",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(UserRegistration.this,"Invalid Pincode",Toast.LENGTH_SHORT).show();
            return;
        }

        //if mobile is Empty
        if(valueMobile.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty Mobile",Toast.LENGTH_SHORT).show();
            return;
        }

          //Mobile Constraints Handler
        db.execSQL("drop table if exists mobileCheck");
        db.execSQL("CREATE TABLE IF NOT EXISTS mobileCheck(mobile TEXT NOT NULL CHECK(mobile LIKE '______%' AND mobile LIKE '9%' OR mobile LIKE '8%' OR mobile LIKE '7%' OR mobile LIKE '6%'))");
        try
        {
            db.execSQL("INSERT INTO mobileCheck(mobile) VALUES('" + valueMobile + "')");
        //    Toast.makeText(UserRegistration.this,"inserted",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(UserRegistration.this,"Invalid Mobile Number",Toast.LENGTH_SHORT).show();
            return;
        }

        //if password is Empty
        if(valuePassword.isEmpty())
        {
            Toast.makeText(UserRegistration.this,"Empty Password",Toast.LENGTH_SHORT).show();
            return;
        }

        //Password Constraints Handler
        db.execSQL("drop table if exists passwordCheck");
        db.execSQL("CREATE TABLE IF NOT EXISTS passwordCheck( password TEXT NOT NULL CHECK(password LIKE '______%'))");
        try
        {
            db.execSQL("INSERT INTO passwordCheck(password) VALUES('" + valuePassword + "')");
         //   Toast.makeText(UserRegistration.this,"inserted",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(UserRegistration.this,"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
        }

    }

    //onClick sign in link
    public void userSignIn(View view)
    {
        Intent i =new Intent(UserRegistration.this,UserLoginPage.class);
        startActivity(i);
        finish();
    }


    @Override
    public void onBackPressed() {
        Intent i =new Intent(UserRegistration.this,UserLoginPage.class);
        startActivity(i);
        finish();
    }


}//end of activity