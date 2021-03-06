package c6231.Server;

import java.util.Date;

/**
 *
 * @author chanman
 */
public class MissingRecord extends Record {

    /**
     *
     */
    protected String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }
    /**
     *
     */
    protected Date lastDate;
    /**
     *
     */
    protected String lastLocation;

    MissingRecord(long recordId, String firstName, String lastName, String address, Date lastDate, String lastLocation, String status) {
        super(recordId, firstName, lastName);
        this.address = address;
        this.lastDate = lastDate;
        this.lastLocation = lastLocation;
        this.status = status;
    }

    /**
     *
     * @return
     */
    @Override
    public String getRecordType() {
        return "MR";
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "[" + getId() + "] " + firstName + " " + lastName + " " + address + " " + lastDate + " @" + lastLocation + " [" + status + "]";
    }
}
