<template>
  <div class="notice">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>公告中心</el-breadcrumb-item>
      <el-breadcrumb-item>查看公告</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <!--<el-collapse v-for="notice in notices" :key="notice.id">
      <el-collapse-item
        :title="'[' + notice.ntitle + ']' + '.............' + notice.createTime"
      >
        <el-divider content-position="left">详细内容：</el-divider>
        <div>
          {{ notice.ncontent }}
        </div>
        <div class="time">
          {{ notice.createTime }}
        </div>
      </el-collapse-item>
    </el-collapse>-->

    <el-form label-width="80px" class="searchBar">
      <el-form-item label="标题名称:">
        <el-input
          v-model="searching"
          placeholder="模糊搜索标题内容"
          @click="searchBy"
        ></el-input>
      </el-form-item>
    </el-form>
    <el-card class="box-card" v-for="notice in notices" :key="notice.id">
      <el-row>
        <el-col :span="6"
          ><div class="grid-content bg-purple">
            <img :src="notice.photo1" alt="公告图片" /></div
        ></el-col>
        <el-col :span="18"
          ><div class="grid-content bg-purple-light">
            <div class="noticetitle">☛{{ notice.ntitle }}</div>
            <div class="content">{{ notice.ncontent }}</div>
            <br />
            <div class="time">发布日期：{{ notice.createTime }}</div>
          </div></el-col
        >
      </el-row>
    </el-card>
    <br /><br /><br />
    <el-pagination background layout="prev, pager, next" :total="1000">
    </el-pagination>
  </div>
</template>

<script>
import { getNotice } from "../service/index";
export default {
  name: "Notice",
  created() {
    // 获取公告信息
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
      notices: [],
      searching: ""
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
  color: rgb(196, 194, 194);
  //margin-left: 20px;
  float: right;
}

.title {
  text-align: center;
  padding: 0 0 30px 50px;
  font-size: 30px;
  font-weight: 100px;
  color: rgb(16, 145, 5);
}
.box-card {
  width: 100%;
  //height: 200px;
}
.noticetitle {
  text-align: left;
  font-size: 23px;
  font-weight: 100px;
  margin-top: 18px;
  margin-left: 20px;
  color: rgb(0, 0, 0);
}
.content {
  margin-left: 20px;
  line-height: 2;
}
img {
  /*设置图片宽度和浏览器宽度一致*/
  width: 100%;
  height: inherit;
}
.searchBar {
  display: grid;
  grid-template-columns: 380px;
  grid-column-gap: 20px;
}
</style>
