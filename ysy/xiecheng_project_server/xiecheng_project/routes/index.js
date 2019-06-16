const express = require('express');
const router = express.Router();
const db = require('../db/db');
const soap = require('soap');

/* GET home page. */
router.get('/', function (req, res, next) {
    let data = {title: 'Express'};

    db.getData(function (err, result) {
        if (err) {
            data.result = JSON.stringify(err);
        } else {
            data.result = JSON.stringify(result);
        }

        res.render('index', data);
    });
});

router.get('/d', function (req, res, next) {
    db.getData(function (err, result) {
        if (err) {
            res.send({error: 1});
        } else {
            res.send(JSON.stringify(result));
        }
    });
});

module.exports = router;
