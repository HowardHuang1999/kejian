$(function () {
  // 实现选项卡功能
  var win =0;
  for (let i = 0; i < 12; i++) {
    $('#btn>li')
      .eq(i)
      .click(function () {
        win = i;if(win >= 4)win-=1;
        // console.log("1");
        $('.layui-body>div').eq(i).css({
          display: 'block'
        })
        $('.layui-body>div').eq(i).siblings().css({
          display: 'none'
        })
      })
  }
  // 实现滚轮控制横向滚动条滚动
  var layeroff = true;
  var scroll_width = 50; // 设置每次滚动长度，单位 px
  var scroll_events = "mousewheel DOMMouseScroll MozMousePixelScroll";
  
  $(document).on(scroll_events, function (e) {
    if(layeroff){
      var delta = e.originalEvent.wheelDelta; 
      var tableArr = $(".layui-table-main");
      var tstable = $(tableArr[win]).scrollLeft();
      // 滑轮向下滚动，滚动条向右移动，scrollleft+
      if (delta > 0) {
        $(tableArr[win]).scrollLeft(tstable - scroll_width );
      } 
      // 滑轮向上滚动，滚动条向座移动，scrollleft-
      else {
        $(tableArr[win]).scrollLeft(tstable + scroll_width );
      }
    }
  });
  

  
  layui.use(['layer','table','jquery'], function () {
    var table = layui.table
    ,$ = layui.jquery
    ,layer = layui.layer;
    // layer.msg('登录成功');
     //新闻列表
    table.render({
      elem: '#news'
      ,height: '540'
      ,url: '/apis/api/not/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10,20]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: 'ID', width: 60 }
        ,{field: 'ntitle', title: '标题', width: 120,minWidth:60}
        ,{field: 'ncontent', title: '新闻正文',minWidth:100,width:350}
        ,{field: 'photo1',title:'图片1',width: 80,minWidth:80,templet:function(d){
          if(d.photo1==null){return '无'}else if(d.photo1==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo1+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo2',title:'图片2',width: 80,minWidth:80,templet:function(d){
          if(d.photo2==null){return '无'}else if(d.photo2==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo2+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo3',title:'图片3',width: 80,minWidth:80,templet:function(d){
          if(d.photo3==null){return '无'}else if(d.photo3==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo3+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo4',title:'图片4',width: 80,minWidth:80,templet:function(d){
          if(d.photo4==null){return '无'}else if(d.photo4==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo4+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo5',title:'图片5',width: 80,minWidth:80,templet:function(d){
          if(d.photo5==null){return '无'}else if(d.photo5==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo5+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field:'status',title:'状态',width:80,minwidth:80,templet:function(d){
          if(d.status==1){
            return '<a class="layui-bg-blue" >显示</a>'
          }else if (d.status==0){
            return '<a class="layui-bg-orange" >隐藏</a>'
          }else{
            return '状态错误'
          }
        }}
        ,{field: 'createTime', title: '发布时间', width: 120, minWidth: 120, sort:true}
        ,{fixed: 'right', width: 130,minWidth:130 , toolbar: '#bar2'}
        ]
      ]
      ,toolbar: '#bar5'
      ,parseData:function(res){
        var dataList = res.data;
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page1").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page1").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //救助信息列表
    table.render({
        
      elem: '#help'
      ,height: '540'
      ,url: '/apis/api/help/check/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10,20]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: 'ID', width: 60 }
        ,{field: 'name', title: '发布人姓名', width: 100,minWidth:60}
        ,{field: 'phone', title: '电话',minWidth:110, width: 110}
        ,{field: 'introduce', title: '救助详情', minWidth: 120}
        ,{field: 'address', title: '救助地址', width: 180, minWidth: 120}
        ,{field: 'photo1',title:'图片1',width: 80,minWidth:80,templet:function(d){
          if(d.photo1==null){return '无'}else if(d.photo1==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo1+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo2',title:'图片2',width: 80,minWidth:80,templet:function(d){
          if(d.photo2==null){return '无'}else if(d.photo2==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo2+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'photo3',title:'图片3',width: 80,minWidth:80,templet:function(d){
          if(d.photo3==null){return '无'}else if(d.photo3==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.photo3+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'createTime', title: '发布时间', width: 120, minWidth: 120, sort:true}
        ,{field: 'status', title: '审核状态',width:110,minWidth:110,fixed: 'right',sort:true,templet:function(d){
          if(d.status==1){
            return '<a class="layui-btn layui-bg-blue" lay-event="audit" >已过审</a>'
          }else if(d.status==-1){
            return '<a class="layui-btn layui-bg-red " lay-event="audit" >未过审</a>'
          }else{
            return '<a class="layui-btn layui-bg-orange" lay-event="audit" >未审核</a>'
          }
        }}
        ,{fixed: 'right', width: 130,minWidth:130 , toolbar: '#bar2'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
        // console.log(res);
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page2").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page2").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //领养申请列表
    table.render({
        
      elem: '#adopt'
      ,height: '540'
      ,url: '/apis/api/ado/check/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: 'ID', width: 60 }
        ,{field: 'name', title: '领养人姓名', width: 110,minWidth:60}
        ,{field: 'phone', title: '电话',minWidth:120, width: 120}
        ,{field: 'idcard', title: '身份证号码', width: 170, minWidth: 170}
        ,{field: 'sex', title:'性别', width:80,minWidth:80}
        ,{field: 'age', title:'年龄', width:80,minWidth:80}
        ,{field: 'introduce', title: '领养意图', minWidth: 120,width:180}
        ,{field: 'address', title: '居住地址', width: 120, minWidth: 120}
        ,{field: 'animalsid', title: '动物id', width: 80, minWidth:80}
        ,{field: 'animalsphoto',title:'动物图片',width: 90,minWidth:80,templet:function(d){
          if(d.animalsphoto==null){return '无'}else if(d.animalsphoto==''){return '无'}else if(d.animalsphoto=='1'){return '测试'}else{
            return '<div onclick="show_img(this)"><img src="'+d.animalsphoto+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'house', title: '房产信息', minWidth: 120,width:120}
        ,{field: 'unitname', title: '工作单位', minWidth: 120,width:120}
        ,{field: 'idphoto', title: '证书照片',minWidth: 120,width:120,templet:function(d){
          if(d.idphoto==null){return '缺失'}else if(d.idphoto==''){return '缺失'}else{
            return '<div onclick="show_img(this)"><img src="'+d.idphoto+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'createTime', title: '申请时间', width: 120, minWidth: 120, sort:true}
        ,{field: 'status', title:'审核状态', width:110,minWidth:110,fixed: 'right',sort:true,templet:function(d){
          if(d.status==1){
            return '<a class="layui-btn layui-bg-blue" lay-event="audit" >已过审</a>'
          }else if(d.status==-1){
            return '<a class="layui-btn layui-bg-red " lay-event="audit" >未过审</a>'
          }else{
            return '<a class="layui-btn layui-bg-orange" lay-event="audit" >未审核</a>'
          }
        }}
        ,{fixed: 'right', width: 130,minWidth:130 , toolbar: '#bar2'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
        // console.log(res);
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page3").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page3").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //志愿者列表
    table.render({
        
      elem: '#vol'
      ,height: '540'
      ,url: '/apis/api/vol/check/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10,20]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: 'ID', width: 60 }
        ,{field: 'vname', title: '志愿者姓名', width: 100,minWidth:60}
        ,{field: 'vphone', title: '电话',minWidth:120, width: 120}
        ,{field: 'sex', title:'性别',minWidth:80,width:80}
        ,{field: 'age', title:'年龄',minWidth:80,width:80}
        ,{field: 'image', title:'照片',width:80,minWidth:80,templet:function(d){
          if(d.image==null){return '无'}else if(d.image==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.image+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'vintroduce', title: '个人简介', minWidth: 120}
        ,{field: 'vaddress', title: '居住地址', width: 120, minWidth: 120}
        ,{field: 'email', title: '邮箱', width:160,minWidth:120}
        ,{field: 'createTime', title: '加入时间', width: 120, minWidth: 120, sort:true}
        ,{field: 'status', title: '状态', width:110,minWidth:110,fixed: 'right',sort:true,templet:function(d){
          if(d.status==1){
            return '<a class="layui-btn layui-bg-blue" lay-event="audit" >已加入</a>'
          }else if(d.status==-1){
            return '<a class="layui-btn layui-bg-red " lay-event="audit" >未通过</a>'
          }else{
            return '<a class="layui-btn layui-bg-orange" lay-event="audit" >未审核</a>'
          }
        }}
        ,{fixed: 'right', width: 130,minWidth:130 , toolbar: '#bar2'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page4").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page4").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //注册用户列表
    table.render({
        
      elem: '#buser'
      ,height: '540'
      ,url: '/apis/api/buser/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: '用户ID', width: 80,minWidth:60 }
        ,{field: 'bname', title: '用户名', width: 100,minWidth: 60}
        ,{field: 'bpwd', title: '密码',minWidth:120, width: 120,templet:function(d){
          if(d.bpwd==null){return '未设置'}else if(d.bpwd.length<=3){return '***'}else{return '*****'}
        }}
        ,{field: 'username',title: '昵称' ,width: 120,minWidth: 60}
        ,{field: 'headphoto', title:'头像',width:80,minWidth:80,templet:function(d){
          if(d.headphoto==null){return '无'}else if(d.headphoto==''){return '无'}else{
            return '<div onclick="show_img(this)"><img src="'+d.headphoto+'" alt="" width="50px" height="50px"></a></div>'
          }
        }}
        ,{field: 'status', title: '账号状态', width:110,minWidth:110,fixed: 'right',sort:true,templet:function(d){
          if(d.status==1){
            return '<a class="layui-bg-blue" >正常</a>'
          }else{
            return '<a class="layui-bg-orange" >屏蔽</a>'
          }
        }}
        ,{fixed: 'right', width: 130,minWidth:130 , toolbar: '#bar2'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page5").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page5").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //留言板内容
    table.render({
        
      elem: '#mesbd'
      ,height: '540'
      ,url: '/apis/api/messageboard/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: '留言ID', width: 80 ,minWidth:60 }
        ,{field: 'buserid', title: '用户ID', width: 80,minWidth: 60}
        ,{field: 'title', title: '留言标题',minWidth:60, width: 120}
        ,{field: 'content',title: '留言内容' ,width: 180,minWidth: 60}
        ,{field: 'createTime', title:'留言时间',width:120,minWidth:60}
        ,{fixed: 'right',title:'留言板不可修改' ,width: 140,minWidth:130 , toolbar: '#bar4'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page6").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page6").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });

    //邮件内容
    table.render({
        
      elem: '#email'
      ,height: '540'
      ,url: '/apis/api/email/check/get' //数据接口
      ,method:'get'
      ,page: true //开启分页
       ,limit:10 //每页个数
       ,limits: [5,10]
      ,response:{
        statusCode:200
      }
      ,cols: [
        [ //表头
        {title:"",type:"checkbox" ,fixed:"left"}
        ,{field: 'id', title: '邮件ID', width: 80 ,minWidth:60 }
        ,{field: 'sender', title: '发送者', width: 190,minWidth: 60}
        ,{field: 'receiver', title: '接收者',minWidth:60, width: 190}
        ,{field: 'title',title: '邮件标题' ,width: 120,minWidth: 60}
        ,{field: 'text', title:'邮件内容',width:180,minWidth:60}
        ,{fixed: 'right',title:'邮件不可修改' ,width: 130,minWidth:130 , toolbar: '#bar4'}
        ]
      ]
      ,toolbar: '#bar1'
      ,parseData:function(res){
        var dataList = res.data;
          var count = res.count; //请求的数据总数
          var list = []; //用来保存当前页显示的数据
          //前端模拟分页，获取当前页、分页显示数据量
          var page = $("#layui-table-page7").find(".layui-laypage-em").next().html();
          var limit = $("#layui-table-page7").find(".layui-laypage-limits select").val();
          // console.log(page + ", " + limit);
          if(page == undefined || page == null || page == ""){
              page = 1;
          }
          if(limit == undefined || limit == null || limit == ""){
              limit = 10;
          }
          //数据从哪条数据开始
          var start = (page-1) * limit;
          //数据从哪条数据结束
          var end = page * limit;
          if(end > count){
              end = count;
          }
          //取分页数据
          for(var i=start; i<end; i++){
              list.push(dataList[i]);
          }
          return {
              "code": 200, //解析接口状态
              "count": count, //解析数据长度
              "data": list //解析数据列表
          }
      }
    });
    
    //新闻中心头工具栏事件绑定
    table.on('toolbar(news)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '发布新闻'
          ,content:$('#newupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','520px']
          ,yes:function(index,layero){
            var ntitle =$("input#ntitle.layui-input")[1].value;
            var ncontent =$("textarea#ncontent.layui-textarea")[1].value;
            var status =$("input[name='nstatus']:checked").val();
            $.ajax({
              type:"POST"
              ,url:"/apis/api/not/check/add"
              ,data:{
                ntitle:ntitle,
                ncontent:ncontent,
                status:status,
                photo1:null,
                photo2:null,
                photo3:null,
                photo4:null,
                photo5:null
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('发布成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("news");
                })
              }
              ,error:function(e){
                layer.msg('发布失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event === "refresh"){
        // console.log($(".layui-laypage-skip").find("input").val(1));
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("news");
      }
      if(event === "LAYTABLE_SEARCH"){
        var searchval = $("#search_title").val();
        table.reload('news',{
          url: '/apis/api/not/findNotice',
          where:{
            title:searchval
          },
          parseData:function(res){
            var dataList = res.data;
              var count = res.count; //请求的数据总数
              var list = []; //用来保存当前页显示的数据
              //前端模拟分页，获取当前页、分页显示数据量
              var page = $("#layui-table-page1").find(".layui-laypage-em").next().html();
              var limit = $("#layui-table-page1").find(".layui-laypage-limits select").val();
              // console.log(page + ", " + limit);
              if(page == undefined || page == null || page == ""){
                  page = 1;
              }
              if(limit == undefined || limit == null || limit == ""){
                  limit = 10;
              }
              //数据从哪条数据开始
              var start = (page-1) * limit;
              //数据从哪条数据结束
              var end = page * limit;
              if(end > count){
                  end = count;
              }
              //取分页数据
              for(var i=start; i<end; i++){
                  list.push(dataList[i]);
              }
              return {
                  "code": 200, //解析接口状态
                  "count": count, //解析数据长度
                  "data": list //解析数据列表
              }
          }
        });
        $("#search_title").val(searchval);

      }
    })

    //新闻中心行工具栏事件绑定
    table.on('tool(news)',function(obj){
      var event = obj.event;
      if(event==="edit"){
        var id=obj.data.id;var time=obj.data.createTime;
        var photo1=obj.data.photo1;var photo2=obj.data.photo2;var photo3=obj.data.photo3;
        var photo4=obj.data.photo4;var photo5=obj.data.photo5;
        if(photo1=='')photo1=null;if(photo2=='')photo2=null;if(photo3=='')photo3=null;
        if(photo4=='')photo4=null;if(photo5=='')photo5=null;
        layeroff = false;
        layer.open({
          title: '修改新闻'
          ,content:$('#newupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 2
          ,area:['500px','520px']
          ,success:function(layero,index){
            // console.log(obj.data.ntitle+"||"+index);
            $("input#ntitle.layui-input")[1].value=obj.data.ntitle;
            $("textarea#ncontent.layui-textarea")[1].value=obj.data.ncontent;
            if(obj.data.status==0){
              $("input[name='nstatus']:last").attr('checked','true');
            }else{
              $("input[name='nstatus']:first").attr('checked','true');
            }
            // console.log($("input[name='nstatus']:checked").val());
          }
          ,yes:function(index,layero){ 
            var ntitle =$("input#ntitle.layui-input")[1].value;
            var ncontent =$("textarea#ncontent.layui-textarea")[1].value;
            var status =$("input[name='nstatus']:checked").val();
            $.ajax({
              type:"POST"
              ,url:"/apis/api/not/check/update"
              ,data:{
                id:id,
                ntitle:ntitle,
                ncontent:ncontent,
                createTime:time,
                photo1:photo1,
                photo2:photo2,
                photo3:photo3,
                photo4:photo4,
                photo5:photo5,
                status:status
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('修改成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("news");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        }); 

      }
      if(event==="delline"){
        layer.confirm('是否要删除该条新闻？',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/not/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })
    
    //救助中心头工具栏事件绑定
    table.on('toolbar(help)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '发布救助信息'
          ,content:$('#helpupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','500px']
          ,yes:function(index,layero){
            var name =$("input#name.layui-input")[1].value;
            var phone =$("input#phone.layui-input")[1].value;
            var introduce =$("textarea#introduce.layui-textarea")[1].value;
            var address =$("input#address.layui-input")[1].value;
            // console.log(name+" "+phone);
            // console.log(introduce+" "+address);
            $.ajax({
              type:"POST"
              ,url:"/apis/api/help/check/add"
              ,data:{
                name:name
                ,phone:phone
                ,introduce:introduce
                ,address:address
                ,photo1:null
                ,photo2:null
                ,photo3:null
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('发布成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('发布失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event==="refresh"){
        // console.log($(".layui-laypage-skip").find("input").val(1));
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("help");
      }
    })

    //救助中心行工具栏事件绑定
    table.on('tool(help)',function(obj){
      var event = obj.event;
      // console.log(event);
      if(event=="audit"){
        var id = obj.data.id;var phone = obj.data.phone;
        var name =obj.data.name;var address = obj.data.address;
        var time=obj.data.createTime;var introduce = obj.data.introduce;
        var photo1=obj.data.photo1;var photo2=obj.data.photo2;var photo3=obj.data.photo3;
        layeroff = false;
        layer.open({
          title: '信息审核'
          ,content: '请选择该条救助信息的审核结果'
          ,type:0
          ,btn:['审核通过','取消','审核不通过']
          ,shadeClose:true
          ,offset: 'r'
          ,yes:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/help/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                introduce:introduce,
                address:address,
                createTime:time,
                photo1:photo1,
                photo2:photo2,
                photo3:photo3,
                status:1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,btn2:function(){
            
          }
          ,btn3:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/help/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                introduce:introduce,
                address:address,
                createTime:time,
                photo1:photo1,
                photo2:photo2,
                photo3:photo3,
                status:-1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });
      }
      if(event==="edit"){
        var id=obj.data.id;var time=obj.data.createTime;
        var photo1=obj.data.photo1;var photo2=obj.data.photo2;var photo3=obj.data.photo3;
        if(photo1=='')photo1=null;if(photo2=='')photo2=null;if(photo3=='')photo3=null;
        layeroff = false;
        layer.open({
          title: '修改救助信息'
          ,content:$('#helpupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 2
          ,area:['500px','500px']
          ,success:function(layero,index){
            // console.log(obj.data.name+"||"+index);
            $("input#name.layui-input")[1].value=obj.data.name;
            $("input#phone.layui-input")[1].value=obj.data.phone;
            $("textarea#introduce.layui-textarea")[1].value=obj.data.introduce;
            $("input#address.layui-input")[1].value=obj.data.address;
          }
          ,yes:function(index,layero){ 
            var name =$("input#name.layui-input")[1].value;
            var phone =$("input#phone.layui-input")[1].value;
            var address =$("input#address.layui-input")[1].value;
            var introduce =$("textarea#introduce.layui-textarea")[1].value;
            var status =obj.data.status;
            // console.log(name+" "+phone+" "+introduce+" "+address);
            $.ajax({
              type:"POST"
              ,url:"/apis/api/help/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                introduce:introduce,
                address:address,
                createTime:time,
                photo1:photo1,
                photo2:photo2,
                photo3:photo3,
                status:status
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('修改成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        }); 

      }
      if(event==="delline"){
        layer.confirm('是否要删除该条救助信息？',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/help/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

    //领养申请中心头工具栏事件绑定
    table.on('toolbar(adopt)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        // console.log("add");
        layeroff = false;
        layer.open({
          title: '新增领养申请信息'
          ,content:$('#adoptupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','550px']
          ,yes:function(index,layero){
            var name =$("input#dname.layui-input")[1].value;
            var phone =$("input#dphone.layui-input")[1].value;
            var idcard =$("input#idcard.layui-input")[1].value;
            var sex =$("input#dsex.layui-input")[1].value;
            var age =$("input#dage.layui-input")[1].value;
            var introduce =$("textarea#dintroduce.layui-textarea")[1].value;
            var address =$("input#daddress.layui-input")[1].value;
            var animalsid =$("input#danimalsid.layui-input")[1].value;
            var house =$("input#house.layui-input")[1].value;
            var unitname =$("input#unitname.layui-input")[1].value;
            
            $.ajax({
              type:"POST"
              ,url:"/apis/api/ado/check/add"
              ,data:{
                name:name
                ,phone:phone
                ,idcard:idcard
                ,sex:sex
                ,age:age
                ,introduce:introduce
                ,address:address
                ,animalsid:animalsid
                ,animalsphoto:null
                ,house:house
                ,idphoto:null
                ,unitname:unitname
                ,status:0
                
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('发布成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("adopt");
                })
              }
              ,error:function(e){
                layer.msg('发布失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            }) 
          }
          ,end:function(){
                layeroff = true;
              }
        });
        
      }
      if(event==="refresh"){
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("adopt");
      }
      if(event === "LAYTABLE_SEARCH"){
        // var searchval = $("#search_title")[1].val();
        console.log($("#search_title")[1].val());
        // if(searchval)
        // table.reload('adopt',{
        //   url: '/apis/api/ado/check/getAdoptBy',
        //   where:{
        //     buserid:searchval
        //   },
        //   parseData:function(res){
        //     var dataList = res.data;
        //       var count = res.count; //请求的数据总数
        //       var list = []; //用来保存当前页显示的数据
        //       //前端模拟分页，获取当前页、分页显示数据量
        //       var page = $("#layui-table-page1").find(".layui-laypage-em").next().html();
        //       var limit = $("#layui-table-page1").find(".layui-laypage-limits select").val();
        //       // console.log(page + ", " + limit);
        //       if(page == undefined || page == null || page == ""){
        //           page = 1;
        //       }
        //       if(limit == undefined || limit == null || limit == ""){
        //           limit = 10;
        //       }
        //       //数据从哪条数据开始
        //       var start = (page-1) * limit;
        //       //数据从哪条数据结束
        //       var end = page * limit;
        //       if(end > count){
        //           end = count;
        //       }
        //       //取分页数据
        //       for(var i=start; i<end; i++){
        //           list.push(dataList[i]);
        //       }
        //       return {
        //           "code": 200, //解析接口状态
        //           "count": count, //解析数据长度
        //           "data": list //解析数据列表
        //       }
        //   }
        // });
        // $("#search_title")[1].val(searchval);

      }
    })

    //领养申请中心行工具栏事件绑定
    table.on('tool(adopt)',function(obj){
      var event = obj.event;
      if(event=="audit"){
        var id = obj.data.id;var phone = obj.data.phone;
        var name =obj.data.name;var idcard =obj.data.idcard;
        var sex =obj.data.sex;var age =obj.data.age;
        var address = obj.data.address;var animalsid = obj.data.animalsid;
        var animalsphoto =obj.data.animalsphoto;var house =obj.data.house;
        var time =obj.data.createTime;var introduce = obj.data.introduce;
        var unitname =obj.data.unitname;var idphoto =obj.data.idphoto;
        layeroff = false;
        layer.open({
          title: '信息审核'
          ,content: '请选择该条领养申请的审核结果'
          ,type:0
          ,btn:['审核通过','取消','审核不通过']
          ,shadeClose:true
          ,offset: 'r'
          ,yes:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/ado/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                idcard:idcard,
                sex:sex,
                age:age,
                introduce:introduce,
                address:address,
                createTime:time,
                animalsid:animalsid,
                animalsphoto:animalsphoto,
                house:house,
                unitname:unitname,
                idphoto:idphoto,
                status:1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,btn2:function(){
            
          }
          ,btn3:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/ado/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                idcard:idcard,
                sex:sex,
                age:age,
                introduce:introduce,
                address:address,
                createTime:time,
                animalsid:animalsid,
                animalsphoto:animalsphoto,
                house:house,
                unitname:unitname,
                idphoto:idphoto,
                status:-1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("adopt");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });
      }
      if(event==="edit"){
        var id=obj.data.id;var time=obj.data.createTime;
        var animalsphoto=obj.data.animalsphoto;var statis=obj.data.status;
        var idphoto=obj.data.idphoto;
        layeroff = false;
        layer.open({
          title: '修改领养申请信息'
          ,content:$('#adoptupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 2
          ,area:['500px','550px']
          ,success:function(layero,index){
            // console.log($("input#dname.layui-input"));
            $("input#dname.layui-input")[1].value=obj.data.name;
            $("input#dphone.layui-input")[1].value=obj.data.phone;
            $("input#idcard.layui-input")[1].value=obj.data.idcard;
            $("input#dsex.layui-input")[1].value=obj.data.sex;
            $("input#dage.layui-input")[1].value=obj.data.age;
            $("textarea#dintroduce.layui-textarea")[1].value=obj.data.introduce;
            $("input#daddress.layui-input")[1].value=obj.data.address;
            $("input#danimalsid.layui-input")[1].value=obj.data.animalsid;
            $("input#house.layui-input")[1].value=obj.data.house;
            $("input#unitname.layui-input")[1].value=obj.data.unitname;
          }
          ,yes:function(index,layero){ 
            var name =$("input#dname.layui-input")[1].value;
            var phone =$("input#dphone.layui-input")[1].value;
            var idcard =$("input#idcard.layui-input")[1].value;
            var sex =$("input#dsex.layui-input")[1].value;
            var age =$("input#dage.layui-input")[1].value;
            var introduce =$("textarea#dintroduce.layui-textarea")[1].value;
            var address =$("input#daddress.layui-input")[1].value;
            var animalsid =$("input#danimalsid.layui-input")[1].value;
            var house =$("input#house.layui-input")[1].value;
            var unitname =$("input#unitname.layui-input")[1].value;
            // console.log(name+" "+phone+" "+introduce+" "+address);
            $.ajax({
              type:"POST"
              ,url:"/apis/api/ado/check/update"
              ,data:{
                id:id,
                name:name,
                phone:phone,
                idcard:idcard,
                sex:sex,
                age:age,
                introduce:introduce,
                address:address,
                animalsid:animalsid,
                animalsphoto:animalsphoto,
                house:house,
                unitname:unitname,
                idphoto:idphoto,
                createTime:time,
                status:status
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('修改成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("adopt");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        }); 

      }
      if(event==="delline"){
        layer.confirm('是否要删除该条领养申请',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/ado/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

    //志愿者中心头工具栏事件绑定
    table.on('toolbar(vol)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '新增志愿者信息'
          ,content:$('#volupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','530px']
          ,yes:function(index,layero){
            var name =$("input#vname.layui-input")[1].value;
            var phone =$("input#vphone.layui-input")[1].value;
            var sex =$("input#vsex.layui-input")[1].value;
            var age =$("input#vage.layui-input")[1].value;
            var email =$("input#vemail.layui-input")[1].value;
            var introduce =$("textarea#vintroduce.layui-textarea")[1].value;
            var address =$("input#vaddress.layui-input")[1].value;
            $.ajax({
              type:"POST"
              ,url:"/apis/api/vol/check/add"
              ,data:{
                vname:name
                ,vphone:phone
                ,sex:sex
                ,age:age
                ,email:email
                ,vintroduce:introduce
                ,vaddress:address
                ,status:0
                ,image:null
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('发布成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("vol");
                })
              }
              ,error:function(e){
                layer.msg('发布失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event==="refresh"){
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("vol");
      }
    })

    //志愿者中心行工具栏事件绑定
    table.on('tool(vol)',function(obj){
      var event = obj.event;
      if(event=="audit"){
        var id = obj.data.id;var vphone = obj.data.vphone;
        var vname =obj.data.vname;var image =obj.data.image;
        var sex =obj.data.sex;var age =obj.data.age;
        var email =obj.data.email;var time =obj.data.createTime;
        var vaddress = obj.data.vaddress;var vintroduce = obj.data.vintroduce;
        layeroff = false;
        layer.open({
          title: '信息审核'
          ,content: '请选择该条志愿者申请的审核结果'
          ,type:0
          ,btn:['审核通过','取消','审核不通过']
          ,shadeClose:true
          ,offset: 'r'
          ,yes:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/vol/check/update"
              ,data:{
                id:id,
                vname:vname,
                vphone:vphone,
                image:image,
                sex:sex,
                age:age,
                email:email,
                vintroduce:vintroduce,
                vaddress:vaddress,
                createTime:time,
                status:1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("help");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,btn2:function(){
            
          }
          ,btn3:function(){
            $.ajax({
              type:"POST"
              ,url:"/apis/api/vol/check/update"
              ,data:{
                id:id,
                vname:vname,
                vphone:vphone,
                image:image,
                sex:sex,
                age:age,
                email:email,
                vintroduce:vintroduce,
                vaddress:vaddress,
                createTime:time,
                status:-1
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('审核完成',{shift:5,icon: 6,time:1500},function(){
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("adopt");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:1500},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });
      }
      if(event==="edit"){
        var id=obj.data.id;var time=obj.data.createTime;
        var image=obj.data.image;var status=obj.data.status;
        layeroff = false;
        layer.open({
          title: '修改志愿者信息'
          ,content:$('#volupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 2
          ,area:['500px','550px']
          ,success:function(layero,index){
            $("input#vname.layui-input")[1].value=obj.data.vname;
            $("input#vphone.layui-input")[1].value=obj.data.vphone;
            $("input#vsex.layui-input")[1].value=obj.data.sex;
            $("input#vage.layui-input")[1].value=obj.data.age;
            $("input#vemail.layui-input")[1].value=obj.data.email;
            $("textarea#vintroduce.layui-textarea")[1].value=obj.data.vintroduce;
            $("input#vaddress.layui-input")[1].value=obj.data.vaddress;
          }
          ,yes:function(index,layero){ 
            var name =$("input#vname.layui-input")[1].value;
            var phone =$("input#vphone.layui-input")[1].value;
            var sex =$("input#vsex.layui-input")[1].value;
            var age =$("input#vage.layui-input")[1].value;
            var vemail =$("input#vemail.layui-input")[1].value;
            var address =$("input#vaddress.layui-input")[1].value;
            var introduce =$("textarea#vintroduce.layui-textarea")[1].value;
            // console.log(name+" "+phone+" "+introduce+" "+address);
            $.ajax({
              type:"POST"
              ,url:"/apis/api/vol/check/update"
              ,data:{
                id:id,
                vname:name,
                vphone:phone,
                image:image,
                sex:sex,
                age:age,
                email:email,
                vintroduce:introduce,
                vaddress:address,
                createTime:time,
                status:status
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('修改成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("vol");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        }); 

      }
      if(event==="delline"){
        layer.confirm('是否要删除该条领养申请',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/vol/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

    //注册用户管理中心头工具栏事件绑定
    table.on('toolbar(buser)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '新增注册用户信息'
          ,content:$('#buserupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','400px']
          ,yes:function(index,layero){
            var name =$("input#bname.layui-input")[1].value;
            var username =$("input#username.layui-input")[1].value;
            var pwd = $("input#bpwd.layui-input")[1].value;
            var status =$("input[name='bstatus']:checked").val();
            $.ajax({
              type:"POST"
              ,url:"/apis/api/buser/check/register"
              ,data:{
                bname:name
                ,username:username
                ,bpwd:pwd
                ,status:status
                ,headphoto:null
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('注册成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("buser");
                })
              }
              ,error:function(e){
                layer.msg('注册失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event==="refresh"){
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("vol");
      }
    })

    //注册用户管理中心行工具栏事件绑定
    table.on('tool(buser)',function(obj){
      var event = obj.event;
      if(event==="edit"){
        var id=obj.data.id;var headphoto=obj.data.headphoto;
        if(headphoto=='')haedphoto=null;
        layeroff = false;
        layer.open({
          title: '修改志愿者信息'
          ,content:$('#buserupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 2
          ,area:['500px','550px']
          ,success:function(layero,index){
            $("input#bname.layui-input")[1].value=obj.data.bname;
            $("input#username.layui-input")[1].value=obj.data.username;
            $("input#bpwd.layui-input")[1].value=obj.data.bpwd;
            if(obj.data.status==1){
              $("input[name='bstatus']:first").attr('checked','true');
            }else{
              $("input[name='bstatus']:last").attr('checked','true');
            }
          }
          ,yes:function(index,layero){ 
            var name =$("input#bname.layui-input")[1].value;
            var pwd =$("input#bpwd.layui-input")[1].value;
            var username =$("input#username.layui-input")[1].value;
            var status =$("input[name='bstatus']:checked").val();
            $.ajax({
              type:"POST"
              ,url:"/apis/api/buser/check/update"
              ,data:{
                id:id,
                bname:name,
                bpwd:pwd,
                username:username,
                headphoto:headphoto,
                status:status
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('修改成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("buser");
                })
              }
              ,error:function(e){
                layer.msg('提交失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        }); 

      }
      if(event==="delline"){
        layer.confirm('是否要删除该注册用户信息？',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/buser/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

    //留言板头工具栏事件绑定
    table.on('toolbar(mesbd)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '新增留言'
          ,content:$('#mesbdupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','430px']
          ,yes:function(index,layero){
            var id =$("input#mesbid.layui-input")[1].value;
            var title =$("input#mestitle.layui-input")[1].value;
            var content =$("textarea#mescontent.layui-textarea")[1].value;
            $.ajax({
              type:"POST"
              ,url:"/apis/api/messageboard/check/publish"
              ,data:{
                buserid:id
                ,title:title
                ,content:content
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('留言成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("mesbd");
                })
              }
              ,error:function(e){
                layer.msg('注册失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event==="refresh"){
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("mesbd");
      }
    })

    //留言板行工具栏事件绑定
    table.on('tool(mesbd)',function(obj){
      var event = obj.event;
      if(event==="delline"){
        layer.confirm('是否要删除该条留言信息？',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/messageboard/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

    //邮件信息头工具栏事件绑定
    table.on('toolbar(email)',function(obj){
      var event = obj.event;
      if(event === 'add'){
        layeroff = false;
        layer.open({
          title: '发送邮件'
          ,content:$('#emailupload').html()
          ,btn:['提交','取消']
          ,type:1
          ,shadeClose:true
          ,anim: 4
          ,area:['500px','430px']
          ,yes:function(index,layero){
            var title =$("input#emailtitle.layui-input")[1].value;
            var text =$("textarea#emailcontent.layui-textarea")[1].value;
            $.ajax({
              type:"POST"
              ,url:"/apis/api/email/send"
              ,data:{
                title:title
                ,text:text
              }
              ,dataType:"json"
              ,success:function(res){
                // console.log(res);
                layer.msg('发送成功',{shift:5,icon: 6,time:2000},function(){
                  layer.close(index);
                  $(".layui-laypage-skip").find("input").val(1);
                  $(".layui-laypage-btn").click();
                  table.reload("email");
                })
              }
              ,error:function(e){
                layer.msg('注册失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
                  layer.close(index);
                })
              }
            })
          }
          ,end:function(){
            layeroff = true;
          }
        });  
      }
      if(event==="refresh"){
        $(".layui-laypage-skip").find("input").val(1);
        $(".layui-laypage-btn").click();
        table.reload("email");
      }
    })

    //留言板行工具栏事件绑定
    table.on('tool(email)',function(obj){
      var event = obj.event;
      if(event==="delline"){
        layer.confirm('是否要删除该条邮件记录？',{shadeClose:true},function(index){
          // console.log(obj.data.id)
          $.ajax({
            url:"/apis/api/email/check/del"
            ,type:"GET"
            ,data:{
              id:obj.data.id
            }
            ,success:function(msg){
              if (msg.code== 200){
                //删除这一行，前端界面的修改，直接删除了这一条数据
                obj.del();
                layer.close(index);
                layer.msg("删除成功", {icon: 6});
              }else{
                layer.msg("删除失败", {icon: 5});
              }
            }
          });
          return false;
        })
      }
    })

  });

  // 获取动物列表
  $.ajax({
    type: "get",
    url: "/apis/api/ani/get",
    dataType: "json",
    success: function (response) {
      // console.log(response);
      var result = response.data;
      $.each(result, function (index, value) {
        var temp = ` <li>
         <div>
           ID：<span class='aniid'>${value.id}</span>
         </div>
         <div>
           名称：<span class='aniName'>${value.aname}</span>
         </div>
         <div onclick="show_img(this)">
           图片：
            <img src="${value.animalsImage}" style="width:100px;height:70px;"></img>
         </div>
         <div id="textarea">
           介绍：<textarea row="4" col="8">${value.aintroduce}</textarea>
         </div >
         <div id="button">
         <button class="layui-btn layui-btn-xs">编辑</button>
         <button class="layui-btn layui-btn-xs del">删除</button>
         </div>
       </li>`;
        $('.del>ul').append(temp);
      });
    }
  });

  // 防止数据未完全加载时调用
  setTimeout(function () {
    // 删除动物
    $('button.del').click(function () {
      // console.log($($(this).parent().siblings()[0]).children().text());
      var id = $($(this).parent().siblings()[0]).children().text();
      layer.confirm("是否删除该条动物信息？",{shadeClose:true},function(index){
        $.ajax({
          type: "get"
          ,url: `/apis/api/ani/del?id=${id}`
          ,dataType:"json"
          ,success:function(res){
            // console.log(res);
            layer.msg('删除成功',{shift:5,icon: 6,time:2000},function(){
              layer.close(index);
              document.location.reload();
              
            })
          }
          ,error:function(e){
            layer.msg('删除失败,请检查网络',{shift:5,icon: 5,time:2000},function(){
              layer.close(index);
            })
          }
          
        });
      });
      
    });

    // 前端实现动物的ID和昵称查询
    $('.search').on('input', function () {
      $('.searchani>ul>li').css({
        display: 'none'
      })
      // console.log($(".search").val());
      $('.searchani>ul>li>div>.aniid').each(function (i) {
        // console.log($(this));
        if ($('.search').val() == $(this).text()) {
          $(this).parent().parent().css({
            display: 'block'
          })
        }
      });
      $('.searchani>ul>li>div>.aniName').each(function (i) {
        // console.log($(this).text());
        if ($('.search').val() == $(this).text()) {
          $(this).parent().parent().css({
            display: 'block'
          })
        }
      });
      if ($('.search').val().length == 0) {
        $('.searchani>ul>li').css({
          display: 'block'
        })
      }
    });


  }, 1000);

  // 退出登陆
  $('.logout').click(function () {
    // console.log("??");
    $.ajax({
      type: "get",
      url: '/apis/api/user/logout',
      success: function (response) {
        console.log(response);
        layer.open({
          title: '退出系统'
          ,content: 'code:'+response.code+' msg:'+response.msg
          ,btn:['退出','取消']
          ,yes:function(index,layero){
            layer.close(index);
            document.location.href = '../login.html';
          }
        }); 
        // document.location.href = '../login.html';
      },
      error: function (e) {
        console.log(e);
        alert('退出失败');
      }
    });
  });

  
})

// 显示大图片
function show_img(t){
  var t = $(t).find("img");
  layer.open({
      type: 1,
      skin: 'layui-layer-rim', //加上边框
       area: ['50%', '60%'], //宽高
      shadeClose: true, //开启遮罩关闭
      end: function (index, layero) {
          return false;
      },
      title:t,
      content: '<div style="text-align:center"><img src="' +
       $(t).attr('src') + '" /></div>'
  });
}