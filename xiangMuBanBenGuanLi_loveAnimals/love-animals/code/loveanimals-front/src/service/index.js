// 这个JS文件就是专门用于管理请求各种接口地址的
import Network from "./network";

// 封装各种接口请求
export const getAnimals = () => Network.get("/api/ani/get");
export const getAdopt = () => Network.get("/api/ado/check/get");
export const getVolunteer = () => Network.get("/api/vol/check/get");
export const getNotice = () => Network.get("/api/not/get");
export const getHelp = () => Network.get("/api/help/check/get");
export const getEmail = () => Network.get("/api/email/check/get");
export const getMessage = () => Network.get("/api/messageboard/getMessage");
export const getBuser = () => Network.get("/api/buser/get");
export const findNotice = () => Network.get("/api/not/findNotice");
export const addAdopt = data => Network.post("/api/ado/check/add", data);
export const addCollection = data =>
  Network.post("/api/collection/check/add", data);
export const addHelp = data => Network.post("/api/help/check/add", data);
export const addVolunteer = data => Network.post("/api/vol/check/add", data);
export const sendEmail = data => Network.post("/api/email/send", data);
export const addDonate = data => Network.post("/api/donate/check/add", data);
export const updateAnimals = data =>
  Network.post("/api/ani/check/update", data);
export const login = data => Network.get("/api/buser/login", data);
export const pushMessage = data =>
  Network.get("/api/messageboard/check/publish", data);
export const logout = () => Network.get("/api/buser/logout");
export const getUserInfo = data => Network.get("/api/buser/get", data);
export const getColection = data =>
  Network.get("/api/buser/check/getcollection", data);
export const addMessage = data =>
  Network.post("/api/messageboard/check/publish", data);
export const getMessageBy = data =>
  Network.get("/api/messageboard/check/getMessageBy", data);
export const getVolunteerBy = data =>
  Network.get("/api/vol/check/getVolunteerBy", data);
export const getAdoptBy = data =>
  Network.get("/api/ado/check/getAdoptBy", data);
export const getDonateBy = data =>
  Network.get("/api/donate/check/getDonateBy", data);
