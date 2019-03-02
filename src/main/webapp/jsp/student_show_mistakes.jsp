<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/5/30
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--需要h5来展示--%>
<!DOCTYPE html>
<html>
<head>
    <title>错误历史</title>
    <script src="resources/js/echarts.common.min.js"></script>
</head>
<body>
<div class="row">
    <div id="main" style="width: 400px;height:200px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '错题历史 '
            },
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: [820, 932, 901, 934, 1290, 1330, 1320],
                type: 'line'
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

    <div id="once" style="width: 300px;height:200px;"></div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('once'));
        myChart.setOption({
            title: {
                text: '最近一个作业错题分布 '
            },
            series : [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:${mistakes_list[0].multipleChoice}, name:'单选'},
                        {value:${mistakes_list[0].clozeTest}, name:'完型'},
                        {value:${mistakes_list[0].readingComprehension}, name:'阅读'},
                        {value:${mistakes_list[0].errorCorrection}, name:'改错'}
                    ]
                }
            ]
        })
    </script>
</div>
</body>
</html>
