var express = require('express');
var router = express.Router();
var mysql = require('mysql');

//------------------
// 載入資料庫連結
//------------------
var pool = require('./lib/db.js');

//----------------------------------------------
// 載入使用權檢查
//----------------------------------------------
var authorize = require('./lib/authorize.js');
//----------------------------------------------



/* GET home page. */
router.get('/', function(req, res, next) {
	
	//------------------------------------------
    // 如尚未登入, 轉至未登入頁面
    //------------------------------------------
    if(!authorize.isPass(req)){
        res.render(authorize.illegalURL, {});
        return;
    }
    //------------------------------------------
	
	
    //取得使用者傳來的參數
    var writingsName=req.param("writingsName");
    var writingsContent=req.param("writingsContent");
    var notes=req.param("notes");
    var editDate=req.param("editDate");
	
    //建立一個新資料物件
    var newData={
        writingsName:writingsName,
        writingsContent:writingsContent,
        notes:notes,
        editDate:editDate
    }	
	
    pool.query('INSERT INTO writings SET ?', newData, function(err, rows, fields) {
        if (err){
            res.render('writingsAddFail', {userNo:req.session.userNo});     //新增失敗
        }else{
            res.render('writingsAddSuccess', {userNo:req.session.userNo});  //新增成功
        }
    });
});

module.exports = router;