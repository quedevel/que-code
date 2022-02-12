hljs.initHighlightingOnLoad();

// 객체의 가변성에 따른 문제점
console.log('객체의 가변성에 따른 문제점1');
var user = {
  name : 'Jaenam',
  gender : 'male'
};

var changeName = function(user, newName){
  var newUser = user;
  newUser.name = newName;
  return newUser;
};

var user2 = changeName(user, 'Jung');

if(user !== user2){
  console.log('유저 정보가 변경되었습니다.');
}

console.log(user.name, user2.name); // Jung Jung
console.log(user === user2);        // true

// 객체의 가변성에 따른 문제점의 해결 방법1
console.log('해결 방법 1');
var user3 = {
  name:'Jaenam',
  gender:'male'
};

var changeName2 = function(user, newName){
  return {
    name : newName,
    gender : user.gender
  }
}

var user4 = changeName2(user3, 'Jung');

if(user3 !== user4){
  console.log('유저 정보가 변경되었습니다.'); // 유저 정보가 변경되었습니다.
}

console.log(user3.name, user4.name);        // Jaenam Jung
console.log(user3 === user4);               // false

// 객체의 가변성에 따른 문제점의 해결 방법2
console.log('해결 방법 2');

// 기존 정보를 복사해서 새로운 객체를 반환하는 함수 ( 얕은 복사 )
var copyObject = function(target){
  var result = {};
  for(var prop in target){
    result[prop] = target[prop];
  }
  return result;
}

var user5 = {
  name:'Jaenam',
  gender:'male'
};

var user6 = copyObject(user5);
user6.name = 'Jung'

if(user5 !== user6){
  console.log('유저 정보가 변경되었습니다.');
}

console.log(user5.name, user6.name);        // Jaenam Jung
console.log(user5 === user6);               // false
var user7 = {
  name : 'Jaenam',
  urls : {
    portfolio : 'http://github.com/abc',
    blog : 'http://blog.com',
    facebook : 'http://facebook.com/abc'
  }
}

var user8 = copyObject(user7);

user8.name = 'Jung';
console.log(user7.name === user8.name);                     // false

user7.urls.portfolio = 'http://portfolio.com';  
console.log(user7.urls.portfolio === user8.urls.portfolio)  // true

user7.urls.blog = '';
console.log(user7.urls.blog === user8.urls.blog)            // true
// 얕은 복사의 문제점
console.log('얕은 복사의 문제점');

// 객체의 깊은 복사를 수행하는 범용 함수
var copyObjectDeep = function(target){
  var result = {};
  if(typeof target === 'object' && target !== null) {
    for(var prop in target){
      result[prop] = copyObjectDeep(target[prop]);
    }
  } else {
    result = target;
  }
  return result;
}

var obj = {
  a: 1,
  b:{
    c:null,
    d:[1,2]
  }
}

var obj2 = copyObjectDeep(obj);

obj2.a = 3;
obj2.b.c = 4;
obj.b.d[1] = 3;

console.log(obj);   // { a: 1, b: { c: null, d:[1,3] } }
console.log(obj2);  // { a: 3, b: { c: 4, d:{0: 1, 1: 2} } }