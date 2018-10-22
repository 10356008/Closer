var express = require('express');
var router = express.Router();
var mysql = require('mysql');

//------------------
// 載入資料庫連結
//------------------
var pool = require('./lib/db.js');
var authorize = require('./lib/authorize.js');
//----------------------
// 引用外掛
//----------------------
var moment = require('moment');


/* GET home page. */
router.get('/', function(req, res, next) {
    //取得使用者傳來的參數
    var writingsID=req.param("writingsID");

    if(!authorize.isPass(req)){
        res.render(authorize.illegalURL, {});
        return;
    }
	
	//刪除資料庫內容
    pool.query('DELETE FROM writings where writingsID=?', [writingsID], function(err, rows, fields) {
        if (err){
            res.render('deleteFail', {});     //刪除失敗
        }else{
            res.render('deleteSuccess', {userNo:req.session.userNo});  //刪除成功
        }
    });
});

module.exports = router;