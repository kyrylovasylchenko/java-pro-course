package homeworks.VKS_05;


import java.util.*;


public class FileNavigator {
    private HashMap<String, List<FileData>> container = new HashMap<>();

    public void add(FileData file, String path){
        if(!file.getPath().equals(path)){
            System.out.println("The path you provided and the file path are different");
        }else if(container.containsKey(path)) {
            for(FileData savedFile : container.get(path)){
                if(savedFile.getFileName().equals(file.getFileName())){
                    System.out.println("File with the same name already exists in this directory");
                    return;
                }
            }
            container.get(path).add(file);
        }else {
            container.put(path, new ArrayList<>(){{add(file);}});
        }
    }

    public List<FileData> find(String path){
        if(!container.containsKey(path)){
            System.out.println("There is no such path");
            return new ArrayList<>();
        }
        return container.get(path);
    }

    public List<FileData> filterBySize(byte size){
        List<FileData> filteredArray = new ArrayList<>();
        for (List<FileData> value : container.values()) {
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
        for(List<FileData> value : container.values()){
            sortedArray.addAll(value);
        }
       sortedArray.sort((firstFile, secondFile) -> {
           return Byte.compare(firstFile.getSize(), secondFile.getSize());
        });
        return sortedArray;
    }


}
