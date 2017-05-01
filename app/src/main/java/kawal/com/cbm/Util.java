package kawal.com.cbm;

import android.net.Uri;

/**
 * Created by kawaldeep on 5/1/2017.
 */

public class Util {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Customers.db";

    public static final String TAB_NAME = "Customer";
    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_Phone = "PHONE";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_GENDER = "GENDER";
    public static final String COL_CITY = "CITY";
    public static final String COL_Address = "ADDRESS";

    public static final String CREATE_TAB_QUERY = "create table Customer(" +
            "_ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "PHONE varchar(20),"+
            "EMAIL varchar(256)," +
            "GENDER varchar(20)," +
            "CITY varchar(256) ," +
            "ADDRESS varchar(200) " +
            ")";

    public static final Uri STUDENT_URI = Uri.parse("content://kawal.com.cbm.mycontentprovider/"+TAB_NAME);
    public static final String INSERT_STUDENT_PHP = "http://www.cablebill.esy.es/insert1.php";
    public static final String LOGIN_STUDENT_PHP = "http://www.cablebill.esy.es/login1.php";
    public static final String KEY_NAME = "keyName";
    public static final String KEY_PHONE = "keyPhone";
    public static final String KEY_EMAIL = "keyEmail";
    public static final String PREFS_NAME = "abc";



}
