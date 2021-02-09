<template>
  <div class="donate">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/donate">爱心捐助</router-link></el-breadcrumb-item
      > </el-breadcrumb
    ><br /><br /><br />
    <div class="logo">
      <img src="../assets/img/adddonate.png" alt="" />
    </div>
    <el-form :model="form" ref="form" label-width="100px">
      <el-form-item>
        <p class="option-desc">TA的一天=有粮+有水+有人照料❤</p>
        <div style="margin-top: 20px">
          <el-radio v-model="ruleForm.money" label="5" border size="medium"
            >¥5元</el-radio
          >
          <el-radio v-model="ruleForm.money" label="10" border size="medium"
            >¥10元</el-radio
          >
          <el-radio v-model="ruleForm.money" label="20" border size="medium"
            >¥20元</el-radio
          >
          <el-radio v-model="ruleForm.money" label="50" border size="medium"
            >¥50元</el-radio
          >
          <el-radio v-model="ruleForm.money" label="100" border size="medium"
            >¥100元</el-radio
          >
        </div>
      </el-form-item>

      <el-form-item label="其他金额" prop="money">
        <el-input
          v-model="ruleForm.money"
          placeholder="请输入其他金额"
        ></el-input>
      </el-form-item>

      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="ruleForm.name"
          placeholder="请输入您的姓名"
        ></el-input>
      </el-form-item>

      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="ruleForm.email"
          placeholder="请输入您的邮箱"
        ></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input
          v-model="ruleForm.phone"
          placeholder="请输入您的联系电话"
        ></el-input>
      </el-form-item>

      <el-form-item prop="message">
        <el-input
          type="textarea"
          v-model="ruleForm.message"
          placeholder="感谢TA的生命中遇到了你！你是否想告诉TA……"
        ></el-input>
      </el-form-item>

      <!--<el-form-item>
        <el-radio-group v-model="ruleForm.moneyway">
          <el-radio label="1">支付宝支付</el-radio>
          <el-radio label="2">微信支付</el-radio>
        </el-radio-group>
      </el-form-item>-->

      <el-form-item>
        <el-button type="primary" @click="submit"
          ><a v-bind:href="url + ruleForm.money" style="color: white"
            >我要支持</a
          ></el-button
        >
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>

    <div v-html="html"></div>
  </div>
</template>

<script>
import { addDonate } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Donate",
  methods: {
    // 提交表单
    submit() {
      if (this.userInfo.id >= 1) {
        let param = new URLSearchParams();
        param.append("name", this.ruleForm.name);
        param.append("email", this.ruleForm.email);
        param.append("phone", this.ruleForm.phone);
        param.append("message", this.ruleForm.message);
        param.append("money", this.ruleForm.money);
        param.append("moneyway", this.ruleForm.moneyway);
        param.append("buserid", this.userInfo.id);
        //alert("提交成功!");

        addDonate(param)
          .then(result => {
            console.log(result);
          })
          .catch(function(err) {
            console.log(err);
          });
        //alert("提交成功!");
      } else {
        this.$message.error("您还未登录，请先登录");
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data() {
    return {
      ruleForm: {
        name: "",
        email: "",
        phone: "",
        money: "",
        message: "",
        moneyway: "",
        buserid: ""
      },
      url: "http://localhost:8080/alipay/toPay?amount=",
      html1:
        '<a v-bind:href="url + ruleForm.money" style="color: white">我要支持</a>',
      html2:
        '<a v-bind:href="url + ruleForm.money" style="color: white">我要支持</a>'
    };
  },
  computed: {
    ...mapGetters(["userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.donate {
  border: 1px solid rgb(182, 178, 178);
  width: 80%px;
  height: 100%;
  padding: 30px;
  margin-left: 10%;
  margin-right: 10%;
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }

  .nomalColor {
    color: #303133;
  }

  .el-col {
    border-radius: 4px;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  button {
    background-color: #4caf50; /* Green */
    border: none;
    color: white;
    padding: 15px 5px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 20px;
    cursor: pointer;
    border-radius: 8px;
    width: 100px;
  }
  .logo {
    height: 360px;
    //margin-left: 30px;
    text-align: center;
  }
}
</style>
