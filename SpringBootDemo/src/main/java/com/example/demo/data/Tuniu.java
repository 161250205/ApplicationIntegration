package com.example.demo.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-18 17:20
 */
@Service
public class Tuniu implements ApplicationRunner {

    private final ResourceLoader resourceLoader;

    @Autowired
    public Tuniu(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("开始处理途牛数据");
        System.out.println("---------------");

        processData();

        System.out.println("---------------");
        System.out.println("途牛数据处理结束");
    }

    private void processData() {
        try {
            String outDir = "classpath:/static";
            String in = "classpath:/static/tuniu/t.html";

            Resource inResource = resourceLoader.getResource(in);
            File inFile = inResource.getFile();
            Resource outDirResource = resourceLoader.getResource(outDir);
            File outDirFile = outDirResource.getFile();
            File outFile = new File(outDirFile.getAbsolutePath() + "/tuniu.xml");
            if (outFile.exists()) {
                outFile.delete();
            }

            Document document = Jsoup.parse(inFile, "UTF-8", "");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document to = builder.newDocument();

            dealWithXiechengDocument(document, to);

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.transform(new DOMSource(to), new StreamResult(outFile));
        } catch (Exception e) {
            System.out.println("途牛处理失败");
            e.printStackTrace();
        }
    }

    private static void dealWithXiechengDocument(Document from, org.w3c.dom.Document to) {
        Elements elements = from.getElementsByClass("J-flightlist");

        org.w3c.dom.Element infoList = to.createElement("infoList");
        to.appendChild(infoList);
        //这几行照抄就完事了
        infoList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema/info");
        infoList.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        infoList.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema/info https://raw.githubusercontent.com/161250205/ApplicationIntegration/master/xsd/xsd.xsd");


        infoList.setAttribute("company", "途牛");

        for (Element element : elements) {
            org.w3c.dom.Element info = to.createElement("info");

            //航空公司
            String companyName = element.getElementsByClass("aircom").first().text();
            org.w3c.dom.Element companyElement = to.createElement("company");
            companyElement.setTextContent(companyName);
            info.appendChild(companyElement);

            //航班号
            String flightNumber = element.getElementsByClass("flihtnumber left").first().text().split(" ")[0];
            org.w3c.dom.Element flightNumberElement = to.createElement("flightNumber");
            flightNumberElement.setTextContent(flightNumber);
            info.appendChild(flightNumberElement);

            //起飞时间, 起飞机场
            Element rightElementInHtml = element.getElementsByClass("fl-depart").first();
            String departureTime = rightElementInHtml.getElementsByClass("hours").first().text();
            String departureAirport = rightElementInHtml.getElementsByClass("airport").first().text();
            org.w3c.dom.Element departureTimeElement = to.createElement("departureTime");
            departureTimeElement.setTextContent(departureTime);
            info.appendChild(departureTimeElement);
            org.w3c.dom.Element departureAirportElement = to.createElement("departureAirport");
            departureAirportElement.setTextContent(departureAirport);
            info.appendChild(departureAirportElement);

            //降落时间, 降落机场
            Element leftElementInHtml = element.getElementsByClass("fl-arrive").first();
            String arrivalTime = leftElementInHtml.getElementsByClass("hours").first().text().substring(0, 5);
            String arrivalAirport = leftElementInHtml.getElementsByClass("airport").first().text();
            org.w3c.dom.Element arrivalTimeElement = to.createElement("arrivalTime");
            arrivalTimeElement.setTextContent(arrivalTime);
            info.appendChild(arrivalTimeElement);
            org.w3c.dom.Element arrivalAirportElement = to.createElement("arrivalAirport");
            arrivalAirportElement.setTextContent(arrivalAirport);
            info.appendChild(arrivalAirportElement);

            //价格
            String price = element.getElementsByClass("num").first().text();
            org.w3c.dom.Element priceElement = to.createElement("price");
            priceElement.setTextContent(price);
            info.appendChild(priceElement);

            //加入到infoList
            infoList.appendChild(info);
        }

    }
}
