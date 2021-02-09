<template>
  <div class="adopt">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/adopt">领养中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/adopt">我要领养</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>查看动物详细信息</el-breadcrumb-item> </el-breadcrumb
    ><br /><br /><br />
    <div class="logo">
      <img src="../assets/img/动物详细信息.png" alt="" />
    </div>
    <br /><br />
    <el-divider content-position="left">汪汪：看看可爱的我吧</el-divider>
    <!--<div class="grid-content bg-purple">
      <el-row>
        <el-col v-for="animal in animals" :key="animal.id" class="card">
          <el-card :body-style="{ padding: '0px' }">
            <img :src="animal.animalsImage" class="image" />
            <div style="padding: 14px;">
              <div class="nomalColor">
                <span>ID：{{ animal.id }}</span
                ><br />
                <span>性名：{{ animal.aname }}</span
                ><br />
                <span>年龄：{{ animal.age }}</span
                ><br />
                <span>性别：{{ animal.sex }}</span
                ><br />
              </div>
              <span>特点：{{ animal.aintroduce }}</span>
              <div class="bottom clearfix">
                <time class="time">时间：{{ animal.createTime }}</time>
              </div>
            </div>
            <el-divider content-position="left">更多图片...</el-divider>
            <img :src="animal.photo1" class="image" />
            <img :src="animal.photo2" class="image" />
            <img :src="animal.photo3" class="image" />
            <img :src="animal.photo4" class="image" />
            <img :src="animal.photo5" class="image" />
            <el-divider content-position="left">汪汪汪汪汪....</el-divider
            ><br /><br /><br />
          </el-card>
        </el-col>
      </el-row>
    </div>-->

    <div v-for="animal in animals" :key="animal.id">
      <el-row class="card">
        <el-col :span="12"
          ><div class="grid-content bg-purple">
            <img :src="animal.animalsImage" class="image" /></div
        ></el-col>
        <el-col :span="12"
          ><div class="grid-content bg-purple-light">
            <div class="nomalColor">
              <span>ID：{{ animal.id }}</span
              ><br />
              <span>性名：{{ animal.aname }}</span
              ><br />
              <span>年龄：{{ animal.age }}</span
              ><br />
              <span>性别：{{ animal.sex }}</span
              ><br />
              <span>时间：{{ animal.createTime }}</span
              ><br /><br />
              <el-button
                :type="animal.status == 1 ? 'danger' : 'success'"
                @click="addRoutest"
                v-text="animal.status == 1 ? '已领养' : '领养'"
                :disabled="animal.status == 1"
              >
              </el-button>
              <el-button
                type="warning"
                icon="el-icon-star-off"
                circle
              ></el-button>
            </div></div
        ></el-col>
      </el-row>

      <el-row>
        <div class="header">
          <span>更多图片...</span>
        </div>
        <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
        <el-col :span="18"
          ><div class="grid-content bg-purple-light">
            <el-card class="box-card">
              <p class="font1">动物简介</p>
              <p class="font2">{{ animal.aintroduce }}</p>
              <br />
            </el-card>
            <img :src="animal.photo1" class="image" />
            <img :src="animal.photo2" class="image" />
            <img :src="animal.photo3" class="image" />
            <img :src="animal.photo4" class="image" />
            <img :src="animal.photo5" class="image" />
            <br /><br /><br /></div
        ></el-col>
        <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      </el-row>
      <div class="header">
        <span>没有更多了哟....</span>
      </div>
      <br /><br /><br />
    </div>
  </div>
</template>

<script>
import { getAnimals } from "../service/index";
export default {
  name: "AnimalsDetails",
  created() {
    // 获取动物信息
    getAnimals()
      .then(result => {
        console.log(result.data);
        this.animals = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {
    addRoutest() {
      this.$router.push("/adopttable");
    }
  },
  data() {
    return {
      animals: []
    };
  }
};
</script>

<style lang="scss" scoped>
.adopt {
  border: 1px solid rgb(182, 178, 178);
  width: 80%px;
  height: 100%;
  padding: 30px;
  margin-left: 10%;
  margin-right: 10%;
  color: rgb(204, 207, 24);
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }

  .nomalColor {
    color: #3f9741;
    padding: 14px;
    margin-left: 30px;
    margin-top: 30px;
    font-size: 23px;
    font-family: sans-serif;
  }

  .el-col {
    border-radius: 4px;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .el-divider {
    font-size: 20px;
    font-family: "Courier New", Courier, monospace;
    margin-top: 10px;
    color: rgb(255, 102, 0);
  }

  .time {
    font-size: 20px;
    font-family: "Courier New", Courier, monospace;
    margin-top: 10px;
    color: #3f9741;
  }
  img {
    /*设置图片宽度和浏览器宽度一致*/
    width: 100%;
    height: inherit;
  }
  .header {
    width: 100%;
    line-height: 30px;
    background-color: #3f9741;
    border-radius: 5px;
    text-align: center;
  }
  .logo {
    height: 170px;
    //margin-left: 30px;
    text-align: center;
    margin-left: 18%;
    margin-right: 18%;
  }
  .box-card {
    width: 100%;
  }
  .font1 {
    text-align: center;
    font-size: 25px;
    color: #3f9741;
  }
  .font2 {
    text-align: center;
    font-size: 20px;
    color: #3f9741;
  }
}
</style>
