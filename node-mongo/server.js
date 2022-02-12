const express = require('express')
const app = express()
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended : true}))

const MongoClient = require('mongodb').MongoClient;

MongoClient.connect('mongodb+srv://quedevel:<password>@cluster0.mor3l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority', 
function(){
    app.listen(8080, () => {
        console.log('listening on 8080')    
    })
})

app.get('/pet', (req, res) => {
    res.send('pet....')
})

app.get('/beauty', (req, res) => {
    res.send('beauty....')
})

app.get('/', (req, res) => {
    res.sendFile(__dirname+'/index.html')
})

app.get('/write', (req, res) => { 
    res.sendFile(__dirname +'/write.html')
})

app.post('/add', (req, res) => {
    res.send('post success....')
    console.log(req.body)
})