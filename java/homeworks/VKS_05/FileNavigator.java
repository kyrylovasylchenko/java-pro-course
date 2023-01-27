package homeworks.VKS_05;


import java.util.*;


public class FileNavigator {
    private HashMap<String, Set<FileData>> container = new HashMap<>();

    public void add(FileData file, String path){
        if(!file.getPath().equals(path)){
            System.out.println("The path you provided and the file path are different");
        }else if(container.containsKey(path)){
            container.get(path).add(file);
        }else {
            container.put(path, new HashSet<>(){{add(file);}});
        }
    }

    public Set<FileData> find(String path){
        if(!container.containsKey(path)){
            System.out.println("There is no such path");
            return new HashSet<>();
        }
        return container.get(path);
    }

    public List<FileData> filterBySize(byte size){
        List<FileData> filteredArray = new ArrayList<>();
        for (Set<FileData> value : container.values()) {
            for (FileData fileData : value) {
                if(fileData.getSize() < size){
                    filteredArray.add(fileData);
                }
            }
        }
        return filteredArray;
    }

    public void remove(String path){
        container.remove(path);
    }

    public List<FileData> sortBySize(){

        List<FileData> sortedArray = new ArrayList<>();
        for(Set<FileData> value : container.values()){
            sortedArray.addAll(value);
        }
        sortedArray.sort(Comparator.comparingInt(FileData::getSize));
        return sortedArray;
    }

}
