var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  var fs = require('fs');
  var os = require('os');
  
  fs.readFile("./user.txt", 'utf8', function(err, data) {
      if(err) {
        return console.log(err);
      }
      var user = data.split(os.EOL).filter(val => val != "").slice(-1).pop();
      res.render('index', {title: 'Hello World Application', name: user })
  })
  
});

module.exports = router;
