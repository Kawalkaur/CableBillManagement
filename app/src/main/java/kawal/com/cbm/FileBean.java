package kawal.com.cbm;

/**
 * Created by kawaldeep on 4/8/2017.
 */

public class FileBean {

    int cusImage;
    String cusName;
    String cusMobile;
    String cusEmail;
    String cusAddress;

    public FileBean() {
    }

    public FileBean(int cusImage, String cusName, String cusMobile, String cusEmail, String cusAddress) {
        this.cusImage = cusImage;
        this.cusName = cusName;
        this.cusMobile = cusMobile;
        this.cusEmail = cusEmail;
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

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

}
