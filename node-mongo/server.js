const express = require('express')
const app = express()

app.listen(8080, function(){
    console.log('listening on 8080')    
})

app.get('/pet', function(req, res){
    res.send('pet....')
})

app.get('/beauty', function(req, res){
    res.send('beauty....')
})