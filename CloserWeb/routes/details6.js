var express = require('express');
var router = express.Router();
var mysql = require('mysql');
//----------------
// 引用db.js
//----------------
var pool = require('./lib/db.js');
//----------------------
// 引用外掛
//----------------------
var moment = require('moment');


/* GET home page. */

router.get('/', function(req, res, next) {


    var writingsID=req.param('writingsID');
	
    pool.query('select * from writings where writingsID = 6', [writingsID], function(err, results) {
        if (err)throw err;

        if(results.length==0){
            res.render('dataNotFound', {});
        }else{
            res.render('details6',  {data:results, moment:moment});  
        }  
    }); 
});

module.exports = router;