const soap = require('soap');
const fs = require('fs');
const http = require('http');
const db = require('../db/db');

const test = {};
test.wsdl = fs.readFileSync('xiecheng.wsdl', 'utf8');
test.server = null;
test.service = {
    XiechengImplService: {
        Xiecheng: {
            getXiechengData: function (args, cb, soapHeader) {
                db.getData(function (err, result) {
                    return cb(result);
                });
            }
        }
    }
};
test.server = http.createServer(function (request, response) {
    response.end('404: Not Found: ' + request.url);
});
test.server.listen(8090, null, null, function () {
    test.soapServer = soap.listen(test.server, '/xiecheng', test.service, test.wsdl);
    test.baseUrl = 'http://' + test.server.address().address + ":" + test.server.address().port;
    if (test.server.address().address === '0.0.0.0' || test.server.address().address === '::') {
        test.baseUrl = 'http://127.0.0.1:' + test.server.address().port;
    }
});

console.log('ws建立完成');