<template>
  <div class="adopt">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item>领养中心</el-breadcrumb-item>
      <el-breadcrumb-item
        ><router-link to="/adopt">申请领养</router-link></el-breadcrumb-item
      > </el-breadcrumb
    ><br />

    <el-row>
      <!-- 左边卡片 -->
      <el-col :span="16">
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
                  <span class="nomalColor">性别：{{ animal.sex }}</span
                  ><br />
                  <time class="time">时间：{{ animal.createTime }}</time>
                  <div class="bottom clearfix">
                    <el-button type="warning" @click="addRoutest2"
                      >查看</el-button
                    >
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
                      @click="submit"
                    ></el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
          <br /><br /><br />
          <el-pagination background layout="prev, pager, next" :total="1000">
          </el-pagination>
        </div>
      </el-col>
      <!-- 右边领养信息 -->
      <el-col :span="8" class="right">
        <div class="header">
          <span>【须知】流浪动物领养须知</span>
        </div>
        <el-card class="box-card">
          <span>领养要求</span><br />
          1）领养人须年满二十三周岁，有稳定职业，在广东有固定住所。<br /><br />2）领养人有爱心和责任感，其家庭成员也有同样的爱心可以接纳动物的加入。<br /><br />3）领养人家中已饲养宠物数量原则上不超过2只。<br /><br />4）同意并签定领养协议（协议内容如下文），愿意配合回访工作。
          <br /><br />
          <hr />
          <hr />
          <br />
          <span>领养程序</span
          ><br />1）阅读网页上的动物介绍、领养要求及协议，若有理想的领养对象，通过我们公布的方式联系救助人或寄养人。<br /><br />2）亲自看望狗狗，通过接触了解其性格习性等，若进一步证实是您的理想领养对象，请您回家慎重思考并与家人全面沟通。<br /><br />3）确定领养意愿后，由适当人员进行家访。<br /><br />4）符合领养条件的，填写申请表，审核通过后领养人凭身份证件办理领养手续，签署具法律效力的领养协议后，您就可以带上心爱的动物回家了。经过一周的试养，如无任何问题，则领养成功。<br /><br />5）回访：在领养完成后，将对领养家庭进行回访。回访形式可以多样，上门拜访、电话、信件、电邮等方式均可采用。回访是为了了解被领养的小动物在新家的适应情况，了解领养人是否按协议规定履行了相关的义务。
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getAnimals, addCollection } from "../service/index";
import { mapGetters } from "vuex";
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
  },
  methods: {
    addRoutest() {
      if (this.userInfo.id >= 1) {
        this.$router.push("/adopttable");
      } else this.$message.error("您还未登录，请先登录");
    },
    addRoutest2() {
      this.$router.push("/animalsdetails");
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    // 提交表单
    submit() {
      if (this.userInfo.id >= 1) {
        this.$message.success("收藏成功!");
        let param2 = new URLSearchParams();
        param2.append("buserid", this.userInfo.id);
        param2.append("animalsid", this.animals.id);
        param2.append("collection", 1);

        // 更新动物状态
        addCollection(param2)
          .then(result => {
            console.log(result);
          })
          .catch(function(err) {
            console.log(err);
          });
      } else this.$message.error("您还未登录，请先登录");
    }
  },

  data() {
    return {
      animals: [],
      collection: [],
      activeIndex: "1",
      ruleForm: {
        buserid: "",
        animalsid: "",
        collection: ""
      }
    };
  },
  mounted() {},
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
