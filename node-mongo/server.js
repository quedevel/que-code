const express = require("express");
const app = express();
const bodyParser = require("body-parser");
app.use(
  bodyParser.urlencoded({
    extended: true,
  })
);

app.use("/public", express.static("public"));

const MongoClient = require("mongodb").MongoClient;

const methodOverride = require("method-override");

app.use(methodOverride("_method"));

app.set("view engine", "ejs");

require('dotenv').config()

var db;

MongoClient.connect(process.env.DB_URL, function (error, client) {
  if (error) {
    return console.log(console.log(error));
  }

  db = client.db("todoapp");

  app.listen(process.env.PORT, () => {
    console.log("listening on 8080");
  });
});

app.get("/pet", (req, res) => {
  res.send("pet....");
});

app.get("/beauty", (req, res) => {
  res.send("beauty....");
});

app.get("/", (req, res) => {
  res.redirect("/list");
});

app.get("/write", (req, res) => {
  res.render("write.ejs");
});

app.post("/add", (req, res) => {
  db.collection("counter").findOne(
    {
      name: "board",
    },
    (err, result) => {
      console.log("result.totalPost : " + result.totalPost);
      var totalPost = result.totalPost;

      db.collection("post").insertOne(
        {
          _id: totalPost + 1,
          data: req.body,
        },
        (err, result) => {
          console.log("저장완료!");
          db.collection("counter").updateOne(
            {
              name: "board",
            },
            {
              $inc: {
                totalPost: 1,
              },
            },
            (err, result) => {
              if (err) return console.log(err);
              console.log("총갯수 +1 성공");
              res.redirect("/list");
            }
          );
        }
      );
    }
  );
});

app.get("/list", function (req, res) {
  // 데이터 모두 찾기
  db.collection("post")
    .find()
    .toArray((error, result) => {
      res.render("list.ejs", {
        posts: result,
      });
    });
});

// URL parameter
app.get("/detail/:id", function (req, res) {
  db.collection("post").findOne(
    {
      _id: Number.parseInt(req.params.id),
    },
    (error, result) => {
      console.log(result);
      res.render("detail.ejs", {
        board: result,
      });
    }
  );
});

app.get("/edit/:id", function (req, res) {
  db.collection("post").findOne(
    {
      _id: Number.parseInt(req.params.id),
    },
    (error, result) => {
      console.log(result);
      res.render("edit.ejs", {
        board: result,
      });
    }
  );
});

app.delete("/delete", (req, res) => {
  db.collection("post").deleteOne(
    {
      _id: Number.parseInt(req.body._id),
    },
    (err, result) => {
      if (err) return console.log(err);
      res.status(200).send({
        message: "삭제에 성공했습니다.",
      });
    }
  );
});

app.put("/edit", (req, res) => {
  var _id = Number.parseInt(req.body._id);

  var params = {
    data: {
      title: req.body.title,
      date: req.body.date,
      content: req.body.content,
    },
  };

  console.log(params);
  db.collection("post").updateOne(
    {
      _id: _id,
    },
    {
      $set: params,
    },
    () => {
      console.log("수정완료");
      res.redirect("/list");
    }
  );
});

const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const session = require("express-session");

app.use(
  session({
    secret: "비밀코드",
    resave: true,
    saveUninitialized: false,
  })
);
app.use(passport.initialize());
app.use(passport.session());

app.get("/login", (req, res) => {
  res.render("login.ejs");
});

app.post(
  "/login",
  passport.authenticate("local", {
    failureRedirect: "/fail",
  }),
  (req, res) => {
    res.redirect("/");
  }
);

passport.use(
  new LocalStrategy(
    {
      usernameField: "id", // form name
      passwordField: "pw", // form name
      session: true, //  session에 저장
      passReqToCallback: false, // 아이디/비번 말고도 다른 정보 검사
    },
    function (id, pw, done) {
      console.log(id, pw);
      db.collection("login").findOne(
        {
          id: id,
        },
        (error, result) => {
          if (error) return done(error);

          if (!result)
            return done(null, false, {
              message: "존재하지않는 아이디요",
            });
          if (pw == result.pw) {
            return done(null, result);
          } else {
            return done(null, false, {
              message: "비번틀렸어요",
            });
          }
        }
      );
    }
  )
);

// 로그인 후 쿠키 방행
passport.serializeUser((user, done) => {
  done(null, user.id);
});

passport.deserializeUser((id, done) => {
    // user의 다른 정보를 넣어쥼
    db.collection('login').findOne({id : id}, (error, result) => {
        done(null, result);
    })
  
});

app.get("/mypage", isLogin, (req, res) => {
    console.log(req.user)
    res.render('mypage.ejs')
});

function isLogin(req, res, next) {
  if (req.user) {
    next();
  } else {
    res.send("로그인 안했는뎅?");
  }
}
