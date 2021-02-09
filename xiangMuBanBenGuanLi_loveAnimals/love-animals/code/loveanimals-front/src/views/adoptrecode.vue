<template>
  <div class="volunteer">
    <el-row>
      <!-- 左边卡片 -->
      <el-col :span="24">
        <div class="grid-content bg-purple">
          <el-row>
            <el-card class="box-card" v-for="adopt in adopts" :key="adopt.id">
              <el-row>
                <el-col :span="24"
                  ><div class="grid-content bg-purple-light">
                    <div class="noticetitle">名字：{{ adopt.name }}</div>
                    <div class="content">性别：{{ adopt.sex }}</div>
                    <div class="content">年龄：{{ adopt.age }}</div>
                    <div class="content">居住地址：{{ adopt.address }}</div>
                    <div class="content">身份证号：{{ adopt.idcard }}</div>
                    <div class="content">职业：{{ adopt.unitname }}</div>
                    <div class="content">房子情况：{{ adopt.house }}</div>
                    <div class="content">自我介绍：{{ adopt.introduce }}</div>
                    <div class="content">动物ID：{{ adopt.animalsid }}</div>
                    <!-- <div
                      class="time"
                      v-text="adopt.status == 1 ? '审核情况：审核通过' : '审核情况：未审核'"
                    >
                      {{ adopt.status }}
                    </div> -->
                    <div class="time">审核情况：{{ adopt.status }}</div>
                    <div class="time">领养时间：{{ adopt.createTime }}</div>
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
import { getAdoptBy } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Donate",
  created() {
    // 获取动物信息
    getAdoptBy({ buserid: this.userInfo.id })
      .then(result => {
        console.log(result.data);
        this.adopts = result.data;
        console.log(this.adopts[0]);
        this.adopts.length;
        console.log(this.adopts[0].status);
        for (var ab in this.adopts) {
          if (this.adopts[ab].status == "0") {
            this.adopts[ab].status = "未审核";
          } else if (this.adopts[ab].status == "1") {
            this.adopts[ab].status = "审核通过";
          } else this.adopts[ab].status = "审核不通过";
        }
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {},
  data() {
    return {
      adopts: []
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
