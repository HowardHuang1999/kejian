<template>
  <div class="volunteer">
    <el-card
      class="box-card"
      v-for="messageborads in messageborad"
      :key="messageborads.id"
    >
      <span>
        <el-avatar :size="60" :src="messageborads.headphoto"></el-avatar>
        <span class="font1">{{ messageborads.username }}</span
        ><br /><br />
        <p class="time">{{ messageborads.createTime }}</p></span
      ><br />
      <p class="title">{{ messageborads.title }}</p>
      <br />
      <p class="text">
        {{ messageborads.content }}
      </p> </el-card
    ><br /><br />
  </div>
</template>

<script>
import { getMessageBy } from "../service/index";
import { mapGetters } from "vuex";
export default {
  name: "Message",
  created() {
    // 获取动物信息
    getMessageBy({ buserid: this.userInfo.id })
      .then(result => {
        console.log(result.data);
        this.messageborad = result.data;
      })
      .catch(function(err) {
        console.log(err);
      });
  },
  methods: {},
  data() {
    return {
      messageborad: []
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
.font1 {
  font-size: 26px;
  color: rgb(25, 99, 37);
  //font-weight: 700;
  margin-left: 20px;
}
.time {
  color: rgb(194, 186, 186);
}

// 右边卡片
.text {
  font-size: 23px;
}

.title {
  font-size: 25px;
  color: rgb(84, 148, 231);
}
</style>
