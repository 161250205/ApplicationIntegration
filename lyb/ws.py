from spyne import Application, rpc, ServiceBase
from spyne import Integer, Unicode, Array, ComplexModel, Iterable, String
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from wsgiref.simple_server import make_server
import xml.dom.minidom
import pymysql

# !/usr/bin/python3
import pymysql
class QunarService(ServiceBase):
    @rpc(Unicode, Integer, _returns=Iterable(Unicode))
    def getTicketsData(self, name, times):
        db = pymysql.connect("localhost", "root", "123456", "qunar")
        cursor = db.cursor()
        cursor.execute("SELECT * from ticket")
        data = cursor.fetchall()
        db.close()
        # ↑取回数据


        # ↓创建xml数据
        doc = xml.dom.minidom.Document()
        root = doc.createElement('infoList')
        root.setAttribute('xmlns', 'http://jw.nju.edu.cn/schema/info')
        root.setAttribute('xmlns:xsi', 'http://www.w3.org/2001/XMLSchema-instance')
        root.setAttribute('company', '去哪儿')
        root.setAttribute('xsi:schemaLocation',
                          'http://jw.nju.edu.cn/schema/info https://raw.githubusercontent.com/161250205/ApplicationIntegration/master/xsd/xsd.xsd')
        doc.appendChild(root)

        for oneTicket in data:
            tpNode = doc.createElement('info')

            nodeCompany = doc.createElement('company')
            nodeCompany.appendChild(doc.createTextNode(str(oneTicket[3])))

            nodeFlightNumber = doc.createElement("flightNumber")
            nodeFlightNumber.appendChild(doc.createTextNode(str(oneTicket[0])))

            nodedepartureTime = doc.createElement("departureTime")
            nodedepartureTime.appendChild(doc.createTextNode(str(oneTicket[2])))

            nodedepartureAirport = doc.createElement("departureAirport")
            nodedepartureAirport.appendChild(doc.createTextNode(str(oneTicket[1])))

            nodearrivalTime = doc.createElement("arrivalTime")
            nodearrivalTime.appendChild(doc.createTextNode(str(oneTicket[5])))

            nodearrivalAirport = doc.createElement("arrivalAirport")
            nodearrivalAirport.appendChild(doc.createTextNode(str(oneTicket[4])))

            nodeprice = doc.createElement("price")
            nodeprice.appendChild(doc.createTextNode(str(oneTicket[6])))

            tpNode.appendChild(nodeCompany)
            tpNode.appendChild(nodeFlightNumber)
            tpNode.appendChild(nodedepartureTime)
            tpNode.appendChild(nodedepartureAirport)
            tpNode.appendChild(nodearrivalTime)
            tpNode.appendChild(nodearrivalAirport)
            tpNode.appendChild(nodeprice)

            root.appendChild(tpNode)
        print(root.toxml(encoding="utf-8"))

        yield str(root.toxml(encoding="utf-8"))




application = Application([QunarService],
                          'spyne.examples.hello',
                          in_protocol=Soap11(validator='lxml'),
                          out_protocol=Soap11())
wsgi_application = WsgiApplication(application)

if __name__ == '__main__':
    import logging

    host = '127.0.0.1'
    port = 8000

    logging.info("listening to http://127.0.0.1:8000")
    logging.info("wsdl is at: http://localhost:8000/?wsdl")

    server = make_server(host, port, wsgi_application)
    server.serve_forever()