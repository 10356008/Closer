var express = require('express');
var router = express.Router();
var mysql = require('mysql');
//----------------
// 引用db.js
//----------------
var pool = require('./lib/db.js');
var authorize = require('./lib/authorize.js');
//----------------------
// 引用外掛
//----------------------
var moment = require('moment');


/* GET home page. */

router.get('/', function(req, res, next) {

    var writingsID=req.param("writingsID");

    if(!authorize.isPass(req)){
        res.render(authorize.illegalURL, {});
        return;
    }
	
    pool.query('select * from writings where writingsID=?', [writingsID], function(err, results) {
        if (err)throw err;

        if(results.length==0){
            res.render('dataNotFound', {});
        }else{
            res.render('detailsOneItem', {userNo:req.session.userNo, data:results, moment:moment});  
        }  
    }); 
});

module.exports = router;