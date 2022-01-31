'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')

module.exports = {
  dev: {

    // Paths
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {},

    // Various Dev Server settings
    host: 'localhost', // can be overwritten by process.env.HOST
    port: 8080, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-


    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'cheap-module-eval-source-map',

    // If you have problems debugging vue-files in devtools,
    // set this to false - it *may* help
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

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
}
