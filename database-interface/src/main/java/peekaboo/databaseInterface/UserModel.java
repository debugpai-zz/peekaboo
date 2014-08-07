package peekaboo.databaseInterface;

import java.math.BigDecimal;

/**
 * Created by deepak.pai on 08/08/14.
 */
public class UserModel {
    private final BigDecimal phno;
    ConnectMe connect = new ConnectMe();

    public UserModel(BigDecimal phno){
        this.phno = phno;
    }

    public void create(){
        String sql = "INSERT INTO Users VALUES " + phno;
        connect.executeQuery(sql);
    }

    public void updateLocation(Double latitude, Double longitude) {
        String sql = "INSERT INTO Locations VALUES " + phno + "," + latitude + "," + longitude;
        connect.executeQuery(sql);
    }

    public void providePermission(BigDecimal phno){
        String sql = "INSERT INTO Permissions VALUES " + this.phno + "," + phno;
        connect.executeQuery(sql);
    }
}
