public class AutoInsurance extends Insurance{
    private String vin;
    private String make;
    private String model;

    //Constructor for AutoInsurance class
    public AutoInsurance(){
        super();
    }

    public AutoInsurance(String policyNumber, String policyOwner, double yearlyPremium, String vin, String make, String model){
        super(policyNumber, policyOwner, yearlyPremium);
        setVin(vin);
        setMake(make);
        setModel(model);
    }

    //Get methods
    public String getVin(){
        return this.vin;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    //Set methods
    public void setVin(String vin){
        this.vin = vin;
    }

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    //Special purpose methods
    public String toString(){
        return super.toString() +
        "The vin is: " + this.getVin() + "\n" +
        "The make is: " + this.getMake() + "\n" +
        "The model is: " + this.getModel() + "\n";
    }

}