package homeworks.VKS_04.phonebook;

import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private List<Record> values;

    public void add(Record record){
        if(record != null) {
            values.add(record);
        }
    }

    public Record find(String name){
        Record record = null;
        for (Record value : values) {
           record = name.contains(value.getName()) ? value : null;
        }
        return record;
    }

    public List<Record> findAll(String name){
        List<Record> recordArray = new ArrayList<>();
        for (Record value : values) {
            if(value.getName().contains(name)){
                recordArray.add(value);
            }
        }
        return recordArray.size() > 0 ? recordArray : null;
    }
}
