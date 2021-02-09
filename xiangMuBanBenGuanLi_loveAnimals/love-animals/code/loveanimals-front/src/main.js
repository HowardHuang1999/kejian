import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "./assets/css/reset.scss";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import axios from "axios";
import VueAxios from "vue-axios";
import VideoPlayer from "vue-video-player";
import Video from "video.js";
import "video.js/dist/video-js.css";

Vue.prototype.$video = Video;

Vue.use(VideoPlayer);
require("vue-video-player/src/custom-theme.css");

Vue.use(VueAxios, axios);
Vue.use(ElementUI);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
