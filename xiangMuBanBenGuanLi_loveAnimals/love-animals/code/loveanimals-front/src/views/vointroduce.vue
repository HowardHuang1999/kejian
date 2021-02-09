<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/volunteer"
          >志愿者中心</router-link
        ></el-breadcrumb-item
      >
      <el-breadcrumb-item>志愿者申请要求</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="about">
      <h2>【招募】我们要招募志愿者啦......</h2>
      <br /><br />
      <div class="content">
        <div>
          <span
            ><img
              align="middle"
              src="http://5b0988e595225.cdn.sohucs.com/images/20181009/70ea25c48b8149ee9307f69b506c3945.jpeg"/></span
          ><br /><br />
          志愿服务是一项崇高的社会公益事业，是城市文明进步的重要标志。为进一步弘扬“奉献、友爱、互助、进步”的志愿精神，认真做好“爱在重阳·孝暖崇义”活动后勤保障工作，营造“寓意祥和、幸福社区”的氛围，现面向社区公开招募重阳节活动志愿者20名。<br /><br /><br />
          <span
            ><img
              align="middle"
              src="http://5b0988e595225.cdn.sohucs.com/images/20181009/9a5047fed4bb4aa09bc96ba1907baa15.gif"/></span
          ><br /><br />
          <span>招募条件</span
          ><br />1、年龄16周岁以上，（13周岁—15周岁须有一名家长带领）<br /><br />2、热心公益事业，具有奉献精神<br /><br />3、思想品质优良，无不良嗜好，无违法乱纪行为<br /><br />4、真诚，有责任感并乐于助人，自愿为社会和他人提供服务和帮助。<br /><br /><br />
          <span>成为志愿者你将获得什么</span
          ><br />1、一次珍贵的志愿服务体验。从上午9点开始，你将与我们一起并肩感受到活动前到结束的点点滴滴。几个小时下来，你或许会觉得很累，但我们相信你将会在志愿服务的过程中，感受到做志愿服务的快乐。<br /><br />2、志愿服务团队。你将会加入到我们这个志愿服务的团队中来，体会到助人为乐的快乐感和充实感。<br /><br />3、志愿服务证明。如果你还是学生，我们还可以为你开具相关的志愿服务证明（社会实践证明）。
        </div>
        <br />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "About",
  methods: {},
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.about {
  border: 1px solid rgb(182, 178, 178);
  width: 80%px;
  height: 100%;
  padding: 30px;
  margin-left: 10%;
  margin-right: 10%;
  h2 {
    font-size: 30px;
    font-weight: 100px;
    margin: 10px;
    text-align: center;
  }
  img {
    text-align: center;
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
}
</style>
