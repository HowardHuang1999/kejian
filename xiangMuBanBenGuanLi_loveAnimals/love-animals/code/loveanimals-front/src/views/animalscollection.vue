<template>
  <div class="adopt">
    <el-row>
      <!-- 左边卡片 -->
      <el-col :span="22">
        <div class="grid-content bg-purple">
          <el-row>
            <el-col
              :span="7"
              v-for="animal in animals"
              :key="animal.id"
              class="card"
            >
              <el-card :body-style="{ padding: '0px' }">
                <img :src="animal.animalsImage" class="image" />
                <div style="padding: 14px;">
                  <div class="nomalColor">
                    <span>ID：{{ animal.id }}</span>
                  </div>
                  <span class="nomalColor">名字：{{ animal.aname }}</span
                  ><br />
                  <span class="nomalColor">性别：{{ animal.sex }}</span>
                  <div class="bottom clearfix">
                    <time class="time">时间：{{ animal.createTime }}</time>
                    <el-button
                      :type="warning"
                      @click="addRoutest2"
                      v-text="'查看'"
                    >
                    </el-button>
                    <el-button
                      :type="animal.status == 1 ? 'danger' : 'success'"
                      @click="addRoutest"
                      v-text="animal.status == 1 ? '已领养' : '领养'"
                      :disabled="animal.status == 1"
                    >
                    </el-button>
                    <el-button
                      type="warning"
                      icon="el-icon-star-off"
                      circle
                    ></el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
          <br /><br /><br />
        </div>
      </el-col>
      <!-- 右边领养信息 -->
      <el-col :span="2" class="right"> </el-col>
    </el-row>
  </div>
</template>

<script>
import { getColection } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Adopt",
  created() {
    // 获取动物信息
    getColection({ buserid: this.userInfo.id })
      .then(result => {
        console.log(result.data);
        this.animals = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {
    addRoutest() {
      this.$router.push("/adopttable");
    },
    addRoutest2() {
      this.$router.push("/animalsdetails");
    }
  },
  data() {
    return {
      animals: []
    };
  },
  computed: {
    ...mapGetters(["userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.adopt {
  //border: 1px solid rgb(182, 178, 178);
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

  // 左边卡片
  .time {
    font-size: 13px;
    color: #999;
  }

  .image {
    width: 100%;
    height: 150px;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }

  .card {
    margin-right: 30px;
    margin-bottom: 10px;
    .el-button {
      float: right;
    }
    &:last-child {
      margin-right: 0;
    }
  }

  // 右边卡片
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }

  .box-card {
    width: 100%;
  }

  .header {
    width: 100%;
    line-height: 30px;
    background-color: #3f9741;
    border-radius: 5px;
    text-align: center;
  }

  // 表单
  .el-form {
    width: 400px;
    position: fixed;
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
}
</style>
