public class HousePost {
    String address;
    Profile host;
    String description;

    public HousePost(String addr, Profile host, String desc) {
        this.address = addr;
        this.host = host;
        this.description = desc;

    }

    public void display() {
        System.out.println("House post for: " + this.address);
    }

    //getters

    public String getAddress() {
        return this.address;
    }

    public Profile getHost() {
        return this.host;
    }

    public String getDescription() {
        return this.description;
    }

    //setters

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHost(Profile host) {
        this.host = host;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
