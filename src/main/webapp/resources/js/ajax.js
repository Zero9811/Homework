function showMistakesAjax() {
    document.getElementById("mainContent").innerHTML = "";
    $.ajax({
        url:'studentQueryMistakes',
        type:'get',
        dataType:'html',
        success: function(msg) {
            //这里是ajax提交成功后，程序返回的数据处理函数。msg是返回的数据，数据类型在dataType参数里定义！
            document.getElementById("mainContent").innerHTML = msg;
        },
        error: function() {
            alert('对不起失败了');
        }
    })
}