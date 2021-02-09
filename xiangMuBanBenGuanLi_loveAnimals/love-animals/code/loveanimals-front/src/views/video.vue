<template>
  <div class="video">
    <div class="logo">
      <img src="../assets/img/视频.png" alt="" />
    </div>
    <div class="header">
      <span>小视频 | 大世界</span>
    </div>
    <el-row>
      <el-col :span="24"
        ><div class="grid-content bg-purple">
          <el-col :span="16">
            <div v-for="(item, i) in list" :key="i" style="margin-bottom: 30px">
              <el-card class="box-card">
                <video
                  :id="'myVideo' + item.id"
                  class="video-js vjs-big-play-centered"
                >
                  <source :src="item.src" type="video/mp4" />
                </video>
              </el-card>
            </div>
          </el-col></div
      ></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      list: [
        {
          src: "http://img.yopoo.cn/banner_video.mp4 ",
          id: 0,
          pic: ""
        },
        {
          src: "http://img.yopoo.cn/banner_video.mp4 ",
          id: 1,
          pic: ""
        },
        {
          src: "http://img.yopoo.cn/banner_video.mp4 ",
          id: 2,
          pic: ""
        }
      ]
    };
  },
  mounted() {
    this.initVideo();
  },
  methods: {
    initVideo() {
      //初始化视频方法 循环列表获取每个视频的id
      this.list.map(item => {
        this.$video("myVideo" + item.id, {
          //确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
          controls: true,
          //自动播放属性,muted:静音播放
          autoplay: "muted",
          //autoplay: false, //自动播放：true/false
          //建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
          preload: "auto",
          //设置视频播放器的显示宽度（以像素为单位）
          width: "800px",
          //设置视频播放器的显示高度（以像素为单位）
          height: "400px",
          //封面图
          poster: item.pic
        });
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.video {
  border: 1px solid rgb(182, 178, 178);
  width: 80%px;
  height: 100%;
  padding: 30px;
  margin-left: 10%;
  margin-right: 10%;
  h2 {
    font-size: 20px;
    font-weight: 100px;
    margin: 10px;
  }
}
.video-js {
  position: relative;
  //margin-left: 200px;
  //float: left;
}
.box-card {
  width: 100%;
  margin-left: 200px;
}
.logo {
  height: 350px;
  //margin-left: 30px;
  text-align: center;
}
.header {
  width: 100%;
  line-height: 30px;
  background-color: #3f9741;
  border-radius: 5px;
  text-align: center;
}
</style>
