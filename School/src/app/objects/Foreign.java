package app.objects;

/**
 * Foreing
 */
public class Foreign extends Student{

    private String country;
    private String program;

    public Foreign(String name, String country, String program){
       
        super(name);

        this.country = country;
        this.program = program;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public void setCareer(String career) {
        super.setCareer("F_"+ career);
    }
    
}