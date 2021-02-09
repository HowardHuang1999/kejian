<template>
  <div class="volunteer">
    <el-row>
      <!-- 左边卡片 -->
      <el-col :span="16">
        <div class="grid-content bg-purple">
          <el-row>
            <el-card
              class="box-card"
              v-for="donate in donates"
              :key="donate.id"
            >
              <el-row>
                <el-col :span="18"
                  ><div class="grid-content bg-purple-light">
                    <div class="noticetitle">名字：{{ donate.name }}</div>
                    <div class="content">电话：{{ donate.phone }}</div>
                    <div class="content">邮箱：{{ donate.email }}</div>
                    <div class="content">捐赠金额：{{ donate.money }}</div>
                    <div class="content">感言：{{ donate.message }}</div>
                    <div class="time">捐赠时间：{{ donate.createTime }}</div>
                  </div>
                </el-col>
              </el-row>
            </el-card>
          </el-row>
          <br /><br /><br />
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getDonateBy } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Donate",
  created() {
    // 获取动物信息
    getDonateBy()
      .then(result => {
        console.log(result.data);
        this.donates = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {},
  data() {
    return {
      donates: []
    };
  },
  computed: {
    ...mapGetters(["userInfo"])
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
