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
      <el-breadcrumb-item>填写领养申请表</el-breadcrumb-item></el-breadcrumb
    ><br /><br /><br />
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="ruleForm.name"
          placeholder="请输入您的姓名"
        ></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="ruleForm.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="ruleForm.age"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>
      <el-form-item label="居住地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item label="身份证号" prop="idcard">
        <el-input v-model="ruleForm.idcard"></el-input>
      </el-form-item>
      <el-form-item label="房子情况" prop="house">
        <el-select v-model="ruleForm.house" placeholder="请根据实际情况选择">
          <el-option label="租赁" value="租赁"></el-option>
          <el-option label="购买" value="购买"></el-option>
          <el-option label="农村自建" value="农村自建"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="工作单位" prop="unitname">
        <el-input v-model="ruleForm.unitname"></el-input>
      </el-form-item>
      <el-form-item label="领养的动物ID" prop="animalsid">
        <el-input v-model="ruleForm.animalsid"></el-input>
      </el-form-item>
      <el-form-item label="自我介绍" prop="introduce">
        <el-input type="textarea" v-model="ruleForm.introduce"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">立即提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {
  getAnimals,
  getAdopt,
  addAdopt,
  updateAnimals
} from "../service/index";
export default {
  name: "Adopt",
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
    // 获取申请人信息
    getAdopt()
      .then(result => {
        console.log(result.data);
        this.adopt = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },

  methods: {
    // 提交表单
    submit() {
      let param = new URLSearchParams();
      let param2 = new URLSearchParams();
      param.append("name", this.ruleForm.name);
      param.append("age", this.ruleForm.age);
      param.append("sex", this.ruleForm.sex);
      param.append("house", this.ruleForm.house);
      param.append("unitname", this.ruleForm.unitname);
      param.append("address", this.ruleForm.address);
      param.append("phone", this.ruleForm.phone);
      param.append("introduce", this.ruleForm.introduce);
      param.append("idcard", this.ruleForm.idcard);
      param.append("animalsid", this.ruleForm.animalsid);
      param2.append("id", this.ruleForm.animalsid);
      param2.append("status", 1);
      alert("提交成功!");

      addAdopt(param)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
      // 更新动物状态
      updateAnimals(param2)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
      this.hiddenForm();
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data() {
    return {
      animals: [],
      adopt: [],
      ruleForm: {
        name: "",
        age: "",
        sex: "",
        house: "",
        unitname: "",
        address: "",
        phone: "",
        introduce: "",
        idcard: "",
        animalsid: ""
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
