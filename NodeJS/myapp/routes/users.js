var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

/* GET display registration page */
router.get('/register', function(req,res,next) {
  res.render('register');
})

/* POST User information */
router.post('/register', function(req,res,next) {
  var fs = require('fs');
  var name = req.body.name+"\n";

  fs.appendFile('./users.txt', name, function (err) {
    if (err) {
      return console.log(err);
    }
  });

  res.redirect('/');
});

module.exports = router;