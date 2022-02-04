hljs.initHighlightingOnLoad();

// 객체의 가변성에 따른 문제점
console.log('객체의 가변성에 따른 문제점...');
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

// 객체의 가변성에 따른 문제점의 해결 방법
console.log('객체의 가변성에 따른 문제점의 해결 방법...');
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