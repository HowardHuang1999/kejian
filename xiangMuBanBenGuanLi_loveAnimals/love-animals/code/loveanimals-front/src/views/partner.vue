<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>我们的伙伴</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="about">
      <h2>我们的合作伙伴：</h2>

      <el-row :gutter="10">
        <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
          ><div class="grid-content bg-purple">
            <a href="http://www.fci.be/en/"
              ><img src="../assets/img/partner1.jpg" alt="合作伙伴1"
            /></a></div
        ></el-col>
        <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11"
          ><div class="grid-content bg-purple-light">
            <a href="http://new.cku.org.cn/"
              ><img src="../assets/img/partner2.jpg" alt="合作伙伴2"
            /></a></div
        ></el-col>
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
export default {
  name: "About",
  methods: {},
  data() {
    return {};
  }
};
</script>

<style lang="scss" scoped>
.about {
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
  .content {
    div {
      span {
        color: rgb(250, 102, 3);
        font-size: 30;
        margin-bottom: 20px;
        font-weight: 80px;
      }
    }
  }

  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #ffff;
  }
  .bg-purple {
    background: #ffff;
  }
  .bg-purple-light {
    background: #ffff;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
}
</style>
