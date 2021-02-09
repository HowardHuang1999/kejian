<template>
  <div class="index">
    <el-container v-show="showMain">
      <!-- 头部 -->
      <el-header style="height: 185px;">
        <div class="logo">
          <img src="../assets/img/logo.png" alt="" />
        </div>
        <el-menu
          mode="horizontal"
          background-color="#088A08"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <div class="menu-ceter">
            <!-- 展示动物信息，可以被领养 -->
            <router-link to="/main"
              ><el-menu-item index="1">首页 </el-menu-item></router-link
            >

            <el-submenu index="2">
              <template slot="title">领养中心</template>
              <router-link to="/adopt"
                ><el-menu-item index="2-1">申请领养 </el-menu-item></router-link
              >
              <router-link to="/adoptintroduce"
                ><el-menu-item index="2-2"
                  >领养流浪小动物须知
                </el-menu-item></router-link
              >
            </el-submenu>

            <el-submenu index="3">
              <template slot="title">救助中心</template>

              <router-link to="/help"
                ><el-menu-item index="3-1">救助申报</el-menu-item></router-link
              >

              <router-link to="/helphandle"
                ><el-menu-item index="3-2"
                  >查看申报处理结果</el-menu-item
                ></router-link
              >

              <router-link to="/helpintroduce"
                ><el-menu-item index="3-3"
                  >流浪动物救助指南
                </el-menu-item></router-link
              >
            </el-submenu>

            <el-submenu index="4">
              <template slot="title">志愿者中心</template>

              <router-link to="/volunteer"
                ><el-menu-item index="4-1"
                  >成为志愿者</el-menu-item
                ></router-link
              >

              <router-link to="/volunteerhandle"
                ><el-menu-item index="4-2"
                  >查询申请处理结果</el-menu-item
                ></router-link
              >

              <router-link to="/vointroduce"
                ><el-menu-item index="4-2"
                  >志愿者招募要求</el-menu-item
                ></router-link
              >
            </el-submenu>

            <el-submenu index="5">
              <template slot="title">公告中心</template>

              <router-link to="/notice"
                ><el-menu-item index="5-1">查看公告 </el-menu-item></router-link
              >
            </el-submenu>

            <router-link to="/donate"
              ><el-menu-item index="6">爱心捐助</el-menu-item></router-link
            >

            <el-submenu index="7">
              <template slot="title">关于我们</template>

              <router-link to="/about"
                ><el-menu-item index="7-1">了解我们</el-menu-item></router-link
              >

              <router-link to="/partner"
                ><el-menu-item index="7-2"
                  >我们的伙伴</el-menu-item
                ></router-link
              >
            </el-submenu>

            <el-submenu index="8">
              <template slot="title">联系我们</template>

              <router-link to="/messageboard"
                ><el-menu-item index="8-1">留言板</el-menu-item></router-link
              >

              <router-link to="/phoneandemail"
                ><el-menu-item index="8-2"
                  >电话&&邮件</el-menu-item
                ></router-link
              >
            </el-submenu>

            <router-link to="/video">
              <el-menu-item index="9">视频媒体</el-menu-item>
            </router-link>

            <router-link to="/personalcenter">
              <el-menu-item index="10">个人中心</el-menu-item>
            </router-link>
          </div>
          <div class="menu-right">
            <el-menu-item
              @click.native="(showLogin = true), (showMain = false)"
              v-if="!isLogin"
              style="color: red;"
              >未登录</el-menu-item
            >
            <el-menu-item @click.native="logout" v-else
              >欢迎 {{ userInfo.bname }}，<span style="color: red;"
                >退出登录</span
              ></el-menu-item
            >
          </div>
        </el-menu>
      </el-header>
      <!-- 中间 -->
      <el-main>
        <router-view></router-view>
      </el-main>
      <!-- 结尾 -->
      <el-footer>
        <el-menu
          mode="horizontal"
          background-color="#E6E6E6"
          text-color="#000000"
          active-text-color="#ffd04b"
        >
          <div class="footer-ceter">
            <div class="footer-ceter1"></div>

            <div style="text-align: center">
              <br />
              <br />

              <a href="/main">首页 </a> &emsp;|&emsp;
              <a href="/donate"> 爱心捐助</a> &emsp;|&emsp;
              <a href="/about">关于我们</a> &emsp;|&emsp;
              <a href="/partner"> 我们的伙伴</a>
              <br />
              <h5>
                Copyright © 2020-2021 流浪动物救助平台(www.sa.com) 版权所有 All
                Rights Reserved.
              </h5>
              <br />
              <a href="http://www.11467.com/maoming/co/19627.htm"
                ><img src="../assets/img/foot01.gif"/></a
              >&emsp;&emsp;
              <a href="https://www.lawxp.com/statutes/s159075.html"
                ><img src="../assets/img/foot02.gif"/></a
              >&emsp;&emsp;
              <a href="http://www.wenming.cn/"
                ><img src="../assets/img/foot03.gif"/></a
              >&emsp;&emsp;
              <a href="https://www.12377.cn/"
                ><img src="../assets/img/foot04.gif"/></a
              >&emsp;&emsp;
            </div>
          </div>
        </el-menu>
      </el-footer>
    </el-container>
    <login v-if="showLogin"></login>
  </div>
</template>

<script>
import login from "./login";
import { mapGetters, mapActions } from "vuex";
export default {
  data() {
    return {
      showLogin: false,
      showMain: true
    };
  },
  computed: {
    ...mapGetters(["isLogin", "userInfo"])
  },
  methods: {
    ...mapActions(["setIsLogin"]),
    logout() {
      this.setIsLogin(false);
      this.$message.success("退出成功");
    }
  },
  components: {
    login
  }
};
</script>

<style lang="scss" scoped>
.index {
  width: 100%;
  height: 100%;
  .el-container {
    position: relative;
    padding-bottom: 300px;
  }

  .el-header {
    position: fixed;
    width: 100%;
    z-index: 999;
    line-height: 200px;
    background-color: #fff;
    .logo {
      height: 119px;
      //margin-left: 30px;
      text-align: center;
    }
    .menu-right {
      position: absolute;
      right: 0;
    }
  }
  .el-main {
    position: relative;
    padding: 0 20px;
    top: 200px;
    overflow: hidden;
  }
  li {
    list-style: none;
    float: left;
    //font-size: 20px;
  }
  .el-footer {
    width: 100%;
    height: 100px; /* footer的高度一定要是固定值*/
    position: absolute;
    bottom: 0px;
    left: 0px;
    background: #ffffff;
  }
  .footer {
    margin-left: 500px;
    margin-top: 15px;
  }
  .footer-ceter1 {
    position: relative;
    left: 30%;
    width: 100%;
  }
  .footer-ceter2 {
    position: relative;
    left: 30%;
    float: left;
    width: 100%;
  }
  .menu-ceter {
    position: relative;
    left: 2%;
  }
  a {
    font-size: 20px;
  }
  img {
    margin-left: 20px;
  }
}
</style>
