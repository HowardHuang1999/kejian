<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }"
        >广东省流浪动物救助平台</el-breadcrumb-item
      >
      <el-breadcrumb-item
        ><router-link to="/help">救助中心</router-link></el-breadcrumb-item
      >
      <el-breadcrumb-item>流浪动物救助指南</el-breadcrumb-item> </el-breadcrumb
    ><br />

    <div class="about">
      <h2>流浪动物救助指南</h2>
      <br />
      <div class="content">
        <div>
          <span
            ><img
              align="middle"
              src="http://5b0988e595225.cdn.sohucs.com/images/20190115/4be60e8dd9394bba8cb184450ffa92cf.jpeg"/></span
          ><br /><br />
          很多人在养了宠物之后，看到路边的流浪动物都会或多或少的参与一些救助，无论是一个人“单打独斗”，还是找到组织集体行动，大部分怀揣爱心的初次救助者们一般都会这样做：<br /><br />·
          在路边发现了流浪动物后第一时间拍照片<br /><br />· 发朋友圈求助<br /><br />·
          找动物保护组织<br /><br />· 希望来个人把小可怜带走<br /><br />
          <span
            ><img
              align="middle"
              src="http://5b0988e595225.cdn.sohucs.com/images/20190115/fd375e341af346f18196eabbfab4e6ee.jpeg"/></span
          ><br /><br />
          发现流浪动物之后，我们应该做什么？仅仅是拍个照片发给我们？仅仅是告诉我们哪里有只流浪动物很可怜，要谁去救一下就离开了？<br /><br />除此之外，我们是不是应该对受伤的动物多一份关心，留下来守着它们直到接管人员来到现场？是不是可以多一份关爱，有车的开车，有箱子的搬纸箱子先将受伤的动物带去医院进行救治？<br /><br />因为不留守，我们不知道接下来待救助动物要独自面对什么。经常就会出现志愿者赶到现场却找不到待救助动物的情况，心中的那份焦急和不安谁又能体会？因为不及时带去就医，很可能会错过待救助动物的最佳治疗时间。<br /><br />只要有人在待救助动物身边留守，对它来说都是一份对生的鼓励、生的信念、生的希望！可能你的一个坚持延续的将是一条生命！
          <span
            ><img
              align="middle"
              src="http://5b0988e595225.cdn.sohucs.com/images/20190115/fd375e341af346f18196eabbfab4e6ee.jpeg"/></span
          ><br /><br />
          其实基地的志愿者们跟每一个发现人都是一样的，都只是普普通通的人。碰到咬人的小动物我们也会害怕，碰到现场惨烈的情况我们也会惊慌。只是看到无助的生命奄奄一息的时候，我们就觉得自己需要做点什么来帮助它们。而在救助现场，只有发现人是最快速以及最有效能够给与它帮助行动的人！<br /><br />我们感谢那些见到需要救助的小动物愿意停下脚步的人们！我们也鼓励那些能第一时间试图救治和坚守现场的人们！我们更渴望能有人与我们一起保护、爱护、珍惜这些弱小的生命！生命垂危，身陷险境的它们需要你我伸出一只关爱的手为它们守护生命之光。<br /><br />救助是一场拿生命与时间赛跑的限时行动！！既艰巨又需要一丝不苟，既慎重又必须竭尽全力。第一发现人应该在告知后尽早的采取行动，而不是告知大家救助地点就悄无声息，将原本可以第一时间给予的陪伴和帮助“转嫁”给志愿者。我们希望赶到救助现场时有人照顾着的那个孱弱生命，哪怕有一线希望，我们也会全力以赴的接力这一场救助！而不是我们怀揣着争分夺秒的心赶到现场，看到的只是一片凄凉。回身准备挖地的铲子，还要收拾沾满泪水的眼眶...
          <br /><br />做救助不容易，人少动物多，有时候真是心有余而力不足。在心力交瘁的时候，如果还碰到伸手党和道德绑架，那才是最伤人的事情。所以一些资深救助人和动保组织经常被误解，但不管怎样，不忘初心才是最关键的。<br /><br />作为从没接触过救助的宠物主甚至是普通人，我们十分希望你的爱心能救动物们一命。如果你只是想做一个伸手党和道德绑架者，我们会拒绝帮助你；如果你在救助时用尽全力还需要帮助时我们会义不容辞。<br /><br />我们坚信，共同携手定能度过一次次的难关。基地才能更坚持坚守，动保之路才能更平稳健康的发展。
        </div>
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
