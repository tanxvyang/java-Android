package OS_Test.model;

import java.util.HashMap;
import java.util.Map;

public class FileModel {
    public Map<String , FileModel> subMap = new HashMap<String, FileModel>();
    private String name;    //文件名或目录
    private String type;    //文件类型
    private int attr;       //用来识别是文件还是目录
    private int startNum;    //在FAT表中的起始位置
    private int size;       //文件大小
    private FileModel father = null;//该文件或目录的上级目录

    public FileModel(String name, String type, int attr, int startNum, int size) {
        this.name = name;
        this.type = type;
        this.attr = attr;
        this.startNum = startNum;
        this.size = size;
    }

    public FileModel(String name, int startNum) {  //目录
        this.name = name;
        this.attr = 3;
        this.startNum = startNum;
        this.type = " ";
        this.size = 1;
    }

    public FileModel(String name, String type, int startNum, int size) {   //文件
        this.name = name;
        this.attr = 2;
        this.startNum = startNum;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FileModel getFather() {
        return father;
    }

    public void setFather(FileModel father) {
        this.father = father;
    }
}
