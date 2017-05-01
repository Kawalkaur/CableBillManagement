package kawal.com.cbm;

import java.io.Serializable;

/**
 * Created by kawaldeep on 4/8/2017.
 */

public class FileBean implements Serializable{

    int cusImage;
    String cusName;
    String cusMobile;
    String cusEmail;
    String Gender;
    String cusCity;

    String cusAddress;

    public FileBean() {
    }

    public FileBean(int cusImage, String cusName, String cusMobile, String cusEmail, String gender, String cusCity, String cusAddress) {
        this.cusImage = cusImage;
        this.cusName = cusName;
        this.cusMobile = cusMobile;
        this.cusEmail = cusEmail;
        Gender = gender;
        this.cusCity = cusCity;
        this.cusAddress = cusAddress;
    }

    public int getCusImage() {
        return cusImage;
    }

    public void setCusImage(int cusImage) {
        this.cusImage = cusImage;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusMobile() {
        return cusMobile;
    }

    public void setCusMobile(String cusMobile) {
        this.cusMobile = cusMobile;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public String getGender() { return Gender; }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCusCity() { return cusCity; }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "cusImage=" + cusImage +
                ", cusName='" + cusName + '\'' +
                ", cusMobile='" + cusMobile + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", Gender='" + Gender + '\'' +
                ", cusCity='" + cusCity + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                '}';
    }
}
