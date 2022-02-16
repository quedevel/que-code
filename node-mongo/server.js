const express = require('express')
const app = express()
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended : true}))

const MongoClient = require('mongodb').MongoClient;
app.set('view engine', 'ejs');

var db;

MongoClient.connect('mongodb+srv://quedevel:??@cluster0.mor3l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority', 
    function(error, client){
        if(error){
            return console.log(console.log(error))
        }

        db = client.db('todoapp');

        app.listen(8080, () => {
            console.log('listening on 8080')    
        })
    }
)

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

    db.collection('counter').findOne({name : 'board'}, (err, result)=>{
        console.log("result.totalPost : "+result.totalPost);
        var totalPost = result.totalPost
        
        db.collection('post').insertOne({_id : totalPost+1, data: req.body}, (err, result) => {
            console.log('저장완료!')
            db.collection('counter').updateOne({name : 'board'},{ $inc : { totalPost: 1 } },(err, result)=>{
                if(err) return console.log(err);
                console.log("총갯수 +1 성공")
            })
        })

    })
    
})

app.get('/list', function(req, res){

    // 데이터 모두 찾기
    db.collection('post').find().toArray((error, result)=>{
        res.render('list.ejs', {posts : result});
    });
})

app.delete('/delete', (req, res)=> {
    console.log(req.body);
})