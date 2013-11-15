package c6231.Server;

import java.util.HashMap;

import c6231.Log;

/**
 *
 * @author chanman
 */
public class RecordContainer {

    static RecordContainer getRecordContainer(String stationName) {
        RecordContainer container = new RecordContainer();
        container.createRecordContainer();
        return container;
    }
    /**
     *
     */
    protected long nextId = 10000;
    /**
     *
     */
    protected final Object idlock = new Object();
    @SuppressWarnings("unchecked")
	final HashMap<String, Record>[] records = new HashMap[26];

    final Object recordsLock = new Object();

    /**
     *
     * @param record
     */
    public void addRecord(Record record) {
        String lastName = record.getLastName();

        // get the lower five bits representing which letter we are after
        // minus one since letters start at 1

        //int entry = (Character.getNumericValue(lastName.charAt(0)) & 0x1f) - 1;

        int entry = lastName.toLowerCase().codePointAt(0) - "a".codePointAt(0);

        if (entry < 0 || entry >= 26) {
            throw new RuntimeException(lastName + " is a bad last name");
        }

        HashMap<String, Record> entries = records[entry];

        synchronized (entries) {
            entries.put(record.getId(), record);
        }
    }

    /**
     *
     */
    protected void createRecordContainer() {
        for (int i = 0; i < 26; i++) {
            records[i] = new HashMap<String, Record>();
        }
    }

    void dump(Log log) {
        synchronized (records) {
            for (HashMap<String, Record> map : records) {
                for (String id : map.keySet()) {
                    log.log(map.get(id).toString());
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public long getNextFreeId() {
        synchronized (idlock) {
            return nextId++;
        }
    }

    Record getRecord(String recordID) {
        for (HashMap<String, Record> entries : records) {
            synchronized (entries) {
                if (entries.containsKey(recordID)) {
                    return entries.get(recordID);
                }
            }
        }
        return null;
    }

    Record getRecord(String recordID, String lastName) {
        int entry = lastName.toLowerCase().codePointAt(0) - "a".codePointAt(0);

        if (entry < 0 || entry >= 26) {
            throw new RuntimeException(lastName + " is a bad last name");
        }

        HashMap<String, Record> entries = records[entry];
        synchronized (entries) {
            if (entries.containsKey(recordID)) {
                return entries.get(recordID);
            }
        }

        return null;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public int getRecordCount() {
        int count = 0;
        synchronized (records) {
            for (HashMap map : records) {
                count += map.size();
            }
        }
        return count;
    }

    void removeRecord(String recordID, String lastName) {
        // get the lower five bits representing which letter we are after
        // minus one since letters start at 1

        //int entry = (Character.getNumericValue(lastName.charAt(0)) & 0x1f) - 1;

        int entry = lastName.toLowerCase().codePointAt(0) - "a".codePointAt(0);

        if (entry < 0 || entry >= 26) {
            throw new RuntimeException(lastName + " is a bad last name");
        }

        HashMap<String, Record> entries = records[entry];

        synchronized (entries) {
            entries.remove(recordID);
        }
    }
}
