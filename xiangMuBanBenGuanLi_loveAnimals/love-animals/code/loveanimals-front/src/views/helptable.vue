<template>
  <div class="help">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">救助中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">救助申报</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>填写救助申请表</el-breadcrumb-item></el-breadcrumb
    ><br /><br /><br />
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item label="居住地址" prop="address">
        <el-input v-model="form.address"></el-input>
      </el-form-item>

      <el-form-item label="自我介绍">
        <el-input type="textarea" v-model="form.introduce"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">立即创建</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addHelp } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Help",
  methods: {
    // 提交表单
    submit() {
      if (this.userInfo.id >= 1) {
        this.$message.success("提交成功!");
        let param = new URLSearchParams();
        let param2 = new URLSearchParams();
        param.append("name", this.form.name);
        param.append("address", this.form.address);
        param.append("phone", this.form.phone);
        param.append("introduce", this.form.introduce);
        param2.append("status", 1);

        addHelp(param)
          .then(result => {
            console.log(result);
          })
          .catch(function(err) {
            console.log(err);
          });
      } else this.$message.error("您还未登录，请先登录");
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  data() {
    return {
      form: {
        name: "",
        phone: "",
        address: "",
        introduce: ""
      }
    };
  },
  computed: {
    ...mapGetters(["userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.help {
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
