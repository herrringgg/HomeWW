package Homeworks.homework03;

public class TV {
    private String companyFirm;
    private double diagonal;
    private double refreshRate;
    private String screenTechnology;
    private String ledBacklight;

    public TV(String companyFirm, double diagonal, double refreshRate, String screenTechnology, String ledBacklight) {
        this.companyFirm = companyFirm;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
        this.screenTechnology = screenTechnology;
        this.ledBacklight = ledBacklight;
    }

    public TV(String companyFirm, double diagonal, double refreshRate) {
        this.companyFirm = companyFirm;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
    }

    public TV() {
        this.companyFirm = "Hisense 755E7NQ";
        this.diagonal = 55;
        this.refreshRate = 60;
        this.screenTechnology = "QLED";
        this.ledBacklight = "Direct LED";
    }

    @Override
    public String toString() {
        return "TV{" +
                "companyFirm = '" + companyFirm + '\'' +
                ", diagonal = " + diagonal +
                ", refreshRate = " + refreshRate +
                ", screenTechnology = '" + screenTechnology + '\'' +
                ", ledBacklight = '" + ledBacklight + '\'' +
                '}';
    }

    public String getCompanyFirm() {
        return companyFirm;
    }

    public void setCompanyFirm(String companyFirm) {
        this.companyFirm = companyFirm;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public String getLedBacklight() {
        return ledBacklight;
    }

    public void setLedBacklight(String ledBacklight) {
        this.ledBacklight = ledBacklight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }
}

