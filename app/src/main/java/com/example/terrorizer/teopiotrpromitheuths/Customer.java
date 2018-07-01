package com.example.terrorizer.teopiotrpromitheuths;

public class Customer {
    // fields
    private int pelatisID;
    private String pelatisName;
    private String pelatisAddress;
    private String pelatisPhone;
    private String pelatisAFM;
    private String pelatisJob;
    private String pelatisDOI;
    private String pelatisTK;
    // constructors
    public Customer() {}
    public Customer(String name, String address, String phone, String afm, String job, String doi, String tk) {
        super();
        this.pelatisName = name;
        this.pelatisAddress = address;
        this.pelatisPhone = phone;
        this.pelatisAFM = afm;
        this.pelatisJob = job;
        this.pelatisDOI = doi;
        this.pelatisTK = tk;
    }

    public int getPelatisID() {
        return pelatisID;
    }

    public void setPelatisID(int pelatisID) {
        this.pelatisID = pelatisID;
    }

    public String getPelatisName() {
        return pelatisName;
    }

    public void setPelatisName(String pelatisName) {
        this.pelatisName = pelatisName;
    }

    public String getPelatisAddress() {
        return pelatisAddress;
    }

    public void setPelatisAddress(String pelatisAddress) {
        this.pelatisAddress = pelatisAddress;
    }

    public String getPelatisPhone() {
        return pelatisPhone;
    }

    public void setPelatisPhone(String pelatisPhone) {
        this.pelatisPhone = pelatisPhone;
    }

    public String getPelatisAFM() {
        return pelatisAFM;
    }

    public void setPelatisAFM(String pelatisAFM) {
        this.pelatisAFM = pelatisAFM;
    }

    public String getPelatisJob() {
        return pelatisJob;
    }

    public void setPelatisJob(String pelatisJob) {
        this.pelatisJob = pelatisJob;
    }

    public String getPelatisDOI() {
        return pelatisDOI;
    }

    public void setPelatisDOI(String pelatisDOI) {
        this.pelatisDOI = pelatisDOI;
    }

    public String getPelatisTK() {
        return pelatisTK;
    }

    public void setPelatisTK(String pelatisTK) {
        this.pelatisTK = pelatisTK;
    }
}
