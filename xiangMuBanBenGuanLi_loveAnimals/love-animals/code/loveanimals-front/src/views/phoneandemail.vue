<template>
  <div class="notice">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>联系我们</el-breadcrumb-item>
      <el-breadcrumb-item>电话&&邮件</el-breadcrumb-item> </el-breadcrumb
    ><br /><br />
    <div class="logo">
      <img src="../assets/img/联系2.png" alt="" />
    </div>
    <br /><br /><br />
    <el-divider content-position="left">话费还有？直接call我们吧</el-divider
    ><br />
    <el-card class="box-card">
      <p class="title">#官方联系电话#</p>
      <br />
      <p class="text">移动电话：18211295134<br />座机电话：3760607</p> </el-card
    ><br /><br />
    <el-form label-width="80px">
      <el-divider content-position="left">电话费贵？直接发email吧</el-divider
      ><br />
      <el-card class="box-card">
        <el-form-item prop="title">
          <el-input
            v-model="ruleForm.title"
            style="width:1000px"
            placeholder="请输入email标题"
          ></el-input>
        </el-form-item>
        <el-form-item prop="text">
          <el-input
            v-model="ruleForm.text"
            rows="6"
            style="width:1000px"
            type="textarea"
            placeholder="邮件主体内容"
            >></el-input
          >
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">发送邮件</el-button>
          <el-button @click="resetForm('ruleForm')">取消</el-button>
        </el-form-item>
      </el-card></el-form
    ><br />
  </div>
</template>

<script>
import { sendEmail } from "../service/index";
export default {
  name: "Phoneandemail",
  created() {},
  methods: {
    submit() {
      let param = new URLSearchParams();
      param.append("title", this.ruleForm.title);
      param.append("text", this.ruleForm.text);

      sendEmail(param)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
      alert("发送成功!");
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data() {
    return {
      ruleForm: {
        title: "",
        text: ""
      }
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

.text {
  font-size: 23px;
  margin-left: 75px;
}

.title {
  font-size: 25px;
  color: rgb(84, 148, 231);
  margin-left: 75px;
}
.box-card {
  width: 100%;
}
.logo {
  height: 119px;
  //margin-left: 30px;
  text-align: center;
}
</style>
