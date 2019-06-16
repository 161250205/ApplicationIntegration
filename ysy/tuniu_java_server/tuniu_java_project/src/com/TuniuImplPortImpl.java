package com;

import com.other.a.XiechengImpl_XiechengImplPort_Server;
import dao.TuniuDataJdbc;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService
public class TuniuImplPortImpl implements Tuniu {

    private TuniuDataJdbc tuniuDataJdbc = new TuniuDataJdbc();

    public TuniuImplPortImpl() {
        try {
            new XiechengImpl_XiechengImplPort_Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WebMethod
    @Override
    public InfoListType getTuniuData() {
        try {
            return tuniuDataJdbc.getTuniuData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
