<template>
  <div class="volunteer">
    <el-row>
      <!-- 左边卡片 -->
      <el-col :span="16">
        <div class="grid-content bg-purple">
          <el-row>
            <el-card
              class="box-card"
              v-for="volunteer in volunteers"
              :key="volunteer.id"
            >
              <el-row>
                <el-col :span="22"
                  ><div class="grid-content bg-purple-light">
                    <div class="content">名字：{{ volunteer.vname }}</div>
                    <div class="content">电话：{{ volunteer.vphone }}</div>
                    <div class="content">邮箱：{{ volunteer.email }}</div>
                    <div class="content">性别：{{ volunteer.sex }}</div>
                    <div class="content">年龄：{{ volunteer.age }}</div>
                    <div class="content">简介：{{ volunteer.vintroduce }}</div>
                    <div class="time">申请时间：{{ volunteer.createTime }}</div>
                  </div>
                </el-col>
                <el-col :span="2"></el-col>
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
import { getVolunteerBy } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Volunteer",
  created() {
    getVolunteerBy({ buserid: this.userInfo.id })
      .then(result => {
        console.log(result.data);
        this.volunteers = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {},
  data() {
    return {
      volunteers: []
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
.time {
  color: rgb(194, 186, 186);
}

// 右边卡片
.content {
  font-size: 23px;
}
</style>
