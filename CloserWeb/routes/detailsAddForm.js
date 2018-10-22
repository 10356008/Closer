var express = require('express');
var router = express.Router();
var mysql = require('mysql');

//----------------------
// 引用db.js
//----------------------
var pool = require('./lib/db.js');
var moment = require('moment');
var authorize = require('./lib/authorize.js');

/* GET home page. */
router.get('/', function(req, res, next) {

    if(!authorize.isPass(req)){
        res.render(authorize.illegalURL, {});
        return;
    }

    var supplierData;
    //------------------	
	// 先取出供應商資料
	//------------------
    pool.query('select * from writings', function(err, results) {       
        if (err) {
            supplierData=[];
        }else{
            supplierData=results;
        }
    
            //------------------------------------------   
            // 將供應商及產品型態資料一起送給輸入表單
            //------------------------------------------
            res.render('detailsAddForm', {userNo:req.session.userNo, moment:moment, supplierData:supplierData});
    }); 
});

module.exports = router;