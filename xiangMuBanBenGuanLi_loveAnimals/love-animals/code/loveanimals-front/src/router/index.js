import Vue from "vue";
import VueRouter from "vue-router";
import adopt from "../views/adopt.vue";
import help from "../views/help.vue";
import notice from "../views/notice.vue";
import volunteer from "../views/volunteer.vue";
import about from "../views/about.vue";
import main from "../views/main.vue";
import partner from "../views/partner.vue";
import vointroduce from "../views/vointroduce.vue";
import adoptintroduce from "../views/adoptintroduce.vue";
import helpintroduce from "../views/helpintroduce.vue";
import helphandle from "../views/helphandle.vue";
import volunteerhandle from "../views/volunteerhandle.vue";
import adopttable from "../views/adopttable.vue";
import animalsdetails from "../views/animalsdetails.vue";
import helptable from "../views/helptable.vue";
import volunteertable from "../views/volunteertable.vue";
import donate from "../views/donate.vue";
import messageboard from "../views/messageboard.vue";
import personal from "../views/personal.vue";
import phoneandemail from "../views/phoneandemail.vue";
import personalcenter from "../views/personalcenter.vue";
import animalscollection from "../views/animalscollection.vue";
import volunteerrecode from "../views/volunteerrecode.vue";
import adoptrecode from "../views/adoptrecode.vue";
import mydonate from "../views/mydonate.vue";
import mymessage from "../views/mymessage.vue";
import video from "../views/video.vue";

Vue.use(VueRouter);

const routes = [
  { path: "/", redirect: "/main" },
  {
    path: "/adopt",
    component: adopt
  },
  {
    path: "/help",
    component: help
  },
  {
    path: "/main",
    component: main
  },
  {
    path: "/notice",
    component: notice
  },
  {
    path: "/volunteer",
    component: volunteer
  },
  {
    path: "/about",
    component: about
  },
  {
    path: "/partner",
    component: partner
  },
  {
    path: "/vointroduce",
    component: vointroduce
  },
  {
    path: "/adoptintroduce",
    component: adoptintroduce
  },
  {
    path: "/helpintroduce",
    component: helpintroduce
  },
  {
    path: "/helphandle",
    component: helphandle
  },
  {
    path: "/volunteerhandle",
    component: volunteerhandle
  },
  {
    path: "/adopttable",
    component: adopttable
  },
  {
    path: "/animalsdetails",
    component: animalsdetails
  },
  {
    path: "/helptable",
    component: helptable
  },
  {
    path: "/volunteertable",
    component: volunteertable
  },
  {
    path: "/donate",
    component: donate
  },
  {
    path: "/messageboard",
    component: messageboard
  },
  {
    path: "/personal",
    component: personal
  },
  {
    path: "/phoneandemail",
    component: phoneandemail
  },
  {
    path: "/personalcenter",
    component: personalcenter,
    children: [
      {
        path: "/personalcenter/animalscollection",
        component: animalscollection
      },
      {
        path: "/personalcenter/volunteerrecode",
        component: volunteerrecode
      },
      {
        path: "/personalcenter/adoptrecode",
        component: adoptrecode
      },
      {
        path: "/personalcenter/mydonate",
        component: mydonate
      },
      {
        path: "/personalcenter/mymessage",
        component: mymessage
      }
    ]
  },
  {
    path: "/video",
    component: video
  }
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes
});

export default router;
