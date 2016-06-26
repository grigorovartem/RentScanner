package Main;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.Map;

public class MapDB {
    private Map<String, Offer> dbMap;
    private DB db;

    private MapDB() throws IOException {
        db = DBMaker.newFileDB(new File("offer_db")).closeOnJvmShutdown().make();
        dbMap = db.getTreeMap("offer");
    }

    public Map<String, Offer> getDbMap() {
        return dbMap;
    }

    private static class LazyHolder {
        private static MapDB INSTANCE = null;

        static {
            try {
                INSTANCE = new MapDB();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static MapDB getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Offer put(String key, Offer value) {
        Offer result = dbMap.put(key, value);
        db.commit();
        return result;
    }

    public Offer get(String key) {
        return dbMap.get(key);
    }
}
