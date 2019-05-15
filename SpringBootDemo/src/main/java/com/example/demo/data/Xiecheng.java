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
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-13 21:07
 */
@Service
public class Xiecheng implements ApplicationRunner {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("开始处理携程数据");
        System.out.println("---------------");

        processData();

        System.out.println("---------------");
        System.out.println("携程数据处理结束");
    }

    public void processData() {
        try {
            String outDir = "classpath:/static";
            String in = "classpath:/static/xiecheng/a.html";

            Resource inResource = resourceLoader.getResource(in);
            File inFile = inResource.getFile();
            Resource outDirResource = resourceLoader.getResource(outDir);
            File outDirFile = outDirResource.getFile();
            File outFile = new File(outDirFile.getAbsolutePath() + "/xiecheng.xml");
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
            System.out.println("携程处理失败");
            e.printStackTrace();
        }
    }

    private void dealWithXiechengDocument(Document from, org.w3c.dom.Document to) {
        Elements elements = from.getElementsByClass("Label_Flight");

        org.w3c.dom.Element infoList = to.createElement("infoList");
        to.appendChild(infoList);
        //这几行照抄就完事了
        infoList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema/info");
        infoList.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        infoList.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema/info https://raw.githubusercontent.com/161250205/ApplicationIntegration/master/xsd/xsd.xsd");


        infoList.setAttribute("company", "携程");

        for (Element element : elements) {
            org.w3c.dom.Element info = to.createElement("info");

            //航空公司
            Element companyNameElementInHtml = element.getElementsByClass("flight_logo").first().getElementsByTag("strong").first();
            String companyName = companyNameElementInHtml.text();
            org.w3c.dom.Element companyElement = to.createElement("company");
            companyElement.setTextContent(companyName);
            info.appendChild(companyElement);

            //航班号
            String flightNumber = companyNameElementInHtml.nextElementSibling().text();
            org.w3c.dom.Element flightNumberElement = to.createElement("flightNumber");
            flightNumberElement.setTextContent(flightNumber);
            info.appendChild(flightNumberElement);

            //起飞时间, 起飞机场
            Element rightElementInHtml = element.getElementsByClass("inb right").first();
            String departureTime = rightElementInHtml.getElementsByClass("time").first().text();
            String departureAirport = rightElementInHtml.getElementsByClass("airport").first().text();
            org.w3c.dom.Element departureTimeElement = to.createElement("departureTime");
            departureTimeElement.setTextContent(departureTime);
            info.appendChild(departureTimeElement);
            org.w3c.dom.Element departureAirportElement = to.createElement("departureAirport");
            departureAirportElement.setTextContent(departureAirport);
            info.appendChild(departureAirportElement);

            //降落时间, 降落机场
            Element leftElementInHtml = element.getElementsByClass("inb left").first();
            String arrivalTime = leftElementInHtml.getElementsByClass("time").first().text();
            String arrivalAirport = leftElementInHtml.getElementsByClass("airport").first().text();
            org.w3c.dom.Element arrivalTimeElement = to.createElement("arrivalTime");
            arrivalTimeElement.setTextContent(arrivalTime);
            info.appendChild(arrivalTimeElement);
            org.w3c.dom.Element arrivalAirportElement = to.createElement("arrivalAirport");
            arrivalAirportElement.setTextContent(arrivalAirport);
            info.appendChild(arrivalAirportElement);

            //价格
            Element priceElementInHtml = element.getElementsByClass("base_price02").first();
            String price = priceElementInHtml.ownText();
            org.w3c.dom.Element priceElement = to.createElement("price");
            priceElement.setTextContent(price);
            info.appendChild(priceElement);

            //加入到infoList
            infoList.appendChild(info);
        }

    }
}
