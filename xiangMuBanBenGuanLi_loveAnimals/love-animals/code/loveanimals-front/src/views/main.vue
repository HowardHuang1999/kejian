<template>
  <div class="main">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item
        :to="{ path: '/' }"
        style="font-size: 25px,
            color: rgb(25, 99, 37)"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>首页</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div id="banner">
      <!--动态将图片轮播图的容器高度设置成与图片一致-->
      <el-carousel :height="bannerHeight + 'px'">
        <!--遍历图片地址,动态生成轮播图-->
        <el-carousel-item v-for="item in imgList" :key="item">
          <a href="https://gongyi.qq.com/succor/detail.htm?id=226724"
            ><img :src="item.idView" alt=""
          /></a>
          <p>{{ item.name }}</p>
        </el-carousel-item>
      </el-carousel>
      <div class="header">
        <span>99公益日| 无界之爱疗愈计划</span>
      </div>
    </div>
    <br />

    <h2>精彩活动：</h2>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="6"
          ><el-card class="box-card"
            ><div class="grid-content bg-purple">
              <a href="http://www.csapa.org/soci/26417.htm"
                ><img src="../assets/img/活动1.jpg" alt="活动1" />
                <p class="font1">
                  中国儿基会少年公益学院 X
                  中国小动物保护协会『生命关爱教育公益大讲堂』
                </p>
                <p>
                  近几年，社会上总是频发宠物狗追咬孩子的意外事件，让人感到遗憾和痛心。
                </p></a
              >
            </div></el-card
          ></el-col
        >
        <el-col :span="6"
          ><el-card class="box-card"
            ><div class="grid-content bg-purple">
              <a href="http://www.csapa.org/soci/26324.htm"
                ><img src="../assets/img/活动2.jpg" alt="活动2" />
                <p class="font1">
                  2018年CRC狂犬病防治项目进度报告
                </p>
                <p>
                  2016年秋，有这样一群人，他们用时108天，帮助全国11,913只流浪动物免费注射了狂犬疫苗
                </p></a
              >
            </div></el-card
          ></el-col
        >
        <el-col :span="6"
          ><el-card class="box-card"
            ><div class="grid-content bg-purple">
              <a href="http://www.csapa.org/soci/26323.htm"
                ><img src="../assets/img/活动3.png" alt="活动3" />
                <p class="font1">
                  第二届“宠爱日”暨2018中国宠物产业发展论坛圆满结束
                </p>
                <p>
                  为延续“宠爱日”精神、深度挖掘“宠爱文化”内涵、推进中国宠物产业发展
                </p></a
              >
            </div></el-card
          ></el-col
        >
        <el-col :span="6"
          ><el-card class="box-card"
            ><div class="grid-content bg-purple">
              <a href="http://www.csapa.org/soci/26322.htm"
                ><img src="../assets/img/活动4.jpg" alt="活动4" />
                <p class="font1">
                  “同爱一起长大”儿童善良教育项目第三次走进北大
                </p>
                <p>
                  2018年5月5日，这已经是中国小动物保护协会独立发起的善良教育项目“同爱一起长大”第三次走进北京大学光华管理学院MBA项目了。
                </p></a
              >
            </div></el-card
          ></el-col
        >
      </el-row>
    </el-main>

    <h2>公告中心：</h2>
    <br />
    <el-row>
      <el-col :span="8"
        ><div class="grid-content bg-purple">
          <a href="http://www.csapa.org/soci/26322.htm"
            ><img src="../assets/img/活动5.jpg" alt="活动5" />
            <p class="font1">
              “中国流浪动物救助联盟”首次筹备沟通会圆满举行
            </p></a
          >
        </div></el-col
      >
      <el-col :span="10"
        ><el-card class="box-card2"
          ><div class="grid-content bg-purple-light">
            <!--<el-collapse v-for="notice in notices" :key="notice.id">
                <el-collapse-item :title="notice.ntitle">
                  <div>
                    {{ notice.ncontent }}
                  </div>
                  <div class="time">
                    {{ notice.createTime }}
                  </div>
                </el-collapse-item>
              </el-collapse>-->
            <a href="http://www.csapa.org/soci/26438.htm"
              ><p class="font2">
                ☛首届中国（聊城）萌宠文化节开幕！中国小动物保护协会张秘书长应邀出席
              </p></a
            >
            <a href="http://www.csapa.org/soci/26437.htm"
              ><p class="font2">
                ☛京东、河北卫视与中国小动物保护协会三方签订战略协议
                打造跨屏电商综艺 助力小动物保护公益事业
              </p></a
            >
            <a href="http://www.csapa.org/soci/26436.htm"
              ><p class="font2">
                ☛基地狗娃儿们华丽"变身"，快来找出熟悉的它！
              </p></a
            >
            <a href="http://www.csapa.org/soci/26435.htm"
              ><p class="font2">
                ☛中国小动物保护协会流浪动物救助试点基地 授牌仪式在京举行
              </p></a
            >
            <a href="http://www.csapa.org/soci/26422.htm"
              ><p class="font2">
                ☛关于WCF与CSAPA开展战略合作的公告
              </p></a
            >
            <a href="http://www.csapa.org/soci/26434.htm"
              ><p class="font2">
                ☛中国流浪动物救助联盟”首次筹备沟通会圆满举行
              </p></a
            ><br /></div></el-card
      ></el-col>
      <el-col :span="6"
        ><div class="grid-content bg-purple">
          <a href="http://www.csapa.org/dangjian/index.htm"
            ><img src="../assets/img/活动6.jpg" alt="活动6"
          /></a></div
      ></el-col>
    </el-row>
    <h2>我们的合作伙伴：</h2>
    <br />
    <div class="about">
      <el-row :gutter="10">
        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
          ><div class="grid-content bg-purple">
            <a href="http://www.fci.be/en/"
              ><img src="../assets/img/partner1.jpg" alt="合作伙伴1"
            /></a></div
        ></el-col>
        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"></el-col>
        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"
          ><div class="grid-content bg-purple"></div
        ></el-col>
        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
          ><div class="grid-content bg-purple-light"></div
        ></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import { getNotice } from "../service/index";
// import $ from "jquery";
export default {
  name: "Main",
  created() {
    // 获取志愿者信息
    getNotice()
      .then(result => {
        console.log(result.data);
        this.notices = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  data() {
    return {
      imgList: [
        { id: 0, idView: require("../assets/img/donate.png") },
        { id: 1, idView: require("../assets/img/donate2.png") },
        { id: 2, idView: require("../assets/img/donate3.jpg") }
      ],
      imgUrlList: [
        { id: 0, idView: "https://gongyi.qq.com/succor/detail.htm?id=226724" },
        { id: 1, idView: "https://gongyi.qq.com/succor/detail.htm?id=226724" },
        { id: 2, idView: "https://gongyi.qq.com/succor/detail.htm?id=226724" }
      ],
      notices: [],
      // 图片父容器高度
      bannerHeight: 1000,
      // 浏览器宽度
      screenWidth: 0
    };
  },
  methods: {
    setSize: function() {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = (400 / 1920) * this.screenWidth;
    }
  },
  mounted() {
    // 首次加载时,需要调用一次
    this.screenWidth = window.innerWidth;
    this.setSize();
    // 窗口大小发生改变时,调用一次
    window.onresize = () => {
      this.screenWidth = window.innerWidth;
      this.setSize();
    };
  }
};
</script>

<style lang="scss" scoped>
.main {
  border: 1px solid rgb(255, 255, 255);
  width: 80%;
  height: 100%;
  padding: 2px;
  margin-top: 0px;
  margin-left: 10%;
  margin-right: 10%;
}
.el-row {
  margin-bottom: 30px;
  &:last-child {
    margin-bottom: 0;
  }
}

//走马灯
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.activity {
  width: 100%;
  height: 100%;
}
img {
  /*设置图片宽度和浏览器宽度一致*/
  width: 100%;
  height: inherit;
}
p {
  text-align: center;
  font-size: 15px;
  color: #000;
}
.font1 {
  text-align: center;
  font-size: 18px;
  color: #000;
  font-weight: 700;
}
.box-card {
  width: 100%;
  height: 360px;
}
.box-card2 {
  width: 100%;
  //height: 360px;
}
h2 {
  font-size: 18px;
  color: rgb(25, 99, 37);
  font-weight: 700;
}
.about {
  border: 1px solid rgb(182, 178, 178);
}
.font2 {
  font-size: 20px;
  color: rgb(24, 55, 80);
  float: left;
  margin-top: 8px;
  text-decoration: underline;
}
.header {
  width: 100%;
  line-height: 30px;
  background-color: #3f9741;
  border-radius: 5px;
  text-align: center;
}
</style>
