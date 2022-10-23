package liga.medical.medicalmonitoring.core.solid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AntiS {

    ObjectMapper objectMapper;

    private long id;
    private String fname;
    private String lname;

    public AntiS(long id, String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public AntiS() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public void savemodelAntiStodatabase(){
        //метод сохранения в бд
    }
    public void createuniqueid(){
        this.id+=this.fname.length()+this.lname.length();
    }
    public String converttojson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }
}
