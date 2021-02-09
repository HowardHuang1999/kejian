module.exports = {
  devServer: {
    proxy: {
      "/api2": {
        target: "http://127.0.0.1:8080/",
        // 允许跨域
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          "^/api2": ""
        }
      }
    }
  }
};
