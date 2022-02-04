const express = require('express');
const app = express();

app.listen(8080, function() {
  console.log('listening on 8080');
})

app.get('/', (req, res) => { res.sendFile(__dirname+'/index.html') });

app.get('/chapter/1', (req, res) => { res.sendFile(__dirname+'/html/immutableObject.html') })
app.get('/chapter/2', (req, res) => { res.sendFile(__dirname+'/html/executionContext.html') })
app.get('/chapter/3', (req, res) => { res.sendFile(__dirname+'/html/this.html') })
app.get('/chapter/4', (req, res) => { res.sendFile(__dirname+'/html/callbackFunction.html') })
app.get('/chapter/5', (req, res) => { res.sendFile(__dirname+'/html/closure.html') })
app.get('/chapter/6', (req, res) => { res.sendFile(__dirname+'/html/prototype.html') })
app.get('/chapter/7', (req, res) => { res.sendFile(__dirname+'/html/class.html') })