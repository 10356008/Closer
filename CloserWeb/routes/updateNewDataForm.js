var express = require('express');
var router = express.Router();
var mysql = require('mysql');

//----------------------
// 引用db.js
//----------------------
var pool = require('./lib/db.js');
var authorize = require('./lib/authorize.js');
var moment = require('moment');


/* GET home page. */
router.get('/', function(req, res, next) {
	var productData;

	//------------------------------------------
    // 如尚未登入, 轉至未登入頁面
    //------------------------------------------
    if(!authorize.isPass(req)){
        res.render(authorize.illegalURL, {});
        return;
    }

	//取得使用者輸入的產品編號
	var writingsID=req.query.writingsID.trim();
	

    //------------------	
	// 取出產品資料
	//------------------
    pool.query('SELECT * FROM writings WHERE writingsID=?', [writingsID], function(err, results) {       
        if (results.length==0) {
            res.render('dataNotFound', {});
			return;
        }else{
            productData=results;
		}
			res.render('updateNewDataForm', {userNo:req.session.userNo, moment:moment, productData:productData});
    	}); 
	}); 

module.exports = router;