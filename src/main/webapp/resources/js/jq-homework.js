$(function () {
    $("#queryhomework").click(function () {
        htmlobj=$.ajax({
            type:"post",
            url:"homework_query_success.action",
            async:false
        })
        $("#showresult").html(htmlobj.responseText);
    });
});
