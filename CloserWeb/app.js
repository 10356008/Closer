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
//----------------------管理者--------------------------
var managerindex = require('./routes/managerindex');

//----------------------管理者登入-----------------------
var loginForm = require('./routes/loginForm');
var login = require('./routes/login');
var loginSuccess = require('./routes/loginSuccess');
var loginFail = require('./routes/loginFail');
var logout = require('./routes/logout');

//----------------------新增--------------------------
var writingsAddForm = require('./routes/writingsAddForm');
var writingsAdd = require('./routes/writingsAdd');


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

//----------------------新增--------------------------
app.use('/writingsAddForm', writingsAddForm);
app.use('/writingsAdd', writingsAdd);



// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
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
