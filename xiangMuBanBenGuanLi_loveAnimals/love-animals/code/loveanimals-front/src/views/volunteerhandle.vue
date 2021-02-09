<template>
  <div class="volunteer">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">志愿者中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>查询申请处理结果</el-breadcrumb-item> </el-breadcrumb
    ><br /><br />
    <h2>申请处理结果：</h2>
    <br /><br />
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="vname" label="姓名" width="180"> </el-table-column>
      <el-table-column prop="vintroduce" label="个人介绍"> </el-table-column>
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
import { getVolunteer } from "../service/index";
export default {
  name: "volunteerhandle",
  created() {
    // 获取志愿者信息
    getVolunteer()
      .then((result) => {
        console.log(result.data);
        this.tableData = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {},
  data() {
    return {
      tableData: [],
    };
  },
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
