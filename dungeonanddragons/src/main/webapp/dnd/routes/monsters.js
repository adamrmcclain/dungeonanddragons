var express = require('express');
var router = express.Router();

var mongoose = require('mongoose');
var Monster = require('../models/Monster.js');

/* GET /monsters listing. */
router.get('/', function(req, res, next) {
  Monster.find(function (err, monsters) {
    if (err) return next(err);
    res.json(monsters);
  });
});

/* GET /monsters/monstername */
router.get('/:monstername', function(req, res, next) {
  Monster.find({"MonsterName" : req.params.monstername}, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* POST /monsters */
router.post('/', function(req, res, next) {
  Monster.create(req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* PUT /monsters/:monstername */
router.put('/:monstername', function(req, res, next) {
  Monster.findAndUpdate({"MonsterName" : req.params.monstername}, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* DELETE /monsters/:monstername */
router.delete('/:monstername', function(req, res, next) {
  Monster.find({"MonsterName" : req.params.monstername}, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  }).remove().exec();
});

module.exports = router;
