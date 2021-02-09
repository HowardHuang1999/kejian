<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/adopt">领养中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>流浪动物领养须知</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="about">
      <h2>【须知】流浪动物领养须知</h2>
      <br />
      <div class="content">
        <div>
          <br />
          我们坚持伴侣动物利益至上的原则，把主人的爱心和责任心列为领养的首要条件。<br /><br />
          <span>领养要求</span><br />
          1）领养人须年满二十三周岁，有稳定职业，在广东有固定住所。<br /><br />2）领养人有爱心和责任感，其家庭成员也有同样的爱心可以接纳动物的加入。<br /><br />3）领养人家中已饲养宠物数量原则上不超过2只。<br /><br />4）同意并签定领养协议（协议内容如下文），愿意配合回访工作。
          <br /><br />
          <span>领养程序</span
          ><br />1）阅读网页上的动物介绍、领养要求及协议，若有理想的领养对象，通过我们公布的方式联系救助人或寄养人。<br /><br />2）亲自看望狗狗，通过接触了解其性格习性等，若进一步证实是您的理想领养对象，请您回家慎重思考并与家人全面沟通。<br /><br />3）确定领养意愿后，由适当人员进行家访。<br /><br />4）符合领养条件的，填写申请表，审核通过后领养人凭身份证件办理领养手续，签署具法律效力的领养协议后，您就可以带上心爱的动物回家了。经过一周的试养，如无任何问题，则领养成功。<br /><br />5）回访：在领养完成后，将对领养家庭进行回访。回访形式可以多样，上门拜访、电话、信件、电邮等方式均可采用。回访是为了了解被领养的小动物在新家的适应情况，了解领养人是否按协议规定履行了相关的义务。
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
  }
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
