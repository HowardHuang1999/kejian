<template>
  <div class="login">
    <el-form
      :model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="用户名" prop="userName">
        <el-input v-model="ruleForm.userName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input
          type="password"
          v-model="ruleForm.pass"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >提交</el-button
        >
        <el-button @click="back">我不登了</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { login, getUserInfo } from "../service/index";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "Login",
  data() {
    var validateUserName = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      } else {
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        userName: "",
        pass: ""
      },
      rules: {
        userName: [{ validator: validateUserName, trigger: "blur" }],
        pass: [{ validator: validatePass, trigger: "blur" }]
      }
    };
  },
  methods: {
    submitForm(formName) {
      console.log(this.isLogin);
      let self = this;
      this.$refs[formName].validate(valid => {
        if (valid) {
          let obj = {
            username: this.ruleForm.userName,
            password: this.ruleForm.pass
          };
          login(obj)
            .then(function(result) {
              if (result.msg === "成功登陆") {
                self.$message.success(result.msg);
                self.$parent.showLogin = false;
                self.$parent.showMain = true;
                self.setIsLogin(true);
                getUserInfo(self.ruleForm.userName)
                  .then(res => {
                    console.log(res.data[0]);
                    self.setUserInfo(res.data[0]);
                    console.log(self.userInfo);
                  })
                  .catch(err => {
                    console.log(err);
                  });
                console.log(self.isLogin, self.ruleForm.userName);
              } else {
                self.$message.error(result.msg || "登录失败");
              }
            })
            .catch(function(err) {
              console.log(err);
            });
        }
      });
    },
    back() {
      this.$parent.showLogin = false;
      this.$parent.showMain = true;
    },
    ...mapActions(["setIsLogin", "setUserInfo"])
  },
  computed: {
    ...mapGetters(["isLogin", "userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.login {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  z-index: 1000;
  background: url("../assets/img/timg.jpg");
  background-size: cover;
  .el-form {
    width: 400px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    padding: 40px 60px 10px 0px;
    background: rgba(255, 255, 255, 0.6);
    border-radius: 5px;
  }
}
</style>
