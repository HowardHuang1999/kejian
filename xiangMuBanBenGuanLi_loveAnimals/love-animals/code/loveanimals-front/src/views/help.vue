<template>
  <div class="help">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">救助中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>救助申报</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <h2>【须知】救助申请须知</h2>
    <br />
    1)请务必详细阅读救助申请<br />2)所有个人信息我们不会向任何人或组织泄露，请放心填写<br />3)请认真填写姓名，联系电话，被救助动物详细地址<br />4）您的申请处理结果可以在“救助中心->查看申请处理结果”查看最新进度<br />5)非常感谢您的认真填写<br /><br /><br />
    <br />
    <el-button type="primary" icon="el-icon-plus" @click="showForm"
      >救助申报</el-button
    >

    <!-- 表单 -->
    <el-form
      :model="ruleForm"
      status-icon
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
      v-show="isShowForm"
    >
      <div class="title">动物救助申报表单</div>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="ruleForm.name"
          placeholder="请输入您的姓名"
        ></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input
          v-model="ruleForm.phone"
          placeholder="请输入您的电话"
        ></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="ruleForm.address"
          placeholder="请输入流浪动物地址"
        ></el-input>
      </el-form-item>
      <el-form-item label="情况描述" prop="introduce">
        <el-input
          type="textarea"
          v-model="ruleForm.introduce"
          placeholder="请输入情况描述"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">提交</el-button>
        <el-button @click="hiddenForm">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { getHelp, addHelp } from "../service/index";
export default {
  name: "Help",
  created() {
    // 获取志愿者信息
    getHelp()
      .then(result => {
        console.log(result.data);
        this.tableData = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {
    // 弹出表单
    showForm() {
      this.$router.push("/helptable");
    },
    // 隐藏表单
    hiddenForm() {
      this.isShowForm = false;
      this.$refs["ruleForm"].resetFields();
    },
    // 提交表单
    submit() {
      let param = new URLSearchParams();
      param.append("name", this.ruleForm.name);
      param.append("address", this.ruleForm.address);
      param.append("phone", this.ruleForm.phone);
      param.append("introduce", this.ruleForm.introduce);

      addHelp(param)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
      this.hiddenForm();
    }
  },
  data() {
    return {
      tableData: [],
      ruleForm: {
        name: "",
        address: "",
        phone: "",
        introduce: ""
      },
      isShowForm: false
    };
  }
};
</script>

<style lang="scss" scoped>
// 表单
.help {
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
.el-form {
  width: 400px;
  position: fixed;
  z-index: 999;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  background-color: rgb(155, 175, 192);
  padding: 20px 60px 0 0;
  border-radius: 5px;

  .title {
    text-align: center;
    padding: 0 0 30px 50px;
    font-size: 30px;
    font-weight: 100px;
  }
}
</style>
