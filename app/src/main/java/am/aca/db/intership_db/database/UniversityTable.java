package am.aca.db.intership_db.database;

public class UniversityTable {
    public static final String TABLE_NAME = "university";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_IS_NATIONAL = "is_national";

    public static final String CREATE_SCRIPT = "CREATE TABLE " + TABLE_NAME +
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_NAME + " TEXT NOT NULL," +
            COLUMN_ADDRESS + " TEXT," +
            COLUMN_IS_NATIONAL + " BOOLEAN" +
            ")";
}
