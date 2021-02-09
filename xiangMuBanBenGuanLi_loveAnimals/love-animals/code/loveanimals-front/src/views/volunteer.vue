<template>
  <div class="volunteer">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>志愿者中心</el-breadcrumb-item>
      <el-breadcrumb-item>成为志愿者</el-breadcrumb-item> </el-breadcrumb
    ><br /><br />
    <span>招募条件</span
    ><br />1)年龄16周岁以上，（13周岁—15周岁须有一名家长带领）<br />2)热心公益事业，具有奉献精神<br />3)思想品质优良，无不良嗜好，无违法乱纪行为<br />4)真诚，有责任感并乐于助人，自愿为社会和他人提供服务和帮助。<br /><br /><br />
    <span>成为志愿者你将获得什么</span
    ><br />1)一次珍贵的志愿服务体验。从上午9点开始，你将与我们一起并肩感受到活动前到结束的点点滴滴。几个小时下来，你或许会觉得很累，但我们相信你将会在志愿服务的过程中，感受到做志愿服务的快乐。<br />2)志愿服务团队。你将会加入到我们这个志愿服务的团队中来，体会到助人为乐的快乐感和充实感。<br />3)志愿服务证明。如果你还是学生，我们还可以为你开具相关的志愿服务证明（社会实践证明）。
    <!--<el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="vname" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="vphone" label="电话" width="180">
      </el-table-column>
      <el-table-column prop="vaddress" label="地址"> </el-table-column>
      <el-table-column prop="vintroduce" label="个人介绍"> </el-table-column>
      <el-table-column prop="createTime" label="申请时间"> </el-table-column>
    </el-table> -->

    <br /><br />
    <el-button type="primary" icon="el-icon-plus" @click="showForm"
      >申请成为志愿者</el-button
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
      <div class="title">志愿者申报表单</div>
      <el-form-item label="姓名" prop="vname">
        <el-input
          v-model="ruleForm.vname"
          placeholder="请输入您的姓名"
        ></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="vphone">
        <el-input
          v-model="ruleForm.vphone"
          placeholder="请输入您的电话"
        ></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="vaddress">
        <el-input
          v-model="ruleForm.vaddress"
          placeholder="请输入您的地址"
        ></el-input>
      </el-form-item>
      <el-form-item label="个人情况" prop="vintroduce">
        <el-input
          type="textarea"
          v-model="ruleForm.vintroduce"
          placeholder="请输入个人情况以及想成为志愿者原因"
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
import { getVolunteer, addVolunteer } from "../service/index";
export default {
  name: "Volunteer",
  created() {
    // 获取志愿者信息
    getVolunteer()
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
      this.$router.push("/volunteertable");
    },
    // 隐藏表单
    hiddenForm() {
      this.isShowForm = false;
      this.$refs["ruleForm"].resetFields();
    },
    // 提交表单
    submit() {
      let param = new URLSearchParams();
      param.append("vname", this.ruleForm.vname);
      param.append("vaddress", this.ruleForm.vaddress);
      param.append("vphone", this.ruleForm.vphone);
      param.append("vintroduce", this.ruleForm.vintroduce);

      addVolunteer(param)
        .then(result => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
    }
  },
  data() {
    return {
      tableData: [],
      ruleForm: {
        vname: "",
        vaddress: "",
        vphone: "",
        vintroduce: ""
      },
      isShowForm: false
    };
  }
};
</script>

<style lang="scss" scoped>
.volunteer {
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
