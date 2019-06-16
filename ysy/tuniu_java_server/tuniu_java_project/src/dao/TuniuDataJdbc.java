package dao;


import com.InfoListType;
import com.InfoType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuniuDataJdbc {

    public InfoListType getTuniuData() throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionTuniuJdbc.getConn()) {
            String sql = "SELECT * FROM ticket";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet set = pstmt.executeQuery();
                InfoListType infoListType = new InfoListType();
                infoListType.setCompany("途牛");
                List<InfoType> list = new ArrayList<>();
                while (set.next()) {
                    InfoType xml = new InfoType();
                    xml.setCompany(set.getString("company"));
                    xml.setArrivalAirport(set.getString("arrival_airport"));
                    xml.setArrivalTime(set.getString("arrival_time"));
                    xml.setDepartureAirport(set.getString("departure_airport"));
                    xml.setDepartureTime(set.getString("departure_time"));
                    xml.setFlightNumber(set.getString("flight_number"));
                    xml.setPrice(set.getInt("price"));
                    list.add(xml);
                }
                infoListType.setInfo(list);
                return infoListType;
            }
        }
    }
}
