const mysql = require('mysql');

const config = {
    host: 'localhost',
    user: 'root',
    password: '123456',
    port: '3306',
    database: 'xiecheng'
};

function getData(callback) {
    const connection = mysql.createConnection(config);
    connection.connect();

    const sql = "select * from ticket";
    connection.query(sql, function (err, result) {
        console.log('here');
        if (err) {
            callback(err, null);
            return;
        }

        callback(null, result);
        return result;
    });
}

exports.getData = getData;
