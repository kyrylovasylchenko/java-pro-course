package homeworks.VKS_05;

import java.util.Objects;

public class FileData {
    private String path;
    private String name;
    private byte size;


    public FileData(String path, String name, byte size) {
        this.path = path;
        this.name = name;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return name;
    }

    public void setFileName(String fileName) {
        this.name = fileName;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "path='" + path + '\'' +
                ", fileName='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
