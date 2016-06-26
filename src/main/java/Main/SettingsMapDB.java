package Main;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SettingsMapDB {
    private Map<String, RentProperties> dbMap;
    private DB db;

    private SettingsMapDB() throws IOException {
        db = DBMaker.newFileDB(new File("settings_db")).closeOnJvmShutdown().make();
        dbMap = db.getTreeMap("settings");
    }

    private static class LazyHolder {
        private static SettingsMapDB INSTANCE = null;

        static {
            try {
                INSTANCE = new SettingsMapDB();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SettingsMapDB getInstance() {
        return SettingsMapDB.LazyHolder.INSTANCE;
    }

    public RentProperties put(String key, RentProperties value) {
        RentProperties result = dbMap.put(key, value);
        db.commit();
        return result;
    }

    public RentProperties get(String key) {
        return dbMap.get(key);
    }
}
