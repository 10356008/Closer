var express = require('express');
var router = express.Router();
var mysql = require('mysql');

//----------------------------------------------
// 載入使用權檢查
//----------------------------------------------
var authorize = require('./lib/authorize.js');
var moment = require('moment');
//----------------------------------------------

//------------------
// 載入資料庫連結
//------------------
var pool = require('./lib/db.js');

var startPage=1;
var linePerPage=15; 
var navSegments=10;

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
    var writingsContent=req.param('writingsContent');
	
    if(writingsContent=="" || writingsContent==null){
        res.render('dataNotFound', {query:"[未輸入關鍵字, 文章]"});
		return;
    }
	
	writingsContent = "%" + writingsContent + "%";
    var pageNo=1

    pool.query('select count(*) as cnt from writings where writingsContent like ?', [writingsContent], function(err, results) {
        if (err)throw err;

        var totalLine=results[0].cnt;
        var totalPage=1;

        pool.query('select * from writings where writingsContent like ?',[writingsContent], function(err, results) {
            if (err) {
                res.render('dataNotFound', {query:"[文章]"});
            }

            if(results.length==0){
                res.render('dataNotFound', {query:"[文章]"});
            }else{
                var recordNo=(pageNo-1)*linePerPage+1;
                res.render('detailsListByPage', {userNo:req.session.userNo, moment:moment, data:results, pageNo:pageNo, totalLine:totalLine, totalPage:totalPage, startPage:startPage, linePerPage:linePerPage, navSegments:navSegments});
            }
        }); 
    }); 
});

module.exports = router;