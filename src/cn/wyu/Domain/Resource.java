package cn.wyu.Domain;

//资源信息表
public class Resource {
    private int resourceId;
    private String uploaderName;
    private String name;
    private String descn;
    private String type;
    private String fileName;
    private String saveFileName;


    public Resource(int resourceId, String uploaderName, String name, String descn, String type, String fileName, String saveFileName) {
        this.resourceId = resourceId;
        this.uploaderName = uploaderName;
        this.name = name;
        this.descn = descn;
        this.type = type;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
    }

    public Resource(String uploaderName, String name, String descn, String type, String fileName, String saveFileName) {
        this.uploaderName = uploaderName;
        this.name = name;
        this.descn = descn;
        this.type = type;
        this.fileName = fileName;
        this.saveFileName = saveFileName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public Resource() {
    }
}
