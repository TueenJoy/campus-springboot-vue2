
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/apis': {
        target: 'https://localhost/',
        changOrigin: true,
        ws: true,
        secure: false,
        pathRewrite: {
          '^/apis': ''
        },
        logLevel: 'debug'
      }
    }
  }
})

