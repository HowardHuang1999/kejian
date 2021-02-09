import {
  SET_IS_LOGIN,
  SET_USER_INFO,
} from './mutations-type'


export default {
  setIsLogin ({ commit }, flag) {
    commit(SET_IS_LOGIN, flag)
  },
  setUserInfo ({ commit }, flag) {
    commit(SET_USER_INFO, flag)
  },
}
