<template>
  <div class="adopt">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>领养中心</el-breadcrumb-item>
      <el-breadcrumb-item
        ><router-link to="/help">我要领养</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>填写领养申请表</el-breadcrumb-item></el-breadcrumb
    ><br /><br /><br />
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.vname"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="form.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="form.age"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="vphone">
        <el-input v-model="form.vphone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="居住地址" prop="vaddress">
        <el-input v-model="form.vaddress"></el-input>
      </el-form-item>

      <el-form-item label="自我介绍" prop="vintroduce">
        <el-input type="textarea" v-model="form.vintroduce"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submit">立即创建</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addVolunteer } from "../service/index";
export default {
  name: "Volunteer",
  methods: {
    // 提交表单
    submit() {
      let param = new URLSearchParams();
      let param2 = new URLSearchParams();
      param.append("vname", this.form.vname);
      param.append("age", this.form.age);
      param.append("sex", this.form.sex);
      param.append("vaddress", this.form.vaddress);
      param.append("vphone", this.form.vphone);
      param.append("email", this.form.email);
      param.append("vintroduce", this.form.vintroduce);
      param2.append("status", 1);
      alert("提交成功!");

      addVolunteer(param)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data() {
    return {
      form: {
        vname: "",
        age: "",
        sex: "",
        vaddress: "",
        vphone: "",
        email: "",
        vintroduce: ""
      }
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
}
</style>
