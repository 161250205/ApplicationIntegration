package com.other.a;

import com.InfoListType;
import com.InfoType;
import com.alibaba.fastjson.JSON;
import config.Config;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class XiechengImplPortImpl implements XiechengImpl {

    @WebMethod
    @Override
    public InfoListType getXiechengData() {

        InfoListType infoListType = new InfoListType();
        infoListType.setCompany("携程");
        infoListType.setInfo(getDataFromServer());

        return infoListType;
    }

    private List<InfoType> getDataFromServer() {
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                HttpGet httpGet = new HttpGet("http://" + Config.xServiceIp + "/d");

                client = HttpClients.createDefault();
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);

                return JSON.parseArray(result, InfoType.class);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
