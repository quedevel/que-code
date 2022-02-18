const express = require('express')
const app = express()
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({extended : true}))

app.use('/public', express.static('public'))

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
    res.render('index.ejs')
})

app.get('/write', (req, res) => { 
    res.render('write.ejs')
})

app.post('/add', (req, res) => {
    
    db.collection('counter').findOne({name : 'board'}, (err, result)=>{
        console.log("result.totalPost : "+result.totalPost);
        var totalPost = result.totalPost
        
        db.collection('post').insertOne({_id : totalPost+1, data: req.body}, (err, result) => {
            console.log('저장완료!')
            db.collection('counter').updateOne({name : 'board'},{ $inc : { totalPost: 1 } },(err, result)=>{
                if(err) return console.log(err);
                console.log("총갯수 +1 성공")
                res.redirect('/list');
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

// URL parameter
app.get('/detail/:id', function(req, res){
    db.collection('post').findOne({_id : Number.parseInt(req.params.id)}, (error, result) => {
        console.log(result)
        res.render('detail.ejs', { board : result });
    })
})

app.get('/edit/:id', function(req, res){
    db.collection('post').findOne({_id : Number.parseInt(req.params.id)}, (error, result) => {
        console.log(result)
        res.render('edit.ejs', { board : result });
    })
})


app.delete('/delete', (req, res)=> {
    db.collection('post').deleteOne({_id : Number.parseInt(req.body._id)}, (err, result) => {
        if(err) return console.log(err)
        res.status(200).send({message : '삭제에 성공했습니다.'});
    });
})