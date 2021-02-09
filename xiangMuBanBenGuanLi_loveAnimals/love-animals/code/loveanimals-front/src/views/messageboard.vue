<template>
  <div class="notice">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>联系我们</el-breadcrumb-item>
      <el-breadcrumb-item>留言板</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="logo">
      <img src="../assets/img/反馈2.png" alt="" />
    </div>

    <el-form ref="form" :model="form" label-width="80px">
      <el-divider content-position="left">欢迎您的留言</el-divider><br /><br />
      <el-card class="box-card">
        <el-form-item>
          <el-input
            style="width:1000px"
            placeholder="请输入留言标题"
            v-model="ruleForm.title"
            >></el-input
          >
        </el-form-item>
        <el-form-item>
          <el-input
            rows="6"
            style="width:1000px"
            type="textarea"
            placeholder="发条友善的留言"
            v-model="ruleForm.content"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">发表留言</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-card></el-form
    ><br />

    <el-divider content-position="left">大家怎么说</el-divider><br /><br />

    <el-form label-width="80px" class="searchBar">
      <el-form-item label="标题名称:">
        <el-input
          v-model="searching"
          placeholder="模糊搜索留言信息"
          @click="searchBy"
        ></el-input>
      </el-form-item>
    </el-form>
    <el-card
      class="box-card"
      v-for="messageborads in messageborad"
      :key="messageborads.id"
    >
      <span>
        <el-avatar :size="60" :src="messageborads.headphoto"></el-avatar>
        <span class="font1">{{ messageborads.username }}</span
        ><br /><br />
        <p class="time">{{ messageborads.createTime }}</p></span
      ><br />
      <p class="title">{{ messageborads.title }}</p>
      <br />
      <p class="text">
        {{ messageborads.content }}
      </p> </el-card
    ><br /><br />
    <el-pagination background layout="prev, pager, next" :total="1000">
    </el-pagination>
  </div>
</template>

<script>
import { getMessage, addMessage } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Messageboard",
  created() {
    // 获取留言信息
    getMessage()
      .then(result => {
        console.log(result.data);
        this.messageborad = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {
    // 提交表单
    submit() {
      if (this.userInfo.id >= 1) {
        let param = new URLSearchParams();
        param.append("title", this.ruleForm.title);
        param.append("content", this.ruleForm.content);
        param.append("buserid", this.userInfo.id);
        alert("提交成功!");

        addMessage(param)
          .then(result => {
            console.log(result);
          })
          .catch(function(err) {
            console.log(err);
          });
      } else this.$message.error("您还未登录，请先登录");
    }
  },
  data() {
    return {
      circleUrl:
        "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3301644026,1718256288&fm=26&gp=0.jpg",
      sizeList: ["large", "medium", "small"],
      messageborad: [],
      buser: [],
      ruleForm: {
        title: "",
        content: "",
        buserid: ""
      }
    };
  },
  computed: {
    ...mapGetters(["userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.logo {
  height: 190px;
  text-align: center;
  //background-image: url("../assets/img/aaa.jpg");
}
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
}
.card {
  margin-right: 30px;
  margin-bottom: 10px;
  .el-button {
    float: right;
  }
  &:last-child {
    margin-right: 0;
  }
}
.time {
  color: rgb(194, 186, 186);
}

// 右边卡片
.text {
  font-size: 23px;
}

.title {
  font-size: 25px;
  color: rgb(84, 148, 231);
}
.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.box-card {
  width: 100%;
}

.header {
  width: 100%;
  line-height: 30px;
  background-color: #3f9741;
  border-radius: 5px;
  text-align: center;
}
.font1 {
  font-size: 26px;
  color: rgb(25, 99, 37);
  //font-weight: 700;
  margin-left: 20px;
}
.searchBar {
  display: grid;
  grid-template-columns: 380px;
  grid-column-gap: 20px;
}
</style>
