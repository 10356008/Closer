var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var favicon = require('serve-favicon');
var logger = require('morgan');
var bodyParser = require('body-parser');

var index = require('./routes/index');
var users = require('./routes/users');


//-----------------------------------------------------
//-----------------------------------------------------
var about = require('./routes/about');
var detailsView = require('./routes/detailsView');
var contact = require('./routes/contact');
var detailsFirst = require('./routes/detailsFirst');
var detailsSecond = require('./routes/detailsSecond');
var detailsThird = require('./routes/detailsThird');
var detailsFourth = require('./routes/detailsFourth');

var details1 = require('./routes/details1');
var details2 = require('./routes/details2');
var details4 = require('./routes/details4');
var details5 = require('./routes/details5');
var details6 = require('./routes/details6');
var details7 = require('./routes/details7');
var details8 = require('./routes/details8');

var detailsOneItemQuery = require('./routes/detailsOneItemQuery');
var detailsSearch = require('./routes/detailsSearch');

var detailsListByPage = require('./routes/detailsListByPage');
var detailsOneItem = require('./routes/detailsOneItem');

var detailsDelete = require('./routes/detailsDelete');

var updateNewDataForm = require('./routes/updateNewDataForm');
var detailsUpdate = require('./routes/detailsUpdate');

var detailsAddForm = require('./routes/detailsAddForm');
var detailsAdd = require('./routes/detailsAdd');
//----------------------管理者--------------------------
var managerindex = require('./routes/managerindex');

//----------------------管理者登入-----------------------
var loginForm = require('./routes/loginForm');
var login = require('./routes/login');
var loginSuccess = require('./routes/loginSuccess');
var loginFail = require('./routes/loginFail');
var logout = require('./routes/logout');



var app = express();


//-----------------------------------------
// 增加使用session及uuid
//-----------------------------------------
var session=require('express-session');
var uuid=require('uuid');

app.use(session({
    genid:function(req){
        return uuid.v1();
    },
    secret: 'secretcode',
    resave: true,
    saveUninitialized: true
}));
//-----------------------------------------


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use(bodyParser.json());


app.use('/', index);
app.use('/users', users);


//-----------------------------------------------------
//-----------------------------------------------------
app.use('/about', about);
app.use('/detailsView', detailsView);
app.use('/contact', contact);
app.use('/detailsFirst', detailsFirst);
app.use('/detailsSecond', detailsSecond);
app.use('/detailsThird', detailsThird);
app.use('/detailsFourth', detailsFourth);

app.use('/details1', details1);
app.use('/details2', details2);
app.use('/details4', details4);
app.use('/details5', details5);
app.use('/details6', details6);
app.use('/details7', details7);
app.use('/details8', details8);

app.use('/detailsOneItemQuery', detailsOneItemQuery);
app.use('/detailsOneItem', detailsOneItem);

app.use('/detailsListByPage', detailsListByPage);
app.use('/detailsSearch', detailsSearch);
app.use('/detailsDelete', detailsDelete);

app.use('/updateNewDataForm', updateNewDataForm);
app.use('/detailsUpdate', detailsUpdate);

app.use('/detailsAddForm', detailsAddForm);
app.use('/detailsAdd', detailsAdd);

//----------------------管理者--------------------------
app.use('/managerindex', managerindex);

//---------------------------
// 管理者首頁設定為登入畫面
//---------------------------
app.use('/managerindex', loginForm);

//----------------------管理者登入-----------------------
app.use('/loginForm', loginForm);
app.use('/login', login);
app.use('/loginSuccess', loginSuccess);
app.use('/loginFail', loginFail);
app.use('/logout', logout);


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
