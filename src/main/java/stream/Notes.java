package stream;


public class Notes {

    private int id;
    private String name;
    private int label;

    public Notes(int id, String name, int label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
