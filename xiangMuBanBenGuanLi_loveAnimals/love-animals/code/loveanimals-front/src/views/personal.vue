<template>
  <div class="notice">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>公告中心</el-breadcrumb-item>
      <el-breadcrumb-item>查看公告</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="title">公告中心</div>
    <el-collapse v-for="notice in notices" :key="notice.id">
      <el-collapse-item :title="notice.ntitle">
        <div>
          {{ notice.ncontent }}
        </div>
        <div class="time">
          {{ notice.createTime }}
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
import { getNotice } from "../service/index";
export default {
  name: "Notice",
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
  methods: {},
  data() {
    return {
      notices: []
    };
  }
};
</script>

<style lang="scss" scoped>
.notice {
  border: 1px solid rgb(182, 178, 178);
  width: 80%;
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
.time {
  color: #ccc;
}

.title {
  text-align: center;
  padding: 0 0 30px 50px;
  font-size: 30px;
  font-weight: 100px;
  color: rgb(16, 145, 5);
}
</style>
