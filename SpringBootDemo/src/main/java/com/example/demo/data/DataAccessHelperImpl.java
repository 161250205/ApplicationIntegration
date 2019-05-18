package com.example.demo.data;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.jaxb.InfoListXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-16 17:00
 */
@Service
public class DataAccessHelperImpl implements DataAccessHelper {

    private final ResourceLoader resourceLoader;

    @Autowired
    public DataAccessHelperImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<InfoListXml> getAirLineData() {
        try {
            String outDir = "classpath:/static";
            Resource outDirResource = resourceLoader.getResource(outDir);
            File outDirFile = outDirResource.getFile();
            File xiechengFile = new File(outDirFile.getAbsolutePath() + "/xiecheng.xml");
            File qunarFile = new File(outDirFile.getAbsolutePath() + "/qunar.xml");
            File tuniuFile = new File(outDirFile.getAbsolutePath() + "/tuniu.xml");

            InfoListXml xxml = convertToJavaBean(InfoListXml.class, xiechengFile);
            InfoListXml qxml = convertToJavaBean(InfoListXml.class, qunarFile);
            InfoListXml txml = convertToJavaBean(InfoListXml.class, tuniuFile);

            return new ArrayList<InfoListXml>(Arrays.asList(xxml, qxml, txml));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<InfoListXml>();
        }
    }

    private static <T> T convertToJavaBean(Class<T> clz, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(file);
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
