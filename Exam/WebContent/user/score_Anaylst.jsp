<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 导入echarts.js -->
<script type="text/javascript" src="/Exam/js/echarts.min.js"></script>
</head>
<body>

     <center>
     
        <!-- 开发一个拥有高度和宽度的DIV标签 -->
        <div id="main" style="width:500px;height:500px"></div>
        <script type="text/javascript">
              //1.创建一个饼状图模型对象
                 var model ={};
              //2.设置名状图的属性信息
                //2.1 饼状图【标题属性】设置
                 model.title={text:'月消费分析图',subtext:'某城市',x:'center'};
                //2.2 饼状图【解释图层】设置
                 model.tooltip={};
                //2.3 饼状图【图例】设置
                 model.legend={
                		         orient: 'vertical',
                		         right:'right',
                		         data:['房租','伙食费','交通费','杂费']
                               };
                //2.4 饼状图【填充数据】设置
                  model.series =[
                	              {
                	            	name:'调查报告',
                	            	type:'pie',
                	            	data:[
                	            		   {name:'房租',value:2500},
                	            		   {name:'伙食费',value:1200},
                	            		   {name:'交通费',value:300},
                	            		   {name:'杂费',value:1000}
                	            		
                	            	     ]
                	            	  
                	              }
                	  
                                ];
                
                 //3.定位DIV,将DIV封装到echarts类型对象中
                 var divDom=document.getElementById("main");
                 var myChart=echarts.init(divDom);
                 //4.通过echarts函数解析模型对象，将模型对象中数据导入到
                 //div中，改变div的css属性，从而改变div在浏览器上展示形式
                 myChart.setOption(model);
        </script>
     </center>
</body>
</html>