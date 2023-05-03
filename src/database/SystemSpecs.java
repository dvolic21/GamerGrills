package database;

public class SystemSpecs {
    private int specs_id;
    private String OS;
    private String processor;
    private String memory;
    private String storage;
    private String graphics;
    private String directX;

    public SystemSpecs(int specs_id, String oS, String processor, String memory, String storage, String graphics,
            String directX) {
        this.specs_id = specs_id;
        this.OS = oS;
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.graphics = graphics;
        this.directX = directX;
    }

    public int getSpecs_id() {
        return specs_id;
    }

    public void setSystem_key(int specs_id) {
        this.specs_id = specs_id;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String oS) {
        OS = oS;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getDirectX() {
        return directX;
    }

    public void setDirectX(String directX) {
        this.directX = directX;
    }
}
