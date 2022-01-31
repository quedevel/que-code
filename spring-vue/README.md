# spring-vue 연동

## 1. 스프링 프로젝트 생성

## 2. vue 폴더 생성

## 3. Vue.js 프로젝트 생성
```
npm i -g @vue/cli-init
vue init webpack [프로젝트 명]

ex) spring-vue/vue> vue init webpack vue-front

? Project name vue-front
? Project description A Vue.js project
? Author quedevel <kdh90817@naver.com>
? Vue build standalone
? Install vue-router? Yes
? Use ESLint to lint your code? No
? Set up unit tests No
? Setup e2e tests with Nightwatch? No
? Should we run `npm install` for you after the project has been created? (recommended) npm

project name : 프로젝트 이름
project description : 프로젝트 설명
Author : 사용자
Vue build : Runtime + Compiler 선택합니다.
Install vue-router : 라우터 설치
Use ESLint to lint youe code : ESLint 플러그인을 통해 코드 검증
Set up unit tests : 유닛테스트 설정
Shoud we run npm install ~ : NPM을 사용할지 Yarn을 사용할지 선택

```

## 4. index.js 설정 변경
```javascript
build: {
    // Template for index.html
    // 기존 경로: index: path.resolve(__dirname, '../dist/index.html'),
    //  SpringBoot Static Folder
    index: path.resolve(__dirname, '../../../src/main/resources/templates/vue/index.html'),

        // Paths
        // 기존 경로: assetsRoot: path.resolve(__dirname, '../dist'),
        //  SpringBoot Static Folder
        assetsRoot: path.resolve(__dirname, '../../../src/main/resources/static/vue'),
        assetsSubDirectory: 'static/',
        assetsPublicPath: 'vue/',

        // assetsRoot : path.resolve(__dirname. 'SpringBoot 프로젝트에 build 결과물 저장할 경로')
        //   * vue 프로젝트를 빌드 시 생성될 css, js 등 파일을 위치할 경로를 설정합니다.
        //   * 위 index.html은 해당 경로의 css, js 등 파일을 읽어와 화면에 보여지게 됩니다.

        // assetsPublicPath: 'vue/'
        //   * index.html에서 읽어올 때 의 경로 
        //   *  (default로는 '/' 이지만, 2번에서 static아래에 vue라는 디렉토리를 생성하였기 때문에, 해당 디렉토리를 읽어오기 위해 수정하도록 하겠습니다.)

        /**
         * Source Maps
         */

        productionSourceMap: true,
        // https://webpack.js.org/configuration/devtool/#production
        devtool: '#source-map',

        // Gzip off by default as many popular static hosts such as
        // Surge or Netlify already gzip all static assets for you.
        // Before setting to `true`, make sure to:
        // npm install --save-dev compression-webpack-plugin
        productionGzip: false,
        productionGzipExtensions: ['js', 'css'],

        // Run the build command with an extra argument to
        // View the bundle analyzer report after build finishes:
        // `npm run build --report`
        // Set to `true` or `false` to always turn it on or off
        bundleAnalyzerReport: process.env.npm_config_report
}
```

## 5. vue build
```
npm run build
```

## 6. controller 설정
```java
@Controller
public class WebController {

    @RequestMapping("/vue")
    public String vue(){
        return "vue/index";
    }
}
```

## 7. 서버 실행 후 접속 http://localhost:8080/vue