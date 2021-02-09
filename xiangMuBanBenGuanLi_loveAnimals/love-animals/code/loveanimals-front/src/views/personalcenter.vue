<template>
  <div class="personalcenter">
    <div class="logo">
      <img src="../assets/img/个人中心.png" alt="" />
    </div>
    <el-menu
      :default-active="activeIndex"
      router
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
    >
      <el-menu-item index="/personalcenter/animalscollection"
        >动物收藏</el-menu-item
      >
      <el-menu-item index="/personalcenter/volunteerrecode"
        >志愿者申请记录</el-menu-item
      >
      <el-menu-item index="/personalcenter/adoptrecode"
        >领养申请记录</el-menu-item
      >
      <el-menu-item index="/personalcenter/mydonate">我的捐赠</el-menu-item>
      <el-menu-item index="/personalcenter/mymessage">我的留言</el-menu-item>
    </el-menu>
    <router-view></router-view>
    <div v-for="collection in collections" :key="collection.id"></div>
  </div>
</template>
<script>
import { getColection } from "../service/index";
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      activeIndex: "1",
      collections: []
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  mounted() {
    getColection({ buserid: this.userInfo.id })
      .then(res => {
        console.log(res.data);
        this.collections = res.data;
      })
      .catch(err => {
        console.log(err);
      });
  },
  computed: {
    ...mapGetters(["userInfo"])
  }
};
</script>

<style lang="scss" scoped>
.personalcenter {
  border: 1px solid rgb(182, 178, 178);
  width: 80%;
  height: 100%;
  padding: 30px;
  margin-left: 10%;
  margin-right: 10%;
}
.logo {
  height: 380px;
  //margin-left: 30px;
  text-align: center;
}
</style>
