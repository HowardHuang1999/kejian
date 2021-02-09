import { SET_IS_LOGIN, SET_USER_INFO } from "./mutations-type";

export default {
  [SET_IS_LOGIN](state, flag) {
    state.isLogin = flag;
  },
  [SET_USER_INFO](state, flag) {
    state.userInfo = flag;
  }
};
