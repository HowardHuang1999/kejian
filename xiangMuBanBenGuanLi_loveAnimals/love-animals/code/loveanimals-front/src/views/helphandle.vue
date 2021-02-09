<template>
  <div class="help">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">救助中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>查询申报处理结果</el-breadcrumb-item> </el-breadcrumb
    ><br />
    <h2>救助申请处理情况：</h2>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="name" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="address" label="流浪动物地址"> </el-table-column>
      <el-table-column prop="introduce" label="情况描述"> </el-table-column>
      <el-table-column prop="createTime" label="申请时间"> </el-table-column>
      <el-table-column prop="status" label="审核状态" width="100">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.status == 1 ? 'success' : 'danger'"
            v-text="scope.row.status == 1 ? '已审核' : '未审核'"
            >{{ scope.row.status }}</el-tag
          >
        </template>
      </el-table-column>
    </el-table>
    <br /><br /><br />
    <el-pagination background layout="prev, pager, next" :total="1000">
    </el-pagination>
  </div>
</template>

<script>
import { getHelp, addHelp } from "../service/index";
export default {
  name: "Help",
  created() {
    // 获取志愿者信息
    getHelp()
      .then((result) => {
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
      this.isShowForm = true;
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
        .then((result) => {
          console.log(result);
        })
        .catch(function(err) {
          console.log(err);
        });
      this.hiddenForm();
    },
  },
  data() {
    return {
      tableData: [],
      ruleForm: {
        name: "",
        address: "",
        phone: "",
        introduce: "",
      },
      isShowForm: false,
    };
  },
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
